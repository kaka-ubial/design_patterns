package model;

import exceptions.ClienteNaoEncontradoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
public class Cliente extends Usuario {
	private String telefone;

	public Cliente(String nome, String telefone) {
		super(nome);
		this.telefone = telefone;
	}

    public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefone() {
		return telefone;
	}

}




