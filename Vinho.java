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

	@Override
	public void adicionarItem() {

	}

	@Override
	public void editarItem() {

	}

	@Override
	public void excluirItem() {

	}

	@Override
	public void listarItens() {

	}

	public void exibirInfo() {

	}

}
