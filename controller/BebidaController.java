package controller;

import exceptions.BebidaException;
import exceptions.BebidaNaoEncontradaException;
import model.Bebida;
import view.BebidaView;
import java.util.ArrayList;
import java.util.Scanner;

public class BebidaController {
    private ArrayList<Bebida> listaBebidas = new ArrayList<>();
    public BebidaView view;

    public BebidaController (BebidaView view){
        this.view = view;
    }

    public ArrayList<Bebida> getListaBebidas() {
        return listaBebidas;
    }

    public void adicionarBebida(String nome, double preco, String descricao, boolean alcoolica) throws BebidaException {
        if (preco <= 0) {
            throw new BebidaException("Preço deve ser maior que zero.");
        }
        Bebida novaBebida = new Bebida(nome, preco, descricao, alcoolica);
        listaBebidas.add(novaBebida);
    }

    public Bebida encontrarBebida(int idBebida) {
        for (Bebida bebida : listaBebidas) {
            if (bebida.getIdItem() == idBebida) {
                return bebida;
            }
        }
        return null;
    }

    public void editarBebida(int idBebida, double novoPreco) throws BebidaException {
        Bebida bebida = encontrarBebida(idBebida);
        if (bebida != null){
            bebida.setPrecoItem(novoPreco);
        } else {
            throw new BebidaException("Bebida não encontrada");
        }
    }

    public void excluirBebida(int idBebida) {
        Bebida bebida = encontrarBebida(idBebida);
        if (bebida != null){
            listaBebidas.remove(bebida);
        } else {
            throw new BebidaNaoEncontradaException("Bebida não encontrada");
        }
    }

    public void listarBebidas() {
        view.exibirTodasBebidas(listaBebidas);
    }
}
