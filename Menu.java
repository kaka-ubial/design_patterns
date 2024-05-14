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

	public abstract void criarMenu();

	public abstract void editarMenu();

	public abstract void deletarMenu();

	public abstract void exibirMenu();

}
