import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Garcom extends Usuario{

	//atributos
	private String turno;

	private int idGarcom;

	private String email;

	private String senha;

	private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

	//construtor que ja adiciona o usuário na lista de usuarios
	public Garcom(String nome, String turno, int idGarcom, String email, String senha) {
		super(nome);
		this.turno = turno;
		this.idGarcom = idGarcom;
		this.email = email;
		this.senha = senha;

		listaUsuarios.add(this);
	}
	//getters e setters
	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getIdGarcom() {
		return idGarcom;
	}

	public ArrayList<Usuario> getlistaUsuarios() {
		return listaUsuarios;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
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
			if (usuario instanceof Garcom) {
				Garcom garcom = (Garcom) usuario;
				garcom.setNome(nome);
				garcom.setTurno(turno);
				garcom.setIdGarcom(idGarcom);
				garcom.setEmail(email);
				garcom.setSenha(senha);
				listaUsuarios.set(index, garcom);
			} else {
				System.out.println("Apenas garçons podem ser editados.");
			}
		} else {
			System.out.println("Usuário não encontrado.");
		}
	}
	private static void salvarGarcomEmArquivo(Garcom garcom) {
		try (FileWriter escritor = new FileWriter("garcons.txt", true)) {
			escritor.write("ID: " + garcom.getIdGarcom() + ", Nome: " + garcom.getNome() + ", Turno: " + garcom.getTurno() + ", Email: " + garcom.getEmail() + "\n");
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao salvar os dados do garçom.");
			e.printStackTrace();
		}
	}
}
