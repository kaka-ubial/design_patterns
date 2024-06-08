import java.util.ArrayList;

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

    // Método para editar um vinho na carta de vinhos
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

    // Método para deletar um vinho da carta de vinhos
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
}
