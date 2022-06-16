import java.util.Random;

public class BarszczSosnowskiego extends Roslina {
    BarszczSosnowskiego(int a, int b) {
        this.setX(a);
        this.setY(b);
        this.setSila(10);
        this.setInicjatywa(0);
        this.setTyp('B');
        this.setNiesmiertelnosc(0);
        this.setCzasOdnowieniaNiesmiertelnosci(0);
        this.setKolor(151, 179, 143);
        this.setNazwa("Barszcz Sosnowskiego");
    }

    public void rozsiew(int x, int y) {
        BarszczSosnowskiego dziecko = new BarszczSosnowskiego(x, y);
        this.getSwiat().getKomentator().skomentujRozsiew(dziecko, x, y);
        this.getSwiat().dodajOrganizm(dziecko);
    }

    public int obrona(Organizm atakujacy) {
        if (atakujacy.odpornoscNaBarszcz() == false) {
            atakujacy.smierc(this.getX(), this.getY());
            return 1;
        } else return 0;
    }

    public void akcja() {
        boolean powodzenie = false;
        int x = this.getX();
        int y = this.getY();
        int szerokoscSwiata = this.getSwiat().getSzerokosc();
        int wysokoscSwiata = this.getSwiat().getWysokosc();
        int a = 1, b = 1, c = 1, d = 1;    //zmienne przechowujace informacje o stanie sasiednich pol
        int indeksOrganizmuPoPrawej = this.getSwiat().szukajPoPozycji(x + 1, y);
        int indeksOrganizmuPoLewej = this.getSwiat().szukajPoPozycji(x - 1, y);
        int indeksOrganizmuPonizej = this.getSwiat().szukajPoPozycji(x, y + 1);
        int indeksOrganizmuPowyzej = this.getSwiat().szukajPoPozycji(x, y - 1);
        //jezeli barszcz wykreje zwierze z nim sasiadujace, to go zabije
        if (indeksOrganizmuPoPrawej != -1) {
            Organizm ofiara = this.getSwiat().szukajPoIndeksie(indeksOrganizmuPoPrawej);
            if ((ofiara.getKrolestwo() == 'z') && (ofiara.odpornoscNaBarszcz() == false)) {
                this.getSwiat().getKomentator().skomentujSmiercPrzezRoslineZabijajacaDookola(this, ofiara);
                ofiara.smierc(x + 1, y);
            }
        }
        if (indeksOrganizmuPoLewej != -1) {
            Organizm ofiara = this.getSwiat().szukajPoIndeksie(indeksOrganizmuPoLewej);
            if ((ofiara.getKrolestwo() == 'z') && (ofiara.odpornoscNaBarszcz() == false)) {
                this.getSwiat().getKomentator().skomentujSmiercPrzezRoslineZabijajacaDookola(this, ofiara);
                ofiara.smierc(x - 1, y);
            }
        }
        if (indeksOrganizmuPonizej != -1) {
            Organizm ofiara = this.getSwiat().szukajPoIndeksie(indeksOrganizmuPonizej);
            if ((ofiara.getKrolestwo() == 'z') && (ofiara.odpornoscNaBarszcz() == false)) {
                this.getSwiat().getKomentator().skomentujSmiercPrzezRoslineZabijajacaDookola(this, ofiara);
                ofiara.smierc(x, y + 1);
            }
        }
        if (indeksOrganizmuPowyzej != -1) {
            Organizm ofiara = this.getSwiat().szukajPoIndeksie(indeksOrganizmuPowyzej);
            if ((ofiara.getKrolestwo() == 'z') && (ofiara.odpornoscNaBarszcz() == false)) {
                this.getSwiat().getKomentator().skomentujSmiercPrzezRoslineZabijajacaDookola(this, ofiara);
                ofiara.smierc(x, y - 1);
            }
        }
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
}