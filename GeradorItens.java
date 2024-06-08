import java.util.ArrayList;
import java.util.Random;

public class GeradorItens {
    private static String[] nomesComidas = {"Salada Caesar", "Spaghetti Carbonara", "Frango à Parmegiana", "Bife Acebolado", "Lasanha"};
    private static String[] nomesBebidas = {"Refrigerante", "Suco de Laranja", "Água Mineral", "Cerveja", "Café"};
    private static String[] nomesVinhos = {"Cabernet Sauvignon", "Merlot", "Chardonnay", "Pinot Noir", "Sauvignon Blanc"};

    public static ArrayList<Item> gerarItensAleatorios(String tipo, int quantidade) {
        ArrayList<Item> itens = new ArrayList<>();
        Random random = new Random();

        String[] nomes;
        if (tipo.equals("comida")) {
            nomes = nomesComidas;
        } else if (tipo.equals("bebida")) {
            nomes = nomesBebidas;
        } else {
            nomes = nomesVinhos;
        }

        for (int i = 0; i < quantidade; i++) {
            String nome = nomes[random.nextInt(nomes.length)];
            double preco = 5 + (50 - 5) * random.nextDouble();
            String descricao = "Descrição de " + nome;

            if (tipo.equals("comida")) {
                boolean vegano = random.nextBoolean();
                boolean gluten = random.nextBoolean();
                boolean lactose = random.nextBoolean();
                itens.add(new Prato(nome, preco, descricao, vegano, gluten, lactose));
            } else if (tipo.equals("bebida")) {
                boolean alcoolica = random.nextBoolean();
                itens.add(new Bebida(nome, preco, descricao, alcoolica));
            } else {
                int idadeVinho = 1 + random.nextInt(20);
                String nacionalidade = "Nacionalidade " + (i + 1);
                String tipoVinho = "Tipo " + (i + 1);
                String uva = "Uva " + (i + 1);
                String corpo = "Corpo " + (i + 1);
                String teorAlcoolico = (10 + random.nextInt(5)) + "%";
                itens.add(new Vinho(nome, preco, descricao, idadeVinho, nacionalidade, tipoVinho, uva, corpo, teorAlcoolico));
            }
        }

        return itens;
    }
}
