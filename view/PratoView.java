package view;

import model.Prato;

import java.util.ArrayList;

public class PratoView {
    public void exibirTodosPratos(ArrayList<Prato> pratos) {
        for (Prato prato : pratos) {
            System.out.println("Id: " + prato.getIdItem() +
                    " | Nome: " + prato.getNomeItem() +
                    " | Preço: " + prato.getPrecoItem() +
                    " | Descrição: " + prato.getDescricaoItem() +
                    " | Vegano?: " + (prato.isVegano() ? "Sim" : "Não") +
                    " | Gluten?: " + (prato.isGluten() ? "Sim" : "Não") +
                    " | Lactose?: " + (prato.isLactose() ? "Sim" : "Não"));
        }
    }
}
