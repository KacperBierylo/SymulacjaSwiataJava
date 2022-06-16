import java.awt.Color;
import java.util.Random;

public abstract class Organizm {
    private int sila;
    private int inicjatywa;
    private Color kolor;
    Swiat swiat;
    private int x;
    private int y;
    private char typ;
    private int niesmiertelnosc;
    private int czasOdnowieniaNiesmiertelnosci;
    private String nazwa;

    public int getSila() {
        return this.sila;
    }

    public void setSila(int nowaSila) {
        this.sila = nowaSila;
    }

    public void setNazwa(String n) {
        this.nazwa = n;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public Color getKolor() {
        return this.kolor;
    }

    public void setKolor(Color k) {
        this.kolor = k;
    }

    public void setKolor(int r, int g, int b) {
        Color c = new Color(r, g, b);
        this.kolor = c;
    }

    public int getInicjatywa() {
        return this.inicjatywa;
    }

    public void setInicjatywa(int nowaInicjatywa) {
        this.inicjatywa = nowaInicjatywa;
    }

    Swiat getSwiat() {
        return swiat;
    }

    void setSwiat(Swiat nowySwiat) {
        this.swiat = nowySwiat;
    }


    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getTyp() {
        return typ;
    }

    public void setTyp(char t) {
        this.typ = t;
    }

    public void akcja() {

    }

    public void akcja(char ruch) {

    }

    public void kolizja(Organizm przeciwnik, int x, int y) {

    }

    public void rysowanie() {

    }

    public char getKrolestwo() {
        return 'o';
    }

    public int getNiesmiertelnosc() {
        return this.niesmiertelnosc;
    }

    public void setNiesmiertelnosc(int n) {
        this.niesmiertelnosc = n;
    }

    public int getCzasOdnowieniaNiesmiertelnosci() {
        return this.czasOdnowieniaNiesmiertelnosci;
    }

    public void setCzasOdnowieniaNiesmiertelnosci(int n) {
        this.czasOdnowieniaNiesmiertelnosci = n;
    }

    void smierc() {
        if (this.getNiesmiertelnosc() > 0) {
            return;
        }
        this.getSwiat().usunOrganizm(this);
    }

    void smierc(int x, int y) {
        if (this.getNiesmiertelnosc() > 0) {
            this.getSwiat().getKomentator().skomentujUniknniecieSmierciPoprzezNiesmiertelnosc(this);
            boolean powodzenie = false;
            int d = 0, a = 0, s = 0, w = 0;
            if (x + 1 < this.getSwiat().getSzerokosc()) {
                if (this.getSwiat().szukajPoPozycji(x + 1, y) == -1) d = 1;
            }
            if (x - 1 > 0) {
                if (this.getSwiat().szukajPoPozycji(x - 1, y) == -1) a = 1;
            }
            if (y + 1 < this.getSwiat().getWysokosc()) {
                if (this.getSwiat().szukajPoPozycji(x, y + 1) == -1) s = 1;
            }
            if (y - 1 > 0) {
                if (this.getSwiat().szukajPoPozycji(x, y - 1) == -1) w = 1;
            }
            if ((d == 0) && (a == 0) && (s == 0) && (w == 0)) return;
            while (powodzenie == false) {
                Random los = new Random();
                int pole = los.nextInt(4);
                if ((pole == 0) && (d == 1)) {
                    this.setX(x + 1);
                    this.setY(y);
                    powodzenie = true;
                } else if ((pole == 1) && (a == 1)) {
                    this.setX(x - 1);
                    this.setY(y);
                    powodzenie = true;
                } else if ((pole == 2) && (s == 1)) {
                    this.setX(x);
                    this.setY(y + 1);
                    powodzenie = true;
                } else if ((pole == 3) && (w == 1)) {
                    this.setX(x);
                    this.setY(y - 1);
                    powodzenie = true;
                }
            }
            return;
        }

        this.getSwiat().usunOrganizm(this);
    }

    void narodziny(int x, int y) {

    }

    int odbicie(Organizm przeciwnik) {
        return 0;
    }

    int ucieczka() {
        return 0;
    }

    public boolean odpornoscNaBarszcz() {
        return false;
    }

    int obrona(Organizm atakujacy) {
        return 0;
    }
}

