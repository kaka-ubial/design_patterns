public class Restaurante {
	//atributos
	private String nome;

	private String culinaria;

	private String descricao;

	private String endereco;

	private String horarioFuncionamento;

	private String telefone;

	public Restaurante(String nome, String culinaria, String descricao, String endereco, String telefone) {
		this.nome = nome;
		this.culinaria = culinaria;
		this.endereco = endereco;
		this.descricao = descricao;
		this.horarioFuncionamento = endereco;
		this.telefone = telefone;
	}

	// getters e setters

	public String getNome() {return nome;}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCulinaria() {return culinaria;}

	public void setCulinaria(String culinaria) {
		this.culinaria = culinaria;
	}

	public String getDescricao() {return descricao;}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {return endereco;}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {return telefone;}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getHorarioFuncionamento() {return horarioFuncionamento;}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public void exibirInfo() {
		System.out.println("Nome: " + nome);
		System.out.println("Culinaria: " + culinaria);
		System.out.println("Descrição: " + descricao);
		System.out.println("Endereço: " + endereco);
		System.out.println("Horário de Funcionamento: " + horarioFuncionamento);
		System.out.println("Telefone: " + telefone);
	}

	public void editarInfo(String nome, String culinaria, String descricao, String endereco, String horarioFuncionamento, String telefone)) {
		setNome(nome);
		setCulinaria(culinaria);
		setDescricao(descricao);
		setEndereco(endereco);
		setHorarioFuncionamento(horarioFuncionamento);
		setTelefone(telefone); }

	}

}
