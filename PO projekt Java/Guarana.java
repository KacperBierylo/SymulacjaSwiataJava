import java.awt.Color;

public class Guarana extends Roslina {
    Guarana(int a, int b) {
        this.setX(a);
        this.setY(b);
        this.setSila(0);
        this.setInicjatywa(0);
        this.setTyp('G');
        this.setNiesmiertelnosc(0);
        this.setCzasOdnowieniaNiesmiertelnosci(0);
        this.setKolor(Color.RED);
        this.setNazwa("Guarana");
    }

    public void rozsiew(int x, int y) {
        Guarana dziecko = new Guarana(x, y);
        this.getSwiat().getKomentator().skomentujRozsiew(dziecko, x, y);
        this.getSwiat().dodajOrganizm(dziecko);
    }

    public int obrona(Organizm atakujacy) {
        int silaAtakujacego = atakujacy.getSila();
        int nowaSila = silaAtakujacego + 3;
        this.getSwiat().getKomentator().skomentujZwiekszenieSily(this, atakujacy, 3);
        atakujacy.setSila(nowaSila);
        return 0;
    }
}