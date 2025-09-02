package view;

import model.Cliente;
import model.Garcom;

import java.util.ArrayList;

public class GarcomView {
    public static void exibirTodosGarcons(ArrayList<Garcom> listaGarcons) {
        System.out.println("Lista de garçons:");
        for (Garcom garcom : listaGarcons) {
            System.out.println("ID: " + garcom.getIdUsuario() +
                    " | Nome: " + garcom.getNome() +
                    " | Turno: " + garcom.getTurno());
        }
    }
}
