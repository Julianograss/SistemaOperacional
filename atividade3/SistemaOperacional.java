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

        JPanel pnlCentralizar = new JPanel();
        pnlCentralizar.setLayout(new BoxLayout(pnlCentralizar, BoxLayout.Y_AXIS));
        pnlCentralizar.setBackground(Color.GRAY);
        pnlCentralizar.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));

        JPanel pnlPainelLogin = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 20, 10, 20);
        pnlPainelLogin.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlPainelLogin.setMaximumSize(new Dimension(300, 150));
        pnlPainelLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlPainelLogin.setAlignmentY(Component.CENTER_ALIGNMENT);
        //pnlPainelLogin.setBackground(Color.BLACK);

        JLabel lblLogMsg = new JLabel("Login", SwingConstants.CENTER);
        lblLogMsg.setFont(new Font("Arial", Font.BOLD, 21));
        lblLogMsg.setAlignmentY(Component.TOP_ALIGNMENT);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        btnEntrar.setMaximumSize(new Dimension(150, 30));

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

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        pnlPainelLogin.add(lblLogMsg, c);
        c.gridx = 0;
        c.gridy = 1;
        pnlPainelLogin.add(lblUsuario, c);
        c.gridx = 0;
        c.gridy = 2;
        pnlPainelLogin.add(lblSenha, c);
        c.gridx = 1;
        c.gridy = 1;
        pnlPainelLogin.add(txtUsuario, c);
        c.gridx = 1;
        c.gridy = 2;
        pnlPainelLogin.add(pswSenhaUsu, c);



        pnlCentralizar.add(pnlPainelLogin);
        
        add(pnlCentralizar);
        setVisible(true);
    }
    public static void main(String args[]){
        new SistemaOperacional();
    }
}
