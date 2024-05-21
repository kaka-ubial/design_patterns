import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cadastro {
    private JTextField nomeCadastro;
    private JTextField turnoCadastro;
    private JPasswordField senhaCadastro;
    private JTextField emailCadastro;
    private JLabel nomeGarcom;
    private JLabel turnoGarcom;
    private JLabel emailGarcom;
    private JLabel senhaGarcom;
    private JPanel cadastro;
    private JButton cadastrarButton;
    private JButton loginExisteButton;

    public Cadastro() {
        loginExisteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        cadastrarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
