public class Wilk extends Zwierze {

    Wilk(int x, int y) {
        this.setSila(9);
        this.setInicjatywa(5);
        this.setX(x);
        this.setY(y);
        this.setTyp('W');
        this.setKolor(172, 172, 172);
        this.setNazwa("Wilk");
        this.setNiesmiertelnosc(0);
        this.setCzasOdnowieniaNiesmiertelnosci(0);
    }

    public void narodziny(int x, int y) {
        Wilk dziecko = new Wilk(x, y);
        this.getSwiat().getKomentator().skomentujNarodziny(dziecko, x, y);
        this.getSwiat().dodajOrganizm(dziecko);
    }
}