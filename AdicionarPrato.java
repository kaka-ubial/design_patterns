import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdicionarPrato {
    private JRadioButton semGlutenRadioButton;
    private JRadioButton semLactoseRadioButton;
    private JRadioButton veganoRadioButton;
    private JTextField nomePrato;
    private JTextField descricaoPrato;
    private JTextField precoPrato;
    private JButton adicionarPratoButton;
    private JButton voltarButton;

    public AdicionarPrato() {
        adicionarPratoButton.addMouseListener(new MouseAdapter() {
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
