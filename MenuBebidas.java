import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class MenuBebidas extends Menu {
    public MenuBebidas(ArrayList<Item> itens, String nome) {
        super(itens, nome);
    }

    // Método para adicionar uma bebida ao menu de bebidas
    @Override
    public void adicionarItem(Item item) {
        if (item instanceof Bebida) {
            this.itens.add(item);
            System.out.println("Bebida adicionada com sucesso!");
        } else {
            System.out.println("O item não é uma bebida e não pode ser adicionado ao menu de bebidas.");
        }
    }

    // Método para editar uma bebida do menu de bebidas
    @Override
    public void editarItem(String nomeBebida, Item novoItem) {
        for (Item item : this.itens) {
            if (item instanceof Bebida && item.getNomeItem().equalsIgnoreCase(nomeBebida)) {
                int index = this.itens.indexOf(item);
                this.itens.set(index, novoItem);
                System.out.println("Bebida editada com sucesso!");
                return;
            }
        }
        System.out.println("Bebida não encontrada no menu de bebidas.");
    }

    // Método para deletar uma bebida do menu de bebidas
    @Override
    public void deletarItem(String nomeBebida) {
        for (Item item : this.itens) {
            if (item instanceof Bebida && item.getNomeItem().equalsIgnoreCase(nomeBebida)) {
                this.itens.remove(item);
                System.out.println("Bebida deletada com sucesso!");
                return;
            }
        }
        System.out.println("Bebida não encontrada no menu de bebidas.");
    }

    @Override
    public Menu criarMenu(ArrayList<Item> itens) {
        return new MenuBebidas(itens, this.nome);
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
    public void exibirMenu() {
        System.out.println("------ " + nome + " ------");
        for (Item item : itens) {
            System.out.println(item.toString());
            System.out.println("-----------------------------");
        }
    }

    public void salvarBebidasEmArquivo() {
        try (FileWriter escritor = new FileWriter("bebidas.txt")) {
            for (Item item : this.getItens()) {
                if (item instanceof Bebida) {
                    Bebida bebida = (Bebida) item;
                    escritor.write("Nome: " + bebida.getNomeItem() + "\n");
                    escritor.write("Preço: " + bebida.getPrecoItem() + "\n");
                    escritor.write("Descrição: " + bebida.getDescricaoItem() + "\n");
                    escritor.write("Alcoólica: " + bebida.isAlcoolica() + "\n\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar as bebidas.");
            e.printStackTrace();
        }
    }
}
