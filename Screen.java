import javax.swing.*;
import java.awt.*;


public class Screen {
    public Screen() {
        JFrame jFrame = new JFrame("Sistema Restaurante"); /* Criando a janela */
        jFrame.setVisible(true); /* Torna a tela visível */
        jFrame.setSize(800, 600); /* Deixa um tamanho padrão a tela */
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* faz o x fechar o programa */
        jFrame.setResizable(false); /* Não deixa trocar de tamanho a tela */
        jFrame.setLocationRelativeTo(null); /* Deixa a tela localizada ao centro do monitor */

    }
}
