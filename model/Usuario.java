package model;

import exceptions.UsuarioNaoEncontradoException;

import java.util.ArrayList;


public abstract class Usuario {
	private static int contador = 1;
	private int idUsuario;
	protected String nome;

	public Usuario(String nome) {
		this.idUsuario = contador++;
		this.nome = nome;
	}

	public int getIdUsuario() { return idUsuario; }

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void excluirUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) throws UsuarioNaoEncontradoException {
		if (!listaUsuarios.remove(usuario)) {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}
	}

	public void editarUsuario(Usuario usuario, ArrayList<Usuario> listaUsuarios) throws UsuarioNaoEncontradoException {
		int index = listaUsuarios.indexOf(usuario);
		if (index != -1) {
			listaUsuarios.set(index, usuario);
		} else {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}
	}
}

