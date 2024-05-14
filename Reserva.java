public class Reserva {

	private String dataReserva;

	private Mesa mesa;

	private Cliente cliente;

	public Reserva(String dataReserva, Mesa mesa, Cliente cliente) {
		this.dataReserva = dataReserva;
		this.mesa = mesa;
		this.cliente = cliente;
	}

	public String getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(String dataReserva) {
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

	public void criarReserva() {

	}

	public void cancelarReserva() {

	}

	public void editarReserva() {

	}

	public void visualizarReservas() {

	}

}
