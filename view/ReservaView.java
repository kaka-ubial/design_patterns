package view;

import model.Cliente;
import model.Reserva;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import controller.ReservaController;

public class ReservaView {
    private ReservaController reservaController;

    public ReservaView(ReservaController reservaController) {
        this.reservaController = reservaController;
    }

    public static void visualizarReservas(ArrayList<Reserva> reservas) {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (Reserva reserva : reservas) {
                String dataFormatada = dateFormat.format(reserva.getDataReserva());
                System.out.println("Data da model.Reserva: " + dataFormatada);
                System.out.println("model.Mesa: " + reserva.getMesa().getNumero());
                System.out.println("model.Cliente: " + reserva.getCliente().getNome());
                System.out.println("----------------------------------");
            }
        }
    }

    public void fazerReserva(Scanner scanner, Cliente cliente) {
        reservaController.listarMesasDisponiveis();

        System.out.println("Digite o número da mesa (ou 'C' para cancelar):");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("C")) {
            System.out.println("Reserva cancelada.");
            return;
        }

        try {
            int numeroMesa = Integer.parseInt(input);

            System.out.println("Digite a data da reserva (dd/MM/yyyy):");
            String dataStr = scanner.nextLine().trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataReserva = dateFormat.parse(dataStr);

            reservaController.fazerReserva(numeroMesa, dataReserva, cliente);

        } catch (Exception e) {
            System.out.println("Erro: entrada inválida. " + e.getMessage());
        }
    }

}
