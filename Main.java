import java.sql.SQLOutput;
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
        System.out.println("1 - Adicionar Prato ao Menu\n2 - Editar Prato\n3 - Deletar Prato\n4 - Exibir Menu");
        String opcaoPrato = scanner.nextLine();
        return opcaoPrato;
    }

    public static String menuBebidasGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar Bebida ao Menu\n2 - Editar Bebida\n3 - Deletar Bebida\n4 - Exibir Menu");
        String opcaoBebida = scanner.nextLine();
        return opcaoBebida;
    }

    public static String menuVinhosGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar Vinho ao Menu\n2 - Editar Vinho\n3 - Deletar Vinho\n4 - Exibir Menu");
        String opcaoVinho = scanner.nextLine();
        return opcaoVinho;
    }

    public static String menuMesasGarcom(Scanner scanner) {
        System.out.println("O que deseja fazer?\n1 - Adicionar mesa\n2 - Editar mesa\n3 - Excluir mesa\n4 - Listar mesas");
        String opcaoMesas = scanner.nextLine();
        return opcaoMesas;
    }

    public static String menuReservasGarcom(Scanner scanner) {
        System.out.println("O que você deseja fazer?\n1 - Adicionar reserva\n2 - Editar reserva\n3 - Excluir reserva\n4 - Listar reservas");
        String opcaoReservas = scanner.nextLine();
        return opcaoReservas;
    }

    public static String menuComandasGarcom(Scanner scanner) {
        System.out.println("O que você deseja fazer?\n1 - Abrir uma comanda\n2 - Editar uma comanda\n3 - Fechar uma comanda\n4 - Excluir uma comanda");
        String opcaoComandas = scanner.nextLine();
        return opcaoComandas;
    }

    public static Cliente newCliente(Scanner scanner) {
        System.out.println("Qual seu nome?");
        String nome = scanner.nextLine();
        String telefone;
        do {
            System.out.println("Qual seu telefone? (Formato: (XX) XXXXX-XXXX)");
            telefone = scanner.nextLine();
        } while (!validarTelefone(telefone));

        return new Cliente(nome, telefone);
    }

    //Funções Garçom
    public static Garcom loginGarcom(Scanner scanner) {
        System.out.println("Qual seu nome?");
        String nomeGarcom = scanner.nextLine();
        System.out.println("Qual seu turno?");
        String turnoGarcom = scanner.nextLine();
        String emailGarcom = "";
        boolean emailValido = false;
        while (!emailValido) {
            System.out.println("Qual seu email?");
            emailGarcom = scanner.nextLine();
            if (isValidEmail(emailGarcom)) {
                emailValido = true;
            } else {
                System.out.println("Email inválido. Por favor, insira um email válido.");
            }
        }
        System.out.println("Qual sua senha?");
        String senhaGarcom = scanner.nextLine();
        return new Garcom(nomeGarcom, turnoGarcom, lastGarcomId, emailGarcom, senhaGarcom);

    }

    public static Prato garcomAdicionarPrato(Scanner scanner) {

        System.out.println("Digite o nome do novo prato:");
        String nomePrato = scanner.nextLine();
        double precoPrato = obterPrecoItem(scanner);
        System.out.println("Digite a descrição do novo prato:");
        String descricaoPrato = scanner.nextLine();
        System.out.println("O prato é vegano? (S/N)");
        boolean vegano = scanner.nextLine().equalsIgnoreCase("S");
        System.out.println("O prato contém glúten? (S/N)");
        boolean gluten = scanner.nextLine().equalsIgnoreCase("S");
        System.out.println("O prato contém lactose? (S/N)");
        boolean lactose = scanner.nextLine().equalsIgnoreCase("S");
        return new Prato(nomePrato, precoPrato, descricaoPrato, vegano, gluten, lactose);

    }

    public static Prato garcomEditarPrato(String nomePratoEditar, Scanner scanner, ArrayList<Item> pratos) {
        Prato pratoExistente = null;
        for (Item item : pratos) {
            if (item instanceof Prato && item.getNomeItem().equalsIgnoreCase(nomePratoEditar)) {
                pratoExistente = (Prato) item;
                break;
            }
        }
        if (pratoExistente != null) {
            System.out.println("Digite o novo nome do prato:");
            String novoNomePrato = scanner.nextLine();
            double precoPratoNovo = obterPrecoItem(scanner);

            System.out.println("Digite a nova descrição do prato:");
            String novaDescricaoPrato = scanner.nextLine();
            System.out.println("O prato é vegano? (S/N)");
            boolean novoVegano = scanner.nextLine().equalsIgnoreCase("S");
            System.out.println("O prato contém glúten? (S/N)");
            boolean novoGluten = scanner.nextLine().equalsIgnoreCase("S");
            System.out.println("O prato contém lactose? (S/N)");
            boolean novaLactose = scanner.nextLine().equalsIgnoreCase("S");

            return new Prato(novoNomePrato, precoPratoNovo, novaDescricaoPrato, novoVegano, novoGluten, novaLactose);
        } else {
            System.out.println("Prato não encontrado");
            return null;
        }
    }

    public static String garcomDeletarPrato(Scanner scanner) {
        System.out.println("Digite o nome do prato que deseja deletar:");
        String nomePratoDeletar = scanner.nextLine();
        return nomePratoDeletar;
    }

    public static Bebida garcomAdicionarBebida(Scanner scanner) {
        System.out.println("Digite o nome da nova bebida:");
        String nomeBebida = scanner.nextLine();
        double precoBebida = obterPrecoItem(scanner);
        System.out.println("Digite a descrição da nova bebida:");
        String descricaoBebida = scanner.nextLine();
        System.out.println("A bebida é alcoólica? (S/N)");
        boolean alcoolica = scanner.nextLine().equalsIgnoreCase("S");
        return new Bebida(nomeBebida, precoBebida, descricaoBebida, alcoolica);
    }

    public static Bebida garcomEditarBebida(String nomeBebidaEditar, Scanner scanner, ArrayList<Item> bebidas) {
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
            double precoBebidaNova = obterPrecoItem(scanner);
            System.out.println("Digite a nova descrição da bebida:");
            String novaDescricaoBebida = scanner.nextLine();
            System.out.println("A bebida é alcoólica? (S/N)");
            boolean novaAlcoolica = scanner.nextLine().equalsIgnoreCase("S");

            return new Bebida(novoNomeBebida, precoBebidaNova, novaDescricaoBebida, novaAlcoolica);
        } else {
            System.out.println("Bebida não encontrada.");
            return null;
        }
    }

    public static String garcomDeletarBebida(Scanner scanner) {
        System.out.println("Digite o nome da bebida que deseja deletar:");
        String nomeBebidaDeletar = scanner.nextLine();
        return nomeBebidaDeletar;
    }

    public static double obterPrecoItem(Scanner scanner) {
        String precoItemStr;
        while (true) {
            System.out.println("Digite o preço da nova bebida no formato R$ 00,00:");
            precoItemStr = scanner.nextLine();

            // Verifica se o preço está no formato correto
            if (precoItemStr.matches("^R\\$ \\d{1,3}(\\.\\d{3})*,\\d{2}$")) {
                break;
            } else {
                System.out.println("Formato inválido. Por favor, digite novamente.");
            }
        }

        // Remove o "R$ " e substitui "," por "." para conversão
        precoItemStr = precoItemStr.replace("R$ ", "").replace(".", "").replace(",", ".");
        return Double.parseDouble(precoItemStr);
    }

    public static Vinho garcomAdicionarVinho(Scanner scanner) {
        System.out.println("Digite o nome do novo vinho:");
        String nomeVinho = scanner.nextLine();
        double precoVinho = obterPrecoItem(scanner);
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

        return new Vinho(nomeVinho, precoVinho, descricaoVinho, idadeVinho, nacionalidadeVinho, tipoVinho, uvaVinho, corpoVinho, teorAlcoolicoVinho);
    }

    public static Vinho garcomEditarVinho(String nomeVinhoEditar, Scanner scanner, ArrayList<Item> vinhos) {
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
            double precoVinhoNovo = obterPrecoItem(scanner);
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

            return new Vinho(novoNomeVinho, precoVinhoNovo, novaDescricaoVinho, novaIdadeVinho, novaNacionalidadeVinho, novoTipoVinho, novaUvaVinho, novoCorpoVinho, novoTeorAlcoolicoVinho);
        } else {
            System.out.println("Vinho não encontrado.");
            return null;
        }
    }

    public static String garcomDeletarVinho(Scanner scanner) {
        System.out.println("Digite o nome do vinho que deseja deletar:");
        String nomeVinhoDeletar = scanner.nextLine();
        return nomeVinhoDeletar;
    }

    private static ArrayList<Reserva> listaReservas = new ArrayList<>();

    public static Reserva garcomCriarReserva(Scanner scanner) {
        System.out.println("Criando uma nova reserva:");

        Date dataReserva = null;
        while (dataReserva == null) {
            System.out.print("Digite a data da reserva (dd/MM/yyyy): ");
            String dataInput = scanner.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dataReserva = dateFormat.parse(dataInput);
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Por favor, insira novamente.");
            }
        }

        int numeroMesa = -1;
        Mesa mesa = null;
        while (mesa == null) {
            System.out.print("Digite o número da mesa: ");
            try {
                numeroMesa = Integer.parseInt(scanner.nextLine());
                mesa = Mesa.encontrarMesa(numeroMesa);
                if (mesa == null) {
                    System.out.println("Mesa não encontrada. Por favor, insira novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Número da mesa inválido. Por favor, insira novamente.");
            }
        }

        Cliente clienteReserva = null;
        while (clienteReserva == null) {
            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = scanner.nextLine();
            try {
                clienteReserva = Cliente.encontrarCliente(nomeCliente);
                System.out.println("Cliente encontrado: " + clienteReserva.getNome() + ", Telefone: " + clienteReserva.getTelefone());
            } catch (ClienteNaoEncontradoException e) {
                System.out.println(e.getMessage() + " Por favor, insira novamente.");
            }
        }

        return new Reserva(dataReserva, mesa, clienteReserva, listaReservas);
    }

    public static Reserva garcomEditarReserva(String reservaEditada, Scanner scanner, ArrayList<Reserva> listaReservas) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataReserva = null;
        try {
            dataReserva = dateFormat.parse(reservaEditada);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido.");
            return null;
        }

        Reserva reservaExistente = null;
        for (Reserva reserva : listaReservas) {
            if (reserva.getDataReserva().equals(dataReserva)) {
                reservaExistente = reserva;
                break;
            }
        }

        if (reservaExistente != null) {
            System.out.print("Digite a nova data da reserva (dd/MM/yyyy): ");
            String novaDataInput = scanner.nextLine();
            Date novaDataReserva = null;
            while (novaDataReserva == null) {
                try {
                    novaDataReserva = dateFormat.parse(novaDataInput);
                } catch (ParseException e) {
                    System.out.print("Formato de data inválido. Digite novamente (dd/MM/yyyy): ");
                    novaDataInput = scanner.nextLine();
                }
            }

            System.out.print("Digite o novo número da mesa: ");
            int novoNumeroMesa = Integer.parseInt(scanner.nextLine());
            Mesa novaMesa = Mesa.encontrarMesa(novoNumeroMesa);
            while (novaMesa == null) {
                System.out.print("Mesa não encontrada. Digite novamente o número da mesa: ");
                novoNumeroMesa = Integer.parseInt(scanner.nextLine());
                novaMesa = Mesa.encontrarMesa(novoNumeroMesa);
            }

            System.out.print("Digite o novo nome do cliente: ");
            String novoNomeCliente = scanner.nextLine();
            Cliente novoCliente = null;
            while (novoCliente == null) {
                try {
                    novoCliente = Cliente.encontrarCliente(novoNomeCliente);
                } catch (ClienteNaoEncontradoException e) {
                    System.out.print("Cliente não encontrado. Digite novamente o nome do cliente: ");
                    novoNomeCliente = scanner.nextLine();
                }
            }

            reservaExistente.setDataReserva(novaDataReserva);
            reservaExistente.setMesa(novaMesa);
            reservaExistente.setCliente(novoCliente);

            System.out.println("Reserva editada com sucesso!");
            return reservaExistente;
        } else {
            System.out.println("Reserva não encontrada.");
            return null;
        }
    }

    public static void garcomCriarMesa(Scanner scanner) {
        try {
            System.out.println("Digite o número da nova mesa:");
            int numeroMesa = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite o número de lugares da nova mesa:");
            int numLugaresMesa = Integer.parseInt(scanner.nextLine());
            Mesa.adicionarMesa(numeroMesa, numLugaresMesa, false);
        } catch (NumberFormatException e) {
            System.out.println("Número inválido. Certifique-se de inserir um número válido para a mesa.");
        } catch (MesaException e) {
            System.out.println("Erro ao adicionar mesa: " + e.getMessage());
        }
    }

    public static void garcomEditarMesa(int numMesaEditar, Scanner scanner) {
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
            mesaEditar.setNumLugares(novoNumLugares);
            System.out.println("Mesa editada com sucesso. Para alterar o estado da reserva, crie uma nova reserva.");
        } else {
            System.out.println("Mesa não encontrada.");
        }

    }

    public static void garcomExcluirMesa(Scanner scanner) {
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
    }

    public static Comanda garcomAbrirComanda(Scanner scanner) {
        System.out.println("Digite o número da mesa para abrir uma comanda:");
        int numeroMesa = Integer.parseInt(scanner.nextLine());

        Mesa mesaSelecionada = null;
        for (Mesa mesa : Mesa.getListaMesas()) {
            if (mesa.getNumero() == numeroMesa) {
                mesaSelecionada = mesa;
                break;
            }
        }

        if (mesaSelecionada != null) {
            System.out.println("Comanda aberta para a mesa #" + mesaSelecionada.getNumero() + ".");
            return new Comanda(mesaSelecionada);
        } else {
            System.out.println("Mesa não encontrada. Por favor, digite um número de mesa válido.");
            return null;
        }
    }


    public static Comanda garcomEditarComanda(Scanner scanner, ArrayList<Item> comidas, ArrayList<Item> bebidas, ArrayList<Item> vinhos) {
        System.out.println("Qual comanda você deseja editar?");
        int idComanda = Integer.parseInt(scanner.nextLine());

        Comanda comanda = encontrarComanda(idComanda);

        if (comanda != null) {
            comanda.exibirComandaEspecifica(comanda);

            // Permita que o usuário adicione, remova ou edite itens na comanda
            boolean continuarEdicao = true;
            while (continuarEdicao) {
                System.out.println("O que você gostaria de fazer?");
                System.out.println("1. Adicionar item");
                System.out.println("2. Remover item");
                System.out.println("3. Confirmar pagamento");
                System.out.println("4. Sair da edição");

                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        adicionarItemComanda(comanda, comidas, bebidas, vinhos, scanner);
                        break;
                    case 2:
                        removerItemComanda(comanda, scanner);
                        break;
                    case 3:
                        comanda.confirmarPagamentoComanda();
                        break;
                    case 4:
                        continuarEdicao = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } else {
            System.out.println("Comanda não encontrada.");
        }

        return comanda;
    }

    public static Comanda encontrarComanda(int idComanda) {
        for (Comanda comanda : Comanda.getListaComandas()) {
            if (comanda.getIdComanda() == idComanda) {
                return comanda;
            }
        }
        return null;
    }

    public static void adicionarItemComanda(Comanda comanda, ArrayList<Item> comidas, ArrayList<Item> bebidas, ArrayList<Item> vinhos, Scanner scanner) {
        System.out.println("Qual o nome do item?");
        String nomeItem = scanner.nextLine();

        // Verificar se o item existe na lista de comidas
        for (Item comida : comidas) {
            if (comida.getNomeItem().equalsIgnoreCase(nomeItem)) {
                comanda.adicionarItem(comida);
                System.out.println("Comida adicionada com sucesso à comanda.");
                return;
            }
        }

        // Verificar se o item existe na lista de bebidas
        for (Item bebida : bebidas) {
            if (bebida.getNomeItem().equalsIgnoreCase(nomeItem)) {
                comanda.adicionarItem(bebida);
                System.out.println("Bebida adicionada com sucesso à comanda.");
                return;
            }
        }

        // Verificar se o item existe na lista de vinhos
        for (Item vinho : vinhos) {
            if (vinho.getNomeItem().equalsIgnoreCase(nomeItem)) {
                comanda.adicionarItem(vinho);
                System.out.println("Vinho adicionado com sucesso à comanda.");
                return;
            }
        }

        System.out.println("Item não encontrado na lista de comidas, bebidas ou vinhos.");
    }

    public static void removerItemComanda(Comanda comanda, Scanner scanner) {
        System.out.println("Qual o nome do item que deseja remover?");
        String nomeItem = scanner.nextLine();
        for (Item item : comanda.getItensComanda()) {
            if (item.getNomeItem().equalsIgnoreCase(nomeItem)) {
                try {
                    comanda.removerItem(item);
                    System.out.println("Item removido com sucesso da comanda.");
                } catch (ItemNaoEncontradoException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Item não encontrado na comanda.");
    }

    public static void garcomFecharComanda(Scanner scanner) {

    }

    public static void garcomDeletarComanda(Scanner scanner) {

    }


    //Validações
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
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
                Reserva reserva = new Reserva(dataReserva, mesaSelecionada, cliente, listaReservas);
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
        Reserva.inicializarReservas(listaReservas);

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
                Cliente cliente = newCliente(scanner);
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
                Garcom garcom = loginGarcom(scanner);
                lastGarcomId++;
                System.out.println("Bem-vindo, " + garcom.getNome());
                while (true) {
                    switch (menuGarcom(scanner)) {
                        case "1":
                            System.out.println("Que menu deseja acessar?\n1 - Menu de Pratos\n2 - Menu de Bebidas\n3 - Menu de Vinhos");
                            String menuGarcom = scanner.nextLine();
                            switch (menuGarcom) {
                                case "1":
                                    switch (menuPratosGarcom(scanner)) {
                                        case "1":
                                            menuDePratos.adicionarItem(garcomAdicionarPrato(scanner));
                                            break;
                                        case "2":
                                            menuDePratos.exibirMenu();
                                            System.out.println("Digite o nome do prato que deseja editar:");
                                            String nomePratoEditar = scanner.nextLine();
                                            menuDePratos.editarItem(nomePratoEditar, garcomEditarPrato(nomePratoEditar, scanner, comidas));
                                            break;
                                        case "3":
                                            menuDePratos.exibirMenu();
                                            menuDePratos.deletarItem(garcomDeletarPrato(scanner));
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
                                            menuDeBebidas.adicionarItem(garcomAdicionarBebida(scanner));
                                            break;
                                        case "2":
                                            menuDeBebidas.exibirMenu();
                                            System.out.println("Digite o nome da bebida que deseja editar:");
                                            String nomeBebidaEditar = scanner.nextLine();
                                            menuDeBebidas.editarItem(nomeBebidaEditar, garcomEditarBebida(nomeBebidaEditar, scanner, bebidas));
                                            break;
                                        case "3":
                                            menuDeBebidas.exibirMenu();
                                            menuDeBebidas.deletarItem(garcomDeletarBebida(scanner));
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
                                            menuDeVinhos.adicionarItem(garcomAdicionarVinho(scanner));
                                            break;
                                        case "2":
                                            menuDeVinhos.exibirMenu();
                                            System.out.println("Digite o nome do vinho que deseja editar:");
                                            String nomeVinhoEditar = scanner.nextLine();
                                            menuDeVinhos.editarItem(nomeVinhoEditar, garcomEditarVinho(nomeVinhoEditar, scanner, vinhos));
                                            break;
                                        case "3":
                                            menuDeVinhos.exibirMenu();
                                            menuDeVinhos.deletarItem(garcomDeletarVinho(scanner));
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
                                    Reserva reserva = garcomCriarReserva(scanner);
                                    if (reserva != null) {
                                        System.out.println("Reserva criada com sucesso: " + reserva);
                                    } else {
                                        System.out.println("Reserva não foi criada.");
                                    }
                                    break;
                                case "2":
                                    Reserva.visualizarReservas(listaReservas);
                                    System.out.print("Digite a data da reserva que deseja editar (dd/MM/yyyy): ");
                                    String reservaEditada = scanner.nextLine();
                                    garcomEditarReserva(reservaEditada, scanner, listaReservas);
                                    break;
                                case "3":
                                    Reserva.visualizarReservas(listaReservas);
                                    System.out.println("Qual a data da reserva?");
                                    String dataCancelarReserva = scanner.nextLine();
                                    System.out.println("Qual a mesa da reserva?");
                                    int mesaCancelarReserva = scanner.nextInt();
                                    System.out.println("Qual o cliente da reserva?");
                                    String nomeCancelarReserva = scanner.nextLine();
                                    Reserva.cancelarReserva(listaReservas, dataCancelarReserva, nomeCancelarReserva, mesaCancelarReserva);
                                    break;
                                case "4":
                                    Reserva.visualizarReservas(listaReservas);
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }
                            break;
                        case "3":
                            switch (menuMesasGarcom(scanner)) {
                                case "1":
                                    garcomCriarMesa(scanner);
                                    break;
                                case "2":
                                    Mesa.exibirTodasMesas();
                                    System.out.println("Digite o número da mesa que deseja editar:");
                                    int numMesaEditar = Integer.parseInt(scanner.nextLine());
                                    garcomEditarMesa(numMesaEditar, scanner);
                                    break;
                                case "3":
                                    Mesa.exibirTodasMesas();
                                    garcomExcluirMesa(scanner);
                                    break;
                                case "4":
                                    Mesa.exibirTodasMesas();
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }
                            break;
                        case "4":
                            switch (menuComandasGarcom(scanner)) {
                                case "1":
                                    garcomAbrirComanda(scanner);
                                    break;
                                case "2":
                                    Comanda.exibirListaComandas();
                                    garcomEditarComanda(scanner, comidas, bebidas, vinhos);
                                    break;
                                case "3":
                                    Mesa.exibirTodasMesas();
                                    garcomExcluirMesa(scanner);
                                    break;
                                case "4":
                                    Mesa.exibirTodasMesas();
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }
                            garcomAbrirComanda(scanner);
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                }
        }
    }
}

