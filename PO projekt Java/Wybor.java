import javax.swing.JOptionPane;

public class Wybor {


    public char oknoWyboru() {
        String[] rodzajeOrganizmow = new String[11];
        rodzajeOrganizmow[0] = "Antylopa";
        rodzajeOrganizmow[1] = "Cyber Owca";
        rodzajeOrganizmow[2] = "Lis";
        rodzajeOrganizmow[3] = "Owca";
        rodzajeOrganizmow[4] = "Wilk";
        rodzajeOrganizmow[5] = "Zolw";
        rodzajeOrganizmow[6] = "Barszcz Sosnowskiego";
        rodzajeOrganizmow[7] = "Guarana";
        rodzajeOrganizmow[8] = "Mlecz";
        rodzajeOrganizmow[9] = "Trawa";
        rodzajeOrganizmow[10] = "Wilcze Jagody";
        char typWybranego = '0';
        Object wybranyRodzaj = JOptionPane.showInputDialog(null, "Wybierz rodzaj zwierzęcia, które zostanie dodane na wybrane pole",
                "Wybór", JOptionPane.QUESTION_MESSAGE, null, rodzajeOrganizmow, "Antylopa");
        if (wybranyRodzaj == null) return '0';
        String wybranyRodzajString = wybranyRodzaj.toString();
        if (wybranyRodzajString.equals("Antylopa")) typWybranego = 'A';
        else if (wybranyRodzajString.equals("Cyber Owca")) typWybranego = 'S';
        else if (wybranyRodzajString.equals("Lis")) typWybranego = 'L';
        else if (wybranyRodzajString.equals("Owca")) typWybranego = 'O';
        else if (wybranyRodzajString.equals("Wilk")) typWybranego = 'W';
        else if (wybranyRodzajString.equals("Zolw")) typWybranego = 'Z';
        else if (wybranyRodzajString.equals("Barszcz Sosnowskiego")) typWybranego = 'B';
        else if (wybranyRodzajString.equals("Guarana")) typWybranego = 'G';
        else if (wybranyRodzajString.equals("Mlecz")) typWybranego = 'M';
        else if (wybranyRodzajString.equals("Trawa")) typWybranego = 'T';
        else if (wybranyRodzajString.equals("Wilcze Jagody")) typWybranego = 'J';

        return typWybranego;
    }


}