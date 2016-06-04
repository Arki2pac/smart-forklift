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

        KnowledgeBase knowledgeBase = new KnowledgeBase();
        knowledgeBase.addData("car parts", "gray");
        knowledgeBase.addData("car parts", "metal");
        knowledgeBase.addData("car parts", "heavy");
        knowledgeBase.addData("car parts", "middleweight");
        knowledgeBase.getKnowledgeBase();
        String ActualKey = "car parts";
        String ActualProperties[] = new String[4];
        Double ActualPropertiesDouble[] = new Double[4];

        for (int i = 0; i < 4; i++){
            ActualProperties[i] = knowledgeBase.getKnowledgeBase().get(ActualKey).get(i);
            System.out.println(ActualProperties[i]);
        }
        Converter converter = new Converter();
        ActualPropertiesDouble = converter.toConvert(ActualProperties);
        for (int i = 0; i < 4; i++) {
            System.out.println(ActualPropertiesDouble[i]);
        }
    }
}
