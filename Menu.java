import java.util.ArrayList;
public abstract class Menu {

	protected ArrayList<Item> itens;

	protected String nome;

	public Menu(ArrayList<Item> itens, String nome) {
		this.itens = itens;
		this.nome = nome;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public abstract void criarMenu(ArrayList<Item> itens);

	public abstract void editarMenu(ArrayList<Item> itens);

	public abstract void deletarMenu(ArrayList<Item> itens);

	public abstract void exibirMenu(ArrayList<Item> itens);

}
