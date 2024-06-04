import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class InterfaceMenu extends JFrame{
    private JPanel interfaceMenu;
    private JTabbedPane mainMenu;
    private JTabbedPane menuCardapios;
    private JTabbedPane tabbedPane4;
    private JList listaMesas;
    private JTable listaComandas;
    private JList<String> mesas;
    private JTable reservaMesas;
    private JTable menuBebidas;
    private JTable menuPratos;
    private JTable table1;
    private JTabbedPane acoesBebidas;
    private JTabbedPane acoesPrato;
    private JTabbedPane acoesVinho;
    private JButton fecharComandaButton;
    private JTabbedPane tabbedPane5;
    private JTextField adicionarNomeBebida;
    private JTextField adicionarDescricaoBebida;
    private JTextField adicionarPrecoBebida;
    private JRadioButton adicionarIsAlcoolicaBebida;
    private JButton adicionarBebidaButton;
    private JList editarBebidaList;
    private JScrollBar scrollBar1;
    private JButton excluirBebidaButton;
    private JScrollBar scrollBar2;
    private JCheckBox semGlutenCheckBox;
    private JCheckBox semLactoseCheckBox;
    private JCheckBox veganoCheckBox;
    private JButton adicionarPratoButton;
    private JTextField addPratoNome;
    private JTextField addDescricaoNome;
    private JTextField addPrecoNome;
    private JScrollBar scrollBar3;
    private JList listPratosEditar;
    private JScrollBar scrollBar4;
    private JTextField addVinhoNome;
    private JTextField addVinhoDescricao;
    private JTextField addVinhoPreco;
    private JTextField addVinhoIdade;
    private JTextField addVinhoPais;
    private JTextField addVinhoTipo;
    private JTextField addVinhoUva;
    private JTextField addVinhoCorpo;
    private JTextField addVinhoTeor;
    private JButton adicionarVinhoButton;
    private JList vinhoListEditar;
    private JScrollBar scrollBar5;
    private JScrollBar scrollBar6;
    private JList comandaMesaAdd;
    private JList itensComandaAdd;

    private JList itemComandaEdit;

    private JList itemComandaDelete;
    private JScrollBar scrollBar8;
    private JScrollBar scrollBar9;
    private JScrollBar scrollBar10;
    private JScrollBar scrollBarAddItem;
    private JButton adicionarComandaButton;
    private JButton deleteItemComanda;
    private JButton editItemComanda;
    private JButton adicionarItemButton;
    private JSpinner spinner1;
    private JButton excluirComandaButton;
    private JButton editarBebidaButton;
    private JButton editarPratoButton;
    private JButton deletarPratoButton;
    private JButton editarVinhoButton;
    private JButton deletarVinhoButton;
    private JList listPratosDeletar;
    private JList vinhoListDeletar;
    private JList excluirBebidaList;
    private JTextField editarNomeList;
    private JTextField editarDescricaoBebida;
    private JTextField editarPrecoBebida;
    private JRadioButton editarAlcoolicaBebida;
    private JTextField editPratoNome;
    private JTextField editPratoDescricao;
    private JTextField editPratoPreco;
    private JTextField editVinhoNome;
    private JTextField editVinhoDescricao;
    private JTextField editVinhoPreco;
    private JTextField editVinhoIdade;
    private JTextField editVinhoPais;
    private JTextField editVinhoTipo;
    private JTextField editVinhoUva;
    private JTextField editVinhoCorpo;
    private JTextField editVinhoTeor;
    private JTable Mesas;
    private ArrayList<Bebida> catalogoBebidas = new ArrayList<>();

    public JPanel getInterfaceMenu() {
        return interfaceMenu;
    }

    public void setInterfaceMenu(JPanel interfaceMenu) {
        this.interfaceMenu = interfaceMenu;
    }

    private void adicionarBebida() {
        String nome = adicionarNomeBebida.getText();
        String descricao = adicionarDescricaoBebida.getText();
        double preco;
        try {
            preco = Double.parseDouble(adicionarPrecoBebida.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preço inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean isAlcoolica = adicionarIsAlcoolicaBebida.isSelected();

        Bebida novaBebida = new Bebida(nome, preco, descricao, isAlcoolica);
        catalogoBebidas.add(novaBebida);

        atualizarTabelaBebidas();
    }

    private void atualizarTabelaBebidas() {
        String[] colunas = {"Nome", "Preço", "Descrição", "Alcoólica"};
        Object[][] dados = new Object[catalogoBebidas.size()][4];

        for (int i = 0; i < catalogoBebidas.size(); i++) {
            Bebida bebida = catalogoBebidas.get(i);
            dados[i][0] = bebida.getNomeItem();
            dados[i][1] = bebida.getPrecoItem();
            dados[i][2] = bebida.getDescricaoItem();
            dados[i][3] = bebida.isAlcoolica();
        }

        menuBebidas.setModel(new javax.swing.table.DefaultTableModel(dados, colunas));
    }
    public InterfaceMenu() {
        adicionarBebidaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                adicionarBebida();
            }
        });


        editarBebidaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        excluirBebidaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        adicionarPratoButton.addMouseListener(new MouseAdapter() {
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
        deletarPratoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        adicionarVinhoButton.addMouseListener(new MouseAdapter() {
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
        deletarVinhoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    private void createUIComponents() {


    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfaceMenu interfaceMenu = new InterfaceMenu();
                interfaceMenu.setVisible(true);
//                JFrame frame = new JFrame("InterfaceMenu");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.getContentPane().add(new InterfaceMenu().getInterfaceMenu());
//
//                frame.pack();
//                frame.setVisible(true);
            }
        });
    }
 }