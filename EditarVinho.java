import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditarVinho {
    private JTextField nomeVinho;
    private JTextField descricaoVinho;
    private JTextField precoVinho;
    private JTextField idadeVinho;
    private JTextField nacionalidadeVinho;
    private JTextField tipoVinho;
    private JTextField uvaVinho;
    private JTextField corpoVinho;
    private JTextField alcoolVinho;
    private JButton editarVinhoButton;
    private JButton voltarButton;

    public EditarVinho() {
        voltarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        editarVinhoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        editarVinhoButton.addMouseListener(new MouseAdapter() {
        });
    }
}
