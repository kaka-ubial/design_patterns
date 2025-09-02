package view;

import model.Bebida;
import model.Vinho;

import java.util.ArrayList;

public class VinhoView {
    public void exibirTodosVinhos(ArrayList<Vinho> vinhos) {
        for (Vinho vinho : vinhos) {
            System.out.println("Id: " + vinho.getIdItem() +
                    " | Nome: " + vinho.getNomeItem() +
                    " | Preço: " + vinho.getPrecoItem() +
                    " | Descrição: " + vinho.getDescricaoItem() +
                    " | Idade: " + vinho.getIdadeVinho() +
                    " | Nacionalidade: " + vinho.getNacionalidade() +
                    " | Tipo: " + vinho.getTipo() +
                    " | Uva: " + vinho.getUva() +
                    " | Corpo: " + vinho.getCorpo() +
                    " | Teor Alcoólico: " + vinho.getTeorAlcoolico());
        }
    }
}
