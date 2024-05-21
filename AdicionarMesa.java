import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdicionarMesa {
    private JTextField numMesa;
    private JRadioButton reservadaRadioButton;
    private JRadioButton nãoReservadaRadioButton;
    private JButton criarNovaMesaButton;
    private JButton voltarButton;

    public AdicionarMesa() {
        criarNovaMesaButton.addMouseListener(new MouseAdapter() {
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
