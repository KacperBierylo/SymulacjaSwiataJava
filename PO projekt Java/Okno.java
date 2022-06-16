import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Okno extends JFrame implements KeyListener {
    Swiat swiat;
    char ruch;

    int wysokosc, szerokosc, iloscOrganizmow;

    public Okno(Swiat tswiat) {
        this.setLayout(null);
        swiat = tswiat;
        wysokosc = tswiat.getWysokosc();
        szerokosc = tswiat.getSzerokosc();
        iloscOrganizmow = tswiat.getIloscOrganizmow();
        setSize(1000, 800);
        setTitle("Kacper Bieryło, 180185");
        JPanel mapa = new Mapa(swiat);
        JPanel menu = new Menu(swiat, this);
        mapa.setBounds(0, 0, szerokosc * 20, wysokosc * 20);
        menu.setBounds(szerokosc * 20, 0, 500, 700);
        add(menu);
        add(mapa);

        this.addKeyListener(this);
        setFocusable(true);
        setVisible(true);


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            swiat.setRuch('d');
            swiat.wykonajTure();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            swiat.setRuch('a');
            swiat.wykonajTure();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            swiat.setRuch('w');
            swiat.wykonajTure();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            swiat.setRuch('s');
            swiat.wykonajTure();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            swiat.setWlaczNiesmiertelnosc(1);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}