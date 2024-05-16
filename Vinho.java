import java.util.ArrayList;

public class Vinho extends Item {

	private int idadeVinho;

	private String nacionalidade;

	private String tipo;

	private String uva;

	private String corpo;

	private String teorAlcoolico;

	private ArrayList<Vinho> catalogoVinhos;

	public Vinho(String nomeItem, double precoItem, String descricaoItem, int idadeVinho, String nacionalidade, String tipo, String uva, String corpo, String teorAlcoolico) {
		super(nomeItem, precoItem, descricaoItem);
		this.idadeVinho = idadeVinho;
		this.nacionalidade = nacionalidade;
		this.tipo = tipo;
		this.uva = uva;
		this.corpo = corpo;
		this.teorAlcoolico = teorAlcoolico;
		catalogoVinhos.add(this);
	}

	public int getIdadeVinho() {
		return idadeVinho;
	}

	public void setIdadeVinho(int idadeVinho) {
		this.idadeVinho = idadeVinho;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUva() {
		return uva;
	}

	public void setUva(String uva) {
		this.uva = uva;
	}
	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(String teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public void editarItem(Item item) {
		if (item instanceof Vinho) {
				Vinho vinho = (Vinho) item;
				for (int i = 0; i < catalogoVinhos.size(); i++) {
						if (catalogoVinhos.get(i).getNomeItem().equals(vinho.getNomeItem())) {
								catalogoVinhos.set(i, vinho);
								break;
						}
				}
		}
	}

	@Override
	public void excluirItem(Item item) {
			if (item instanceof Vinho) {
					Vinho vinho = (Vinho) item;
					for (int i = 0; i < catalogoVinhos.size(); i++) {
							if (catalogoVinhos.get(i).getNomeItem().equals(vinho.getNomeItem())) {
									catalogoVinhos.remove(i);
									break;
							}
					}
			}
	}
	
	@Override
	public void listarItens(ArrayList<Item> itens) {
		for (Item item : itens) {
			if (item instanceof Vinho) {
					Vinho vinho = (Vinho) item;
					System.out.println("Nome: " + vinho.getNomeItem());
					System.out.println("Preço: " + vinho.getPrecoItem());
					System.out.println("Descrição: " + vinho.getDescricaoItem());
					System.out.println("Idade do Vinho: " + vinho.getIdadeVinho());
					System.out.println("Nacionalidade: " + vinho.getNacionalidade());
					System.out.println("Tipo: " + vinho.getTipo());
					System.out.println("Uva: " + vinho.getUva());
					System.out.println("Corpo: " + vinho.getCorpo());
					System.out.println("Teor Alcoólico: " + vinho.getTeorAlcoolico());
					System.out.println();
			}
	}
	}

	public void exibirInfo(ArrayList<Item> itens) {
		System.out.println("Nome: " + this.getNomeItem());
		System.out.println("Preço: " + this.getPrecoItem());
		System.out.println("Descrição: " + this.getDescricaoItem());
		System.out.println("Idade do Vinho: " + this.getIdadeVinho());
		System.out.println("Nacionalidade: " + this.getNacionalidade());
		System.out.println("Tipo: " + this.getTipo());
		System.out.println("Uva: " + this.getUva());
		System.out.println("Corpo: " + this.getCorpo());
		System.out.println("Teor Alcoólico: " + this.getTeorAlcoolico());
		System.out.println();
	}

}
