import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class CartaVinhos extends Menu {
    public CartaVinhos(ArrayList<Item> itens, String nome) {
        super(itens, nome);
    }


    // Método para adicionar um vinho à carta de vinhos
    @Override
    public void adicionarItem(Item item) {
        if (item instanceof Vinho) {
            this.itens.add(item);
            System.out.println("Vinho adicionado com sucesso!");
        } else {
            System.out.println("O item não é um vinho e não pode ser adicionado à carta de vinhos.");
        }
    }

    @Override
    public void editarItem(String nomeVinho, Item novoItem) {
        for (Item item : this.itens) {
            if (item instanceof Vinho && item.getNomeItem().equalsIgnoreCase(nomeVinho)) {
                int index = this.itens.indexOf(item);
                this.itens.set(index, novoItem);
                System.out.println("Vinho editado com sucesso!");
                return;
            }
        }
        System.out.println("Vinho não encontrado na carta de vinhos.");
    }

    @Override
    public void deletarItem(String nomeVinho) {
        for (Item item : this.itens) {
            if (item instanceof Vinho && item.getNomeItem().equalsIgnoreCase(nomeVinho)) {
                this.itens.remove(item);
                System.out.println("Vinho deletado com sucesso!");
                return;
            }
        }
        System.out.println("Vinho não encontrado na carta de vinhos.");
    }

    @Override
    public Menu criarMenu(ArrayList<Item> itens) {
        return new CartaVinhos(itens, this.nome);
    }

    @Override
    public Menu editarMenu(Menu menu, String nome) {
        menu.setNome(nome);
        return this;
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

    public void salvarCartaDeVinhosEmArquivo() {
        try (FileWriter escritor = new FileWriter("carta_vinhos.txt")) {
            for (Item item : this.getItens()) {
                if (item instanceof Vinho) {
                    Vinho vinho = (Vinho) item;
                    escritor.write("Nome: " + vinho.getNomeItem() + ", Preço: " + vinho.getPrecoItem() +
                            ", Descrição: " + vinho.getDescricaoItem() + ", Idade do Vinho: " + vinho.getIdadeVinho() +
                            ", Nacionalidade: " + vinho.getNacionalidade() + ", Tipo: " + vinho.getTipo() +
                            ", Uva: " + vinho.getUva() + ", Corpo: " + vinho.getCorpo() +
                            ", Teor Alcoólico: " + vinho.getTeorAlcoolico() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar a carta de vinhos.");
            e.printStackTrace();
        }
    }
}
