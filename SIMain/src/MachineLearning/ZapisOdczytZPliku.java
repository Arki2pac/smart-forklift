package MachineLearning;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Grzegorz on 2016-03-26.
 */
public class ZapisOdczytZPliku {
    private String sciezka = "C:\\Users\\Grzegorz\\Documents\\Projects\\smart-forklift\\SI\\Dane.txt";

    public List<String> odczytZPliku() throws IOException {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(sciezka));
            List<String> list = new ArrayList<>();
            while((line = br.readLine()) != null){
                list.add(line);
            }
            return list;
    }
    public void zapisDoPliku(double dana){
        PrintWriter plik = null;
        try {
            plik = new PrintWriter(new FileOutputStream(sciezka, true));
            System.out.println("Trwa zapisywanie do pliku...");
            plik.println(dana);
            plik.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku!");
        }
    }
}
