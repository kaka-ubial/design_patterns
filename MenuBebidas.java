import java.util.ArrayList;
public class MenuBebidas extends Menu {
    public MenuBebidas(ArrayList<Item> itens, String nome) {
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

    public Menu criarMenu(ArrayList<Item> itens){
        return new MenuBebidas(itens, "Menu de Bebidas");
    }

    @Override
    public Menu editarMenu(Menu MenuBebidas, String nome) {
        MenuBebidas.setNome(nome);
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
