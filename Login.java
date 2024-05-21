import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {
    private JPanel login;
    private JButton logarButton;
    private JButton semCadastroButton;
    private JTextField emailLogin;
    private JPasswordField passwordLogin;
    private JLabel senhaLoginLabel;
    private JLabel emailLoginLabel;
    private JButton loginButton;

    public Login() {
        logarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        semCadastroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
