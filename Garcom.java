import java.util.ArrayList;
import java.util.List;
public class Garcom extends Usuario{

	//atributos
	private String turno;

	private int idGarcom;

	private ArrayList<Usuario> listaUsuarios;

	//construtor
	public Garcom(String nome, String turno, int idGarcom) {
		super(nome);
		this.turno = turno;
		this.idGarcom = idGarcom;
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

	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}

	//métodos
	//método para adicionar um novo usuário dentro da lista de usuários
	public void adicionarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) {
		listaUsuarios.add(usuario);

	}

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
				listaUsuarios.set(index, garcom);
			} else {
				System.out.println("Apenas garçons podem ser editados.");
			}
		} else {
			System.out.println("Usuário não encontrado.");
		}
	}
}
