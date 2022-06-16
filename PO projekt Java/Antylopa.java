import java.util.Random;

public class Antylopa extends Zwierze {
    Antylopa(int x, int y) {
        this.setSila(4);
        this.setInicjatywa(4);
        this.setX(x);
        this.setY(y);
        this.setTyp('A');
        this.setKolor(104, 67, 12);
        this.setNazwa("Antylopa");
    }

    public void narodziny(int x, int y) {
        Antylopa dziecko = new Antylopa(x, y);
        this.getSwiat().getKomentator().skomentujNarodziny(dziecko, x, y);
        this.getSwiat().dodajOrganizm(dziecko);
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
            if ((ruch == 0) && (x < szerokoscSwiata - 2)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x + 2, y);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x + 2, y);
                if (czyKolizja == -1) {
                    this.setX(x + 2);
                    powodzenie = true;
                } else {
                    kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x + 2, y);
                    powodzenie = true;
                }
            } else if ((ruch == 1) && (x > 1)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x - 2, y);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x - 2, y);
                if (czyKolizja == -1) {
                    this.setX(x - 2);
                    powodzenie = true;
                } else {
                    kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x - 2, y);
                    powodzenie = true;
                }
            } else if ((ruch == 2) && (y > 1)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x, y - 2);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x, y - 2);
                if (czyKolizja == -1) {
                    this.setY(y - 2);
                    powodzenie = true;
                } else {
                    kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x, y - 2);
                    powodzenie = true;
                }
            } else if ((ruch == 3) && (y < wysokoscSwiata - 2)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x, y + 2);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x, y + 2);
                if (czyKolizja == -1) {
                    this.setY(y + 2);
                    powodzenie = true;
                } else {
                    kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x, y + 2);
                    powodzenie = true;
                }
            }
        }
    }

    public int ucieczka() {
        int szerokoscSwiata = this.getSwiat().getSzerokosc();
        int wysokoscSwiata = this.getSwiat().getWysokosc();
        Random los = new Random();
        int rezultat = los.nextInt(2);
        if (rezultat == 0) return 0;
        else {
            int x = this.getX();
            int y = this.getY();
            if ((this.getSwiat().szukajPoPozycji(x + 1, y) == -1) && (x + 1 < szerokoscSwiata)) {
                this.getSwiat().getKomentator().skomentujUcieczke(this, x + 1, y);
                this.setX(x + 1);
            } else if ((this.getSwiat().szukajPoPozycji(x - 1, y) == -1) && (x - 1 >= 0)) {
                this.getSwiat().getKomentator().skomentujUcieczke(this, x - 1, y);
                this.setX(x - 1);
            } else if ((this.getSwiat().szukajPoPozycji(x, y + 1) == -1) && (y + 1 < wysokoscSwiata)) {
                this.getSwiat().getKomentator().skomentujUcieczke(this, x, y + 1);
                this.setY(y + 1);
            } else if ((this.getSwiat().szukajPoPozycji(x, y - 1) == -1) && (x + 1 < szerokoscSwiata) && (y - 1 >= 0)) {
                this.getSwiat().getKomentator().skomentujUcieczke(this, x, y - 1);
                this.setY(y - 1);
            } else {
                return 0;
            }
            return 1;
        }
    }

}