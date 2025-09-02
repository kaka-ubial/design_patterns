package model;

import exceptions.UsuarioNaoEncontradoException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Garcom extends Usuario {
	private String turno;
	private String email;
	private String senha;

	public Garcom(String nome, String turno, String email, String senha) {
		super(nome);
		this.turno = turno;
		this.email = email;
		this.senha = senha;
	}

	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
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
}
