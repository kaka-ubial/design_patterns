import java.io.FileWriter;
import java.io.IOException;
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
        for (Item item : this.getItens()) {
            System.out.println(item);
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
