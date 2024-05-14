import java.util.ArrayList;

public class Mesa {
	//atributos
	private int numero;

	private int numLugares;

	private boolean reservado;
	private ArrayList<Mesa> listaMesas;

	//construtor
	public Mesa(int numero, int numLugares, boolean reservado) {
		this.numero = numero;
		this.numLugares = numLugares;
		this.reservado = reservado;
	}

	//getters e setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumLugares() {
		return numLugares;
	}

	public void setNumLugares(int numLugares) {
		this.numLugares = numLugares;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	//métodos
	public void adicionarMesa(Mesa mesa, ArrayList<Mesa> listaMesas) {
		listaMesas.add(mesa);

	}

	public void excluirMesa(Mesa mesa, ArrayList<Mesa> listaMesas) {
		listaMesas.remove(mesa);
	}

	public void editarMesa(Mesa mesa, ArrayList<Mesa> listaMesas) {
		int index = listaMesas.indexOf(mesa);
		if (index != -1){
			mesa.setNumero(numero);
			mesa.setReservado(reservado);
			mesa.setNumLugares(numLugares);
			listaMesas.set(index, mesa);
		}
		else {
			System.out.println("Mesa não encontrada.");
		}

	}

	public void reservarMesa() {

	}

}
