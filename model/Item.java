package model;

import java.text.DecimalFormat;

public abstract class Item {
	private static int contador = 1;
	private int idItem;
	private String nomeItem;
	private double precoItem;
	private String descricaoItem;

	public Item(String nomeItem, double precoItem, String descricaoItem) {
		this.idItem = contador++;
		this.nomeItem = nomeItem;
		this.precoItem = precoItem;
		this.descricaoItem = descricaoItem;
	}

	public int getIdItem() { return idItem; }
	public String getNomeItem() { return nomeItem; }
	public void setNomeItem(String nomeItem) { this.nomeItem = nomeItem; }
	public double getPrecoItem() { return precoItem; }
	public void setPrecoItem(double precoItem) { this.precoItem = precoItem; }
	public String getDescricaoItem() { return descricaoItem; }
	public void setDescricaoItem(String descricaoItem) { this.descricaoItem = descricaoItem; }

	public String precoFormatado() {
		return new DecimalFormat("#.00").format(precoItem);
	}

	@Override
	public String toString() {
		return "Nome: " + nomeItem +
				"\nPreço: " + precoFormatado() +
				"\nDescrição: " + descricaoItem;
	}
}
