import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
public class Cliente extends Usuario {
	//atributos
	private String telefone;

	private static ArrayList<Cliente> listaClientes = new ArrayList<>();

	//construtor que ja adiciona o usuário na lista de usuarios
	public Cliente(String nome, String telefone) {
		super(nome);
		this.telefone = telefone;
		listaClientes.add(this);
	}

	public static void inicializarClientes() {
		new Cliente("João", "123456789");
		new Cliente("Maria", "987654321");
		new Cliente("Carlos", "555555555");
		new Cliente("Ana", "111222333");
		new Cliente("Pedro", "444555666");
	}

	public static Cliente encontrarCliente(String nomeCliente) throws ClienteNaoEncontradoException {
		for (Cliente cliente : listaClientes) {
			if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
				return cliente; // Retorna o cliente encontrado
			}
		}
		throw new ClienteNaoEncontradoException("Cliente não encontrado: " + nomeCliente);
	}

    public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
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

	public static void imprimirListaClientes() {
		System.out.println("Lista de clientes:");
		for (Cliente cliente : listaClientes) {
			System.out.println("Nome: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone());
		}
	}

	public void salvarClienteEmArquivo() {
		try (FileWriter escritor = new FileWriter("clientes.txt")) {
			for (Usuario usuario : listaClientes) {
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

	public static void carregarClientesDoArquivo() {
		try (BufferedReader leitor = new BufferedReader(new FileReader("clientes.txt"))) {
			String linha;
			while ((linha = leitor.readLine()) != null) {
				if (linha.startsWith("Cliente: ")) {
					String[] partes = linha.split(", Telefone: ");
					String nome = partes[0].substring(9); // Remove "Cliente: "
					String telefone = partes[1];
					Cliente cliente = new Cliente(nome, telefone);
					listaClientes.add(cliente);
				}
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao carregar os clientes.");
			e.printStackTrace();
		}
	}
		}




