package Utils;

import java.util.Scanner;

public class MenuUtils {
    public static String menuPrincipal(Scanner scanner) {
        System.out.println("Bem-vindo ao gerenciamento de restaurante!");
        System.out.println("Você é:\n1 - model.Cliente\n2 - Garçom");

        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String menuCliente(Scanner scanner) {
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Visualizar cardápio\n2 - Reservar uma mesa\n4 - Sair");
        String opcaoUsuario = scanner.nextLine();
        return opcaoUsuario;
    }

    public static String menuGarcom(Scanner scanner) {
        System.out.println("MENU");
        System.out.println("1 - Menus do model.Restaurante\n2 - Reservas\n3 - Mesas\n4 - Comandas\n5 - Visualizar Clientes\n6 - Sair");
        String opcaoGarcom = scanner.nextLine();
        return opcaoGarcom;
    }

    public static String menuPratosGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar model.Prato ao model.Menu\n2 - Editar model.Prato\n3 - Deletar model.Prato\n4 - Exibir model.Menu\n5 - Voltar");
        String opcaoPrato = scanner.nextLine();
        return opcaoPrato;
    }

    public static String menuBebidasGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar model.Bebida ao model.Menu\n2 - Editar model.Bebida\n3 - Deletar model.Bebida\n4 - Exibir model.Menu\n5 - Voltar");
        String opcaoBebida = scanner.nextLine();
        return opcaoBebida;
    }

    public static String menuVinhosGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar model.Vinho ao model.Menu\n2 - Editar model.Vinho\n3 - Deletar model.Vinho\n4 - Exibir model.Menu\n5 - Voltar");
        String opcaoVinho = scanner.nextLine();
        return opcaoVinho;
    }

    public static String menuMesasGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?\n1 - Adicionar mesa\n2 - Editar mesa\n3 - Excluir mesa\n4 - Listar mesas\n5 - Voltar");
        String opcaoMesas = scanner.nextLine();
        return opcaoMesas;
    }

    public static String menuReservasGarcom(Scanner scanner) {
        System.out.println("O que você deseja fazer?\n1 - Adicionar reserva\n2 - Editar reserva\n3 - Excluir reserva\n4 - Listar reservas\n5 - Voltar");
        String opcaoReservas = scanner.nextLine();
        return opcaoReservas;
    }

    public static String menuComandasGarcom(Scanner scanner) {
        System.out.println("O que você deseja fazer?\n1 - Abrir uma comanda\n2 - Editar uma comanda\n3 - Excluir uma comanda\n4 - Voltar");
        String opcaoComandas = scanner.nextLine();
        return opcaoComandas;
    }

}
