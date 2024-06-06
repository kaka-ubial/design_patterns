import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cliente extends Usuario {
	// atributos
	private String telefone;
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

	// construtor que já adiciona o usuário na lista de usuários
	public Cliente(String nome, String telefone) {
		super(nome);
		this.telefone = telefone;
		listaUsuarios.add(this);
	}

	// getters e setters
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	// métodos

	// método para excluir usuários da lista
	public void excluirUsuario(Usuario usuario, ArrayList listaUsuarios) throws UsuarioNaoEncontradoException {
		if (listaUsuarios.contains(usuario)) {
			listaUsuarios.remove(usuario);
		} else {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}
	}

	// método para editar um usuário da lista
	public void editarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) throws UsuarioNaoEncontradoException {
		int index = listaUsuarios.indexOf(usuario);
		if (index != -1) {
			if (usuario instanceof Cliente) {
				Cliente cliente = (Cliente) usuario;
				cliente.setNome(this.getNome());
				cliente.setTelefone(this.telefone);
				listaUsuarios.set(index, cliente);
			} else {
				System.out.println("Apenas clientes podem ser editados.");
			}
		} else {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}
	}


	// método para salvar clientes em arquivo
	public void salvarClienteEmArquivo() {
		try (FileWriter escritor = new FileWriter("clientes.txt")) {
			for (Usuario usuario : listaUsuarios) {
				if (usuario instanceof Cliente) {
					Cliente cliente = (Cliente) usuario;
					escritor.write("Cliente: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone() + "\n");
				}
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao salvar os clientes.");
			e.printStackTrace();
		}
	}

	// método para obter a lista de usuários
	public static ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	}

