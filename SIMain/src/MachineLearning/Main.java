package MachineLearning;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Grzegorz on 2016-03-26.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ZapisOdczytZPliku zapisOdczytZPliku = new ZapisOdczytZPliku();
        Dane dane = new Dane();
        dane.pobranieDoTablicy();
    }
}
