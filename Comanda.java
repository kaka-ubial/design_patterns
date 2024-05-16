import java.util.ArrayList;

public class Comanda {
	//atributos
	private static int proximoId = 1;

	private int idComanda;
	private ArrayList<Item> itensComanda;

	private  ArrayList<Comanda> listaComandas;
	private double precoTotal;

	private boolean pago;

	//construtor
	public Comanda() {
		this.idComanda = proximoId++;
		this.itensComanda = new ArrayList<>();
		this.precoTotal = 0;
		this.pago = false;
		listaComandas.add(this);
	}

	//getters e setters
	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public ArrayList<Item> getItensComanda() {
		return itensComanda;
	}

	public void setItensComanda(ArrayList<Item> itensComanda) {
		this.itensComanda = itensComanda;
	}

	public ArrayList<Comanda> getListaComandas() {
		return listaComandas;
	}

	public void setListaComandas(ArrayList<Comanda> listaComandas) {
		this.listaComandas = listaComandas;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	//métodos
	//método para adicionar item à comanda
	public void adicionarItem(Item item) {
		itensComanda.add(item);
		precoTotal += item.getPrecoItem();
	}
	//método para remover item da comanda
	public void removerItem(Item item) {
		itensComanda.remove(item);
		precoTotal -= item.getPrecoItem();
	}

	//método para calcular preço final da comanda
	public double calcularPrecoTotal() {
		double total = 0;
		for (Item item : itensComanda) {
			total += item.getPrecoItem();
		}
		return total;
	}

	//método para exibir detalhes da comanda
	public void exibirComandaEspecifica() {
		System.out.println("Comanda #" + idComanda);
		for (Item item : itensComanda) {
			System.out.println(item.getNomeItem() + ": R$" + item.getPrecoItem());
		}
		System.out.println("Total: R$" + precoTotal);
	}

	//método para exibir a lista de comandas:
	public ArrayList exibirListaComandas(ArrayList listaComandas) {
		return listaComandas;
	}

	//método para mudar o estado da comanda para paga
	public void pagarComanda(){
		pago = true;
		System.out.println("A comanda " + idComanda + "foi paga");
	}
}
