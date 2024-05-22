import java.util.ArrayList;

public class Mesa {
	//atributos
	private int numero;

	private int numLugares;

	private boolean reservado;
	private ArrayList<Mesa> listaMesas = new ArrayList<>();

	//construtor que ja adiciona o usuário na lista de usuarios
	public Mesa(int numero, int numLugares, boolean reservado) {
		this.numero = numero;
		this.numLugares = numLugares;
		this.reservado = reservado;
		listaMesas.add(this);
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

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	//métodos

	//método para verificar o estado da mesa
	public boolean isReservado() {
		return reservado;
	}

	//método para excluir uma mesa da lista
	public void excluirMesa(Mesa mesa, ArrayList<Mesa> listaMesas) {
		listaMesas.remove(mesa);
	}

	//método para editar uma mesa da lista
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

	//método para mudar o estado de reserva da mesa (reservá-la)
	public void reservarMesa(Mesa mesa) {
		reservado = true;

	}
	//método para mudar o estado de reserva da mesa (cancelar reserva)
	public void cancelarReservaMesa(Mesa mesa){
		reservado = false;
	}

}
