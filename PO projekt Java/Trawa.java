import java.awt.Color;

public class Trawa extends Roslina {
    Trawa(int a, int b) {
        this.setX(a);
        this.setY(b);
        this.setSila(0);
        this.setInicjatywa(0);
        this.setTyp('T');
        this.setNiesmiertelnosc(0);
        this.setCzasOdnowieniaNiesmiertelnosci(0);
        this.setKolor(Color.GREEN);
        this.setNazwa("Trawa");
    }

    public void rozsiew(int x, int y) {
        Trawa dziecko = new Trawa(x, y);
        this.getSwiat().getKomentator().skomentujRozsiew(dziecko, x, y);
        this.getSwiat().dodajOrganizm(dziecko);
    }
}