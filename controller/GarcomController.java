package controller;

import exceptions.GarcomException;
import model.Garcom;
import model.Usuario;
import view.GarcomView;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GarcomController {
    private static ArrayList<Garcom> listaGarcons = new ArrayList<>();
    public GarcomView view;

    public GarcomController(GarcomView view){
        this.view = view;
    }

    public ArrayList<Garcom> getListaGarcom() {
        return listaGarcons;
    }

    public static void inicializarGarcom() {
        listaGarcons.add(new Garcom("João", "Noturno", "joao@gmail.com", "1234"));
        listaGarcons.add(new Garcom("Maria", "Noturno", "maria@gmail.com", "5678"));
    }

    public Garcom login(String email, String senha) throws GarcomException {
        if (email == null || email.isBlank() || senha == null || senha.isBlank()) {
            throw new GarcomException("Email e senha não podem estar vazios.");
        }

        for (Garcom garcom : listaGarcons) {
            if (garcom.getEmail().equalsIgnoreCase(email) && garcom.getSenha().equals(senha)) {
                return garcom;
            }
        }

        throw new GarcomException("Email ou senha incorretos.");
    }

    public void adicionarGarcom(String nome, String turno, String email, String senha) {
        if (nome == null || nome.isBlank() || turno == null || email == null || senha == null ) {
            throw new GarcomException("Não são aceitos campos vazios");
        }
        Garcom novoGarcom = new Garcom(nome, turno, email, senha);
        listaGarcons.add(novoGarcom);
    }

    public static Garcom encontrarGarcom(int idGarcom) throws GarcomException {
        for (Garcom garcom : listaGarcons) {
            if (garcom.getIdUsuario() == idGarcom) {
                return garcom;
            }
        }
        throw new GarcomException("Garcom não encontrado: " + idGarcom);
    }

    private void atualizarSeNaoVazio(String valor, java.util.function.Consumer<String> setter) {
        if (valor != null && !valor.isBlank()) setter.accept(valor);
    }

    public void editarGarcom(int idGarcom, String novoNome, String novoTurno, String novoEmail, String novaSenha) throws GarcomException {
        Garcom garcom = encontrarGarcom(idGarcom);

        atualizarSeNaoVazio(novoNome, garcom::setNome);
        atualizarSeNaoVazio(novoTurno, garcom::setTurno);
        atualizarSeNaoVazio(novoEmail, garcom::setEmail);
        atualizarSeNaoVazio(novaSenha, garcom::setSenha);
    }

    public void excluirGarcom(int idGarcom) throws GarcomException {
        Garcom garcom = encontrarGarcom(idGarcom);
        listaGarcons.remove(garcom);
    }

    public void listarGarcons() {
        view.exibirTodosGarcons(listaGarcons);
    }



    public void salvarGarconsEmArquivo() {
        try (FileWriter escritor = new FileWriter("resources/garcons.txt")) {
            for (Garcom garcom : listaGarcons) {
                escritor.write("Garçom: " + garcom.getNome() +
                        ", Turno: " + garcom.getTurno() +
                        ", Email: " + garcom.getEmail() +
                        ", ID: " + garcom.getIdUsuario() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os garçons.");
            e.printStackTrace();
        }
    }

}
