public class Komentator {

    private Swiat swiat;

    Komentator(Swiat s) {
        this.swiat = s;
    }

    public void skomentujRuch(Organizm organizm, int x0, int y0, int x, int y) {
        swiat.dodajDoLogow(organizm.getNazwa() + " próbuje poruszyć się z pola " + x0 + " " + y0 + " na pole " + x + " " + y);
    }

    public void skomentujNarodziny(Organizm nowyOrganizm, int x, int y) {
        swiat.dodajDoLogow(nowyOrganizm.getNazwa() + " " + "urodził się na polu " + x + " " + y);
    }

    public void skomentujRozsiew(Organizm roslina, int x, int y) {
        swiat.dodajDoLogow(roslina.getNazwa() + " rozsiewa się na pole " + x + " " + y);
    }

    public void skomentujWalke(Organizm wygrany, Organizm przegrany) {
        swiat.dodajDoLogow("Wygrał " + wygrany.getNazwa() + ", przegrał " + przegrany.getNazwa());
    }

    public void skomentujUcieczke(Organizm broniacy, int x, int y) {
        swiat.dodajDoLogow(broniacy.getNazwa() + " uciekł na pole " + x + " " + y);
    }

    public void skomentujOdbicie(Organizm broniacy, Organizm atakujacy) {
        swiat.dodajDoLogow(broniacy.getNazwa() + " odbił atak " + atakujacy.getNazwa());
    }

    public void skomentujZauwazenieSilniejszegoPrzeciwnika(Organizm broniacy, int x, int y) {
        swiat.dodajDoLogow(broniacy.getNazwa() + " zauwazyl silniejszego przeciwnika na polu " + x + " " + y);
    }

    public void skomentujSmiercPrzezRoslineZabijajacaDookola(Organizm roslina, Organizm zabity) {
        swiat.dodajDoLogow(roslina.getNazwa() + " zabija " + zabity.getNazwa());
    }

    public void skomentujZwiekszenieSily(Organizm zwiekszajacy, Organizm beneficjent, int wartosc) {
        swiat.dodajDoLogow(zwiekszajacy.getNazwa() + " zwiększył siłę " + beneficjent.getNazwa() + " o " + wartosc);
    }

    public void skomentujUniknniecieSmierciPoprzezNiesmiertelnosc(Organizm unikajacySmierci) {
        swiat.dodajDoLogow(unikajacySmierci.getNazwa() + " uniknął śmierci, dzięki swojej nieśmiertelności");
    }

    public void skomentujDodanieOrganizmu(Organizm dodany) {
        swiat.dodajDoLogow("Organizm " + dodany.getNazwa() + " został dodany do świata gry");
    }
}