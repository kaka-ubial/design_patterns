import java.util.ArrayList;

public class Cliente extends Usuario {
	//atributos
	private String telefone;

	private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

	//construtor que ja adiciona o usuário na lista de usuarios
	public Cliente(String nome, String telefone) {
		super(nome);
		this.telefone = telefone;
		listaUsuarios.add(this);
	}

	//getters e setters
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	//métodos

	//método para excluir usuários da lista
	public void excluirUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios){
		listaUsuarios.remove(usuario);
	}

	//método para editar um usuário da lista
	public void editarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios){
		int index = listaUsuarios.indexOf(usuario);
		if (index != -1){
			if (usuario instanceof Cliente) {
				Cliente cliente = (Cliente) usuario;
				cliente.setNome(nome);
				cliente.setTelefone(telefone);
				listaUsuarios.set(index, cliente);
			} else {
				System.out.println("Apenas clientes podem ser editados.");
			}
		} else {
			System.out.println("Usuário não encontrado.");
		}
	}

}


