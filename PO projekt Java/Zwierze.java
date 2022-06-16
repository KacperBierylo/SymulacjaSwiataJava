import java.util.Random;

public abstract class Zwierze extends Organizm {

    public char getKrolestwo() {
        return 'z';
    }

    public void akcja() {
        boolean powodzenie = false;

        int x = this.getX();
        int y = this.getY();
        int szerokoscSwiata = this.getSwiat().getSzerokosc();
        int wysokoscSwiata = this.getSwiat().getWysokosc();
        while (powodzenie == false) {
            Random los = new Random();
            int ruch = los.nextInt(4);
            if ((ruch == 0) && (x < szerokoscSwiata - 1)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x + 1, y);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x + 1, y);
                if (czyKolizja == -1) {
                    this.setX(x + 1);
                    powodzenie = true;
                } else {
                    kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x + 1, y);
                    powodzenie = true;
                }
            } else if ((ruch == 1) && (x > 0)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x - 1, y);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x - 1, y);
                if (czyKolizja == -1) {
                    this.setX(x - 1);
                    powodzenie = true;
                } else {
                    kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x - 1, y);
                    powodzenie = true;
                }
            } else if ((ruch == 2) && (y > 0)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x, y - 1);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x, y - 1);
                if (czyKolizja == -1) {
                    this.setY(y - 1);
                    powodzenie = true;
                } else {
                    kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x, y - 1);
                    powodzenie = true;
                }
            } else if ((ruch == 3) && (y < wysokoscSwiata - 1)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x, y + 1);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x, y + 1);
                if (czyKolizja == -1) {
                    this.setY(y + 1);
                    powodzenie = true;
                } else {
                    kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x, y + 1);
                    powodzenie = true;
                }
            }

        }

    }

    public void kolizja(Organizm przeciwnik, int newX, int newY) {
        if (przeciwnik.odbicie(this) == 1) return;
        if (przeciwnik.ucieczka() == 1) {
            this.setX(newX);
            this.setY(newY);
            return;
        }
        if (przeciwnik.obrona(this) == 1) return;
        if (this.getTyp() != przeciwnik.getTyp()) {
            int sila = this.getSila();
            int silaPrzeciwnika = przeciwnik.getSila();
            if (sila >= silaPrzeciwnika) {
                this.getSwiat().getKomentator().skomentujWalke(this, przeciwnik);
                przeciwnik.smierc(newX, newY);
                this.setX(newX);
                this.setY(newY);
            } else if (silaPrzeciwnika > sila) {
                this.getSwiat().getKomentator().skomentujWalke(przeciwnik, this);
                this.smierc(newX, newY);
            }
        } else {
            int xPrzeciwnika = przeciwnik.getX();
            int yPrzeciwnika = przeciwnik.getY();
            int wysokoscSwiata = this.getSwiat().getWysokosc();
            int szerokoscSwiata = this.getSwiat().getSzerokosc();
            if ((this.getSwiat().szukajPoPozycji(xPrzeciwnika + 1, yPrzeciwnika) == -1) && (xPrzeciwnika < szerokoscSwiata - 1))
                narodziny(xPrzeciwnika + 1, yPrzeciwnika);
            else if ((this.getSwiat().szukajPoPozycji(xPrzeciwnika - 1, yPrzeciwnika) == -1) && (xPrzeciwnika > 0))
                narodziny(xPrzeciwnika - 1, yPrzeciwnika);
            else if ((this.getSwiat().szukajPoPozycji(xPrzeciwnika, yPrzeciwnika + 1) == -1) && (yPrzeciwnika < wysokoscSwiata - 1))
                narodziny(xPrzeciwnika, yPrzeciwnika + 1);
            else if ((this.getSwiat().szukajPoPozycji(xPrzeciwnika, yPrzeciwnika - 1) == -1) && (yPrzeciwnika > 0))
                narodziny(xPrzeciwnika, yPrzeciwnika - 1);
        }
    }

}