package controller;

import exceptions.ClienteException;
import exceptions.ClienteNaoEncontradoException;
import model.Cliente;
import model.Usuario;
import view.ClienteView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ClienteController {
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public ClienteView view;

    public ClienteController(ClienteView view){
        this.view = view;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static void inicializarClientes() {
        listaClientes.add(new Cliente("João", "123456789"));
        listaClientes.add(new Cliente("Maria", "987654321"));
        listaClientes.add(new Cliente("Carlos", "555555555"));
        listaClientes.add(new Cliente("Ana", "111222333"));
        listaClientes.add(new Cliente("Pedro", "444555666"));
    }


    public void adicionarCliente(String nome, String telefone) {
        if (nome == null || nome.isBlank() || telefone == null || !telefone.matches("\\d+")) {
            throw new ClienteException("Nome ou telefone inválidos");
        }
        Cliente novoCliente = new Cliente(nome, telefone);
        listaClientes.add(novoCliente);
    }

    public static Cliente encontrarCliente(int idCliente) throws ClienteNaoEncontradoException {
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdUsuario() == idCliente) {
                return cliente;
            }
        }
        throw new ClienteNaoEncontradoException("Cliente não encontrado: " + idCliente);
    }

    public void editarCliente(int idCliente, String novoNome, String novoTelefone) throws ClienteNaoEncontradoException {
        Cliente cliente = encontrarCliente(idCliente);
        cliente.setNome(novoNome);
        cliente.setTelefone(novoTelefone);
    }

    public void excluirCliente(int idCliente) throws ClienteNaoEncontradoException {
        Cliente cliente = encontrarCliente(idCliente);
        listaClientes.remove(cliente);
    }

    public static void imprimirListaClientes() {
        view.exibirTodosClientes(listaClientes);
    }

    public void salvarClienteEmArquivo() {
        try (FileWriter escritor = new FileWriter("resources/clientes.txt")) {
            for (Usuario usuario : listaClientes) {
                if (usuario instanceof Cliente) {
                    Cliente cliente = (Cliente) usuario;
                    escritor.write("model.Cliente: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os clientes.");
            e.printStackTrace();
        }
    }

    public static void carregarClientesDoArquivo() {
        try (BufferedReader leitor = new BufferedReader(new FileReader("resources/clientes.txt"))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.startsWith("model.Cliente: ")) {
                    String[] partes = linha.split(", Telefone: ");
                    String nome = partes[0].substring(9); // Remove "model.Cliente: "
                    String telefone = partes[1];
                    Cliente cliente = new Cliente(nome, telefone);
                    listaClientes.add(cliente);
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao carregar os clientes.");
            e.printStackTrace();
        }
    }
}
