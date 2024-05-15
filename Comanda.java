import java.util.ArrayList;

public class Comanda {

	private static int proximoId = 1;

	private int idComanda;
	private ArrayList<Item> itensComanda;
	private double precoTotal;

	private boolean pago;

	public Comanda() {
		this.idComanda = proximoId++;
		this.itensComanda = new ArrayList<>();
		this.precoTotal = 0;
		this.pago = false;
	}

	public void adicionarItem(Item item) {
		itensComanda.add(item);
		precoTotal += item.getPrecoItem();
	}

	public void removerItem(Item item) {
		itensComanda.remove(item);
		precoTotal -= item.getPrecoItem();
	}

	public double calcularPrecoTotal() {
		double total = 0;
		for (Item item : itensComanda) {
			total += item.getPrecoItem();
		}
		return total;
	}

	public void exibirComanda() {
		System.out.println("Comanda #" + idComanda);
		for (Item item : itensComanda) {
			System.out.println(item.getNomeItem() + ": R$" + item.getPrecoItem());
		}
		System.out.println("Total: R$" + precoTotal);
	}

	public void pagarComanda(){
		pago = true;
		System.out.println("A comanda " + idComanda + "foi paga");
	}
}
