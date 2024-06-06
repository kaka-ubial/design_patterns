import java.io.FileWriter;
import java.io.IOException;
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
    public Menu editarMenu(Menu menu, String nome) {
        menu.setNome(nome);
        return this;
    }

    @Override
    public Menu deletarMenu(Menu menu, ArrayList<Item> itens) {
        menu.getItens().clear();
        return this;
    }

    public void exibirMenu() {
        System.out.println("Menu de Bebidas: ");
        for(Item item : this.getItens()){
            System.out.println(item);
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
