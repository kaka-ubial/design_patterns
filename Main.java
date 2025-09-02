import controller.*;
import exceptions.GarcomException;
import model.*;
import view.ClienteView;
import view.GarcomView;
import view.MesaView;
import view.ReservaView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static Utils.MenuUtils.menuPrincipal;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static MesaView mesaView = new MesaView();
    private static MesaController mesaController = new MesaController(mesaView);

    private static ReservaView reservaView = new ReservaView(reservaController);
    private static ReservaController reservaController = new ReservaController(reservaView, mesaController);

    private static Menu menuDePratos;
    private static Menu menuDeBebidas;
    private static Menu menuDeVinhos;

    private static RestauranteController restauranteController;

    public static void main(String[] args) {
        inicializarSistema();
    }

    private static void inicializarSistema() {
        MesaController.inicializarMesas();
        ClienteController.inicializarClientes();

        ArrayList<Item> comidas = GeradorItens.gerarItensAleatorios(Prato.class, 5);
        ArrayList<Item> bebidas = GeradorItens.gerarItensAleatorios(Bebida.class, 5);
        ArrayList<Item> vinhos = GeradorItens.gerarItensAleatorios(Vinho.class, 5);

        menuDePratos = new Menu(comidas, "Menu de Pratos");
        menuDeBebidas = new Menu(bebidas, "Menu de Bebidas");
        menuDeVinhos = new Menu(vinhos, "Carta de Vinhos");

        Restaurante restaurante = new Restaurante();
        restauranteController = new RestauranteController(restaurante);
        try {
            byte[] dados = restauranteController.getRestaurante().serializar();
            try (FileOutputStream fos = new FileOutputStream("restaurante.ser")) {
                fos.write(dados);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar/restaurar restaurante: " + e.getMessage());
        }
    }
    }



