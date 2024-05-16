import java.util.ArrayList;

abstract public class Item {
	//atributos
	protected String nomeItem;

	protected double precoItem;

	protected String descricaoItem;

	public Item(String nomeItem, double precoItem, String descricaoItem) {
		this.nomeItem = nomeItem;
		this.precoItem = precoItem;
		this.descricaoItem = descricaoItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public double getPrecoItem() {
		return precoItem;
	}

	public void setPrecoItem(double precoItem) {
		this.precoItem = precoItem;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public abstract void adicionarItem(Item item, ArrayList<Item> itens);

	public abstract void editarItem(Item item, ArrayList<Item> itens);

	public abstract void excluirItem(Item item, ArrayList<Item> itens);

	public abstract void listarItens(ArrayList<Item> itens);

}
