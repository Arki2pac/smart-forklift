package sample.gui;

import javafx.scene.image.Image;

/**
 * Created by infokomes on 03.06.16.
 */
public class graphic {

    // Forklifts
    public static Image forklift;
    public static Image forklift2;

    // Etc
    public static Image background;
    public static Image conveyor;
    public static Image cover;

    // Cases
    public static Image caseOne;
    public static Image caseTwo;
    public static Image caseThree;
    public static Image caseFour;
    public static Image caseFive;
    public static Image caseSix;
    public static Image caseSeven;
    public static Image caseEight;
    // Oil
    public static Image oilSlick;

    public static void loadGraphics() {
        forklift = new Image("img/forklift.png");
        forklift2 = new Image("img/forklift2.png");
        background = new Image("img/background_test.png");
        conveyor = new Image("img/conveyor.png");
        cover = new Image("img/cover.png");
        caseOne = new Image("img/case1.png");
        caseTwo = new Image("img/case2.png");
        caseThree = new Image("img/case3.png");
        caseFour = new Image("img/case4.png");
        caseFive = new Image("img/case5.png");
        caseSix = new Image("img/case6.png");
        caseSeven = new Image("img/case7.png");
        caseEight = new Image("img/case8.png");
        oilSlick = new Image("img/oil.png");

    }
}
