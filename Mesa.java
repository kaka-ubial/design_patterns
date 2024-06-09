import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Mesa {
	private int numero;
	private int numLugares;
	private boolean reservado;
	private static ArrayList<Mesa> listaMesas = new ArrayList<>();

	public Mesa(int numero, int numLugares, boolean reservado) {
		this.numero = numero;
		this.numLugares = numLugares;
		this.reservado = reservado;
		listaMesas.add(this);
	}

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

	public static ArrayList<Mesa> getListaMesas() {
		return listaMesas;
	}

	public static void inicializarMesas() {
		// Define os números de lugares para cada mesa
		int[] numLugaresPorMesa = {4, 6, 2, 8, 4, 6, 2, 8, 4, 6};

		// Cria as mesas com números de lugares diferentes
		for (int i = 0; i < numLugaresPorMesa.length; i++) {
			Mesa mesa = new Mesa(i + 1, numLugaresPorMesa[i], false);
		}
	}

	public static void adicionarMesa(int numero, int numLugares, boolean reservado) throws MesaException {
		if (numero <= 0 || numLugares <= 0) {
			throw new MesaException("Número e número de lugares da mesa devem ser maiores que zero.");
		}
		Mesa novaMesa = new Mesa(numero, numLugares, reservado);
		System.out.println("Mesa criada com sucesso!");
	}


	public static void exibirTodasMesas() {
		for (Mesa mesa : listaMesas) {
			System.out.println("Número da Mesa: " + mesa.getNumero());
			System.out.println("Número de Lugares: " + mesa.getNumLugares());
			System.out.println("Reservado: " + (mesa.isReservado() ? "Sim" : "Não"));
			System.out.println("------------------------");
		}
	}

	public void excluirMesa(Mesa mesa) {
		listaMesas.remove(mesa);
	}

	public void editarMesa(Mesa mesa) {
		int index = listaMesas.indexOf(mesa);
		if (index != -1) {
			mesa.setNumero(numero);
			mesa.setReservado(reservado);
			mesa.setNumLugares(numLugares);
			listaMesas.set(index, mesa);
		} else {
			System.out.println("Mesa não encontrada.");
		}
	}

	public void reservarMesa() {
		reservado = true;
	}

	public void cancelarReservaMesa(Mesa mesa) {
		reservado = false;
	}
	public static Mesa encontrarMesa(int numeroMesa) {
		for (Mesa mesa : listaMesas) {
			if (mesa.getNumero() == numeroMesa) {
				return mesa;
			}
		}
		return null;
	}

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
