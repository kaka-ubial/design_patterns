import java.text.DecimalFormat;

public class Vinho extends Item {
	private int idadeVinho;
	private String nacionalidade;
	private String tipo;
	private String uva;
	private String corpo;
	private String teorAlcoolico;

	public Vinho(String nomeItem, double precoItem, String descricaoItem, int idadeVinho, String nacionalidade, String tipo, String uva, String corpo, String teorAlcoolico) {
		super(nomeItem, precoItem, descricaoItem);
		this.idadeVinho = idadeVinho;
		this.nacionalidade = nacionalidade;
		this.tipo = tipo;
		this.uva = uva;
		this.corpo = corpo;
		this.teorAlcoolico = teorAlcoolico;
	}

	// Getters e Setters omitidos para brevidade

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Nome: " + getNomeItem() +
				"\nPreço: " + df.format(getPrecoItem()) +
				"\nDescrição: " + getDescricaoItem() +
				"\nIdade do Vinho: " + idadeVinho +
				"\nNacionalidade: " + nacionalidade +
				"\nTipo: " + tipo +
				"\nUva: " + uva +
				"\nCorpo: " + corpo +
				"\nTeor Alcoólico: " + teorAlcoolico;
	}
}
