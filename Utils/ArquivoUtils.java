package Utils;

import model.Item;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoUtils {

    public static void salvarItensEmArquivo(ArrayList<Item> itens, String nomeArquivo) {
        try (FileWriter escritor = new FileWriter(nomeArquivo)) {
            for (Item item : itens) {
                escritor.write(item.toString() + "\n\n");
            }
            System.out.println("Itens salvos em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo " + nomeArquivo);
            e.printStackTrace();
        }
    }
}
