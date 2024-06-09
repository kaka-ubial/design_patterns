import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Comanda {
	//atributos
	private static int proximoId = 1;
	private int idComanda;
	private ArrayList<Item> itensComanda = new ArrayList<>();
	private static ArrayList<Comanda> listaComandas = new ArrayList<>();
	private double precoTotal;
	private boolean pago;
	private Mesa mesa;

	//construtor
	public Comanda(Mesa mesa) {
		this.idComanda = proximoId++;
		this.itensComanda = new ArrayList<>();
		this.precoTotal = 0;
		this.pago = false;
		this.mesa = mesa;
		listaComandas.add(this);
	}

	// getters e setters
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

	public static ArrayList<Comanda> getListaComandas() {
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

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	//métodos
	//método para adicionar item à comanda
	public void adicionarItem(Item item) {
		itensComanda.add(item);
		precoTotal += item.getPrecoItem();
	}

	// método para remover item da comanda
	public void removerItem(Item item) throws ItemNaoEncontradoException {
		if (itensComanda.contains(item)) {
			itensComanda.remove(item);
			precoTotal -= item.getPrecoItem();
		} else {
			throw new ItemNaoEncontradoException("Item não encontrado na comanda.");
		}
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
	public void exibirComandaEspecifica(Comanda comanda) {
		System.out.println("Comanda #" + idComanda);
		System.out.println("Mesa:" + mesa.getNumero());
		for (Item item : itensComanda) {
			System.out.println(item.getNomeItem() + ": R$" + item.getPrecoItem());
		}
		System.out.println("Total: R$" + precoTotal);
	}

	//método para exibir a lista de comandas:
	public static void exibirListaComandas() {
		if (listaComandas.isEmpty()){
			System.out.println("Nenhuma comanda encontrada.");
		}
		else{
			System.out.println(listaComandas);
		}
	}

	//método para mudar o estado da comanda para paga
	public void confirmarPagamentoComanda(){
		pago = true;
		System.out.println("A comanda " + idComanda + " foi paga");
	}

	public void salvarComandasEmArquivo() {
		try (FileWriter escritor = new FileWriter("comandas.txt")) {
			for (Comanda comanda : listaComandas) {
				escritor.write("Comanda #" + comanda.getIdComanda() + ", Mesa: " + comanda.getMesa().getNumero() + ", Total: R$" + comanda.getPrecoTotal() + ", Pago: " + comanda.isPago() + "\n");
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao salvar as comandas.");
			e.printStackTrace();
		}
	}
}
