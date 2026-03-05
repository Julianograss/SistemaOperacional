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
        //pnlCentralizar.setBorder(BorderFactory.createEmptyBorder(175, 200, 100, 200));
        pnlCentralizar.setBackground(Color.GRAY);
        pnlCentralizar.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));

        JPanel pnlPainelLogin = new JPanel(new GridLayout(2,2, 10,50));
        pnlPainelLogin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pnlPainelLogin.setMaximumSize(new Dimension(300, 150));
        pnlPainelLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlPainelLogin.setAlignmentY(Component.CENTER_ALIGNMENT);
        //pnlPainelLogin.setBackground(Color.BLACK);

        JLabel lblLogMsg = new JLabel("Login", SwingConstants.CENTER);
        lblLogMsg.setFont(new Font("Arial", Font.BOLD, 21));
        lblLogMsg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        pnlPainelLogin.add(lblUsuario);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 10));
        pnlPainelLogin.add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha: ");
        lblSenha.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPainelLogin.add(lblSenha);

        pnlPainelLogin.add(lblLogMsg, BorderLayout.NORTH);
        pnlCentralizar.add(Box.createRigidArea(new Dimension(0, 10)));
        pnlCentralizar.add(pnlPainelLogin);
        pnlCentralizar.add(Box.createRigidArea(new Dimension(0, 20)));
        pnlCentralizar.add(btnEntrar);
        
        add(pnlCentralizar);
        setVisible(true);
    }
    public static void main(String args[]){
        new SistemaOperacional();
    }
}