import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditarBebida {
    private JTextField nomeBebida;
    private JTextField descricaoBebida;
    private JTextField precoBebida;
    private JComboBox alcoolBebida;
    private JButton editarBebidaButton;
    private JButton voltarButton;

    public EditarBebida() {
        editarBebidaButton.addMouseListener(new MouseAdapter() {
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
