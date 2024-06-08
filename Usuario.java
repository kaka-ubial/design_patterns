import java.util.ArrayList;

public abstract class Usuario {
 	//atributos
	protected String nome;

	//construtor
	public Usuario(String nome) {
		this.nome = nome;
	}

	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//métodos
	//método para excluir usuários da lista
	public abstract void excluirUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) throws UsuarioNaoEncontradoException;

	//método para editar um usuário da lista
	public abstract void editarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) throws UsuarioNaoEncontradoException;


}
