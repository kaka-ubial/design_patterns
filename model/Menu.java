package model;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Item> itens;
	private String nome;

	public Menu(ArrayList<Item> itens, String nome) {
		this.nome = nome;
		this.itens = itens != null ? itens : new ArrayList<>();
	}

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public ArrayList<Item> getItens() { return itens; }

	public void adicionarItem(Item item) {
		itens.add(item);
	}

	public void removerItem(Item item) {
		itens.remove(item);
	}
}
