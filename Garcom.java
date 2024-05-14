public class Garcom extends Usuario{
	//atributos
	private String turno;

	private int idGarcom;
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
	public void adicionarUsuario(){

	}

	public void excluirUsuario(){

	}

	public void editarUsuario(){

	}
}
