package model;
import controller.MesaController;
import exceptions.ClienteNaoEncontradoException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Reserva {
	private static int contador = 1;
	private int idReserva;
	private Date dataReserva;
	private Mesa mesa;
	private Cliente cliente;

	public Reserva(Date dataReserva, Mesa mesa, Cliente cliente) {
		this.idReserva = contador++;
		this.dataReserva = dataReserva;
		this.mesa = mesa;
		this.cliente = cliente;
	}

	public int getIdReserva() {
		return idReserva;
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

}
