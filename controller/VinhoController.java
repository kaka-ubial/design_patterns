package controller;

import exceptions.VinhoException;
import model.Vinho;
import view.VinhoView;

import java.util.ArrayList;

public class VinhoController {
    private ArrayList<Vinho> listaVinhos = new ArrayList<>();
    public VinhoView view;

    public VinhoController (VinhoView view){
        this.view = view;
    }

    public ArrayList<Vinho> getListaVinhos() {
        return listaVinhos;
    }

    public void adicionarVinho(String nome, double preco, String descricao, int idadeVinho, String nacionalidade, String tipo, String uva, String corpo, String teorAlcoolico) throws VinhoException {
        if (preco <= 0) {
            throw new VinhoException("Preço deve ser maior que zero.");
        }
        Vinho novoVinho = new Vinho(nome, preco, descricao, idadeVinho, nacionalidade, tipo, uva, corpo, teorAlcoolico);
        listaVinhos.add(novoVinho);
    }

    public Vinho encontrarVinho(int idVinho) {
        for (Vinho vinho : listaVinhos) {
            if (vinho.getIdItem() == idVinho) {
                return vinho;
            }
        }
        return null;
    }

    public void editarVinho(int idVinho, double novoPreco) throws VinhoException {
        Vinho vinho = encontrarVinho(idVinho);
        if (vinho != null){
            vinho.setPrecoItem(novoPreco);
        } else {
            throw new VinhoException("Vinho não encontrado");
        }
    }

    public void excluirVinho(int idVinho) {
        Vinho vinho = encontrarVinho(idVinho);
        if (vinho != null){
            listaVinhos.remove(vinho);
        } else {
            throw new VinhoException("Vinho não encontrado");
        }
    }

    public void listarVinhos() {
        view.exibirTodosVinhos(listaVinhos);
    }

}
