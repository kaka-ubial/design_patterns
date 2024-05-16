import java.util.ArrayList;

public class Bebida extends Item {

	private boolean alcoolica;

	public Bebida(String nomeItem, double precoItem, String descricaoItem, boolean alcoolica) {
		super(nomeItem, precoItem, descricaoItem);
		this.alcoolica = alcoolica;
	}

	public boolean isAlcoolica() {
		return alcoolica;
	}

	public void setAlcoolica(boolean alcoolica) {
		this.alcoolica = alcoolica;
	}

	@Override
	public void adicionarItem(Item item, ArrayList<Item> itens) {
		itens.add(item);
	}

	@Override
	public void editarItem(Item item, ArrayList<Item> itens) {

	}

	@Override
	public void excluirItem(Item item, ArrayList<Item> itens) {

	}

	@Override
	public void listarItens(ArrayList<Item> itens) {

	}
}
