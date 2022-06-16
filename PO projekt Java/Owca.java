import java.awt.Color;

public class Owca extends Zwierze {
    Owca(int x, int y) {
        this.setSila(4);
        this.setInicjatywa(4);
        this.setX(x);
        this.setY(y);
        this.setTyp('O');
        this.setKolor(Color.WHITE);
        this.setNazwa("Owca");
        this.setNiesmiertelnosc(0);
        this.setCzasOdnowieniaNiesmiertelnosci(0);
    }

    public void narodziny(int x, int y) {
        Owca dziecko = new Owca(x, y);
        this.getSwiat().getKomentator().skomentujNarodziny(dziecko, x, y);
        this.getSwiat().dodajOrganizm(dziecko);
    }
}