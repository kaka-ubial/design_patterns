package controller;

import exceptions.MesaException;
import model.Mesa;
import view.MesaView;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MesaController {
    private ArrayList<Mesa> listaMesas = new ArrayList<>();
    public MesaView view;

    public MesaController(MesaView view){
        this.view = view;
    }

    public ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

    public static void inicializarMesas() {
        // Define os números de lugares para cada mesa
        int[] numLugaresPorMesa = {4, 6, 2, 8, 4, 6, 2, 8, 4, 6};

        // Cria as mesas com números de lugares diferentes
        for (int i = 0; i < numLugaresPorMesa.length; i++) {
            Mesa mesa = new Mesa(i + 1, numLugaresPorMesa[i], false);
        }
    }

    public void adicionarMesa(int numero, int numLugares, boolean reservado) throws MesaException {
        if (numero <= 0 || numLugares <= 0) {
            throw new MesaException("Número e número de lugares da mesa devem ser maiores que zero.");
        }
        Mesa novaMesa = new Mesa(numero, numLugares, reservado);
        listaMesas.add(novaMesa);
    }

    public Mesa encontrarMesa(int numeroMesa) {
        for (Mesa mesa : listaMesas) {
            if (mesa.getNumero() == numeroMesa) {
                return mesa;
            }
        }
        return null;
    }

    public void excluirMesa(int numeroMesa) throws MesaException {
        Mesa mesa = encontrarMesa(numeroMesa);
        if (mesa != null){
            listaMesas.remove(mesa);
        } else {
            throw new MesaException("Mesa não encontrada");
        }
    }

    public void editarMesa(int numero, int novosLugares) throws MesaException {
        Mesa mesa = encontrarMesa(numero);
        if (mesa != null){
            mesa.setNumLugares(novosLugares);
        } else {
            throw new MesaException("Mesa não encontrada");
        }
    }

    public void listarMesas() {
        view.exibirTodasMesas(listaMesas);
    }

    public void salvarMesaEmArquivo() {
        try (FileWriter escritor = new FileWriter("mesas.txt")) {
            for (Mesa mesa : listaMesas) {
                escritor.write("model.Mesa: " + mesa.getNumero() + ", Número de lugares: " + mesa.getNumLugares() + ", Reservado: " + mesa.isReservado() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar as mesas.");
            e.printStackTrace();
        }
    }
}
