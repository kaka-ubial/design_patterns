import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CriarReserva {
    private JTextField dataDaReservaTextField;
    private JTextField númeroDaMesaTextField;
    private JButton criarReservaButton;
    private JButton voltarButton;

    public CriarReserva() {
        criarReservaButton.addMouseListener(new MouseAdapter() {
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
