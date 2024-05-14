import java.util.ArrayList;

public class Cliente extends Usuario {

	private String telefone;

	private ArrayList<Usuario> listaUsuarios;
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
	public void adicionarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) {
		listaUsuarios.add(usuario);

	}

	public void excluirUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios){
		listaUsuarios.remove(usuario);
	}

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


