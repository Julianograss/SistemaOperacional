package atividade3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SistemaOperacional extends JFrame{
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

        JButton btnEntrar = new JButton("Entrar");
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
        c.gridwidth = 0;

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

        JPanel pnlCentralizar = new JPanel();
        pnlCentralizar.setBackground(Color.GRAY);
        pnlCentralizar.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));

        JPanel pnlCaixaStts = new JPanel(new BorderLayout());
        pnlCaixaStts.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        pnlCaixaStts.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        pnlCaixaStts.setBackground(Color.BLACK);

        JLabel lblMsgSttsCaix = new JLabel("CAIXA ABERTO");
        lblMsgSttsCaix.setFont(new Font("Arial", Font.BOLD, 22));
        lblMsgSttsCaix.setForeground(new Color(57, 255, 20));


        jnlOperador.add(pnlCaixaStts, BorderLayout.NORTH);
        pnlCaixaStts.add(lblMsgSttsCaix, BorderLayout.WEST);
        jnlOperador.add(pnlCentralizar, BorderLayout.CENTER);

        jnlOperador.setVisible(true);
    }
    public static void main(String args[]){
        new SistemaOperacional();
    }
}
