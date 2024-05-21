import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditarMesa {
    private JTextField númeroDaMesaTextField;
    private JTextField númeroDeLugaresTextField;
    private JButton editarDadosButton;
    private JButton voltarButton;

    public EditarMesa() {
        editarDadosButton.addMouseListener(new MouseAdapter() {
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
