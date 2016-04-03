package MachineLearning;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Grzegorz on 2016-03-26.
 */
public class Dane {

    public double objetosc = 0.0;
    public double kolor = 0.0;
    public double waga = 0.0;
    public double latwopalne = 0.0;

    ZapisOdczytZPliku zapisOdczytZPliku = new ZapisOdczytZPliku();

    public double getObjetosc() {
        return objetosc;
    }

    public double getKolor() {
        return kolor;
    }

    public double getWaga() {
        return waga;
    }

    public double getLatwopalne() {
        return latwopalne;
    }

    public void setObjetosc(double objetosc) {
        this.objetosc = objetosc;
    }

    public void setKolor(double kolor) {
        this.kolor = kolor;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public void setLatwopalne(double latwopalne) {
        this.latwopalne = latwopalne;
    }

    public double[][] stworzenieMacierzyCech() throws IOException {
        int iloscWierszy = zapisOdczytZPliku.odczytZPliku().size()/4;
        double[][] macierzRegresji = new double[iloscWierszy][5];
        return  macierzRegresji;
    }

    public double[] stworzenieMacierzyWartosci() throws IOException {
        double[] macierzWartosci = new double[zapisOdczytZPliku.odczytZPliku().size()/4];
        return macierzWartosci;
    }



    public void pobranieDanych(){
        double pomocna;
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj objętość paczki:");
        setObjetosc(in.nextDouble());
        zapisOdczytZPliku.zapisDoPliku(getObjetosc());
        System.out.println("Podaj kolor paczki:");
        setKolor(in.nextDouble());
        zapisOdczytZPliku.zapisDoPliku(getKolor());
        System.out.println("Podaj wagę paczki:");
        setWaga(in.nextDouble());
        zapisOdczytZPliku.zapisDoPliku(getWaga());
        System.out.println("Czy paczka posiada rzeczy łatwopalne?");
        setLatwopalne(in.nextDouble());
        zapisOdczytZPliku.zapisDoPliku(getLatwopalne());
    }

    public void pobranieDoTablicy() throws IOException {
        double[][] macierzRegresji = stworzenieMacierzyCech();
        double[] macierzWartosci = stworzenieMacierzyWartosci();
        for (int i = 0; i < macierzRegresji.length; i++) {
            macierzRegresji[i][0] = 1.0;
        }
        int pomocnicza = 0;
        for(int i = 0; i < zapisOdczytZPliku.odczytZPliku().size()/4; i++){
            for (int j = 1; j < 5; j++){
                macierzRegresji[i][j] = Double.parseDouble(zapisOdczytZPliku.odczytZPliku().get(pomocnicza));
                pomocnicza++;
            }
        }

        for (int i = 0; i < macierzRegresji.length; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(macierzRegresji[i][j] + " ");
            }
            System.out.println();
        }
    }
}
