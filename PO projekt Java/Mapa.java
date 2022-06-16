import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Mapa extends JPanel implements MouseListener {
    Swiat swiat;
    char ruch;
    int wysokosc, szerokosc, iloscOrganizmow;

    public Mapa(Swiat tswiat) {
        this.setLayout(null);
        swiat = tswiat;
        wysokosc = tswiat.getWysokosc();
        szerokosc = tswiat.getSzerokosc();
        iloscOrganizmow = tswiat.getIloscOrganizmow();
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int wspX = e.getX() / 20;           //20 - rozmiar pojedynczego kwadratu
        int wspY = e.getY() / 20;
        int indeks = swiat.szukajPoPozycji(wspX, wspY);
        if (indeks != -1) {
            return;
        }
        Wybor oknoWyboruZwierzecia = new Wybor();
        char wybranyTyp = oknoWyboruZwierzecia.oknoWyboru();
        if (wybranyTyp == '0') {
            return;
        }

        if (wybranyTyp == 'A') {
            Antylopa nowyOrganizm = new Antylopa(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        } else if (wybranyTyp == 'S') {
            CyberOwca nowyOrganizm = new CyberOwca(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        } else if (wybranyTyp == 'L') {
            Lis nowyOrganizm = new Lis(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        } else if (wybranyTyp == 'O') {
            Owca nowyOrganizm = new Owca(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        } else if (wybranyTyp == 'W') {
            Wilk nowyOrganizm = new Wilk(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        } else if (wybranyTyp == 'Z') {
            Zolw nowyOrganizm = new Zolw(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        } else if (wybranyTyp == 'B') {
            BarszczSosnowskiego nowyOrganizm = new BarszczSosnowskiego(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        } else if (wybranyTyp == 'G') {
            Guarana nowyOrganizm = new Guarana(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        } else if (wybranyTyp == 'M') {
            Mlecz nowyOrganizm = new Mlecz(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        } else if (wybranyTyp == 'T') {
            Trawa nowyOrganizm = new Trawa(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        } else if (wybranyTyp == 'J') {
            WilczeJagody nowyOrganizm = new WilczeJagody(wspX, wspY);
            swiat.dodajOrganizm(nowyOrganizm);
            swiat.getKomentator().skomentujDodanieOrganizmu(nowyOrganizm);
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        iloscOrganizmow = swiat.getIloscOrganizmow();
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                boolean czyWypisano = false;
                for (int k = 0; k < iloscOrganizmow; k++) {
                    if ((swiat.szukajPoIndeksie(k).getX() == i) && (swiat.szukajPoIndeksie(k).getY() == j)) {
                        g.setColor(swiat.szukajPoIndeksie(k).getKolor());
                        g.fillRect(i * 20, j * 20, 20, 20);
                        czyWypisano = true;
                        break;
                    }
                }
                if (czyWypisano == false) {
                    Color c = swiat.getKolorGruntu();
                    g.setColor(c);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
            }
        }

    }
}