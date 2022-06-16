import java.awt.Color;

public class WilczeJagody extends Roslina {
    WilczeJagody(int a, int b) {
        this.setX(a);
        this.setY(b);
        this.setSila(99);
        this.setInicjatywa(0);
        this.setTyp('J');
        this.setNiesmiertelnosc(0);
        this.setCzasOdnowieniaNiesmiertelnosci(0);
        this.setKolor(Color.black);
        this.setNazwa("Wilcze Jagody");
    }

    public void rozsiew(int x, int y) {
        WilczeJagody dziecko = new WilczeJagody(x, y);
        this.getSwiat().getKomentator().skomentujRozsiew(dziecko, x, y);
        this.getSwiat().dodajOrganizm(dziecko);
    }

    public int obrona(Organizm atakujacy) {
        atakujacy.smierc(this.getX(), this.getY());
        return 1;
    }
}