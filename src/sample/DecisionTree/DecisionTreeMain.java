package sample.DecisionTree;
import sample.DecisionTree.*;

import java.io.IOException;

/**
 * Created by infokomes on 06.06.16.
 */
public class DecisionTreeMain {
//    rodzaj,waga,objetosc,extra

    public static int TreeRegal;

//      String[5] COMMAND = {"python3",
//            "/home/infokomes/Desktop/Project/smart-forklift/src/DecisionTree/DecisionTree/python/main_new.py"};

    public static void DecisionTreeTest(int x1, int x2, int x3, int x4) {
        String[] COMMAND = {"python3",
                "/home/infokomes/Desktop/Project/smart-forklift/src/DecisionTree/DecisionTree/python/main_new.py", Integer.toString(x1), Integer.toString(x2), Integer.toString(x3), Integer.toString(x4)};
//        COMMAND[2] = Integer.toString(x1);
//        COMMAND[3] = Integer.toString(x2);
//        COMMAND[4] = Integer.toString(x3);
//        COMMAND[5] = Integer.toString(x4);
        DecisionTree decisionTree = new DecisionTree(COMMAND);
        try {
            decisionTree.run();
            TreeRegal =  decisionTree.getRegalAfterLearning();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
