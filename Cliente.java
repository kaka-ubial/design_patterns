public class Cliente extends Usuario {

	private String telefone;

	public Cliente(String nome, String telefone) {
		super(nome);
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public void adicionarUsuario() {

	}

	@Override
	public void excluirUsuario() {

	}

	@Override
	public void editarUsuario() {

	}
}


