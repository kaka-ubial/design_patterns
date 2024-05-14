import java.util.ArrayList;
public class MenuComidas extends Menu {
    public MenuComidas(ArrayList<Item> itens, String nome) {
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
        return new MenuComidas(itens, "Menu de Pratos");
    }

    @Override
    public Menu editarMenu(ArrayList<Item> itens) {
        return this;
    }

    @Override
    public Menu deletarMenu(ArrayList<Item> itens) {
        itens.clear();
        return this;
    }

    @Override
    public void exibirMenu(ArrayList<Item> itens) {
        for(Item item : itens){
            System.out.println(item);
        }
    }
}
