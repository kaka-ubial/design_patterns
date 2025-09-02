package model;

import exceptions.ItemNaoEncontradoException;
import java.util.ArrayList;

public class Pedido {
	private static int proximoId = 1;
	private int idComanda;
	private ArrayList<Item> itensComanda = new ArrayList<>();
	private double precoTotal;
	private boolean pago;
	private Mesa mesa;

	public Pedido(Mesa mesa) {
		this.idComanda = proximoId++;
		this.mesa = mesa;
		this.precoTotal = 0;
		this.pago = false;
	}

	public void adicionarItem(Item item) {
		itensComanda.add(item);
		precoTotal += item.getPrecoItem();
	}

	public void removerItem(Item item) throws ItemNaoEncontradoException {
		if (!itensComanda.remove(item)) {
			throw new ItemNaoEncontradoException("Item não encontrado na comanda.");
		}
		precoTotal -= item.getPrecoItem();
	}

	public double calcularPrecoTotal() {
		return precoTotal;
	}

	public void pagar() {
		this.pago = true;
	}

	// Getters
	public int getIdComanda() { return idComanda; }
	public ArrayList<Item> getItensComanda() { return itensComanda; }
	public double getPrecoTotal() { return precoTotal; }
	public boolean isPago() { return pago; }
	public Mesa getMesa() { return mesa; }
}
