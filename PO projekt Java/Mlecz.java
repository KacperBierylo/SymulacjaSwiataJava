import java.util.Random;
import java.awt.Color;

public class Mlecz extends Roslina {

    Mlecz(int a, int b) {
        this.setX(a);
        this.setY(b);
        this.setSila(0);
        this.setInicjatywa(0);
        this.setTyp('M');
        this.setNiesmiertelnosc(0);
        this.setCzasOdnowieniaNiesmiertelnosci(0);
        this.setKolor(Color.yellow);
        this.setNazwa("Mlecz");
    }

    public void rozsiew(int x, int y) {
        Mlecz dziecko = new Mlecz(x, y);
        this.getSwiat().getKomentator().skomentujRozsiew(dziecko, x, y);
        this.getSwiat().dodajOrganizm(dziecko);
    }

    public void akcja() {
        int proby = 0;    //podejmuje 3 proby rozsiania sie
        boolean powodzenie = false;
        int x = this.getX();
        int y = this.getY();
        int szerokoscSwiata = this.getSwiat().getSzerokosc();
        int wysokoscSwiata = this.getSwiat().getWysokosc();
        int a = 0, b = 0, c = 0, d = 0;    //zmienne informujace czy rozsianie sie na dane pole jest mozliwe
        while (powodzenie == false) {
            Random los = new Random();
            int pole = los.nextInt(32);
            if ((pole == 0) && (x < szerokoscSwiata - 1)) {

                int czyKolizja = this.getSwiat().szukajPoPozycji(x + 1, y);
                if (czyKolizja == -1) {
                    rozsiew(x + 1, y);
                    powodzenie = true;
                } else a = 1;
            } else if ((pole == 1) && (x > 0)) {

                int czyKolizja = this.getSwiat().szukajPoPozycji(x - 1, y);
                if (czyKolizja == -1) {
                    rozsiew(x - 1, y);
                    powodzenie = true;
                } else b = 1;
            } else if ((pole == 2) && (y > 0)) {

                int czyKolizja = this.getSwiat().szukajPoPozycji(x, y - 1);
                if (czyKolizja == -1) {
                    rozsiew(x, y - 1);
                    powodzenie = true;
                } else c = 1;
            } else if ((pole == 3) && (y < wysokoscSwiata - 1)) {

                int czyKolizja = this.getSwiat().szukajPoPozycji(x, y + 1);
                if (czyKolizja == -1) {
                    rozsiew(x, y + 1);
                    powodzenie = true;
                } else d = 1;
            } else if ((pole > 3) && (pole <= 31)) {
                proby++;
            }
            if (a == 1 && b == 1 && c == 1 && d == 1) powodzenie = true;
            if (proby >= 3) powodzenie = true;
        }
    }
}