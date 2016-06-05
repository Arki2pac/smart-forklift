package MachineLearning;

import sample.KnowledgeBase;
import sample.converter.Converter;

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



//        Integer ActualProperties[] = new Integer[4];
//        ActualProperties[0]=1;
//        ActualProperties[1]=30;
//        ActualProperties[2]=30;
//        ActualProperties[3]=3;
//
//        Double ActualPropertiesDouble[] = new Double[4];
//        ActualPropertiesDouble[] = ActualProperties[];


    }
}
