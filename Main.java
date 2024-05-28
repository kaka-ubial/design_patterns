
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;


public class Main {
    private static int lastGarcomId = 1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("InterfaceMenu");
        frame.setContentPane(new InterfaceMenu().getInterfaceMenu());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
//        int idGarcom;
//        ArrayList<Item> comidas = new ArrayList<>();
//        ArrayList<Item> bebidas = new ArrayList<>();
//        ArrayList<Item> vinhos = new ArrayList<>();
//        Menu menuDePratos = new MenuComidas(comidas, "Menu de Pratos");
//        Menu menuDeBebidas = new MenuBebidas(comidas, "Menu de Bebidas");
//        Menu menuDeVinhos = new CartaVinhos(comidas, "Carta de Vinhos");
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Bem vindo ao gerenciamento de restaurante!");
//        System.out.println("Você é: 1 - Cliente\n2 - Garçom\n");
//
//        String userInput = scanner.nextLine();
//
//        switch (userInput) {
//            case "1":
//                System.out.println("Qual seu nome?");
//                String nome = scanner.nextLine();
//                System.out.println("Qual seu telefone?");
//                String telefone = scanner.nextLine();
//                Cliente cliente = new Cliente(nome, telefone);
//                System.out.println("Bem vindo, " + cliente.getNome());
//                System.out.println("O que você deseja fazer?");
//                System.out.println("1 - Visualizar cardápio\n2 - Reservar uma mesa\n");
//                String opcaoUsuario = scanner.nextLine();
//                switch (opcaoUsuario) {
//                    case "1":
//                        System.out.println("Qual cardápio você deseja visualizar?\n1 - Cardápio de Pratos\n2 - Cardápio de Bebidas\n3 - Carta de Vinhos");
//                        String menuUsuario = scanner.nextLine();
//                        switch (menuUsuario) {
//                            case "1":
//                                menuDePratos.exibirMenu();
//                                break;
//                            case "2":
//                                menuDeBebidas.exibirMenu();
//                                break;
//                            case "3":
//                                menuDeVinhos.exibirMenu();
//                                break;
//                            default:
//                                System.out.println("Opção inválida.");
//                                break;
//                        }
//                        break;
//                    case "2":
//                        System.out.println("Função de reserva não implementada.");
//                        break;
//                    default:
//                        System.out.println("Opção inválida.");
//                        break;
//                }
//                break;
//            case "2":
//                System.out.println("Qual seu nome?");
//                String nomeGarcom = scanner.nextLine();
//                System.out.println("Qual seu turno?");
//                String turnoGarcom = scanner.nextLine();
//                System.out.println("Qual seu email?");
//                String emailGarcom = scanner.nextLine();
//                System.out.println("Qual sua senha?");
//                String senhaGarcom = scanner.nextLine();
//                Garcom garcom = new Garcom(nomeGarcom, turnoGarcom, lastGarcomId, emailGarcom, senhaGarcom);
//                lastGarcomId++;
//                System.out.println(garcom.getlistaUsuarios());
//                System.out.println("Bem vindo, " + garcom.getNome());
//                System.out.println("MENU");
//                System.out.println("1 - Menus do Restaurante\n2 - Reservas\n3 - Mesas\n");
//                String opcaoGarcom = scanner.nextLine();
//                switch (opcaoGarcom) {
//                    case "1":
//                        System.out.println("Que menu deseja acessar?\n1 - Menu de Pratos\n2 - Menu de Bebidas\n3 - Menu de Vinhos");
//                        break;
//                    case "2":
//                        System.out.println("O que você deseja fazer?\n1 - Adicionar reserva\n2 - Editar reserva\n3 - Excluir reserva\n4 - Listar reservas");
//                        String opcaoReservas = scanner.nextLine();
//                        switch (opcaoReservas) {
//                            case "1":
//                                System.out.println("Adicionar reserva não implementado.");
//                                break;
//                            case "2":
//                                System.out.println("Editar reserva não implementado.");
//                                break;
//                            case "3":
//                                System.out.println("Excluir reserva não implementado.");
//                                break;
//                            case "4":
//                                System.out.println("Listar reservas não implementado.");
//                                break;
//                            default:
//                                System.out.println("Opção inválida.");
//                                break;
//                        }
//                        break;
//                    case "3":
//                        System.out.println("O que deseja fazer?\n1 - Adicionar mesa\n2 - Editar mesa\n3 - Excluir mesa\n4 - Listar mesas");
//                        String opcaoMesas = scanner.nextLine();
//                        switch (opcaoMesas) {
//                            case "1":
//                                System.out.println("Adicionar mesa não implementado.");
//                                break;
//                            case "2":
//                                System.out.println("Editar mesa não implementado.");
//                                break;
//                            case "3":
//                                System.out.println("Excluir mesa não implementado.");
//                                break;
//                            case "4":
//                                System.out.println("Listar mesas não implementado.");
//                                break;
//                            default:
//                                System.out.println("Opção inválida.");
//                                break;
//                        }
//                        break;
//                    default:
//                        System.out.println("Opção inválida.");
//                        break;
//                }
//                break;
//            default:
//                System.out.println("Opção inválida.");
//                break;
//        }
//
//        scanner.close();

    }

}



