import java.util.ArrayList;
import java.util.Date;

public class Reserva {
	//atributos
	private Date dataReserva;

	private Mesa mesa;

	private Cliente cliente;

	private static ArrayList<Reserva> listaReservas = new ArrayList<>();

	//construtor que adiciona a reserva na lista logo depois do objeto ser instanciado
	public Reserva(Date dataReserva, Mesa mesa, Cliente cliente) {
		this.dataReserva = dataReserva;
		this.mesa = mesa;
		this.cliente = cliente;
		listaReservas.add(this);
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

	public ArrayList<Reserva> getListaReservas() {
		if (listaReservas.isEmpty()) {
			System.out.println("Lista de reservas está vazia.");
		}
		return listaReservas;
	}


	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}


	//métodos
	//método para cancelar uma reserva, remove ela da lista e muda o estado da mesa para reservada =  false
	public void cancelarReserva(Reserva reserva) {
		listaReservas.remove(reserva);
		Mesa mesa = reserva.getMesa();
		mesa.cancelarReservaMesa(mesa);
	}

	//método para editar uma reserva
	public void editarReserva(Reserva reserva) {
		reserva.setDataReserva(dataReserva);
		reserva.setCliente(cliente);
		reserva.setMesa(mesa);
	}


	//método para visualizar todas as reservas na lista de reservas
	public static void visualizarReservas() {
		if (listaReservas.isEmpty()){
			System.out.println("Nenhuma reserva encontrada.");
		}
		else{
			for (Reserva reserva : listaReservas) {
				System.out.println("Data da Reserva: " + reserva.getDataReserva());
				System.out.println("Mesa: " + reserva.getMesa());
				System.out.println("Cliente: " + reserva.getCliente());
				System.out.println("----------------------------------");
			}}
	}


}
