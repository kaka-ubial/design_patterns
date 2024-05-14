public class Prato extends Item {

	private boolean vegano;

	private boolean gluten;

	private boolean lactose;

	public Prato(String nomeItem, double precoItem, String descricaoItem, boolean vegano, boolean gluten, boolean lactose) {
		super(nomeItem, precoItem, descricaoItem);
		this.vegano = vegano;
		this.gluten = gluten;
		this.lactose = lactose;
	}

	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public boolean isLactose() {
		return lactose;
	}

	public void setLactose(boolean lactose) {
		this.lactose = lactose;
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
