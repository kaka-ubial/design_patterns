public abstract class Usuario {

	protected String nome;

	public Usuario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public abstract void adicionarUsuario();

	public abstract void excluirUsuario();

	public abstract void editarUsuario();


}
