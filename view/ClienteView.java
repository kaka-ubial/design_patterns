package view;

import model.Cliente;

import java.util.ArrayList;

public class ClienteView {
    public static void exibirTodosClientes(ArrayList<Cliente> listaClientes) {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println("ID: " + cliente.getIdUsuario() +
                    " | Nome: " + cliente.getNome() +
                    " | Telefone: " + cliente.getTelefone());
        }
    }

}
