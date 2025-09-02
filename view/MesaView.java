package view;
import controller.MesaController;
import model.Mesa;

import java.util.ArrayList;

public class MesaView {
    public void exibirTodasMesas(ArrayList<Mesa> mesas) {
        for (Mesa mesa : mesas) {
            System.out.println("Número: " + mesa.getNumero() +
                    " | Lugares: " + mesa.getNumLugares() +
                    " | Reservada: " + (mesa.isReservado() ? "Sim" : "Não"));
        }
    }

}
