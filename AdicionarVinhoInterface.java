import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdicionarVinhoInterface {
    private JButton adicionarVinhoButton;
    private JTextField addVinhoNome;
    private JTextField addVinhoAlcool;
    private JLabel nomeVinho;
    private JLabel descricaoVinho;
    private JLabel precoVinho;
    private JLabel idadeVinho;
    private JLabel nacionalidadeVinho;
    private JLabel tipoVinho;
    private JLabel uvaVinho;
    private JLabel corpoVinho;
    private JLabel alcoolVinho;
    private JTextField addVinhoDescricao;
    private JTextField addVinhoPreco;
    private JTextField addVinhoIdade;
    private JTextField addVinhoNacionalidade;
    private JTextField addVinhoTipo;
    private JTextField addVinhoUva;
    private JTextField addVinhoCorpo;
    private JButton voltarButton;

    public AdicionarVinhoInterface() {
        adicionarVinhoButton.addMouseListener(new MouseAdapter() {
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
