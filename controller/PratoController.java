package controller;

import exceptions.PratoException;
import model.Prato;
import view.PratoView;

import java.util.ArrayList;

public class PratoController {
    private ArrayList<Prato> listaPratos = new ArrayList<>();
    public PratoView view;

    public PratoController(PratoView view){
        this.view = view;
    }

    public ArrayList<Prato> getListaPratos() {
        return listaPratos;
    }

    public void adicionarPrato(String nome, double preco, String descricao, boolean vegano, boolean gluten, boolean lactose) throws PratoException {
        if (preco <= 0) {
            throw new PratoException("Preço deve ser maior que zero.");
        }
        Prato novoPrato = new Prato(nome, preco, descricao, vegano, gluten, lactose);
        listaPratos.add(novoPrato);
    }

    public Prato encontrarPrato(int idPrato) {
        for (Prato prato : listaPratos) {
            if (prato.getIdItem() == idPrato) {
                return prato;
            }
        }
        return null;
    }

    public void excluirPrato(int idPrato) throws PratoException {
        Prato prato = encontrarPrato(idPrato);
        if (prato != null){
            listaPratos.remove(prato);
        } else {
            throw new PratoException("Prato não encontrado");
        }
    }

    public void editarPrato(int idPrato, double precoNovo) throws PratoException {
        Prato prato = encontrarPrato(idPrato);
        if (prato != null){
            prato.setPrecoItem(precoNovo);
        } else {
            throw new PratoException("Prato não encontrado");
        }
    }

    public void listarPratos() {
        view.exibirTodosPratos(listaPratos);
    }

}
