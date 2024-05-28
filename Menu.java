import java.util.ArrayList;
public abstract class
Menu {
	//atributos
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

	public abstract Menu criarMenu(ArrayList<Item> itens);

	public abstract Menu editarMenu(Menu menu, String nome);

	public abstract Menu deletarMenu(Menu menu, ArrayList<Item> itens);

	public abstract void exibirMenu();

}
