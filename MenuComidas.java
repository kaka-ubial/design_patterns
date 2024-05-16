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
    public Menu editarMenu(Menu MenuComidas, String nome) {
        MenuComidas.setNome(nome);
        return this;
    }

    @Override
    public Menu deletarMenu(Menu menu, ArrayList<Item> itens) {
        menu.getItens().clear();
        return this;
    }

    @Override
    public void exibirMenu(Menu menu) {
        for(Item item : menu.getItens()){
            System.out.println(item);
        }
    }
}
