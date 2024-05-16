import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static int lastGarcomId = 1; 

    public static void main(String[] args) {
        /* new Screen(); */
        int idGarcom;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao gerenciamento de restaurante!");
        System.out.println("Você é: 1 - Cliente\n2 - Garçom\n");

        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("Qual seu nome?");
                String nome = scanner.nextLine();
                System.out.println("Qual seu telefone?");
                String telefone = scanner.nextLine();
                Cliente cliente = new Cliente(nome, telefone);
                break;
            case "2":
                System.out.println("Qual seu nome?");
                String nomeGarcom = scanner.nextLine();
                System.out.println("Qual seu turno?");
                String turnoGarcom = scanner.nextLine();
                Garcom garcom = new Garcom(nomeGarcom, turnoGarcom, lastGarcomId);
                lastGarcomId++;
                System.out.println(garcom.getlistaUsuarios());;

                break;
            default:
                break;
        }

    }
}
