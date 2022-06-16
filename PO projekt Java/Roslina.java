import java.util.Random;

public abstract class Roslina extends Organizm {

    public void akcja() {
        boolean powodzenie = false;
        int x = this.getX();
        int y = this.getY();
        int szerokoscSwiata = this.getSwiat().getSzerokosc();
        int wysokoscSwiata = this.getSwiat().getWysokosc();
        int a = 1, b = 1, c = 1, d = 1;
        while (powodzenie == false) {
            Random los = new Random();
            int pole = los.nextInt(32);
            if ((pole == 0) && (x < szerokoscSwiata - 1)) {
                a = 0;
                int czyKolizja = this.getSwiat().szukajPoPozycji(x + 1, y);
                if (czyKolizja == -1) {
                    rozsiew(x + 1, y);
                    powodzenie = true;
                } else a = 1;
            } else if ((pole == 1) && (x > 0)) {
                b = 0;
                int czyKolizja = this.getSwiat().szukajPoPozycji(x - 1, y);
                if (czyKolizja == -1) {
                    rozsiew(x - 1, y);
                    powodzenie = true;
                } else b = 1;
            } else if ((pole == 2) && (y > 0)) {
                c = 0;
                int czyKolizja = this.getSwiat().szukajPoPozycji(x, y - 1);
                if (czyKolizja == -1) {
                    rozsiew(x, y - 1);
                    powodzenie = true;
                } else c = 1;
            } else if ((pole == 3) && (y < wysokoscSwiata - 1)) {
                d = 0;
                int czyKolizja = this.getSwiat().szukajPoPozycji(x, y + 1);
                if (czyKolizja == -1) {
                    rozsiew(x, y + 1);
                    powodzenie = true;
                } else d = 1;
            } else if ((pole > 3) && (pole < 31)) powodzenie = true;
            if (a == 1 && b == 1 && c == 1 && d == 1) powodzenie = true;
        }
    }


    public void rozsiew(int x, int y) {

    }


    public char getKrolestwo() {
        return 'r';
    }
}