package MachineLearning;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Grzegorz on 2016-03-26.
 */
public class Dane {

    public double objetosc = 0.0;
    public double Rodzaj = 0.0;
    public double waga = 0.0;
    public double special = 0.0;

    public double numerPolki = 0.0;

    ZapisOdczytZPliku zapisOdczytZPliku = new ZapisOdczytZPliku();


    public double getRodzaj() {
        return Rodzaj;
    }

    public void setRodzaj(double rodzaj) {
        Rodzaj = rodzaj;
    }

    public double getObjetosc() {
        return objetosc;
    }

    public double getWaga() {
        return waga;
    }

    public double getSpecial() {
        return special;
    }

    public void setObjetosc(double objetosc) {
        this.objetosc = objetosc;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public void setSpecial(double special) {
        this.special = special;
    }

    public void setNumerPolki(double numerPolki) {
        this.numerPolki = numerPolki;
    }

    public double getNumerPolki() {

        return numerPolki;
    }

    public double[][] stworzenieMacierzyCech() throws IOException {
        int iloscWierszy = zapisOdczytZPliku.odczytZPlikuCech().size()/4;
        double[][] macierzRegresji = new double[iloscWierszy][5];
        return  macierzRegresji;
    }

    public double[] stworzenieMacierzyWartosci() throws IOException {
        double[] macierzWartosci = new double[zapisOdczytZPliku.odczytZPlikuPolek().size()];
        return macierzWartosci;
    }

    public void pobranieDanych(){
        double pomocna;
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj objętość paczki:");
        setObjetosc(in.nextDouble());
        zapisOdczytZPliku.zapisDoPlikuCech(getObjetosc());
        System.out.println("Podaj rodzaj produktu:");
        setRodzaj(in.nextDouble());
        zapisOdczytZPliku.zapisDoPlikuCech(getRodzaj());
        System.out.println("Podaj wagę paczki:");
        setWaga(in.nextDouble());
        zapisOdczytZPliku.zapisDoPlikuCech(getWaga());
        System.out.println("Podaj inforamcje extra");
        setSpecial(in.nextDouble());
        zapisOdczytZPliku.zapisDoPlikuCech(getSpecial());
        System.out.println("Podaj numer półki");
        setNumerPolki(in.nextDouble());
        zapisOdczytZPliku.zapisDoPlikuCech(getNumerPolki());
    }

    public double[] pobranieDoTablicywartosci() throws IOException {
        double[] macierzWartosci = stworzenieMacierzyWartosci();
        for (int i = 0; i < macierzWartosci.length; i++) {
            macierzWartosci[i] = 0.0;
        }
        int pomocnicza = 0;
        for(int i = 0; i < zapisOdczytZPliku.odczytZPlikuPolek().size(); i++){
            macierzWartosci[i] = Double.parseDouble(zapisOdczytZPliku.odczytZPlikuPolek().get(pomocnicza));
            pomocnicza++;
        }
        return macierzWartosci;
    }


    public double[][] pobranieDoTablicyCech() throws IOException {
        double[][] macierzRegresji = stworzenieMacierzyCech();
        for (int i = 0; i < macierzRegresji.length; i++) {
            macierzRegresji[i][0] = 1.0;
        }
        int pomocnicza = 0;
        for(int i = 0; i < zapisOdczytZPliku.odczytZPlikuCech().size()/4; i++){
            for (int j = 1; j < 5; j++){
                macierzRegresji[i][j] = Double.parseDouble(zapisOdczytZPliku.odczytZPlikuCech().get(pomocnicza));
                pomocnicza++;
            }
        }

        return macierzRegresji;
    }

    public void wypisanieTablic(double[] tablicaWartosci, double[][] tablicaCech){
        for (int i = 0; i < tablicaWartosci.length; i++) {
            System.out.println(tablicaWartosci[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < tablicaCech.length; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(tablicaCech[i][j] + " ");
            }
            System.out.println();
        }
    }
}
