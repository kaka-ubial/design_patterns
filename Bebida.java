import java.util.ArrayList;

public class Bebida extends Item {

	private boolean alcoolica;

	private ArrayList<Bebida> catalogoBebidas = new ArrayList<>();


	public Bebida(String nomeItem, double precoItem, String descricaoItem, boolean alcoolica) {
		super(nomeItem, precoItem, descricaoItem);
		this.alcoolica = alcoolica;
		catalogoBebidas.add(this);
	}

	public boolean isAlcoolica() {
		return alcoolica;
	}

	public void setAlcoolica(boolean alcoolica) {
		this.alcoolica = alcoolica;
	}

	public void editarItem(Item item) {
		if (item instanceof Bebida) {
				Bebida bebida = (Bebida) item;
				for (int i = 0; i < catalogoBebidas.size(); i++) {
						if (catalogoBebidas.get(i).getNomeItem().equals(bebida.getNomeItem())) {
								catalogoBebidas.set(i, bebida);
								break;
						}
				}
		}
	}

	@Override
	public void excluirItem(Item item) {
			if (item instanceof Bebida) {
					Bebida bebida = (Bebida) item;
					for (int i = 0; i < catalogoBebidas.size(); i++) {
							if (catalogoBebidas.get(i).getNomeItem().equals(bebida.getNomeItem())) {
									catalogoBebidas.remove(i);
									break;
							}
					}
			}
	}

	@Override
	public void listarItens(ArrayList<Item> itens) {
		for (Item item : itens) {
			if (item instanceof Bebida) {
					Bebida bebida = (Bebida) item;
					System.out.println("Nome: " + bebida.getNomeItem());
					System.out.println("Preço: " + bebida.getPrecoItem());
					System.out.println("Descrição: " + bebida.getDescricaoItem());
					System.out.println("Alcoólica: " + bebida.isAlcoolica());
					System.out.println();
			}
		}
	}
}
