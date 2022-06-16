
//import javax.swing.*;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Menu extends JPanel implements ActionListener {

    Swiat swiat;
    JButton bNastepnaTura;
    JButton bZapisz;
    JButton bWczytaj;
    JButton bLogi;
    Okno okno;

    Menu(Swiat tswiat, Okno tokno) {
        this.setLayout(new GridLayout(1, 1, 0, 0));
        this.setLayout(null);
        okno = tokno;
        swiat = tswiat;
        bNastepnaTura = new JButton("Nastepna tura");
        bNastepnaTura.setLocation(0, 0);
        bNastepnaTura.setBounds(0, 0, 125, 20);
        bNastepnaTura.addActionListener(this);
        bZapisz = new JButton("Zapisz stan gry");
        bZapisz.setLocation(130, 0);
        bZapisz.setBounds(125, 0, 125, 20);
        bZapisz.addActionListener(this);
        bWczytaj = new JButton("Wczytaj gre");
        bWczytaj.setLocation(125, 20);
        bWczytaj.setBounds(125, 20, 125, 20);
        bWczytaj.addActionListener(this);
        bLogi = new JButton("Logi");
        bLogi.setLocation(0, 20);
        bLogi.setBounds(0, 20, 125, 20);
        bLogi.addActionListener(this);
        add(bLogi);
        add(bZapisz);
        add(bNastepnaTura);
        add(bWczytaj);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();

        if (zrodlo == bNastepnaTura) {
            swiat.wykonajTure();
            okno.repaint();
            bNastepnaTura.setFocusable(false);
            bZapisz.setFocusable(false);
            bWczytaj.setFocusable(false);
            bLogi.setFocusable(false);
        } else if (zrodlo == bZapisz) {
            swiat.zapisSwiata();
            bNastepnaTura.setFocusable(false);
            bZapisz.setFocusable(false);
            bWczytaj.setFocusable(false);
            bLogi.setFocusable(false);
        } else if (zrodlo == bWczytaj) {
            swiat.wczytanieSwiata();
            okno.repaint();
            bNastepnaTura.setFocusable(false);
            bZapisz.setFocusable(false);
            bWczytaj.setFocusable(false);
            bLogi.setFocusable(false);
        } else if (zrodlo == bLogi) {
            JFrame logiOkno = new JFrame("Logi");
            JTextArea log = new JTextArea(swiat.getLog(), 800, 50);
            JScrollPane scroll = new JScrollPane(log);
            scroll.setVisible(true);
            log.setEditable(false);
            log.setLineWrap(true);
            logiOkno.getContentPane().add(scroll, BorderLayout.WEST);
            logiOkno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            logiOkno.setSize(520, 520);
            logiOkno.setVisible(true);
            bNastepnaTura.setFocusable(false);
            bZapisz.setFocusable(false);
            bWczytaj.setFocusable(false);
            bLogi.setFocusable(false);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Czlowiek(-1, -1).getKolor());
        g.fillRect(20, 50, 20, 20);
        g.setColor(new CyberOwca(-1, -1).getKolor());
        g.fillRect(20, 80, 20, 20);
        g.setColor(new Antylopa(-1, -1).getKolor());
        g.fillRect(20, 110, 20, 20);
        g.setColor(new Lis(-1, -1).getKolor());
        g.fillRect(20, 140, 20, 20);
        g.setColor(new Owca(-1, -1).getKolor());
        g.fillRect(20, 170, 20, 20);
        g.setColor(new Wilk(-1, -1).getKolor());
        g.fillRect(20, 200, 20, 20);
        g.setColor(new Zolw(-1, -1).getKolor());
        g.fillRect(20, 230, 20, 20);
        g.setColor(new BarszczSosnowskiego(-1, -1).getKolor());
        g.fillRect(20, 260, 20, 20);
        g.setColor(new Guarana(-1, -1).getKolor());
        g.fillRect(20, 290, 20, 20);
        g.setColor(new Mlecz(-1, -1).getKolor());
        g.fillRect(20, 320, 20, 20);
        g.setColor(new Trawa(-1, -1).getKolor());
        g.fillRect(20, 350, 20, 20);
        g.setColor(new WilczeJagody(-1, -1).getKolor());
        g.fillRect(20, 380, 20, 20);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        g.drawString("Czlowiek", 45, 60);
        g.drawString("Cyber Owca", 45, 90);
        g.drawString("Antylopa", 45, 120);
        g.drawString("Lis", 45, 150);
        g.drawString("Owca", 45, 180);
        g.drawString("Wilk", 45, 210);
        g.drawString("Zolw", 45, 240);
        g.drawString("Barszcz Sosnowskiego", 45, 280);
        g.drawString("Guarana", 45, 310);
        g.drawString("Mlecz", 45, 340);
        g.drawString("Trawa", 45, 370);
        g.drawString("Wilcze Jagody", 45, 400);
    }
}


