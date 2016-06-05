package sample;

import MachineLearning.Dane;
import MachineLearning.RegresjaWielowymiarowa;
import MachineLearning.ZapisOdczytZPliku;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import sample.astar.*;
import sample.MachineLearning.*;

import static sample.Controller.prepareActionHandlers;
import static sample.astar.OilArray.*;
import static sample.gui.Graphic.*;
import static sample.gui.Gui.*;
import static sample.gui.Cases.*;
import static sample.gui.Forklift.*;


public class Main extends Application {

    static int[] tempArray = new int[80];
    // Mouse events
    static double mouseX = 0.0;
    static double mouseY = 0.0;
    //Map
    static Map<Integer, AstarPoints> multiplePoints = new HashMap<Integer, AstarPoints>();
    //KnowledgeBase
    public static KnowledgeBase knowledgeBase;
    public static KnowledgeBase knowledgeBaseInt;
    //Regals
    public static Regal regal = new Regal();
    public static Regal regal2 = new Regal();
    public static Regal regal3 = new Regal();
    public static Regal regal4 = new Regal();
    //Types
    public int numbercase = 0;
    public static int TypeCase = 1;
    public static int TypeRegal = 1;
    public Integer[] Key = new Integer[5];
    public static int RandTypeCase;
    public static String[] RandCaseName = new String[20];
    public static  String ActualPropertiesName[] = new String[4];
    public static  Integer ActualPropertiesNameInt[] = new Integer[4];
    public static  String CaseTypeName = " ";
    public static  String RegalTypeName = " ";
    public static Random RandCaseInt = new Random();
    //Strategies
    static Astar astar;
    static LearningStrategy learningStrategy;
    static int fieldNumber[] = new int[100];
    // Random for algorithm Cases
    static Random randPoints = new Random();
    // Boolean for pathfinding (true if came back, false if still walking)
    static boolean didComeBack = false;
    public int iterator = 0;
    ///Regresion
    public static int Regression(double x1, double x2, double x3, double x4) throws IOException {
        ZapisOdczytZPliku zapisOdczytZPliku = new ZapisOdczytZPliku();
        Dane dane = new Dane();
        RegresjaWielowymiarowa regresjaWielowymiarowa = new RegresjaWielowymiarowa(dane.pobranieDoTablicyCech(), dane.pobranieDoTablicywartosci());
        regresjaWielowymiarowa.porownanie(dane.pobranieDoTablicyCech(), dane.pobranieDoTablicywartosci());
        regresjaWielowymiarowa.read();
//        dane.wypisanieTablic(dane.pobranieDoTablicywartosci(),dane.pobranieDoTablicyCech());
        return regresjaWielowymiarowa.test(x1, x2, x3, x4);
    }
    // Get Cases that algorithm returns [x,y] and change them to Gui Cases for example [ 15,15 ] -> 255
    private static void getFieldNumber() {
        int it = 0;
        for (int i = astar.pathXY.size() - 1; i >= 0; i--) {
            for (int j = 0; j < algorithmAvailablePoints.size(); j++) {
                if ((algorithmAvailablePoints.get(j).getX()) == (astar.pathXY.get(i).getX()) &&
                        (algorithmAvailablePoints.get(j).getY()) == (astar.pathXY.get(i).getY())) {
                    fieldNumber[it] = j;
                    it++;
                }
            }
        }
    }
// Oil Cordinate Converts
    private static void convertOilNumberToCoordinates() {
        for(int i = 0; i < oilsToDraw.length; i++) {
//            System.out.print("X: " + multiplePoints.get(oilsToDraw[i]).getX() + " Y: " + multiplePoints.get(oilsToDraw[i]).getY() + "\n");
            oilsCoordinates[i][0] = multiplePoints.get(oilsToDraw[i]).getX();
            oilsCoordinates[i][1] = multiplePoints.get(oilsToDraw[i]).getY();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage mainStage) throws Exception {
//        learningStrategy = new MultipleRegression();

       /* ********************************* START ALGORITHM!!!!!!!!!!! *************************************************
        a - array size (our Gui has 16x16)
        sy - start point y
        sx - start point x
        dy - destination point y
        dx - destination point x
        z - array with blocked Cases
                      a   a  sy  sx dy dx    z                       */
        // astar.test(16, 16, 0, 0, 10, 8, astarBlockedPoints);
        // scenario for oil
        oilArray[0] = 0;
        astarBlockedPoints[81] = pointsForOil[0];
        oilArray[1] = 15;
        astarBlockedPoints[82] = pointsForOil[15];
        oilArray[2] = 30;
        astarBlockedPoints[83] = pointsForOil[30];
        oilArray[3] = 32;
        astarBlockedPoints[84] = pointsForOil[32];
        oilArray[4] = 34;
        astarBlockedPoints[85] = pointsForOil[34];
        oilArray[5] = 36;
        astarBlockedPoints[86] = pointsForOil[36];
        oilArray[6] = 37;
        astarBlockedPoints[87] = pointsForOil[37];
        oilArray[7] = 17;
        astarBlockedPoints[88] = pointsForOil[17];
        astarBlockedPoints[89] = pointsForOil[21];
        oilArray[9] = 7;
        astarBlockedPoints[80] = pointsForOil[7];

        prepareKnowledgeBase();



        //ActualPropertiesName
        for (int i = 0; i < 4; i++){
//            ActualPropertiesName[i] = knowledgeBase.getKnowledgeBase().get(RandCaseName[1]).get(i);
           ActualPropertiesName[i] = "";
        }

        makeRegal();
        int x = 0;
        int y = 0;
        for (int i = 0; i <= 255; i++) {
            algorithmAvailablePoints.put(i, new AstarPoints(x, y));
            x++;
            if (x > 15) {
                y++;
                x = 0;
            }
        }

        prepareMultiplePoints();

        getOilSlickNumber();
        convertOilNumberToCoordinates();

        Map<String, List<String>> knowledgeBase = Main.knowledgeBase.getKnowledgeBase();
        //System.out.println(knowledgeBase.toString());

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            mainStage.setTitle("Inteligentny wozek widlowy");
            //   Group root = new Group();
            mainScene = new Scene(page);
            mainStage.setScene(mainScene);
            Canvas canvas = new Canvas(WIDTH, HEIGHT);
            page.getChildren().add(canvas);
            prepareActionHandlers();
            graphicsContext = canvas.getGraphicsContext2D();
            loadGraphics();
            getFieldNumber();
            /**
             * Main "game" loop
             */
            setCase();

            new AnimationTimer() {
                public void handle(long currentNanoTime) {

                    try {
                        tickAndRender();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    setStatement();
                    conveyorAnimated();

                }
            }.start();

            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (int i = 0; i < algorithmAvailablePoints.size(); i++) {
//            System.out.print("X:" + algorithmAvailablePoints.get(i).getX() + " Y:" + algorithmAvailablePoints.get(i).getY() + "\n");
//        }
    }

    private void prepareMultiplePoints() {
        AstarPoints.prepareMultiplePoints(multiplePoints);
    }
    //Wiedza
    private void prepareKnowledgeBase() {
        knowledgeBase = new KnowledgeBase();

        knowledgeBase.addData("Car Parts", "Metal");
        knowledgeBase.addData("Car Parts", "30");
        knowledgeBase.addData("Car Parts", "30");
        knowledgeBase.addData("Car Parts", "Normal");

        knowledgeBase.addData("Wood Car Parts", "Wood");
        knowledgeBase.addData("Wood Car Parts", "20");
        knowledgeBase.addData("Wood Car Parts", "20");
        knowledgeBase.addData("Wood Car Parts", "Normal");

        knowledgeBase.addData("Instructions", "Paper");
        knowledgeBase.addData("Instructions", "10");
        knowledgeBase.addData("Instructions", "10");
        knowledgeBase.addData("Instructions", "Flammable");

        knowledgeBase.addData("Nitro", "Gas");
        knowledgeBase.addData("Nitro", "10");
        knowledgeBase.addData("Nitro", "20");
        knowledgeBase.addData("Nitro", "Flammable");

        knowledgeBase.addData("Azot", "Gas");
        knowledgeBase.addData("Azot", "10");
        knowledgeBase.addData("Azot", "20");
        knowledgeBase.addData("Azot", "Cool");

        knowledgeBase.addData("Oxygen", "Gas");
        knowledgeBase.addData("Oxygen", "10");
        knowledgeBase.addData("Oxygen", "20");
        knowledgeBase.addData("Oxygen", "Normal");

        knowledgeBase.addData("Ammoniac", "Gas");
        knowledgeBase.addData("Ammoniac", "10");
        knowledgeBase.addData("Ammoniac", "20");
        knowledgeBase.addData("Ammoniac", "Flammable");

        knowledgeBase.addData("Mercury", "Metal");
        knowledgeBase.addData("Mercury", "30");
        knowledgeBase.addData("Mercury", "20");
        knowledgeBase.addData("Mercury", "Cool");

        knowledgeBase.addData("Fire extinguisher", "Metal");
        knowledgeBase.addData("Fire extinguisher", "10");
        knowledgeBase.addData("Fire extinguisher", "10");
        knowledgeBase.addData("Fire extinguisher", "Normal");

        knowledgeBase.addData("Oil Canister", "Metal");
        knowledgeBase.addData("Oil Canister", "10");
        knowledgeBase.addData("Oil Canister", "20");
        knowledgeBase.addData("Oil Canister", "Normal");

        knowledgeBase.addData("Books", "Paper");
        knowledgeBase.addData("Books", "10");
        knowledgeBase.addData("Books", "10");
        knowledgeBase.addData("Books", "Flammable");

        knowledgeBase.addData("Notebooks", "Paper");
        knowledgeBase.addData("Notebooks", "10");
        knowledgeBase.addData("Notebooks", "10");
        knowledgeBase.addData("Notebooks", "Flammable");

        knowledgeBase.addData("Pine Boards", "Wood");
        knowledgeBase.addData("Pine Boards", "20");
        knowledgeBase.addData("Pine Boards", "20");
        knowledgeBase.addData("Pine Boards", "Flammable");

        knowledgeBase.addData("Table Parts", "Wood");
        knowledgeBase.addData("Table Parts", "20");
        knowledgeBase.addData("Table Parts", "20");
        knowledgeBase.addData("Table Parts", "Normal");

        knowledgeBaseInt = new KnowledgeBase();

        knowledgeBaseInt.addData("Car Parts", "1");
        knowledgeBaseInt.addData("Car Parts", "30");
        knowledgeBaseInt.addData("Car Parts", "30");
        knowledgeBaseInt.addData("Car Parts", "3");

        knowledgeBaseInt.addData("4 Car Parts", "4");
        knowledgeBaseInt.addData("4 Car Parts", "20");
        knowledgeBaseInt.addData("4 Car Parts", "20");
        knowledgeBaseInt.addData("4 Car Parts", "3");

        knowledgeBaseInt.addData("Instructions", "2");
        knowledgeBaseInt.addData("Instructions", "10");
        knowledgeBaseInt.addData("Instructions", "10");
        knowledgeBaseInt.addData("Instructions", "1");

        knowledgeBaseInt.addData("Nitro", "3");
        knowledgeBaseInt.addData("Nitro", "10");
        knowledgeBaseInt.addData("Nitro", "20");
        knowledgeBaseInt.addData("Nitro", "1");

        knowledgeBaseInt.addData("Azot", "3");
        knowledgeBaseInt.addData("Azot", "10");
        knowledgeBaseInt.addData("Azot", "20");
        knowledgeBaseInt.addData("Azot", "2");

        knowledgeBaseInt.addData("Oxygen", "3");
        knowledgeBaseInt.addData("Oxygen", "10");
        knowledgeBaseInt.addData("Oxygen", "20");
        knowledgeBaseInt.addData("Oxygen", "3");

        knowledgeBaseInt.addData("Ammoniac", "3");
        knowledgeBaseInt.addData("Ammoniac", "10");
        knowledgeBaseInt.addData("Ammoniac", "20");
        knowledgeBaseInt.addData("Ammoniac", "1");

        knowledgeBaseInt.addData("Mercury", "1");
        knowledgeBaseInt.addData("Mercury", "30");
        knowledgeBaseInt.addData("Mercury", "20");
        knowledgeBaseInt.addData("Mercury", "2");

        knowledgeBaseInt.addData("Fire extinguisher", "1");
        knowledgeBaseInt.addData("Fire extinguisher", "10");
        knowledgeBaseInt.addData("Fire extinguisher", "10");
        knowledgeBaseInt.addData("Fire extinguisher", "3");

        knowledgeBaseInt.addData("Oil Canister", "1");
        knowledgeBaseInt.addData("Oil Canister", "10");
        knowledgeBaseInt.addData("Oil Canister", "20");
        knowledgeBaseInt.addData("Oil Canister", "3");

        knowledgeBaseInt.addData("Books", "2");
        knowledgeBaseInt.addData("Books", "10");
        knowledgeBaseInt.addData("Books", "10");
        knowledgeBaseInt.addData("Books", "1");

        knowledgeBaseInt.addData("Notebooks", "2");
        knowledgeBaseInt.addData("Notebooks", "10");
        knowledgeBaseInt.addData("Notebooks", "10");
        knowledgeBaseInt.addData("Notebooks", "1");

        knowledgeBaseInt.addData("Pine Boards", "4");
        knowledgeBaseInt.addData("Pine Boards", "20");
        knowledgeBaseInt.addData("Pine Boards", "20");
        knowledgeBaseInt.addData("Pine Boards", "1");

        knowledgeBaseInt.addData("Table Parts", "4");
        knowledgeBaseInt.addData("Table Parts", "20");
        knowledgeBaseInt.addData("Table Parts", "20");
        knowledgeBaseInt.addData("Table Parts", "3");

        //RandCaseName
        RandCaseName[0]="Car Parts";
        RandCaseName[1]="Car Parts";
        RandCaseName[2]="Wood Car Parts";
        RandCaseName[3]="Instructions";
        RandCaseName[4]="Nitro";
        RandCaseName[5]="Azot";
        RandCaseName[6]="Oxygens";
        RandCaseName[7]="Ammoniac";
        RandCaseName[8]="Mercury";
        RandCaseName[9]="Fire extinguisher";
        RandCaseName[10]="Oil Canister";
        RandCaseName[11]="Books";
        RandCaseName[12]="Notebooks";
        RandCaseName[13]="Boards";
        RandCaseName[14]="Table Parts";
        RandCaseName[15]="Table Parts";

    }

    // Wiedza 2
    private void makeRegal() {
        Key[1]=1;
        Key[2]=1;
        Key[3]=1;
        Key[4]=1;

        regal.addData(1,156);
        regal.addData(1,156);
        regal.addData(1,3);
        regal.addData(1,0);
        regal.addData(2,210);
        regal.addData(2,156);
        regal.addData(2,3);
        regal.addData(2,3);
        regal.addData(3,156);
        regal.addData(3,195);
        regal.addData(3,4);
        regal.addData(3,0);
        regal.addData(4,210);
        regal.addData(4,195);
        regal.addData(4,4);
        regal.addData(4,3);
        regal.addData(5,156);
        regal.addData(5,247);
        regal.addData(5,5);
        regal.addData(5,0);
        regal.addData(6,210);
        regal.addData(6,247);
        regal.addData(6,5);
        regal.addData(6,3);
        regal.addData(7,156);
        regal.addData(7,282);
        regal.addData(7,6);
        regal.addData(7,0);
        regal.addData(8,210);
        regal.addData(8,282);
        regal.addData(8,6);
        regal.addData(8,3);
        regal.addData(9,156);
        regal.addData(9,340);
        regal.addData(9,7);
        regal.addData(9,0);
        regal.addData(10,210);
        regal.addData(10,340);
        regal.addData(10,7);
        regal.addData(10,3);
        regal.addData(11,156);
        regal.addData(11,372);
        regal.addData(11,8);
        regal.addData(11,0);
        regal.addData(12,210);
        regal.addData(12,372);
        regal.addData(12,8);
        regal.addData(12,3);
        regal.addData(13,156);
        regal.addData(13,429);
        regal.addData(13,9);
        regal.addData(13,0);
        regal.addData(14,210);
        regal.addData(14,429);
        regal.addData(14,9);
        regal.addData(14,3);
        regal.addData(15,156);
        regal.addData(15,466);
        regal.addData(15,10);
        regal.addData(15,0);
        regal.addData(16,210);
        regal.addData(16,466);
        regal.addData(16,10);
        regal.addData(16,3);
        regal.addData(17,156);
        regal.addData(17,519);
        regal.addData(17,11);
        regal.addData(17,0);
        regal.addData(18,210);
        regal.addData(18,519);
        regal.addData(18,11);
        regal.addData(18,3);
        regal.addData(19,156);
        regal.addData(19,554);
        regal.addData(19,12);
        regal.addData(19,0);
        regal.addData(20,210);
        regal.addData(20,554);
        regal.addData(20,12);
        regal.addData(20,3);

        regal2.addData(1,313);
        regal2.addData(1,156);
        regal2.addData(1,3);
        regal2.addData(1,4);
        regal2.addData(2,367);
        regal2.addData(2,156);
        regal2.addData(2,3);
        regal2.addData(2,7);
        regal2.addData(3,313);
        regal2.addData(3,195);
        regal2.addData(3,4);
        regal2.addData(3,4);
        regal2.addData(4,367);
        regal2.addData(4,195);
        regal2.addData(4,4);
        regal2.addData(4,7);
        regal2.addData(5,313);
        regal2.addData(5,247);
        regal2.addData(5,5);
        regal2.addData(5,4);
        regal2.addData(6,367);
        regal2.addData(6,247);
        regal2.addData(6,5);
        regal2.addData(6,7);
        regal2.addData(7,313);
        regal2.addData(7,282);
        regal2.addData(7,6);
        regal2.addData(7,4);
        regal2.addData(8,367);
        regal2.addData(8,282);
        regal2.addData(8,6);
        regal2.addData(8,7);
        regal2.addData(9,313);
        regal2.addData(9,340);
        regal2.addData(9,7);
        regal2.addData(9,4);
        regal2.addData(10,367);
        regal2.addData(10,340);
        regal2.addData(10,7);
        regal2.addData(10,7);
        regal2.addData(11,313);
        regal2.addData(11,372);
        regal2.addData(11,8);
        regal2.addData(11,4);
        regal2.addData(12,367);
        regal2.addData(12,372);
        regal2.addData(12,8);
        regal2.addData(12,7);
        regal2.addData(13,313);
        regal2.addData(13,429);
        regal2.addData(13,9);
        regal2.addData(13,4);
        regal2.addData(14,367);
        regal2.addData(14,429);
        regal2.addData(14,9);
        regal2.addData(14,7);
        regal2.addData(15,313);
        regal2.addData(15,466);
        regal2.addData(15,10);
        regal2.addData(15,4);
        regal2.addData(16,367);
        regal2.addData(16,466);
        regal2.addData(16,10);
        regal2.addData(16,7);
        regal2.addData(17,313);
        regal2.addData(17,519);
        regal2.addData(17,11);
        regal2.addData(17,4);
        regal2.addData(18,367);
        regal2.addData(18,519);
        regal2.addData(18,11);
        regal2.addData(18,7);
        regal2.addData(19,313);
        regal2.addData(19,554);
        regal2.addData(19,12);
        regal2.addData(19,4);
        regal2.addData(20,367);
        regal2.addData(20,554);
        regal2.addData(20,12);
        regal2.addData(20,7);

        regal3.addData(1,472);
        regal3.addData(1,156);
        regal3.addData(1,3);
        regal3.addData(1,8);
        regal3.addData(2,525);
        regal3.addData(2,156);
        regal3.addData(2,3);
        regal3.addData(2,11);
        regal3.addData(3,472);
        regal3.addData(3,195);
        regal3.addData(3,4);
        regal3.addData(3,8);
        regal3.addData(4,525);
        regal3.addData(4,195);
        regal3.addData(4,4);
        regal3.addData(4,11);
        regal3.addData(5,472);
        regal3.addData(5,247);
        regal3.addData(5,5);
        regal3.addData(5,8);
        regal3.addData(6,525);
        regal3.addData(6,247);
        regal3.addData(6,5);
        regal3.addData(6,11);
        regal3.addData(7,472);
        regal3.addData(7,282);
        regal3.addData(7,6);
        regal3.addData(7,8);
        regal3.addData(8,525);
        regal3.addData(8,282);
        regal3.addData(8,6);
        regal3.addData(8,11);
        regal3.addData(9,472);
        regal3.addData(9,340);
        regal3.addData(9,7);
        regal3.addData(9,8);
        regal3.addData(10,525);
        regal3.addData(10,340);
        regal3.addData(10,7);
        regal3.addData(10,11);
        regal3.addData(11,472);
        regal3.addData(11,372);
        regal3.addData(11,8);
        regal3.addData(11,8);
        regal3.addData(12,525);
        regal3.addData(12,372);
        regal3.addData(12,8);
        regal3.addData(12,11);
        regal3.addData(13,472);
        regal3.addData(13,429);
        regal3.addData(13,9);
        regal3.addData(13,8);
        regal3.addData(14,525);
        regal3.addData(14,429);
        regal3.addData(14,9);
        regal3.addData(14,11);
        regal3.addData(15,472);
        regal3.addData(15,466);
        regal3.addData(15,10);
        regal3.addData(15,8);
        regal3.addData(16,525);
        regal3.addData(16,466);
        regal3.addData(16,10);
        regal3.addData(16,11);
        regal3.addData(17,472);
        regal3.addData(17,519);
        regal3.addData(17,11);
        regal3.addData(17,8);
        regal3.addData(18,525);
        regal3.addData(18,519);
        regal3.addData(18,11);
        regal3.addData(18,11);
        regal3.addData(19,472);
        regal3.addData(19,554);
        regal3.addData(19,12);
        regal3.addData(19,8);
        regal3.addData(20,525);
        regal3.addData(20,554);
        regal3.addData(20,12);
        regal3.addData(20,11);

        regal4.addData(1,629);
        regal4.addData(1,156);
        regal4.addData(1,3);
        regal4.addData(1,12);
        regal4.addData(2,682);
        regal4.addData(2,156);
        regal4.addData(2,3);
        regal4.addData(2,15);
        regal4.addData(3,629);
        regal4.addData(3,195);
        regal4.addData(3,4);
        regal4.addData(3,12);
        regal4.addData(4,682);
        regal4.addData(4,195);
        regal4.addData(4,4);
        regal4.addData(4,15);
        regal4.addData(5,629);
        regal4.addData(5,247);
        regal4.addData(5,5);
        regal4.addData(5,12);
        regal4.addData(6,682);
        regal4.addData(6,247);
        regal4.addData(6,5);
        regal4.addData(6,15);
        regal4.addData(7,629);
        regal4.addData(7,282);
        regal4.addData(7,6);
        regal4.addData(7,12);
        regal4.addData(8,682);
        regal4.addData(8,282);
        regal4.addData(8,6);
        regal4.addData(8,15);
        regal4.addData(9,629);
        regal4.addData(9,340);
        regal4.addData(9,7);
        regal4.addData(9,12);
        regal4.addData(10,682);
        regal4.addData(10,340);
        regal4.addData(10,7);
        regal4.addData(10,15);
        regal4.addData(11,629);
        regal4.addData(11,372);
        regal4.addData(11,8);
        regal4.addData(11,12);
        regal4.addData(12,682);
        regal4.addData(12,372);
        regal4.addData(12,8);
        regal4.addData(12,15);
        regal4.addData(13,629);
        regal4.addData(13,429);
        regal4.addData(13,9);
        regal4.addData(13,12);
        regal4.addData(14,682);
        regal4.addData(14,429);
        regal4.addData(14,9);
        regal4.addData(14,15);
        regal4.addData(15,629);
        regal4.addData(15,466);
        regal4.addData(15,10);
        regal4.addData(15,12);
        regal4.addData(16,682);
        regal4.addData(16,466);
        regal4.addData(16,10);
        regal4.addData(16,15);
        regal4.addData(17,629);
        regal4.addData(17,519);
        regal4.addData(17,11);
        regal4.addData(17,12);
        regal4.addData(18,682);
        regal4.addData(18,519);
        regal4.addData(18,11);
        regal4.addData(18,15);
        regal4.addData(19,629);
        regal4.addData(19,554);
        regal4.addData(19,12);
        regal4.addData(19,12);
        regal4.addData(20,682);
        regal4.addData(20,554);
        regal4.addData(20,12);
        regal4.addData(20,15);
    }

    // Moving
    private double calculateXIterator() {
        return (multiplePoints.get(fieldNumber[iterator]).getX() - actualPositionW) / movingTicks;
    }
    private double calculateYIterator() {
        return (multiplePoints.get(fieldNumber[iterator]).getY() - actualPositionH) / movingTicks;
    }
    private void waitUntilRunThreadFinishes(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private Runnable prepareRunableForMovingSlowly(double xIterator, double yIterator) {
        return () -> {
            for (int i = 0; i < movingTicks; i++) {
                actualPositionW += xIterator;
                actualPositionH += yIterator;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
    private void move() {
        double xIterator = calculateXIterator();
        double yIterator = calculateYIterator();
        Runnable runnable = prepareRunableForMovingSlowly(xIterator, yIterator);
        pool.execute(runnable);

        waitUntilRunThreadFinishes(100 * movingTicks);
    }
    private void handleGoingForPackage() {
        iterator++;
        move();
    }

    private void handleReturning() {
        if (iterator >= 0 && returnMode) {
            iterator--;
            move();
        }
    }

    private void ShowCase(int numbercase, int typecase,double x, double y) {
        casePoints[numbercase][0] = x;       //X
        casePoints[numbercase][1] = y;       //Y
        switch (typecase) {
                        case 1:
                            casesToSpawn[numbercase] = caseOne;
                            break;
                        case 2:
                            casesToSpawn[numbercase] = caseTwo;
                            break;
                        case 3:
                            casesToSpawn[numbercase] = caseThree;
                            break;
                        case 4:
                            casesToSpawn[numbercase] = caseFour;
                            break;
                    }
        casesToSpawn[numbercase] = caseOne;
        IntStream.range(0, 20).forEach(
                n -> {
                    int i = 0;
                    int k = caseSpawn.nextInt(79) + 1;
                    boolean temp = true;
                    while (temp == true) {
                        if (!contains(tempArray, k)) {
                            tempArray[n] = k;
                            i = k;
                            temp = false;
                        } else {
                            k = caseSpawn.nextInt(79) + 1;
                        }
                    }
                    locOfCases[n] = n;
                }
        );
    }

    public static void ShowActualCase(int typecase) {
        switch (typecase) {
            case 1:
                actualCase = caseOne; // Metal
                break;
            case 2:
                actualCase = caseTwo; // Paper
                break;
            case 3:
                actualCase = caseThree; // Gas
                break;
            case 4:
                actualCase = caseFour; // Wood
                break;
            case 5:
                actualCase = caseFive; // Flameable
                break;
            case 6:
                actualCase = caseSix; // Cool
                break;
        }
    }

    private void mouseClicked() {
        Integer caseofcase[] = new Integer[2];
        Integer x[] = new Integer[2];
        x[0]=0;
        x[1]=0;

        mainPool.execute(() -> {

            boolean free = true;
            boolean free2 = true;
            Integer size = 1;

            switch (TypeRegal) {
                case 1:
                    if((regal.BooleanFree(Key[1]))==true){
                        caseofcase[0]=regal.getRegal().get(Key[1]).get(0);
                        caseofcase[1]=regal.getRegal().get(Key[1]).get(1);
                        x[0]=regal.getRegal().get(Key[1]).get(2);
                        x[1]=regal.getRegal().get(Key[1]).get(3);
                        free = false;
                        free2 = false;
                        regal.addData(Key[1],15);
                        Key[1]++;
                    }
                    break;
                case 2:
                    if((regal2.BooleanFree(Key[2]))==true){
                        caseofcase[0]=regal2.getRegal().get(Key[2]).get(0);
                        caseofcase[1]=regal2.getRegal().get(Key[2]).get(1);
                        x[0]=regal2.getRegal().get(Key[2]).get(2);
                        x[1]=regal2.getRegal().get(Key[2]).get(3);
                        free = false;
                        free2 = false;
                        regal2.addData(Key[2],15);
                        Key[2]++;
                    }
                    break;
                case 3:
                    if((regal3.BooleanFree(Key[3]))==true){
                        caseofcase[0]=regal3.getRegal().get(Key[3]).get(0);
                        caseofcase[1]=regal3.getRegal().get(Key[3]).get(1);
                        x[0]=regal3.getRegal().get(Key[3]).get(2);
                        x[1]=regal3.getRegal().get(Key[3]).get(3);
                        free = false;
                        free2 = false;
                        regal3.addData(Key[3],15);
                        Key[3]++;
                    }
                    break;
                case 4:
                    if((regal4.BooleanFree(Key[4]))==true){
                        caseofcase[0]=regal4.getRegal().get(Key[4]).get(0);
                        caseofcase[1]=regal4.getRegal().get(Key[4]).get(1);
                        x[0]=regal4.getRegal().get(Key[4]).get(2);
                        x[1]=regal4.getRegal().get(Key[4]).get(3);
                        free = false;
                        free2 = false;
                        regal4.addData(Key[4],15);
                        Key[4]++;
                    }
                    break;
            }

            ShowActualCase(TypeCase);
//            getRandomCase();
//            int[] destinationXY = findPlace();
//            int randCasePoint = randPoints.nextInt(80);
            astar.test(16, 16, 0, 0, x[0],x[1], astarBlockedPoints);
//            astar.test(16,16,0,0,destinationXY[0],destinationXY[1],astarBlockedPoints);
            getFieldNumber();

            while (iterator < astar.pathXY.size() - 1) {
                handleGoingForPackage();
            }
            returnMode = true;
            unlockPack = true;
            if(free2 == false){
            ShowCase(numbercase,TypeCase,caseofcase[0],caseofcase[1]);
                actualCase = null;
                numbercase++;
            }

            while (iterator > 0 && returnMode) {
                handleReturning();
            }
            if (iterator == 0) {
                System.out.print("END\n");
                returnMode = false;
            }
        });
    }
    private void setCase() {
        mainScene.addEventHandler(MouseEvent.MOUSE_RELEASED,
                mouseEvent -> mouseClicked());
    }

// End Moving

    private void getRandomCase() {
        int random = new Random().nextInt(7);
//        if (random == 0)
    }

    private  int  findPlaces() {
        int places = 1;
        return  places;
    }

// Machine Learning
    private int[] findPlace() {
        String caseName = "explosives";
        return learningStrategy.findDestinationPlace(knowledgeBase, caseName);
    }


}