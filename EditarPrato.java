import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditarPrato {
    private JRadioButton semGlutenRadioButton;
    private JRadioButton veganoRadioButton;
    private JButton editarPratoButton;
    private JButton voltarButton;
    private JTextField nomePrato;
    private JTextField descricaoPrato;
    private JTextField precoPrato;
    private JRadioButton semLactoseRadioButton;

    public EditarPrato() {
        voltarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        editarPratoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
