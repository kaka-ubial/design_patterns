package model;

import java.text.DecimalFormat;

public class Bebida extends Item {
	private boolean alcoolica;

	public Bebida(String nomeItem, double precoItem, String descricaoItem, boolean alcoolica) {
		super(nomeItem, precoItem, descricaoItem);
		this.alcoolica = alcoolica;
	}

	public boolean isAlcoolica() {
		return alcoolica;
	}
	public void setAlcoolica(boolean alcoolica) {
		this.alcoolica = alcoolica;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Nome: " + getNomeItem() +
				"\nPreço: " + df.format(getPrecoItem()) +
				"\nDescrição: " + getDescricaoItem() +
				"\nAlcoólica: " + (alcoolica ? "Sim" : "Não");
	}
}
