import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Reserva {
	//atributos
	private Date dataReserva;

	private Mesa mesa;

	private Cliente cliente;


	//construtor que adiciona a reserva na lista logo depois do objeto ser instanciado
	public Reserva(Date dataReserva, Mesa mesa, Cliente cliente, ArrayList<Reserva> listaReservas) {
		this.dataReserva = dataReserva;
		this.mesa = mesa;
		this.cliente = cliente;
		listaReservas.add(this);
		mesa.setReservado(true);
	}

	//getters e setters
	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public static void inicializarReservas(ArrayList<Reserva> listaReservas) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date data1 = dateFormat.parse("21/12/2024");
			Date data2 = dateFormat.parse("22/12/2024");
			Date data3 = dateFormat.parse("23/12/2024");

			Mesa mesa1 = Mesa.encontrarMesa(1);
			Mesa mesa4 = Mesa.encontrarMesa(4);
			Mesa mesa7 = Mesa.encontrarMesa(7);

			Cliente clienteJoao = Cliente.encontrarCliente("João");
			Cliente clienteCarlos = Cliente.encontrarCliente("Carlos");
			Cliente clienteAna = Cliente.encontrarCliente("Ana");

			new Reserva(data1, mesa1, clienteJoao, listaReservas);
			new Reserva(data2, mesa4, clienteCarlos, listaReservas);
			new Reserva(data3, mesa7, clienteAna, listaReservas);
		} catch (ParseException | ClienteNaoEncontradoException e) {
			e.printStackTrace();
		}
	}

	public static void cancelarReserva(ArrayList<Reserva> listaReservas, String dataReservaStr, String nomeCliente, int numMesa) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dataReserva = dateFormat.parse(dataReservaStr);

			boolean reservaEncontrada = false;

			for (Reserva reserva : listaReservas) {
				if (reserva.getDataReserva().compareTo(dataReserva) == 0 &&
						reserva.getMesa().getNumero() == numMesa &&
						reserva.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
					listaReservas.remove(reserva);
					Mesa mesa = reserva.getMesa();
					mesa.cancelarReservaMesa(mesa);
					System.out.println("Reserva cancelada com sucesso.");
					reservaEncontrada = true;
					break;
				}
			}

			if (!reservaEncontrada) {
				System.out.println("Reserva não encontrada.");
			}
		} catch (ParseException e) {
			System.out.println("Formato de data inválido.");
		}
	}


	//método para editar uma reserva
	public void editarReserva(Reserva reserva) {
		reserva.setDataReserva(dataReserva);
		reserva.setCliente(cliente);
		reserva.setMesa(mesa);
	}


	//método para visualizar todas as reservas na lista de reservas
	public static void visualizarReservas(ArrayList<Reserva> listaReservas) {
		if (listaReservas.isEmpty()) {
			System.out.println("Nenhuma reserva encontrada.");
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			for (Reserva reserva : listaReservas) {
				String dataFormatada = dateFormat.format(reserva.getDataReserva());
				System.out.println("Data da Reserva: " + dataFormatada);
				System.out.println("Mesa: " + reserva.getMesa().getNumero());
				System.out.println("Cliente: " + reserva.getCliente().getNome());
				System.out.println("----------------------------------");
			}
		}
	}


}
