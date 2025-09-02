package view;

import model.Item;
import model.Pedido;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PedidoView {
    private DecimalFormat df = new DecimalFormat("#.00");

    public void exibirComanda(Pedido pedido) {
        System.out.println("Comanda #" + pedido.getIdComanda());
        System.out.println("Mesa: " + pedido.getMesa().getNumero());
        System.out.println("Itens:");
        for (Item item : pedido.getItensComanda()) {
            System.out.println("- " + item.getNomeItem() + ": R$" + df.format(item.getPrecoItem()));
        }
        System.out.println("Total: R$" + df.format(pedido.getPrecoTotal()));
        System.out.println("Pago: " + (pedido.isPago() ? "Sim" : "Não"));
        System.out.println("-----------------------------------");
    }

    public void exibirListaComandas(ArrayList<Pedido> listaPedidos) {
        if (listaPedidos.isEmpty()) {
            System.out.println("Nenhuma comanda encontrada.");
        } else {
            for (Pedido pedido : listaPedidos) {
                exibirComanda(pedido);
            }
        }
    }
}
