import java.util.ArrayList;

public abstract class Usuario {

	protected String nome;

	public Usuario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public abstract void adicionarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios);

	public abstract void excluirUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios);

	public abstract void editarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios);


}
