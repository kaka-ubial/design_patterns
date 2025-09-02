package controller;

import model.Item;
import model.Mesa;
import model.Pedido;
import exceptions.ItemNaoEncontradoException;

import java.util.ArrayList;

public class PedidoController {
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public Pedido criarPedido(Mesa mesa) {
        Pedido novoPedido = new Pedido(mesa);
        listaPedidos.add(novoPedido);
        return novoPedido;
    }

    public Pedido buscarPedido(int idComanda) {
        return listaPedidos.stream()
                .filter(p -> p.getIdComanda() == idComanda)
                .findFirst()
                .orElse(null);
    }

    public void editarPedido(int pedidoId, String novoItem, int novaQtd) {
        Pedido pedido = pedidoService.buscarPorId(pedidoId);
        if (pedido == null) {
            throw new PedidoNaoEncontradoException("Pedido não encontrado!");
        }
        pedidoService.editarPedido(pedido, novoItem, novaQtd);
    }

    public void deletarPedido(int idComanda) {
        Pedido pedido = buscarPedido(idComanda);
        if (pedido != null) {
            listaPedidos.remove(pedido);
            System.out.println("Comanda #" + idComanda + " deletada com sucesso.");
        } else {
            System.out.println("Comanda #" + idComanda + " não encontrada.");
        }
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }
}
