import java.io.FileWriter;
import java.io.IOException;
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
    public Menu editarMenu(Menu menu, String nome) {
        menu.setNome(nome);
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
