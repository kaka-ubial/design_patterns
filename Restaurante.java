import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Restaurante implements MinhaSerializable, Serializable {
	//atributos
	private String nome;

	private String culinaria;

	private String descricao;

	private String endereco;

	private String horarioFuncionamento;

	private String telefone;


	public Restaurante() {
		this.nome = "Restaurante Feliz";
		this.culinaria = "Contemporânea";
		this.endereco = "Avenida Fulano de Tal 1235";
		this.descricao = "Esse é um ótimo restaurante familiar";
		this.horarioFuncionamento = "11:30h - 19:30h - Seg - Sáb";
		this.telefone = "(41) 9999-0000";

	}

	// getters e setters

	public String getNome() {return nome;}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCulinaria() {return culinaria;}

	public void setCulinaria(String culinaria) {
		this.culinaria = culinaria;
	}

	public String getDescricao() {return descricao;}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {return endereco;}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {return telefone;}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getHorarioFuncionamento() {return horarioFuncionamento;}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public void exibirInfo() {
		System.out.println("Nome: " + nome);
		System.out.println("Culinária: " + culinaria);
		System.out.println("Descrição: " + descricao);
		System.out.println("Endereço: " + endereco);
		System.out.println("Horário de Funcionamento: " + horarioFuncionamento);
		System.out.println("Telefone: " + telefone);
	}

	public void editarInfo(String nome, String culinaria, String descricao, String endereco, String horarioFuncionamento, String telefone) {
		setNome(nome);
		setCulinaria(culinaria);
		setDescricao(descricao);
		setEndereco(endereco);
		setHorarioFuncionamento(horarioFuncionamento);
		setTelefone(telefone);
	}

	public byte[] serializar() throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try (ObjectOutputStream escritor = new ObjectOutputStream(byteArrayOutputStream)) {
			escritor.writeObject(this);
		}
		return byteArrayOutputStream.toByteArray();
	}

	@Override
	public void desserializar(byte[] dados) throws IOException, ClassNotFoundException {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dados);
		try (ObjectInputStream leitor = new ObjectInputStream(byteArrayInputStream)) {
			Restaurante restaurante = (Restaurante) leitor.readObject();
			this.nome = restaurante.nome;
			this.culinaria = restaurante.culinaria;
			this.descricao = restaurante.descricao;
			this.endereco = restaurante.endereco;
			this.horarioFuncionamento = restaurante.horarioFuncionamento;
			this.telefone = restaurante.telefone;
		}
	}

	public void salvarRestauranteEmArquivo() {
		try (FileWriter escritor = new FileWriter("restaurante.txt")) {
			escritor.write("Nome: " + nome + "\n");
			escritor.write("Culinaria: " + culinaria + "\n");
			escritor.write("Descrição: " + descricao + "\n");
			escritor.write("Endereço: " + endereco + "\n");
			escritor.write("Horário de Funcionamento: " + horarioFuncionamento + "\n");
			escritor.write("Telefone: " + telefone + "\n");
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao salvar as informações do restaurante.");
			e.printStackTrace();
		}
	}
}