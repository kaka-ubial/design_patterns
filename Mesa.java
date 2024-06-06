import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Mesa {
	// atributos
	private int numero;
	private int numLugares;
	private boolean reservado;
	private static ArrayList<Mesa> listaMesas = new ArrayList<>();

	// construtor que já adiciona o usuário na lista de usuários
	public Mesa(int numero, int numLugares, boolean reservado) {
		this.numero = numero;
		this.numLugares = numLugares;
		this.reservado = reservado;
		listaMesas.add(this);
	}

	public static ArrayList<Mesa> getListaMesas() {
		return listaMesas;
	}

	public static void setListaMesas(ArrayList<Mesa> listaMesas) {
		Mesa.listaMesas = listaMesas;
	}

	// getters e setters
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

	// métodos

	// método para verificar o estado da mesa
	public boolean isReservado() {
		return reservado;
	}

	// método para excluir uma mesa da lista
	public static void excluirMesa(Mesa mesa) throws MesaNaoEncontradaException {
		if (listaMesas.contains(mesa)) {
			listaMesas.remove(mesa);
		} else {
			throw new MesaNaoEncontradaException("Mesa não encontrada.");
		}
	}

	// método para editar uma mesa da lista
	public void editarMesa(Mesa mesa) throws MesaNaoEncontradaException {
		int index = listaMesas.indexOf(mesa);
		if (index != -1) {
			mesa.setNumero(this.numero);
			mesa.setReservado(this.reservado);
			mesa.setNumLugares(this.numLugares);
			listaMesas.set(index, mesa);
		} else {
			throw new MesaNaoEncontradaException("Mesa não encontrada.");
		}
	}

	// método para mudar o estado de reserva da mesa (reservá-la)
	public void reservarMesa(Mesa mesa) throws MesaNaoEncontradaException {
		if (listaMesas.contains(mesa)) {
			mesa.setReservado(true);
		} else {
			throw new MesaNaoEncontradaException("Mesa não encontrada.");
		}
	}

	// método para mudar o estado de reserva da mesa (cancelar reserva)
	public void cancelarReservaMesa(Mesa mesa) throws MesaNaoEncontradaException {
		if (listaMesas.contains(mesa)) {
			mesa.setReservado(false);
		} else {
			throw new MesaNaoEncontradaException("Mesa não encontrada.");
		}
	}

	// método para salvar mesas em arquivo
	public void salvarMesaEmArquivo() {
		try (FileWriter escritor = new FileWriter("mesas.txt")) {
			for (Mesa mesa : listaMesas) {
				escritor.write("Mesa: " + mesa.getNumero() + ", Número de lugares: " + mesa.getNumLugares() + ", Reservado: " + mesa.isReservado() + "\n");
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao salvar as mesas.");
			e.printStackTrace();
		}
	}
}
