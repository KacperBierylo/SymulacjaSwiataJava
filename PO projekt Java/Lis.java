import java.awt.Color;
import java.util.Random;

public class Lis extends Zwierze {
    Lis(int x, int y) {
        this.setSila(3);
        this.setInicjatywa(7);
        this.setX(x);
        this.setY(y);
        this.setTyp('L');
        this.setKolor(Color.ORANGE);
        this.setNazwa("Lis");
        this.setNiesmiertelnosc(0);
        this.setCzasOdnowieniaNiesmiertelnosci(0);
    }

    public void akcja() {
        int a = 0, b = 0, c = 0, d = 0;    //zmienne przechowujace informacje, czy lis sprawdzil juz dane pole
        boolean powodzenie = false;
        int x = this.getX();
        int y = this.getY();
        int szerokoscSwiata = this.getSwiat().getSzerokosc();
        int wysokoscSwiata = this.getSwiat().getWysokosc();
        if (x + 1 >= wysokoscSwiata) a = 1;
        if (x - 1 < 0) b = 1;
        if (y - 1 < 0) c = 1;
        if (y + 1 >= wysokoscSwiata) d = 1;
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
                    int sila = this.getSila();
                    int SilaPrzeciwnika = this.getSwiat().szukajPoIndeksie(czyKolizja).getSila();
                    if (sila >= SilaPrzeciwnika) {
                        kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x + 1, y);
                        powodzenie = true;
                    } else {
                        this.getSwiat().getKomentator().skomentujZauwazenieSilniejszegoPrzeciwnika(this, x + 1, y);
                        a = 1;
                    }
                }
            } else if ((ruch == 1) && (x > 0)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x - 1, y);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x - 1, y);
                if (czyKolizja == -1) {
                    this.setX(x - 1);
                    powodzenie = true;
                } else {
                    int sila = this.getSila();
                    int SilaPrzeciwnika = this.getSwiat().szukajPoIndeksie(czyKolizja).getSila();
                    if (sila >= SilaPrzeciwnika) {
                        kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x - 1, y);
                        powodzenie = true;
                    } else {
                        this.getSwiat().getKomentator().skomentujZauwazenieSilniejszegoPrzeciwnika(this, x - 1, y);
                        b = 1;
                    }
                }
            } else if ((ruch == 2) && (y > 0)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x, y - 1);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x, y - 1);
                if (czyKolizja == -1) {
                    this.setY(y - 1);
                    powodzenie = true;
                } else {
                    int sila = this.getSila();
                    int SilaPrzeciwnika = this.getSwiat().szukajPoIndeksie(czyKolizja).getSila();
                    if (sila >= SilaPrzeciwnika) {
                        kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x, y - 1);
                        powodzenie = true;
                    } else {
                        c = 1;
                        this.getSwiat().getKomentator().skomentujZauwazenieSilniejszegoPrzeciwnika(this, x, y - 1);
                    }
                }
            } else if ((ruch == 3) && (y < wysokoscSwiata - 1)) {
                int czyKolizja = this.getSwiat().szukajPoPozycji(x, y + 1);
                this.getSwiat().getKomentator().skomentujRuch(this, x, y, x, y + 1);
                if (czyKolizja == -1) {
                    this.setY(y + 1);
                    powodzenie = true;
                } else {
                    int sila = this.getSila();
                    int SilaPrzeciwnika = this.getSwiat().szukajPoIndeksie(czyKolizja).getSila();
                    if (sila >= SilaPrzeciwnika) {
                        kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), x, y + 1);
                        powodzenie = true;
                    } else {
                        d = 1;
                        this.getSwiat().getKomentator().skomentujZauwazenieSilniejszegoPrzeciwnika(this, x, y + 1);
                    }
                }
            }
            if (a == 1 && b == 1 && c == 1 && d == 1) break;
        }

    }

    public void narodziny(int x, int y) {
        Lis dziecko = new Lis(x, y);
        this.getSwiat().getKomentator().skomentujNarodziny(dziecko, x, y);
        this.getSwiat().dodajOrganizm(dziecko);
    }

}