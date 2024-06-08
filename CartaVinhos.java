import java.util.ArrayList;

public class CartaVinhos extends Menu {
    public CartaVinhos(ArrayList<Item> itens, String nome) {
        super(itens, nome);
    }

    @Override
    public ArrayList<Item> getItens() {
        return super.getItens();
    }

    @Override
    public void setItens(ArrayList<Item> itens) {
        super.setItens(itens);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public Menu criarMenu(ArrayList<Item> itens) {
        return new CartaVinhos(itens, "Carta de Vinhos");
    }


    @Override
    public Menu editarMenu(Menu CartaVinhos, String nome) {
        CartaVinhos.setNome(nome);
        return this;
}

    @Override
    public Menu deletarMenu(Menu menu, ArrayList<Item> itens) {
        menu.getItens().clear();
        return this;
    }

    @Override
    public void exibirMenu() {
        for(Item item : this.getItens()){
            System.out.println(item);
        }
    }
}
