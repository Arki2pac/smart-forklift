package sample.gui;

import javafx.scene.image.Image;

import java.util.Random;

/**
 * Created by infokomes on 03.06.16.
 */
public class Cases {

    // Cases
    public static Image caseOne;
    public static Image caseTwo;
    public static Image caseThree;
    public static Image caseFour;
    public static Image caseFive;
    public static Image caseSix;
    public static Image caseSeven;
    public static Image caseEight;

    public static double casePoints[][] = new double[80][2];

    // Randoms for Cases-spawns
    public static Random caseSpawn = new Random();
    public static Random caseNumber = new Random();
    public static Image casesToSpawn[] = new Image[20];

    public static int[][] casesCoordinates = {
            {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0}, {10, 0}, {11, 0}, {12, 0},
            {3, 3}, {4, 3}, {5, 3}, {6, 3}, {7, 3}, {8, 3}, {9, 3}, {10, 3}, {11, 3}, {12, 3},
            {3, 4}, {4, 4}, {5, 4}, {6, 4}, {7, 4}, {8, 4}, {9, 4}, {10, 4}, {11, 4}, {12, 4},
            {3, 7}, {4, 7}, {5, 7}, {6, 7}, {7, 7}, {8, 7}, {9, 7}, {10, 7}, {11, 7}, {12, 7},
            {3, 8}, {4, 8}, {5, 8}, {6, 8}, {7, 8}, {8, 8}, {9, 8}, {10, 8}, {11, 8}, {12, 8},
            {3, 11}, {4, 11}, {5, 11}, {6, 11}, {7, 11}, {8, 11}, {9, 11}, {10, 11}, {11, 11}, {12, 11},
            {3, 12}, {4, 12}, {5, 12}, {6, 12}, {7, 12}, {8, 12}, {9, 12}, {10, 12}, {11, 12}, {12, 12},
            {3, 15}, {4, 15}, {5, 15}, {6, 15}, {7, 15}, {8, 15}, {9, 15}, {10, 15}, {11, 15}, {12, 15},
    };




}
