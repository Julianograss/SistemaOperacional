package atividade3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class SistemaOperacional extends JFrame{
    public String[] colunas = {"Cód", "Descrição", "Qtd", "V.Unit", "Total"}; 
    public DefaultTableModel modelo = new DefaultTableModel(colunas, 0); 
    public JTable tabela = new JTable(modelo);
    public int j = 30;
    public JLabel lblTotal = new JLabel();
    public SistemaOperacional(){
        setSize(800,600);
        setTitle("Login Sistema Operacional");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //painel auxiliar para centralizr o painel de login
        JPanel pnlCentralizar = new JPanel();
        pnlCentralizar.setLayout(new BoxLayout(pnlCentralizar, BoxLayout.Y_AXIS));
        pnlCentralizar.setBackground(Color.GRAY);
        pnlCentralizar.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));

        JPanel pnlPainelLogin = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 20, 10, 20);
        pnlPainelLogin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlPainelLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnlPainelLogin.setMaximumSize(new Dimension(400, 200));
        pnlPainelLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlPainelLogin.setAlignmentY(Component.CENTER_ALIGNMENT);
        //pnlPainelLogin.setBackground(Color.BLACK);

        JLabel lblLogMsg = new JLabel("Login", SwingConstants.CENTER);
        lblLogMsg.setFont(new Font("Arial", Font.BOLD, 21));
        lblLogMsg.setAlignmentY(Component.TOP_ALIGNMENT);

        BotaoArredondado btnEntrar = new BotaoArredondado("Entrar", j);
        btnEntrar.setForeground(Color.BLACK);
        btnEntrar.setBackground(new Color(34, 139, 34));
        btnEntrar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        btnEntrar.setMaximumSize(new Dimension(150, 30));

        //ajusta o tamanho do painel de login quando expandir a tela
        addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
                    pnlCentralizar.setBorder(BorderFactory.createEmptyBorder(300, 0, 0, 0));
                    pnlPainelLogin.setMaximumSize(new Dimension(500, 350));
                    btnEntrar.setMaximumSize(new Dimension(250, 40));

                }
                else if ((e.getNewState() & Frame.NORMAL) == Frame.NORMAL) {
                    pnlCentralizar.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));
                    pnlPainelLogin.setMaximumSize(new Dimension(300, 150));
                    btnEntrar.setMaximumSize(new Dimension(150, 30));

                }
            }
        });

        JLabel lblUsuario = new JLabel("Usuario: ");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 13));

        JTextField txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 10));

        JLabel lblSenha = new JLabel("Senha: ");
        lblSenha.setFont(new Font("Arial", Font.PLAIN, 13));

        JPasswordField pswSenhaUsu = new JPasswordField();

        //ajusta a mensagem no GridBagLayout
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        pnlPainelLogin.add(lblLogMsg, c);
        c.gridwidth = 1;

        //Usuario
        c.gridx = 0;
        c.gridy = 1;
        pnlPainelLogin.add(lblUsuario, c);
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        pnlPainelLogin.add(txtUsuario, c);
        c.weightx = 0;

        //Senha 
        c.gridx = 0;
        c.gridy = 2;
        pnlPainelLogin.add(lblSenha, c);
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1.0;
        pnlPainelLogin.add(pswSenhaUsu, c);
        c.weightx = 0;

        //Botao Entrar
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        pnlPainelLogin.add(btnEntrar, c);
        c.gridwidth = 1;

        btnEntrar.addActionListener(e -> {
            janelaOperador();
        });


        pnlCentralizar.add(pnlPainelLogin);
        
        add(pnlCentralizar);
        setVisible(true);
    }
    public void janelaOperador(){
        JFrame jnlOperador = new JFrame("Caixa");
        jnlOperador.setSize(800,600);
        jnlOperador.setLocationRelativeTo(null);
        jnlOperador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jnlOperador.setLayout(new BorderLayout());

        JPanel pnlCentralizar = new JPanel(new BorderLayout());
        pnlCentralizar.setBackground(Color.GRAY);
        pnlCentralizar.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JPanel pnlCaixaStts = new JPanel(new BorderLayout());
        pnlCaixaStts.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        pnlCaixaStts.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        pnlCaixaStts.setBackground(Color.BLACK);

        JLabel lblMsgSttsCaix = new JLabel("CAIXA ABERTO");
        lblMsgSttsCaix.setFont(new Font("Arial", Font.BOLD, 22));
        lblMsgSttsCaix.setForeground(new Color(57, 255, 20));

        BotaoArredondado btnCaixaStts = new BotaoArredondado("Fechar Caixa",j);
        btnCaixaStts.setBackground(Color.RED);
        btnCaixaStts.setFont(new Font("Arial", Font.BOLD, 13));
        //tabela.setAlignmentX(LEFT_ALIGNMENT);
        
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel pnlCaixOpera = new JPanel();
        pnlCaixOpera.setBackground(Color.CYAN);
        pnlCaixOpera.setLayout(new BoxLayout(pnlCaixOpera, BoxLayout.Y_AXIS));
        pnlCaixOpera.setPreferredSize(new Dimension(300,500));
        pnlCaixOpera.setBorder(BorderFactory.createEmptyBorder(150,20,150,20));

        JLayeredPane pnlInofsCaix = new JLayeredPane();
        pnlInofsCaix.setBorder(BorderFactory.createEmptyBorder(3, 3,3, 3));
        pnlInofsCaix.setMaximumSize(new Dimension(190,50));

        JLabel lblCodigo = new JLabel("CÓDIGO/SKU (Enter p/ Inserir)");
        lblCodigo.setFont(new Font("Arial", Font.BOLD, 9));

        JTextField txtCodigo = new JTextField();
        txtCodigo.setPreferredSize(new Dimension(125, 25));

        JPanel pnlInfosTotal = new JPanel();

        
        pnlInofsCaix.add(txtCodigo, JLayeredPane.DEFAULT_LAYER);
        pnlInofsCaix.add(lblCodigo, JLayeredPane.PALETTE_LAYER);
        


        /*lblTotal.setVerticalAlignment(SwingConstants.CENTER);
        lblTotal.setText("0");
        lblTotal.setForeground(new Color(34, 139, 34));
        lblTotal.setFont(new Font("Arial", Font.BOLD, 35));*/
        

        btnCaixaStts.addActionListener(e ->{
            String msgCaixaStts = lblMsgSttsCaix.getText();
            btnCaixaStts.setText("Abrir Caixa");
            btnCaixaStts.setBackground(Color.GREEN);
            lblMsgSttsCaix.setText("CAIXA FECHADO");
            lblMsgSttsCaix.setForeground(Color.RED);
            if (msgCaixaStts.equals("CAIXA ABERTO")){
                lblMsgSttsCaix.setText("CAIXA FECHADO");
                lblMsgSttsCaix.setForeground(Color.RED);
                btnCaixaStts.setText("Abrir Caixa");
                btnCaixaStts.setBackground(Color.GREEN);
                txtCodigo.setText("");
                txtCodigo.setEditable(false);
            } else if(msgCaixaStts.equals("CAIXA FECHADO")){
                lblMsgSttsCaix.setText("CAIXA ABERTO");
                lblMsgSttsCaix.setForeground(Color.GREEN);
                btnCaixaStts.setText("Fechar Caixa");
                btnCaixaStts.setBackground(Color.RED);
                txtCodigo.setEditable(true);
                txtCodigo.requestFocusInWindow();
            }
        });

        pnlCaixOpera.add(pnlInofsCaix, BorderLayout.CENTER);
        //pnlCaixOpera.add(lblTotal);

        jnlOperador.add(pnlCaixaStts, BorderLayout.NORTH);
        pnlCaixaStts.add(lblMsgSttsCaix, BorderLayout.WEST);
        pnlCaixaStts.add(btnCaixaStts, BorderLayout.EAST);
        
        pnlCentralizar.add(pnlCaixOpera, BorderLayout.EAST);
        pnlCentralizar.add(scroll, BorderLayout.CENTER); 
        jnlOperador.add(pnlCentralizar, BorderLayout.CENTER);

        jnlOperador.setVisible(true);
        txtCodigo.requestFocusInWindow();
    }
    public void atualizarTotal() { 
        double soma = 0; 
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel(); 
        
        for (int i = 0; i < modelo.getRowCount(); i++) { 
            // Assume que a coluna 4 é o total do item (Qtd * Valor Unit) 
            soma += (double) modelo.getValueAt(i, 4); 
        } 
        
        lblTotal.setText(String.format("R$ %.2f", soma)); 
    } 
    public static void main(String args[]){
        new SistemaOperacional();
    }
}

