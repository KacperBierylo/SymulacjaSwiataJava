import java.util.Random;

public class Zolw extends Zwierze {
    Zolw(int x, int y) {
        this.setSila(2);
        this.setInicjatywa(1);
        this.setX(x);
        this.setY(y);
        this.setTyp('Z');
        this.setKolor(4, 61, 6);
        this.setNazwa("Żółw");
    }

    public void narodziny(int x, int y) {
        Zolw dziecko = new Zolw(x, y);
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
            int ruch = los.nextInt(16);
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
            } else if ((ruch > 3) && (ruch < 16)) powodzenie = true;
        }
    }

    public int odbicie(Organizm przeciwnik) {
        if (przeciwnik.getSila() < 5) {
            this.getSwiat().getKomentator().skomentujOdbicie(this, przeciwnik);
            return 1;
        } else return 0;
    }

}