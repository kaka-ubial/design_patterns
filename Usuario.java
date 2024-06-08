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
	public void excluirUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) throws UsuarioNaoEncontradoException {
		if (!listaUsuarios.remove(usuario)) {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}
	}

	// Método para editar um usuário da lista
	public void editarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) throws UsuarioNaoEncontradoException {
		int index = listaUsuarios.indexOf(usuario);
		if (index != -1) {
			listaUsuarios.set(index, usuario);
		} else {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}
	}
}

