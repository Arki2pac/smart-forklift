package MachineLearning;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Grzegorz on 2016-03-26.
 */
public class ZapisOdczytZPliku {
    private String sciezkaCech = "DaneCechy.txt";
    private String sciezkaPolek = "DanePolki.txt";


    public List<String> odczytZPlikuCech() throws IOException {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(sciezkaCech));
            List<String> list = new ArrayList<>();
            while((line = br.readLine()) != null){
                list.add(line);
            }
            return list;
    }
    public void zapisDoPlikuCech(double dana){
        PrintWriter plik = null;
        try {
            plik = new PrintWriter(new FileOutputStream(sciezkaCech, true));
            System.out.println("Trwa zapisywanie do pliku...");
            plik.println(dana);
            plik.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku!");
        }
    }

    public List<String> odczytZPlikuPolek() throws IOException {
        String line;
        BufferedReader br = new BufferedReader(new FileReader(sciezkaPolek));
        List<String> list = new ArrayList<>();
        while((line = br.readLine()) != null){
            list.add(line);
        }
        return list;
    }
    public void zapisDoPlikuPolek(double dana){
        PrintWriter plik = null;
        try {
            plik = new PrintWriter(new FileOutputStream(sciezkaPolek, true));
            System.out.println("Trwa zapisywanie do pliku...");
            plik.println(dana);
            plik.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku!");
        }
    }
}
