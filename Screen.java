import java.awt.*;
import javax.swing.*;

public class Screen {
    public Screen() {
        JFrame jFrame = new JFrame("Sistema Restaurante"); /* Criando a janela */
        jFrame.setVisible(true); /* Torna a tela visível */
        jFrame.setSize(800, 600); /* Define um tamanho padrão para a tela */
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* Faz o botão de fechar fechar o programa */
        jFrame.setResizable(false); /* Impede que a tela mude de tamanho */
        jFrame.setLocationRelativeTo(null); /* Centraliza a tela no monitor */
        Container contentPane = jFrame.getContentPane();// Obtém o painel de conteúdo do JFrame */
        contentPane.setBackground(Color.gray); // Define a cor de fundo*/
        contentPane.revalidate();// garantir que atualizou corretamete */
        // Carrega a imagem a partir de um arquivo (neste caso, "imagem.jpg" na mesma pasta do código)
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("imagem_teste.jpg"));//referencia a imagem
        JLabel imageLabel = new JLabel(imageIcon);// Cria um JLabel para exibir a imagem
        jFrame.add(imageLabel);// Adiciona o JLabel ao JFrame
        jFrame.setVisible(true); /* Torna a tela visível */
        /* teste  */
    }
}
