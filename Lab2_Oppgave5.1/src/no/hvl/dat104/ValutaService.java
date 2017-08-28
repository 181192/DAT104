package no.hvl.dat104;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ValutaService {
    private static Valuta valuta;
    private static ArrayList<Valuta> tab;

    public static ArrayList<Valuta> lesFraFil(String fileName) {
        tab = new ArrayList<>();
        try (BufferedReader tekstLeser = new BufferedReader(new FileReader(fileName))){
            String linje = tekstLeser.readLine();
            while (linje != null) {
                String[] par = linje.split(";");
                valuta = new Valuta(par[0],par[1]);
                tab.add(valuta);

                linje = tekstLeser.readLine();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return tab;
    }
}
