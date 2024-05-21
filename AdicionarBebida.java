import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdicionarBebida {
    private JTextField nomeBebida;
    private JTextField descricaoBebida;
    private JTextField precoBebida;
    private JComboBox temAlcoolBebida;
    private JButton adicionarBebidaButton;
    private JButton voltarButton;

    public AdicionarBebida() {
        adicionarBebidaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        voltarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
