package model;

import java.io.Serializable;

public class Restaurante implements Serializable {

	private String nome = "Restaurante Feliz";
	private String culinaria = "Contemporânea";
	private String descricao = "Esse é um ótimo restaurante familiar";
	private String endereco = "Avenida Fulano de Tal 1235";
	private String horarioFuncionamento = "11:30h - 19:30h - Seg - Sáb";
	private String telefone = "(41) 9999-0000";

	// Getters e Setters
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getCulinaria() { return culinaria; }
	public void setCulinaria(String culinaria) { this.culinaria = culinaria; }

	public String getDescricao() { return descricao; }
	public void setDescricao(String descricao) { this.descricao = descricao; }

	public String getEndereco() { return endereco; }
	public void setEndereco(String endereco) { this.endereco = endereco; }

	public String getHorarioFuncionamento() { return horarioFuncionamento; }
	public void setHorarioFuncionamento(String horarioFuncionamento) { this.horarioFuncionamento = horarioFuncionamento; }

	public String getTelefone() { return telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }

}
