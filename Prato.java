import java.util.ArrayList;

public class Prato extends Item {

	private boolean vegano;

	private boolean gluten;

	private boolean lactose;

	private ArrayList<Prato> catalogoPrato;


	public Prato(String nomeItem, double precoItem, String descricaoItem, boolean vegano, boolean gluten, boolean lactose) {
		super(nomeItem, precoItem, descricaoItem);
		this.vegano = vegano;
		this.gluten = gluten;
		this.lactose = lactose;
		catalogoPrato.add(this);
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

	public void editarItem(Item item) {
		if (item instanceof Prato) {
				Prato prato = (Prato) item;
				for (int i = 0; i < catalogoPrato.size(); i++) {
						if (catalogoPrato.get(i).getNomeItem().equals(prato.getNomeItem())) {
								catalogoPrato.set(i, prato);
								break;
						}
				}
		}
	}

@Override
	public void excluirItem(Item item) {
			if (item instanceof Prato) {
					Prato prato = (Prato) item;
					for (int i = 0; i < catalogoPrato.size(); i++) {
							if (catalogoPrato.get(i).getNomeItem().equals(prato.getNomeItem())) {
									catalogoPrato.remove(i);
									break;
							}
					}
			}
	}

	@Override
	public void listarItens(ArrayList<Item> itens) {
		for(Item item : itens) {
			System.out.println(item);
		}
	}
}
