import javax.swing.JOptionPane;

public class Czlowiek extends Zwierze {
    Czlowiek(int x, int y) {
        this.setSila(5);
        this.setInicjatywa(4);
        this.setX(x);
        this.setY(y);
        this.setTyp('C');
        this.setKolor(255, 229, 180);
        this.setNazwa("Człowiek");
        this.setNiesmiertelnosc(0);
        this.setCzasOdnowieniaNiesmiertelnosci(0);
    }

    public void akcja(char ruch) {
        int stanNiesmiertelnosci = this.getNiesmiertelnosc();
        int czasOdnowienia = this.getCzasOdnowieniaNiesmiertelnosci();

        if (getCzasOdnowieniaNiesmiertelnosci() > 0) {
            this.setCzasOdnowieniaNiesmiertelnosci(czasOdnowienia - 1);
        }
        if (stanNiesmiertelnosci > 0) {
            this.setKolor(255, 215, 0);
            this.setNiesmiertelnosc(stanNiesmiertelnosci - 1);
        }
        if (this.getNiesmiertelnosc() <= 1) this.setKolor(255, 229, 180);
        if (this.getSwiat().getWlaczNiesmiertelnosc() == 1) {

            if (this.getCzasOdnowieniaNiesmiertelnosci() == 0) {
                JOptionPane.showMessageDialog(null, "W tej turze została aktywowana nieśmiertelność!");
                this.setKolor(255, 215, 0);
                this.setNiesmiertelnosc(5);
                this.setCzasOdnowieniaNiesmiertelnosci(10);
                this.getSwiat().setWlaczNiesmiertelnosc(0);
            } else {
                JOptionPane.showMessageDialog(null, "Pozostało " + (czasOdnowienia - 1) + " tur czasu odnowienia!");
                this.getSwiat().setWlaczNiesmiertelnosc(0);
            }
        }
        int x = this.getX();
        int y = this.getY();
        int szerokoscSwaita = this.getSwiat().getSzerokosc();
        int wysokoscSwiata = this.getSwiat().getWysokosc();
        if ((ruch == 'd') && (x < szerokoscSwaita - 1)) {
            int czyKolizja = this.getSwiat().szukajPoPozycji(x + 1, y);
            this.getSwiat().getKomentator().skomentujRuch(this, x, y, x + 1, y);
            if (czyKolizja == -1) {
                this.setX(x + 1);
            } else {
                kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x + 1, y);
            }
        } else if ((ruch == 'a') && (x > 0)) {
            int czyKolizja = this.getSwiat().szukajPoPozycji(x - 1, y);
            this.getSwiat().getKomentator().skomentujRuch(this, x, y, x - 1, y);
            if (czyKolizja == -1) {
                this.setX(x - 1);
            } else {
                kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x - 1, y);
            }
        } else if ((ruch == 'w') && (y > 0)) {
            int czyKolizja = this.getSwiat().szukajPoPozycji(x, y - 1);
            this.getSwiat().getKomentator().skomentujRuch(this, x, y, x, y - 1);
            if (czyKolizja == -1) {
                this.setY(y - 1);
            } else {
                kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x, y - 1);
            }
        } else if ((ruch == 's') && (y < wysokoscSwiata - 1)) {
            int czyKolizja = this.getSwiat().szukajPoPozycji(x, y + 1);
            this.getSwiat().getKomentator().skomentujRuch(this, x, y, x, y + 1);
            if (czyKolizja == -1) {
                this.setY(y + 1);
            } else {
                kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x, y + 1);
            }
        }
    }
}

