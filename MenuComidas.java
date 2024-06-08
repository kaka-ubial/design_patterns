import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
public class MenuComidas extends Menu {
    public MenuComidas(ArrayList<Item> itens, String nome) {
        super(itens, nome);
    }

    @Override
    public Menu criarMenu(ArrayList<Item> itens) {
        return new MenuComidas(itens, this.nome);
    }

    @Override
    public Menu editarMenu(Menu menu, String nome) {
        menu.setNome(nome);
        return menu;
    }

    @Override
    public Menu deletarMenu(Menu menu, ArrayList<Item> itens) {
        itens.clear();
        return menu;
    }

    @Override
    public void adicionarItem(Item item) {
        if (item instanceof Prato) {
            this.itens.add(item);
            System.out.println("Prato adicionado com sucesso!");
        } else {
            System.out.println("O item não é um prato e não pode ser adicionado ao menu de comidas.");
        }
    }

    @Override
    public void editarItem(String nomePrato, Item novoItem) {
        for (Item item : this.itens) {
            if (item instanceof Prato && item.getNomeItem().equalsIgnoreCase(nomePrato)) {
                int index = this.itens.indexOf(item);
                this.itens.set(index, novoItem);
                System.out.println("Prato editado com sucesso!");
                return;
            }
        }
        System.out.println("Prato não encontrado no menu de comidas.");
    }

    @Override
    public void deletarItem(String nomePrato) {
        for (Item item : this.itens) {
            if (item instanceof Prato && item.getNomeItem().equalsIgnoreCase(nomePrato)) {
                this.itens.remove(item);
                System.out.println("Prato deletado com sucesso!");
                return;
            }
        }
        System.out.println("Prato não encontrado no menu de comidas.");
    }

    @Override
    public void exibirMenu() {
        System.out.println("------ " + nome + " ------");
        for (Item item : itens) {
            System.out.println(item.toString());
            System.out.println("-----------------------------");
        }
    }

    public void salvarMenuComidasEmArquivo() {
        try (FileWriter escritor = new FileWriter("menu_comidas.txt")) {
            for (Item item : this.getItens()) {
                if (item instanceof Prato) {
                    Prato prato = (Prato) item;
                    escritor.write("Nome: " + prato.getNomeItem() + "\n");
                    escritor.write("Preço: " + prato.getPrecoItem() + "\n");
                    escritor.write("Descrição: " + prato.getDescricaoItem() + "\n");
                    escritor.write("Vegano: " + prato.isVegano() + "\n");
                    escritor.write("Contém glúten: " + prato.isGluten() + "\n");
                    escritor.write("Contém lactose: " + prato.isLactose() + "\n\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o menu de comidas.");
            e.printStackTrace();
        }
    }
}
