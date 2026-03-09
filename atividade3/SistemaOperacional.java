package atividade3;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.*;

public class SistemaOperacional extends JFrame{
    public DefaultTableModel modeloEstoque;
    public JTable tblEstoque;
    public double caixVirtual = 10000;
    public double soma = 0;
    public double vlrCompr = 0;
    public DefaultTableModel modelo; 
    public JTable tblItens;
    public int j = 30, EstqBaixo = 20;
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
        pnlCentralizar.setBackground(new Color(180,240,240));
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

        JLabel lblLogMsg = new JLabel("Login", SwingConstants.CENTER);
        lblLogMsg.setForeground(new Color(34, 139, 34));
        lblLogMsg.setFont(new Font("Arial", Font.BOLD, 21));
        lblLogMsg.setAlignmentY(Component.TOP_ALIGNMENT);

        BotaoArredondado btnEntrar = new BotaoArredondado("Entrar", j);
        btnEntrar.setForeground(Color.WHITE);
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
        JLabel lblUsuario = new JLabel("Usuário: ");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
        JTextField txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 10));
        JLabel lblSenha = new JLabel("Senha: ");
        lblSenha.setFont(new Font("Arial", Font.PLAIN, 13));
        JPasswordField pswSenhaUsu = new JPasswordField();

        //ajusta a mensagem no GridBagLayout
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        pnlPainelLogin.add(lblLogMsg, c); c.gridwidth = 1;
        //Usuario
        c.gridx = 0; c.gridy = 1;
        pnlPainelLogin.add(lblUsuario, c);
        c.gridx = 1; c.gridy = 1; c.weightx = 1.0;
        pnlPainelLogin.add(txtUsuario, c); c.weightx = 0;
        //Senha 
        c.gridx = 0; c.gridy = 2;
        pnlPainelLogin.add(lblSenha, c);
        c.gridx = 1; c.gridy = 2; c.weightx = 1.0;
        pnlPainelLogin.add(pswSenhaUsu, c); c.weightx = 0;
        //Botao Entrar
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        pnlPainelLogin.add(btnEntrar, c); c.gridwidth = 1;

        btnEntrar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            char[] cSenha = pswSenhaUsu.getPassword();
            String strSenha = String.valueOf(cSenha);
            if (usuario.equals("admin") && strSenha.equals("admin")){
                janelaGerente();
            } else {
                janelaOperador();
            }
        });
        pnlCentralizar.add(pnlPainelLogin);
        
        add(pnlCentralizar);
        setVisible(true);
    }
    public void janelaOperador(){
        BancoFake banco = new BancoFake();
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
        BotaoArredondado btnCaixaStts = new BotaoArredondado("Fechar Caixa", j);
        btnCaixaStts.setBackground(Color.RED);
        btnCaixaStts.setFont(new Font("Arial", Font.BOLD, 13));
        
        String[] colunas = {"Cód", "Descrição", "Qtd", "V.Unit", "Total"}; 

        modelo = new DefaultTableModel(colunas, 0);
        tblItens = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tblItens);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel pnlCaixOpera = new JPanel();
        pnlCaixOpera.setBackground(new Color(255,240,180,230));
        pnlCaixOpera.setLayout(new BoxLayout(pnlCaixOpera, BoxLayout.Y_AXIS));
        pnlCaixOpera.setPreferredSize(new Dimension(300,500));
        pnlCaixOpera.setBorder(BorderFactory.createEmptyBorder(150,50,150,50));

        JPanel pnlInofsCaix = new JPanel(new BorderLayout());
        pnlInofsCaix.setBackground(Color.WHITE);
        pnlInofsCaix.setOpaque(true);
        pnlInofsCaix.setMaximumSize(new Dimension(400,50));
        TitledBorder borda = BorderFactory.createTitledBorder("CÓDIGO/SKU (Enter p/ Inserir)");
        borda.setTitleFont(new Font("Arial", Font.BOLD, 9));
        pnlInofsCaix.setBorder(borda);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setOpaque(false);
        txtCodigo.setBorder(null);

        pnlInofsCaix.add(txtCodigo, BorderLayout.CENTER);
        
        JPanel pnlTotal = new JPanel();
        pnlTotal.setBorder(BorderFactory.createTitledBorder("TOTAL DA VENDA"));
        pnlTotal.setBackground(Color.WHITE);
        pnlTotal.setMaximumSize(new Dimension(400,90));

        lblTotal.setFont(new Font("Arial", Font.BOLD, 40));
        lblTotal.setForeground(new Color(34,139,34));
        lblTotal.setText("R$  0,00");

        pnlTotal.add(lblTotal);
        pnlCaixOpera.add(Box.createRigidArea(new Dimension(0,30)));

        JTextArea teclasAtalho = new JTextArea("\nF1 - Finalizar\nF2 - Cancelar Item\nF3 - Sangria\nF5 - Sair");
        teclasAtalho.setBackground(new Color(255,240,180,100));
        teclasAtalho.setEditable(false);
        teclasAtalho.setFocusable(false);

        JPanel pnlAtalhos = new JPanel();
        pnlAtalhos.setOpaque(false);
        pnlAtalhos.setMaximumSize(new Dimension(400,90));
        pnlAtalhos.setAlignmentX(RIGHT_ALIGNMENT);

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
                modelo.setRowCount(0); 
                lblTotal.setText("R$  0,00");
            } else if(msgCaixaStts.equals("CAIXA FECHADO")){
                lblMsgSttsCaix.setText("CAIXA ABERTO");
                lblMsgSttsCaix.setForeground(Color.GREEN);
                btnCaixaStts.setText("Fechar Caixa");
                btnCaixaStts.setBackground(Color.RED);
                txtCodigo.setEditable(true);
                txtCodigo.requestFocusInWindow();
                modelo.setRowCount(0);
            }
        });
        txtCodigo.addActionListener(e ->{
            String codigoDigitado = txtCodigo.getText();
            Produto p = banco.buscar(codigoDigitado);

            if(p != null){
                DefaultTableModel modelo = (DefaultTableModel) tblItens.getModel();
                double qtd = 1.0;
                double totalItem = p.preco*qtd;

                modelo.addRow(new Object[]{codigoDigitado, p.nome, qtd, p.preco, totalItem});

                atualizarTotal();
                txtCodigo.setText("");
            } else{
                JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
                txtCodigo.selectAll();
            }
        });
        
        pnlCaixOpera.add(pnlInofsCaix);
        pnlCaixOpera.add(Box.createRigidArea(new Dimension(0,20)));
        pnlCaixOpera.add(pnlTotal);

        pnlAtalhos.add(teclasAtalho);
        pnlCaixOpera.add(pnlAtalhos);   

        jnlOperador.add(pnlCaixaStts, BorderLayout.NORTH);
        pnlCaixaStts.add(lblMsgSttsCaix, BorderLayout.WEST);
        pnlCaixaStts.add(btnCaixaStts, BorderLayout.EAST);
        
        pnlCentralizar.add(pnlCaixOpera, BorderLayout.EAST);
        pnlCentralizar.add(scroll, BorderLayout.CENTER); 
        jnlOperador.add(pnlCentralizar, BorderLayout.CENTER);

        configurarAtalhos(jnlOperador);
        jnlOperador.setVisible(true);
    }
    public void atualizarTotal() { 
        double soma = 0;
        DefaultTableModel modelo = (DefaultTableModel) tblItens.getModel(); 
        
        for (int i = 0; i < modelo.getRowCount(); i++) { 
            // Assume que a coluna 4 é o total do item (Qtd * Valor Unit) 
            Object valor = modelo.getValueAt(i, 4);
            soma += ((Number) valor).doubleValue();
        } 
        lblTotal.setText(String.format("R$ %.2f", soma)); 
    } 
    public void janelaGerente(){
        JFrame jnlGerente = new JFrame();
        jnlGerente.setSize(800, 600);
        jnlGerente.setLayout(new BorderLayout());
        jnlGerente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jnlGerente.setLocationRelativeTo(null);
        JTabbedPane tbdpOpcoes = new JTabbedPane();

        JPanel pnlEstoque = new JPanel();
        pnlEstoque.setLayout(new BorderLayout());
        JPanel pnlInfosEstoque = new JPanel();
        pnlInfosEstoque.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlInfosEstoque.setPreferredSize(new Dimension(0, 40));
        pnlInfosEstoque.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblBuscProd = new JLabel();
        lblBuscProd.setText("Buscar Produto: ");
        lblBuscProd.setFont(new Font("Arial", Font.BOLD, 11));
        lblBuscProd.setPreferredSize(new Dimension(100, 25));
        JTextField txtBuscProd = new JTextField();
        txtBuscProd.setPreferredSize(new Dimension(200, 20));
        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setFont(new Font("Arial", Font.BOLD, 12));
        btnFiltrar.setPreferredSize(new Dimension(75,25));
        JCheckBox chkFiltro = new JCheckBox();
        JLabel lblAplqFiltr = new JLabel("Apenas Baixo Estoque");
        lblAplqFiltr.setFont(new Font("Arial", Font.BOLD, 11));
        lblAplqFiltr.setPreferredSize(new Dimension(200,25));

        JPanel pnlTblEstoque = new JPanel(new BorderLayout());

        String[] colunas = {"ID", "Produto", "Categoria", "Estoque Atual", "Preço"};

        modeloEstoque = new DefaultTableModel(colunas,0);
        tblEstoque = new JTable(modeloEstoque);

        JScrollPane scrollEstoque = new JScrollPane(tblEstoque);

        modeloEstoque.addRow(new Object[]{1, "Arroz 5kg", "Alimentos", 50, "R$ 25,90"});
        modeloEstoque.addRow(new Object[]{2, "Feijão 1kg", "Alimentos", 30, "R$ 8,90"});
        modeloEstoque.addRow(new Object[]{3, "Oleo de soja", "Alimentos", 20, "R$ 6,20"});
        modeloEstoque.addRow(new Object[]{4, "Coca Cola 2L", "Bebidas", 10, "R$ 12,00"});
        modeloEstoque.addRow(new Object[]{5, "Energético 2L", "Bebidas", 5, "R$ 14,00"});
        modeloEstoque.addRow(new Object[]{6, "Macarrão", "Alimentos", 50, "R$ 5,40"});
        modeloEstoque.addRow(new Object[]{7, "Açucar", "Alimentos", 40, "R$ 4,70"});
        modeloEstoque.addRow(new Object[]{8, "Café", "Alimentos", 35, "R$ 18,90"});
        modeloEstoque.addRow(new Object[]{9, "Detergente 500ml", "Limpeza", 40, "R$ 7,10"});
        modeloEstoque.addRow(new Object[]{10, "Sabão em pó 4kg", "Limpeza", 10, "R$ 32,50"});
        modeloEstoque.addRow(new Object[]{11, "Desinfetante 1L", "Limpeza", 20, "R$ 22,30"});
        modeloEstoque.addRow(new Object[]{12, "Água mineral 500ml", "Bebidas", 100, "R$ 0.80"});
        modeloEstoque.addRow(new Object[]{13, "Sal", "Alimentos", 30, "R$ 2,50"});
        modeloEstoque.addRow(new Object[]{14, "Farinha", "Alimentos", 30, "R$ 3,40"});
        modeloEstoque.addRow(new Object[]{15, "Azeite", "Alimentos", 15, "R$ 19,50"});

        pnlTblEstoque.add(scrollEstoque, BorderLayout.CENTER);

        DefaultTableModel modelo = (DefaultTableModel) tblEstoque.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblEstoque.setRowSorter(sorter);

        txtBuscProd.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscProd.getText()));
            }
        });
        chkFiltro.addActionListener(e -> {
            if (chkFiltro.isSelected()){
                sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.BEFORE,EstqBaixo,3));
            } else {
                sorter.setRowFilter(null);
            }
        });
        pnlInfosEstoque.add(lblBuscProd);
        pnlInfosEstoque.add(txtBuscProd);
        pnlInfosEstoque.add(btnFiltrar);
        pnlInfosEstoque.add(chkFiltro);
        pnlInfosEstoque.add(lblAplqFiltr);
        pnlEstoque.add(pnlInfosEstoque, BorderLayout.NORTH);
        pnlEstoque.add(pnlTblEstoque);

        JPanel pnlRelatorios = new JPanel(new FlowLayout());
        JButton btnGeraPDF = new JButton("Gerar PDF de Vendas Mensal");
        btnGeraPDF.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, vlrCompr);
        });
        pnlRelatorios.add(btnGeraPDF);
        JButton btnCSV = new JButton("Exportar Estoque (CSV)");
        btnCSV.addActionListener(e -> {
            exportarCSV();
        });
        pnlRelatorios.add(btnCSV);
        
        JPanel pnlUsuarios= new JPanel();

        tbdpOpcoes.add("Estoque", pnlEstoque);
        tbdpOpcoes.add("Relatórios", pnlRelatorios);
        tbdpOpcoes.add("Usuários", pnlUsuarios);

        jnlGerente.add(tbdpOpcoes);

        jnlGerente.setVisible(true);
    }
    private double configurarAtalhos(JFrame frame){
        InputMap im = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = frame.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1");
        am.put("F1", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(modelo.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(null, "Venda Finalizada!");
                    modelo.setRowCount(0);
                    atualizarTotal();
                }
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "F2");
        am.put("F2", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                int row = tblItens.getSelectedRow();
                if (row != -1) {
                    String senha = JOptionPane.showInputDialog("Senha (admin):");
                    if ("admin".equals(senha)) {
                        modelo.removeRow(row);
                        atualizarTotal();
                    }
                }
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "F3");
        am.put("F3", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                double soma = 0;
                DefaultTableModel modelo = (DefaultTableModel) tblItens.getModel(); 
        
                for (int i = 0; i < modelo.getRowCount(); i++) { 
                    Object valor = modelo.getValueAt(i, 4);
                    soma += ((Number) valor).doubleValue();
                }
                caixVirtual = caixVirtual-soma;
                vlrCompr = soma;
                
                JOptionPane.showMessageDialog(null, "Valor em caixa: R$"+caixVirtual);
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "F5");
        am.put("F5", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        return vlrCompr;
    }
    private void exportarCSV() {
    try (java.io.FileWriter writer = new java.io.FileWriter("estoque.csv")) {
        for (int i = 0; i < tblEstoque.getColumnCount(); i++) {
            writer.write(tblEstoque.getColumnName(i) + ",");
        }
        writer.write("\n");
        
        for (int i = 0; i < tblEstoque.getRowCount(); i++) {
            for (int j = 0; j < tblEstoque.getColumnCount(); j++) {
                writer.write(tblEstoque.getValueAt(i, j).toString() + ",");
            }
            writer.write("\n");
        }
        JOptionPane.showMessageDialog(this, "Arquivo CSV gerado!");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public static void main(String args[]){
        new SistemaOperacional();
    }
}
