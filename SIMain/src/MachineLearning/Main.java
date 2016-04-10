package MachineLearning;

import java.io.IOException;

/**
 * Created by Grzegorz on 2016-03-26.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ZapisOdczytZPliku zapisOdczytZPliku = new ZapisOdczytZPliku();
        Dane dane = new Dane();
        RegresjaWielowymiarowa regresjaWielowymiarowa = new RegresjaWielowymiarowa(dane.pobranieDoTablicyCech(), dane.pobranieDoTablicywartosci());
        regresjaWielowymiarowa.porownanie(dane.pobranieDoTablicyCech(), dane.pobranieDoTablicywartosci());
        regresjaWielowymiarowa.read();
        System.out.println();
        dane.wypisanieTablic(dane.pobranieDoTablicywartosci(),dane.pobranieDoTablicyCech());
    }
}
