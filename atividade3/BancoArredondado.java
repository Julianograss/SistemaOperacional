package atividade3;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
public class BotaoArredondado extends JButton {
    private int raio;
    public BotaoArredondado(String texto, int raio) {
        super(texto);
        this.raio = raio;
        // Remove as bordas e fundos padrão para não sobrepor o nosso desenho
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        // Muda a cor se estiver pressionado ou com o mouse sobre
        if (getModel().isArmed()) {
        g2.setColor(getBackground().darker());
        } else {
        g2.setColor(getBackground());
        }
        // Desenha o retângulo arredondado
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), raio, raio));
        // Desenha o texto por cima
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent()) / 2 - 2;
        g2.drawString(getText(), x, y);
        g2.dispose();
    }
}
