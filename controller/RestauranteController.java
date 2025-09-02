package controller;

import model.Restaurante;
import java.io.*;

public class RestauranteController {
    private Restaurante restaurante;

    public RestauranteController(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void editarInfo(String nome, String culinaria, String descricao, String endereco, String horarioFuncionamento, String telefone) {
        atualizarSeNaoVazio(nome, restaurante::setNome);
        atualizarSeNaoVazio(culinaria, restaurante::setCulinaria);
        atualizarSeNaoVazio(descricao, restaurante::setDescricao);
        atualizarSeNaoVazio(endereco, restaurante::setEndereco);
        atualizarSeNaoVazio(horarioFuncionamento, restaurante::setHorarioFuncionamento);
        atualizarSeNaoVazio(telefone, restaurante::setTelefone);
    }

    private void atualizarSeNaoVazio(String valor, java.util.function.Consumer<String> setter) {
        if (valor != null && !valor.isBlank()) setter.accept(valor);
    }

    public void salvarRestauranteEmArquivo() {
        try (FileWriter escritor = new FileWriter("restaurante.txt")) {
            escritor.write("Nome: " + restaurante.getNome() + "\n");
            escritor.write("Culinaria: " + restaurante.getCulinaria() + "\n");
            escritor.write("Descrição: " + restaurante.getDescricao() + "\n");
            escritor.write("Endereço: " + restaurante.getEndereco() + "\n");
            escritor.write("Horário de Funcionamento: " + restaurante.getHorarioFuncionamento() + "\n");
            escritor.write("Telefone: " + restaurante.getTelefone() + "\n");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar as informações do restaurante.");
            e.printStackTrace();
        }
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }
}
