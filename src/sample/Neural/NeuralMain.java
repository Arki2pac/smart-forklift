package sample.Neural;

import java.io.IOException;

/**
 * Created by infokomes on 06.06.16.
 */

public class NeuralMain {
//    rodzaj,waga,objetosc,extra

    public static int NeuralCase;

//      String[5] COMMAND = {"python3",
//            "/home/infokomes/Desktop/Project/smart-forklift/src/DecisionTree/DecisionTree/python/main_new.py"};

    public static void NeuralTest() {

        Neural neural = new Neural();
        try {
            neural.Neuralrun();
            NeuralCase =  neural.getRegalAfterLearning();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}