package model;

import java.util.ArrayList;
import java.text.DecimalFormat;


public class Prato extends Item {
	private boolean vegano;
	private boolean gluten;
	private boolean lactose;

	public Prato(String nomeItem, double precoItem, String descricaoItem, boolean vegano, boolean gluten, boolean lactose) {
		super(nomeItem, precoItem, descricaoItem);
		this.vegano = vegano;
		this.gluten = gluten;
		this.lactose = lactose;
	}

	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public boolean isLactose() {
		return lactose;
	}

	public void setLactose(boolean lactose) {
		this.lactose = lactose;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ").append(getNomeItem())
				.append("\nPreço: ").append(df.format(getPrecoItem()))
				.append("\nDescrição: ").append(getDescricaoItem());

		if (vegano) {
			sb.append("\nVegano");
		}
		if (gluten) {
			sb.append("\nContém Glúten");
		}
		if (lactose) {
			sb.append("\nContém Lactose");
		}

		return sb.toString();
	}


}
