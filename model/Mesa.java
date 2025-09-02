package model;

import exceptions.MesaException;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Mesa {
	private int numero;
	private int numLugares;
	private boolean reservado;

	public Mesa(int numero, int numLugares, boolean reservado) {
		this.numero = numero;
		this.numLugares = numLugares;
		this.reservado = reservado;
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
	public void reservarMesa() {
		this.reservado = true;
	}
	public void cancelarReservaMesa() {
		reservado = false;
	}
}
