import java.awt.Color;
import java.lang.Math;

public class CyberOwca extends Zwierze {
    CyberOwca(int x, int y) {
        this.setSila(11);
        this.setInicjatywa(4);
        this.setX(x);
        this.setY(y);
        this.setTyp('S');
        this.setKolor(Color.PINK);
        this.setNazwa("Cyber Owca");
        this.setNiesmiertelnosc(0);
        this.setCzasOdnowieniaNiesmiertelnosci(0);
    }

    public void narodziny(int x, int y) {
        CyberOwca dziecko = new CyberOwca(x, y);
        this.getSwiat().getKomentator().skomentujNarodziny(dziecko, x, y);
        this.getSwiat().dodajOrganizm(dziecko);
    }


    public void akcja() {
        int wysokoscSwiata = this.getSwiat().getWysokosc();
        int szerokoscSwiata = this.getSwiat().getSzerokosc();
        Organizm organizm;
        Organizm barszcz;
        double odleglosc = wysokoscSwiata + szerokoscSwiata;
        double odlegloscBarszczu;
        int xB = -1;
        int yB = -1;
        int xBtemp = -1;
        int yBtemp = -1;
        for (int i = 0; i < szerokoscSwiata; i++) {

            for (int j = 0; j < wysokoscSwiata; j++) {
                int indeksOrganizmu = this.getSwiat().szukajPoPozycji(i, j);
                if (indeksOrganizmu != -1) {
                    organizm = this.getSwiat().szukajPoIndeksie(indeksOrganizmu);
                    if (organizm.getTyp() == 'B') {
                        barszcz = this.getSwiat().szukajPoIndeksie(indeksOrganizmu);
                        xBtemp = barszcz.getX();
                        yBtemp = barszcz.getY();
                        odlegloscBarszczu = Math.sqrt((this.getX() - xBtemp) * (this.getX() - xBtemp) + (this.getY() - yBtemp) * (this.getY() - yBtemp));
                        if (odlegloscBarszczu <= odleglosc) {
                            xB = xBtemp;
                            yB = yBtemp;
                            odleglosc = odlegloscBarszczu;
                        }
                    }
                }
            }
        }
        if (odleglosc != wysokoscSwiata + szerokoscSwiata) {
            int xCyberOwcy = this.getX();
            int yCyberOwcy = this.getY();
            int roznicaX = Math.abs(xCyberOwcy - xB);
            int roznicaY = Math.abs(yCyberOwcy - yB);
            if (roznicaX >= roznicaY) {
                if (xCyberOwcy > xB) {
                    int czyKolizja = this.getSwiat().szukajPoPozycji(xCyberOwcy - 1, yCyberOwcy);
                    this.getSwiat().getKomentator().skomentujRuch(this, xCyberOwcy, yCyberOwcy, xCyberOwcy - 1, yCyberOwcy);
                    if (czyKolizja == -1) {
                        this.setX(xCyberOwcy - 1);
                    } else {
                        kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), xCyberOwcy - 1, yCyberOwcy);
                    }
                } else if (xCyberOwcy < xB) {
                    int czyKolizja = this.getSwiat().szukajPoPozycji(xCyberOwcy + 1, yCyberOwcy);
                    this.getSwiat().getKomentator().skomentujRuch(this, xCyberOwcy, yCyberOwcy, xCyberOwcy - 1, yCyberOwcy);
                    if (czyKolizja == -1) {
                        this.setX(xCyberOwcy + 1);
                    } else {
                        kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), xCyberOwcy + 1, yCyberOwcy);
                    }
                }

            } else {
                if (yCyberOwcy > yB) {
                    int czyKolizja = this.getSwiat().szukajPoPozycji(xCyberOwcy, yCyberOwcy - 1);
                    this.getSwiat().getKomentator().skomentujRuch(this, xCyberOwcy, yCyberOwcy, xCyberOwcy, yCyberOwcy - 1);
                    if (czyKolizja == -1) {
                        this.setY(yCyberOwcy - 1);
                    } else {
                        kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), xCyberOwcy, yCyberOwcy - 1);
                    }
                } else if (yCyberOwcy < yB) {
                    int czyKolizja = this.getSwiat().szukajPoPozycji(xCyberOwcy, yCyberOwcy + 1);
                    this.getSwiat().getKomentator().skomentujRuch(this, xCyberOwcy, yCyberOwcy, xCyberOwcy, yCyberOwcy + 1);
                    if (czyKolizja == -1) {
                        this.setY(yCyberOwcy + 1);
                    } else {
                        kolizja(this.getSwiat().szukajPoIndeksie(czyKolizja), xCyberOwcy, yCyberOwcy + 1);
                    }
                }


            }

        } else super.akcja();

    }

    public boolean odpornoscNaBarszcz() {
        return true;
    }
}

