public abstract class Item {
	private String nomeItem;
	private double precoItem;
	private String descricaoItem;

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

	@Override
	public String toString() {
		return "Nome: " + nomeItem +
				"\nPreço: " + precoItem +
				"\nDescrição: " + descricaoItem;
	}
}
