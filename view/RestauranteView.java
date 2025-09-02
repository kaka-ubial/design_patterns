package view;

import model.Restaurante;

public class RestauranteView {
    public void exibirInfo(Restaurante restaurante) {
        System.out.println("Nome: " + restaurante.getNome());
        System.out.println("Culinária: " + restaurante.getCulinaria());
        System.out.println("Descrição: " + restaurante.getDescricao());
        System.out.println("Endereço: " + restaurante.getEndereco());
        System.out.println("Horário de Funcionamento: " + restaurante.getHorarioFuncionamento());
        System.out.println("Telefone: " + restaurante.getTelefone());
    }
}
