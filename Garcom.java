import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Garcom extends Usuario {

	private String turno;
	private int idGarcom;
	private String email;
	private String senha;
	private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

	public Garcom(String nome, int idGarcom) {
		super(nome);
		this.idGarcom = idGarcom;
		listaUsuarios.add(this);
	}

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

	public void excluirUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) throws UsuarioNaoEncontradoException {
		if (!listaUsuarios.remove(usuario)) {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}
	}

	public void editarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) throws UsuarioNaoEncontradoException {
		int index = listaUsuarios.indexOf(usuario);
		if (index != -1) {
			if (usuario instanceof Garcom) {
				Garcom garcom = (Garcom) usuario;
				garcom.setNome(nome);
				garcom.setTurno(turno);
				garcom.setIdGarcom(idGarcom);
				garcom.setEmail(email);
				garcom.setSenha(senha);
				listaUsuarios.set(index, garcom);
			} else {
				throw new UsuarioNaoEncontradoException("Apenas garçons podem ser editados.");
			}
		} else {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}
	}

	public void salvarGarcomEmArquivo(Garcom garcom) {
		try (FileWriter escritor = new FileWriter("garcom.txt")) {
			for (Usuario usuario : listaUsuarios) {
				if (usuario instanceof Garcom) {
					Garcom garcom1 = (Garcom) garcom;
					escritor.write("Garçom: " + garcom.getNome() + ", Turno: " + garcom.getTurno() + ", Id: " + garcom.getIdGarcom() + "\n");
				}
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao salvar os dados do garçom.");
			e.printStackTrace();
		}
	}
}
