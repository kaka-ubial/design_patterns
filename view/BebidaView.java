package view;
import model.Bebida;
import model.Item;
import java.util.ArrayList;
import java.util.Scanner;

public class BebidaView {

    public void exibirTodasBebidas(ArrayList<Bebida> bebidas) {
        for (Bebida bebida : bebidas) {
            System.out.println("Id: " + bebida.getIdItem() +
                    " | Nome: " + bebida.getNomeItem() +
                    " | Preço: " + bebida.getPrecoItem() +
                    " | Descrição: " + bebida.getDescricaoItem() +
                    " | Alcoólica?: " + (bebida.isAlcoolica() ? "Sim" : "Não"));
        }
    }

}
