package controller;

import exceptions.BebidaException;
import exceptions.BebidaNaoEncontradaException;
import exceptions.ClienteNaoEncontradoException;
import exceptions.ReservaException;
import model.Bebida;
import model.Cliente;
import model.Mesa;
import model.Reserva;
import view.MesaView;
import view.ReservaView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReservaController {
    private ArrayList<Reserva> listaReservas = new ArrayList<>();
    public ReservaView view;
    private MesaController mesaController;

    public ReservaController(ReservaView view, MesaController mesaController){
        this.view = view;
        this.mesaController = mesaController;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void fazerReserva(int numeroMesa, Date dataReserva, Cliente cliente) {
        Mesa mesaSelecionada = mesaController.encontrarMesa(numeroMesa);

        if (mesaSelecionada != null && !mesaSelecionada.isReservado()) {
            Reserva reserva = new Reserva(dataReserva, mesaSelecionada, cliente);
            listaReservas.add(reserva);
            mesaSelecionada.reservarMesa();
            System.out.println("Reserva realizada com sucesso para a mesa #" + mesaSelecionada.getNumero());
        } else {
            System.out.println("Mesa não disponível para reserva.");
        }
    }

    public Reserva encontrarReserva(int idReserva) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getIdReserva() == idReserva) {
                return reserva;
            }
        }
        return null;
    }

    public void editarReserva(int idReserva, Date novaData) throws ReservaException {
        Reserva reserva = encontrarReserva(idReserva);
        if (reserva != null){
            reserva.setDataReserva(novaData);
        } else {
            throw new ReservaException("Reserva não encontrada");
        }
    }

    public void excluirReserva(int idReserva) throws ReservaException{
        Reserva reserva = encontrarReserva(idReserva);
        if (reserva != null){
            Mesa mesa = reserva.getMesa();
            mesa.cancelarReservaMesa();
            listaReservas.remove(reserva);
        } else {
            throw new ReservaException("Reserva não encontrada");
        }
    }

    public void listarMesasDisponiveis() {
        for (Mesa mesa : mesaController.getListaMesas()) {
            if (!mesa.isReservado()) {
                System.out.println("Mesa #" + mesa.getNumero() + " - Lugares: " + mesa.getNumLugares());
            }
        }
    }
}
