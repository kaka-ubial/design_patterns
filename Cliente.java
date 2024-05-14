import java.util.ArrayList;

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
	public void adicionarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) {
		listaUsuarios.add(usuario);

	}

	public void excluirUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios){
		listaUsuarios.remove(usuario);
	}

	public void editarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios){
		int index = listaUsuarios.indexOf(usuario);
		if (index != -1){
			usuario.setNome(nome);
			listaUsuarios.set(index, usuario);
		} else {
			System.out.println("Usuário não encontrado.");
		}
	}
}


