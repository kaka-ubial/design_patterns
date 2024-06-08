import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static int lastGarcomId = 1;

    public static String menuPrincipal(Scanner scanner) {
        System.out.println("Bem-vindo ao gerenciamento de restaurante!");
        System.out.println("Você é:\n1 - Cliente\n2 - Garçom");

        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String menuCliente(Scanner scanner) {
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Visualizar cardápio\n2 - Reservar uma mesa\n3 - Sair");
        String opcaoUsuario = scanner.nextLine();
        return opcaoUsuario;
    }

    public static String menuGarcom(Scanner scanner) {
        System.out.println("MENU");
        System.out.println("1 - Menus do Restaurante\n2 - Reservas\n3 - Mesas\n4 - Comandas");
        String opcaoGarcom = scanner.nextLine();
        return opcaoGarcom;
    }

    public static String menuPratosGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar Prato ao Menu\n2 - Editar Prato\n3 - Deletar Prato\n4 - Exbibir Menu");
        String opcaoPrato = scanner.nextLine();
        return opcaoPrato;
    }

    public static String menuBebidasGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar Bebida ao Menu\n2 - Editar Bebida\n3 - Deletar Bebida\n4 - Exbibir Menu");
        String opcaoBebida = scanner.nextLine();
        return opcaoBebida;
    }

    public static String menuVinhosGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar Vinho ao Menu\n2 - Editar Vinho\n3 - Deletar Vinho\n4 - Exbibir Menu");
        String opcaoVinho = scanner.nextLine();
        return opcaoVinho;
    }

    public static String menuMesasGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?");
        System.out.println("O que deseja fazer?\n1 - Adicionar mesa\n2 - Editar mesa\n3 - Excluir mesa\n4 - Listar mesas");
        String opcaoMesas = scanner.nextLine();
        return opcaoMesas;
    }

    public static String menuReservasGarcom(Scanner scanner){
        System.out.println("O que você deseja fazer?\n1 - Adicionar reserva\n2 - Editar reserva\n3 - Excluir reserva\n4 - Listar reservas");
        String opcaoReservas = scanner.nextLine();
        return opcaoReservas;
    }

    public static boolean validarTelefone(String telefone) {
        // Expressão regular para validar telefone
        String regex = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}";
        return telefone.matches(regex);
    }

    public static void listarMesasDisponiveis() {
        ArrayList<Mesa> mesasDisponiveis = new ArrayList<>();
        for (Mesa mesa : Mesa.getListaMesas()) {
            if (!mesa.isReservado()) {
                mesasDisponiveis.add(mesa);
            }
        }
        if (mesasDisponiveis.isEmpty()) {
            System.out.println("Não há mesas disponíveis para reserva.");
        } else {
            System.out.println("Mesas disponíveis para reserva:");
            for (Mesa mesa : mesasDisponiveis) {
                System.out.println("Mesa " + mesa.getNumero() + " - Lugares: " + mesa.getNumLugares());
            }
        }
    }



    public static void fazerReserva(Scanner scanner, Cliente cliente) {
        listarMesasDisponiveis();
        System.out.println("Digite o número da mesa que deseja reservar:");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine();

        Mesa mesaSelecionada = null;
        for (Mesa mesa : Mesa.getListaMesas()) {
            if (mesa.getNumero() == numeroMesa && !mesa.isReservado()) {
                mesaSelecionada = mesa;
                break;
            }
        }

        if (mesaSelecionada != null) {
            System.out.println("Digite a data da reserva (dd/MM/yyyy):");
            String dataReservaStr = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date dataReserva = dateFormat.parse(dataReservaStr);
                Reserva reserva = new Reserva(dataReserva, mesaSelecionada, cliente);
                mesaSelecionada.setReservado(true);
                System.out.println("Reserva realizada com sucesso para a mesa #" + mesaSelecionada.getNumero());
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
            }
        } else {
            System.out.println("Mesa não disponível para reserva.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mesa.inicializarMesas();
        Cliente.inicializarClientes();

        // Gerar itens aleatórios
        ArrayList<Item> comidas = GeradorItens.gerarItensAleatorios("comida", 5);
        ArrayList<Item> bebidas = GeradorItens.gerarItensAleatorios("bebida", 5);
        ArrayList<Item> vinhos = GeradorItens.gerarItensAleatorios("vinho", 5);

        // Criação dos menus
        Menu menuDePratos = new MenuComidas(comidas, "Menu de Pratos");
        Menu menuDeBebidas = new MenuBebidas(bebidas, "Menu de Bebidas");
        Menu menuDeVinhos = new CartaVinhos(vinhos, "Carta de Vinhos");


        switch (menuPrincipal(scanner)) {
            case "1":
                System.out.println("Qual seu nome?");
                String nome = scanner.nextLine();
                String telefone;
                do {
                    System.out.println("Qual seu telefone? (Formato: (XX) XXXXX-XXXX)");
                    telefone = scanner.nextLine();
                } while (!validarTelefone(telefone));

                Cliente cliente = new Cliente(nome, telefone);
                System.out.println("------------------------------------------");
                System.out.println("Seja bem-vindo(a), " + cliente.getNome());
                System.out.println("------------------------------------------");
                while (true) {
                    switch (menuCliente(scanner)) {
                        case "1":
                            System.out.println("Qual cardápio você deseja visualizar?\n1 - Cardápio de Pratos\n2 - Cardápio de Bebidas\n3 - Carta de Vinhos");
                            String menuUsuario = scanner.nextLine();
                            switch (menuUsuario) {
                                case "1":
                                    menuDePratos.exibirMenu();
                                    break;
                                case "2":
                                    menuDeBebidas.exibirMenu();
                                    break;
                                case "3":
                                    menuDeVinhos.exibirMenu();
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }
                            break;
                        case "2":
                            fazerReserva(scanner, cliente);
                            break;
                        case "3":
                            System.out.println("Obrigado por usar nosso sistema. Até mais!");
                            return;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                }
            case "2":
                System.out.println("Qual seu nome?");
                String nomeGarcom = scanner.nextLine();
                System.out.println("Qual seu turno?");
                String turnoGarcom = scanner.nextLine();
                System.out.println("Qual seu email?");
                String emailGarcom = scanner.nextLine();
                System.out.println("Qual sua senha?");
                String senhaGarcom = scanner.nextLine();
                Garcom garcom = new Garcom(nomeGarcom, turnoGarcom, lastGarcomId, emailGarcom, senhaGarcom);
                lastGarcomId++;
                System.out.println("Bem-vindo, " + garcom.getNome());
                switch (menuGarcom(scanner)) {
                    case "1":
                        System.out.println("Que menu deseja acessar?\n1 - Menu de Pratos\n2 - Menu de Bebidas\n3 - Menu de Vinhos");
                        String menuGarcom = scanner.nextLine();
                        switch (menuGarcom) {
                            case "1":
                                switch (menuPratosGarcom(scanner)) {
                                            case "1":
                                                System.out.println("Digite o nome do novo prato:");
                                                String nomePrato = scanner.nextLine();
                                                System.out.println("Digite o preço do novo prato:");
                                                double precoPrato = Double.parseDouble(scanner.nextLine());
                                                System.out.println("Digite a descrição do novo prato:");
                                                String descricaoPrato = scanner.nextLine();
                                                System.out.println("O prato é vegano? (S/N)");
                                                boolean vegano = scanner.nextLine().equalsIgnoreCase("S");
                                                System.out.println("O prato contém glúten? (S/N)");
                                                boolean gluten = scanner.nextLine().equalsIgnoreCase("S");
                                                System.out.println("O prato contém lactose? (S/N)");
                                                boolean lactose = scanner.nextLine().equalsIgnoreCase("S");

                                                Prato novoPrato = new Prato(nomePrato, precoPrato, descricaoPrato, vegano, gluten, lactose);
                                                menuDePratos.adicionarItem(novoPrato);
                                                System.out.println("Prato adicionado com sucesso.");
                                                break;
                                            case "2":
                                                System.out.println("Digite o nome do prato que deseja editar:");
                                                String nomePratoEditar = scanner.nextLine();
                                                Prato pratoExistente = null;
                                                for (Item item : comidas) {
                                                    if (item instanceof Prato && item.getNomeItem().equalsIgnoreCase(nomePratoEditar)) {
                                                        pratoExistente = (Prato) item;
                                                        break;
                                                    }
                                                }
                                                if (pratoExistente != null) {
                                                    System.out.println("Digite o novo nome do prato:");
                                                    String novoNomePrato = scanner.nextLine();
                                                    System.out.println("Digite o novo preço do prato:");
                                                    double novoPrecoPrato = Double.parseDouble(scanner.nextLine());
                                                    System.out.println("Digite a nova descrição do prato:");
                                                    String novaDescricaoPrato = scanner.nextLine();
                                                    System.out.println("O prato é vegano? (S/N)");
                                                    boolean novoVegano = scanner.nextLine().equalsIgnoreCase("S");
                                                    System.out.println("O prato contém glúten? (S/N)");
                                                    boolean novoGluten = scanner.nextLine().equalsIgnoreCase("S");
                                                    System.out.println("O prato contém lactose? (S/N)");
                                                    boolean novaLactose = scanner.nextLine().equalsIgnoreCase("S");

                                                    Prato novoPratoEditado = new Prato(novoNomePrato, novoPrecoPrato, novaDescricaoPrato, novoVegano, novoGluten, novaLactose);
                                                    menuDePratos.editarItem(nomePratoEditar, novoPratoEditado);
                                                    System.out.println("Prato editado com sucesso.");
                                                } else {
                                                    System.out.println("Prato não encontrado.");
                                                }
                                                break;
                                            case "3":
                                                System.out.println("Digite o nome do prato que deseja deletar:");
                                                String nomePratoDeletar = scanner.nextLine();
                                                menuDePratos.deletarItem(nomePratoDeletar);
                                                System.out.println("Prato deletado com sucesso.");
                                                break;
                                            case "4":
                                                menuDePratos.exibirMenu();
                                                break;
                                            default:
                                                break;
                                        }
                                        break;
                                    case "2":
                                        switch (menuBebidasGarcom(scanner)) {
                                            case "1":
                                                System.out.println("Digite o nome da nova bebida:");
                                                String nomeBebida = scanner.nextLine();
                                                System.out.println("Digite o preço da nova bebida:");
                                                double precoBebida = Double.parseDouble(scanner.nextLine());
                                                System.out.println("Digite a descrição da nova bebida:");
                                                String descricaoBebida = scanner.nextLine();
                                                System.out.println("A bebida é alcoólica? (S/N)");
                                                boolean alcoolica = scanner.nextLine().equalsIgnoreCase("S");

                                                Bebida novaBebida = new Bebida(nomeBebida, precoBebida, descricaoBebida, alcoolica);
                                                menuDeBebidas.adicionarItem(novaBebida);
                                                System.out.println("Bebida adicionada com sucesso.");
                                                break;
                                            case "2":
                                                System.out.println("Digite o nome da bebida que deseja editar:");
                                                String nomeBebidaEditar = scanner.nextLine();
                                                Bebida bebidaExistente = null;
                                                for (Item item : bebidas) {
                                                    if (item instanceof Bebida && item.getNomeItem().equalsIgnoreCase(nomeBebidaEditar)) {
                                                        bebidaExistente = (Bebida) item;
                                                        break;
                                                    }
                                                }
                                                if (bebidaExistente != null) {
                                                    System.out.println("Digite o novo nome da bebida:");
                                                    String novoNomeBebida = scanner.nextLine();
                                                    System.out.println("Digite o novo preço da bebida:");
                                                    double novoPrecoBebida = Double.parseDouble(scanner.nextLine());
                                                    System.out.println("Digite a nova descrição da bebida:");
                                                    String novaDescricaoBebida = scanner.nextLine();
                                                    System.out.println("A bebida é alcoólica? (S/N)");
                                                    boolean novaAlcoolica = scanner.nextLine().equalsIgnoreCase("S");

                                                    Bebida novaBebidaEditada = new Bebida(novoNomeBebida, novoPrecoBebida, novaDescricaoBebida, novaAlcoolica);
                                                    menuDeBebidas.editarItem(nomeBebidaEditar, novaBebidaEditada);
                                                    System.out.println("Bebida editada com sucesso.");
                                                } else {
                                                    System.out.println("Bebida não encontrada.");
                                                }
                                                break;
                                            case "3":
                                                System.out.println("Digite o nome da bebida que deseja deletar:");
                                                String nomeBebidaDeletar = scanner.nextLine();
                                                menuDeBebidas.deletarItem(nomeBebidaDeletar);
                                                System.out.println("Bebida deletada com sucesso.");
                                                break;
                                            case "4":
                                                menuDeBebidas.exibirMenu();
                                                break;
                                            default:
                                                break;
                                        }
                                        break;
                                    case "3":
                                        switch (menuVinhosGarcom(scanner)) {
                                            case "1":
                                                System.out.println("Digite o nome do novo vinho:");
                                                String nomeVinho = scanner.nextLine();
                                                System.out.println("Digite o preço do novo vinho:");
                                                double precoVinho = Double.parseDouble(scanner.nextLine());
                                                System.out.println("Digite a descrição do novo vinho:");
                                                String descricaoVinho = scanner.nextLine();
                                                System.out.println("Digite a idade do vinho:");
                                                int idadeVinho = Integer.parseInt(scanner.nextLine());
                                                System.out.println("Digite a nacionalidade do vinho:");
                                                String nacionalidadeVinho = scanner.nextLine();
                                                System.out.println("Digite o tipo do vinho:");
                                                String tipoVinho = scanner.nextLine();
                                                System.out.println("Digite a uva do vinho:");
                                                String uvaVinho = scanner.nextLine();
                                                System.out.println("Digite o corpo do vinho:");
                                                String corpoVinho = scanner.nextLine();
                                                System.out.println("Digite o teor alcoólico do vinho:");
                                                String teorAlcoolicoVinho = scanner.nextLine();

                                                Vinho novoVinho = new Vinho(nomeVinho, precoVinho, descricaoVinho, idadeVinho, nacionalidadeVinho, tipoVinho, uvaVinho, corpoVinho, teorAlcoolicoVinho);
                                                menuDeVinhos.adicionarItem(novoVinho);
                                                System.out.println("Vinho adicionado com sucesso.");
                                                break;
                                            case "2":
                                                System.out.println("Digite o nome do vinho que deseja editar:");
                                                String nomeVinhoEditar = scanner.nextLine();
                                                Vinho vinhoExistente = null;
                                                for (Item item : vinhos) {
                                                    if (item instanceof Vinho && item.getNomeItem().equalsIgnoreCase(nomeVinhoEditar)) {
                                                        vinhoExistente = (Vinho) item;
                                                        break;
                                                    }
                                                }
                                                if (vinhoExistente != null) {
                                                    System.out.println("Digite o novo nome do vinho:");
                                                    String novoNomeVinho = scanner.nextLine();
                                                    System.out.println("Digite o novo preço do vinho:");
                                                    double novoPrecoVinho = Double.parseDouble(scanner.nextLine());
                                                    System.out.println("Digite a nova descrição do vinho:");
                                                    String novaDescricaoVinho = scanner.nextLine();
                                                    System.out.println("Digite a nova idade do vinho:");
                                                    int novaIdadeVinho = Integer.parseInt(scanner.nextLine());
                                                    System.out.println("Digite a nova nacionalidade do vinho:");
                                                    String novaNacionalidadeVinho = scanner.nextLine();
                                                    System.out.println("Digite o novo tipo do vinho:");
                                                    String novoTipoVinho = scanner.nextLine();
                                                    System.out.println("Digite a nova uva do vinho:");
                                                    String novaUvaVinho = scanner.nextLine();
                                                    System.out.println("Digite o novo corpo do vinho:");
                                                    String novoCorpoVinho = scanner.nextLine();
                                                    System.out.println("Digite o novo teor alcoólico do vinho:");
                                                    String novoTeorAlcoolicoVinho = scanner.nextLine();

                                                    Vinho novoVinhoEditado = new Vinho(novoNomeVinho, novoPrecoVinho, novaDescricaoVinho, novaIdadeVinho, novaNacionalidadeVinho, novoTipoVinho, novaUvaVinho, novoCorpoVinho, novoTeorAlcoolicoVinho);
                                                    menuDeVinhos.editarItem(nomeVinhoEditar, novoVinhoEditado);
                                                    System.out.println("Vinho editado com sucesso.");
                                                } else {
                                                    System.out.println("Vinho não encontrado.");
                                                }
                                                break;
                                            case "3":
                                                System.out.println("Digite o nome do vinho que deseja deletar:");
                                                String nomeVinhoDeletar = scanner.nextLine();
                                                menuDeVinhos.deletarItem(nomeVinhoDeletar);
                                                System.out.println("Vinho deletado com sucesso.");
                                                break;
                                            case "4":
                                                menuDeVinhos.exibirMenu();
                                                break;
                                            default:
                                                break;
                                        }
                                        break;

                                    default:
                                        System.out.println("Opção inválida.");
                                        break;
                                }
                                break;
                            case "2":
                                switch (menuReservasGarcom(scanner)) {
                                    case "1":
                                        System.out.println("Criando uma nova reserva:");

                                        System.out.print("Digite a data da reserva (dd/MM/yyyy HH:mm): ");
                                        String dataInput = scanner.nextLine();
                                        Date dataReserva = null;
                                        try {
                                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                            dataReserva = dateFormat.parse(dataInput);
                                        } catch (ParseException e) {
                                            System.out.println("Formato de data inválido. A reserva não será criada.");
                                            return;
                                        }

                                        System.out.print("Digite o número da mesa: ");
                                        int numeroMesa = Integer.parseInt(scanner.nextLine());

                                        Mesa mesa = Mesa.encontrarMesa(numeroMesa);

                                        if (mesa == null) {
                                            System.out.println("Mesa não encontrada. A reserva não será criada.");
                                            return;
                                        }

                                        System.out.print("Digite o nome do cliente: ");
                                        String nomeCliente = scanner.nextLine();

                                        Cliente clienteReserva = Cliente.encontrarCliente(nomeCliente);

                                        if (clienteReserva == null) {
                                            System.out.println("Cliente não encontrado. A reserva não será criada.");
                                            return;
                                        }

                                        Reserva reserva = new Reserva(dataReserva, mesa, clienteReserva);
                                        System.out.println("Reserva criada com sucesso!");


                                        break;
                                    case "2":
                                        System.out.println("Editar reserva não implementado.");
                                        break;
                                    case "3":
                                        System.out.println("Deletar reserva não implementado");
                                        break;
                                    case "4":
                                        Reserva.visualizarReservas();
                                        break;
                                    default:
                                        System.out.println("Opção inválida.");
                                        break;
                                }
                                break;
                            case "3": // Menu de Mesas para Garçom
                                switch (menuMesasGarcom(scanner)) {
                                    case "1": // Adicionar Mesa
                                        System.out.println("Digite o número da nova mesa:");
                                        int numeroMesa = Integer.parseInt(scanner.nextLine());
                                        System.out.println("Digite o número de lugares da nova mesa:");
                                        int numLugaresMesa = Integer.parseInt(scanner.nextLine());
                                        System.out.println("A mesa está reservada? (S/N)");
                                        boolean reservadoMesa = scanner.nextLine().equalsIgnoreCase("S");

                                        Mesa.adicionarMesa(numeroMesa, numLugaresMesa, reservadoMesa);
                                        System.out.println("Mesa adicionada com sucesso.");
                                        break;
                                    case "2": // Editar Mesa
                                        System.out.println("Digite o número da mesa que deseja editar:");
                                        int numMesaEditar = Integer.parseInt(scanner.nextLine());
                                        Mesa mesaEditar = null;
                                        for (Mesa mesa : Mesa.getListaMesas()) {
                                            if (mesa.getNumero() == numMesaEditar) {
                                                mesaEditar = mesa;
                                                break;
                                            }
                                        }
                                        if (mesaEditar != null) {
                                            System.out.println("Digite o novo número de lugares:");
                                            int novoNumLugares = Integer.parseInt(scanner.nextLine());
                                            System.out.println("A mesa está reservada? (S/N)");
                                            boolean novoReservado = scanner.nextLine().equalsIgnoreCase("S");

                                            mesaEditar.setNumLugares(novoNumLugares);
                                            mesaEditar.setReservado(novoReservado);
                                            System.out.println("Mesa editada com sucesso.");
                                        } else {
                                            System.out.println("Mesa não encontrada.");
                                        }
                                        break;
                                    case "3": // Excluir Mesa
                                        System.out.println("Digite o número da mesa que deseja excluir:");
                                        int numMesaExcluir = Integer.parseInt(scanner.nextLine());
                                        Mesa mesaExcluir = null;
                                        for (Mesa mesa : Mesa.getListaMesas()) {
                                            if (mesa.getNumero() == numMesaExcluir) {
                                                mesaExcluir = mesa;
                                                break;
                                            }
                                        }
                                        if (mesaExcluir != null) {
                                            mesaExcluir.excluirMesa(mesaExcluir);
                                            System.out.println("Mesa excluída com sucesso.");
                                        } else {
                                            System.out.println("Mesa não encontrada.");
                                        }
                                        break;
                                    case "4": // Listar Mesas
                                        Mesa.exibirTodasMesas();
                                        break;
                                    default:
                                        System.out.println("Opção inválida.");
                                        break;
                                }
                                break;
                            case "4":
                                while (true) {
                                    System.out.println("Digite o número da mesa para abrir uma comanda:");
                                    int numeroMesa = scanner.nextInt();
                                    scanner.nextLine();

                                    Mesa mesaSelecionada = null;
                                    for (Mesa mesa : Mesa.getListaMesas()) {
                                        if (mesa.getNumero() == numeroMesa) {
                                            mesaSelecionada = mesa;
                                            break;
                                        }
                                    }

                                    if (mesaSelecionada != null) {
                                        Comanda comanda = new Comanda(mesaSelecionada);
                                        System.out.println("Comanda aberta para a mesa #" + mesaSelecionada.getNumero() + ".");
                                        break; // Sai do loop se a mesa for encontrada
                                    } else {
                                        System.out.println("Mesa não encontrada. Por favor, digite um número de mesa válido.");
                                    }
                                }
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                scanner.close();
        }
    }
