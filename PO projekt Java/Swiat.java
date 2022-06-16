import javax.swing.JFrame;
import java.awt.Color;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Swiat {
    private Organizm[] organizmy;
    private Okno plansza;
    private int iterator;
    private int wysokosc;
    private int szerokosc;
    private int iloscOrganizmow;
    private int czyWlaczycNiesmiertelnosc;  //informacja o nieśmiertelności człowieka
    private String log;
    private Color kolorGruntu;
    private char ruch;  //informacja o ruchu człowieka
    private Komentator komentator;

    public Swiat(int w, int s) {
        this.iloscOrganizmow = 0;
        this.wysokosc = w;
        this.szerokosc = s;
        this.czyWlaczycNiesmiertelnosc = 0;
        this.log = "";
        organizmy = new Organizm[wysokosc * szerokosc];
        komentator = new Komentator(this);
        this.iterator = 0;    //iterator dla wyokonywania tury, jako zmienna w klasie, żeby móc zmieniać jego wartość przy dodawaniu i usuwaniu organizmów
        kolorGruntu = new Color(128, 128, 0);
    }

    public void wykonajTure() {
        log = "";
        for (iterator = 0; iterator < iloscOrganizmow; iterator++) {
            if (organizmy[iterator].getTyp() != 'C')
                organizmy[iterator].akcja();
            else {
                organizmy[iterator].akcja(ruch);
                ruch = '0';
            }
        }
    }

    public int getIloscOrganizmow() {
        return this.iloscOrganizmow;
    }

    public int getWysokosc() {
        return this.wysokosc;
    }

    public int getSzerokosc() {
        return this.szerokosc;
    }

    public char getRuch() {
        return ruch;
    }

    public void setRuch(char r) {
        ruch = r;
    }

    public Color getKolorGruntu() {
        return this.kolorGruntu;
    }

    public void setWlaczNiesmiertelnosc(int n) {
        this.czyWlaczycNiesmiertelnosc = n;
    }

    public int getWlaczNiesmiertelnosc() {
        return czyWlaczycNiesmiertelnosc;
    }

    public void dodajDoLogow(String Zdarzenie) {
        log = log + Zdarzenie + "\n";
    }

    public String getLog() {
        return log;
    }

    Komentator getKomentator() {
        return komentator;
    }

    public void odswiez() {
        plansza.repaint();
    }

    public int szukajPoPozycji(int x, int y) {
        for (int i = 0; i < iloscOrganizmow; i++) {
            if ((organizmy[i].getX() == x) && (organizmy[i].getY() == y)) {
                return i;
            }
        }
        return -1;
    }

    public Organizm szukajPoIndeksie(int i) {
        return organizmy[i];
    }

    public void dodajOrganizm(Organizm nowyOrganizm) {
        if (iloscOrganizmow == szerokosc * wysokosc)
            return;
        nowyOrganizm.setSwiat(this);
        int inicjatywa = nowyOrganizm.getInicjatywa();
        int pozycja = iloscOrganizmow;
        for (int i = 0; i < iloscOrganizmow; i++) { // organizmy sa sortowane wedlug inicjatywy przy wstawianiu do
            // tablicy
            if (organizmy[i].getInicjatywa() < inicjatywa) {
                pozycja = i;
                break;
            }
        }
        for (int i = iloscOrganizmow; i > pozycja; i--) {
            organizmy[i] = organizmy[i - 1];
        }
        organizmy[pozycja] = nowyOrganizm;
        if (pozycja <= iterator) iterator++;
        iloscOrganizmow++;
    }

    public void usunOrganizm(Organizm martwyOrganizm) {
        int indeksMartwego = -1;
        for (int i = 0; i < iloscOrganizmow; i++) {
            if (organizmy[i] == martwyOrganizm) {
                indeksMartwego = i;
                break;
            }
        }

        for (int i = indeksMartwego; i < iloscOrganizmow - 1; i++) {
            organizmy[i] = organizmy[i + 1];
        }
        organizmy[iloscOrganizmow - 1] = null;
        if (indeksMartwego <= iterator) iterator--;
        iloscOrganizmow--;
    }

    public void rysowanie() {
        plansza = new Okno(this);
        plansza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void generujSwiat() {
        Czlowiek nowyOgranizm = new Czlowiek(0, 0); // czlowiek startuje z pozycji (0, 0)
        dodajOrganizm(nowyOgranizm);
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                if ((i == 0) && (j == 0))
                    j = 1; // pominiecie pola czlowieka
                Random loss = new Random();
                int los = loss.nextInt(110); // dla kazdego pola 10% szans na pojawienie sie losowego organizmu
                if (los == 0) {
                    Antylopa nowyOrganizm = new Antylopa(j, i);
                    dodajOrganizm(nowyOrganizm);
                } else if (los == 1) {
                    BarszczSosnowskiego nowyOrganizm = new BarszczSosnowskiego(j, i);
                    dodajOrganizm(nowyOrganizm);
                } else if (los == 2) {
                    Guarana nowyOrganizm = new Guarana(j, i);
                    dodajOrganizm(nowyOrganizm);
                } else if (los == 3) {
                    Lis nowyOrganizm = new Lis(j, i);
                    dodajOrganizm(nowyOrganizm);
                } else if (los == 4) {
                    Mlecz nowyOrganizm = new Mlecz(j, i);
                    dodajOrganizm(nowyOrganizm);
                } else if (los == 5) {
                    Owca nowyOrganizm = new Owca(j, i);
                    dodajOrganizm(nowyOrganizm);
                } else if (los == 6) {
                    Trawa nowyOrganizm = new Trawa(j, i);
                    dodajOrganizm(nowyOrganizm);
                } else if (los == 7) {
                    WilczeJagody nowyOrganizm = new WilczeJagody(j, i);
                    dodajOrganizm(nowyOrganizm);
                } else if (los == 8) {
                    Wilk nowyOrganizm = new Wilk(j, i);
                    dodajOrganizm(nowyOrganizm);
                } else if (los == 9) {
                    Zolw nowyOrganizm = new Zolw(j, i);
                    dodajOrganizm(nowyOrganizm);
                } else if (los == 10) {
                    CyberOwca nowyOrganizm = new CyberOwca(j, i);
                    dodajOrganizm(nowyOrganizm);
                }

            }
        }
    }

    public void zapisSwiata() {
        File zapis = new File("zapis.txt");
        PrintWriter writer = null;
        try {
            zapis.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer = new PrintWriter("zapis.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        writer.println(wysokosc + " " + szerokosc + " " + iloscOrganizmow);
        for (int i = 0; i < iloscOrganizmow; i++) {
            writer.println((int) organizmy[i].getTyp() + " " + organizmy[i].getX() + " " + organizmy[i].getY() + " " + organizmy[i].getSila() + " " + organizmy[i].getNiesmiertelnosc() + " " + organizmy[i].getCzasOdnowieniaNiesmiertelnosci());
        }
        writer.close();
    }


    public void wczytanieSwiata() {

        File odczyt = new File("zapis.txt");
        boolean czyIstnieje = odczyt.exists();
        if (czyIstnieje == false) return;

        for (int i = 0; i < iloscOrganizmow; i++) {
            organizmy[i] = null;
        }
        iloscOrganizmow = 0;
        int zwysokosc, zszerokosc, ilosc, niesmiertelnosc, czasOdnowieniaNiesmiertelnosci;
        Scanner scnr = null;
        try {
            scnr = new Scanner(odczyt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        zwysokosc = scnr.nextInt();
        zszerokosc = scnr.nextInt();
        ilosc = scnr.nextInt();

        this.szerokosc = zszerokosc;
        this.wysokosc = zwysokosc;
        for (int i = 0; i < ilosc; i++) {
            int typ;
            int wspX, wspY, sila;
            typ = scnr.nextInt();
            wspX = scnr.nextInt();
            wspY = scnr.nextInt();
            sila = scnr.nextInt();
            niesmiertelnosc = scnr.nextInt();
            czasOdnowieniaNiesmiertelnosci = scnr.nextInt();
            if (typ == 'A') {
                Antylopa nowyOrganizm = new Antylopa(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'B') {
                BarszczSosnowskiego nowyOrganizm = new BarszczSosnowskiego(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'C') {
                Czlowiek nowyOrganizm = new Czlowiek(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'G') {
                Guarana nowyOrganizm = new Guarana(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'L') {
                Lis nowyOrganizm = new Lis(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'M') {
                Mlecz nowyOrganizm = new Mlecz(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'O') {
                Owca nowyOrganizm = new Owca(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'T') {
                Trawa nowyOrganizm = new Trawa(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'J') {
                WilczeJagody nowyOrganizm = new WilczeJagody(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'W') {
                Wilk nowyOrganizm = new Wilk(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'Z') {
                Zolw nowyOrganizm = new Zolw(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            } else if (typ == 'S') {
                CyberOwca nowyOrganizm = new CyberOwca(wspX, wspY);
                nowyOrganizm.setSila(sila);
                nowyOrganizm.setNiesmiertelnosc(niesmiertelnosc);
                nowyOrganizm.setCzasOdnowieniaNiesmiertelnosci(czasOdnowieniaNiesmiertelnosci);
                dodajOrganizm(nowyOrganizm);
            }
        }
    }
}