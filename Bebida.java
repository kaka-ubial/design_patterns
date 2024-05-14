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
	public void adicionarItem() {

	}

	@Override
	public void editarItem() {

	}

	@Override
	public void excluirItem() {

	}

	@Override
	public void listarItens() {

	}
}
