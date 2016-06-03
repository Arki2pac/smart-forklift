package sample.astar;

import javafx.scene.image.Image;

import java.util.Random;

import static sample.gui.map.algorithmAvailablePoints;

/**
 * Created by infokomes on 03.06.16.
 */
public class oilArray {

    // Oil
    public static Image oilSlick;

    // Random for oil spawns
    public static Random oilRandom = new Random();
    // Arrays for oil spawns
    public static int oilArray[] = new int[10];
    public static int oilsToDraw[] = new int[10];
    public static int oilsCoordinates[][] = new int[10][2];

    public static int[][] astarBlockedPoints = {
            {12, 1}, {11, 1}, {10, 1}, {9, 1}, {8, 1}, {7, 1}, {6, 1}, {5, 1}, {4, 1}, {3, 1},
            {3, 2}, {4, 2}, {5, 2}, {6, 2}, {7, 2}, {8, 2}, {9, 2}, {10, 2}, {11, 2}, {12, 2},
            {12, 5}, {11, 5}, {10, 5}, {9, 5}, {8, 5}, {7, 5}, {6, 5}, {5, 5}, {4, 5}, {3, 5},
            {3, 6}, {4, 6}, {5, 6}, {6, 6}, {7, 6}, {8, 6}, {9, 6}, {10, 6}, {11, 6}, {12, 6},
            {12, 9}, {11, 9}, {10, 9}, {9, 9}, {8, 9}, {7, 9}, {6, 9}, {5, 9}, {4, 9}, {3, 9},
            {3, 10}, {4, 10}, {5, 10}, {6, 10}, {7, 10}, {8, 10}, {9, 10}, {10, 10}, {11, 10},
            {12, 10},
            {12, 13}, {11, 13}, {10, 13}, {9, 13}, {8, 13}, {7, 13}, {6, 13}, {5, 13}, {4, 13},
            {3, 13}, {3, 14}, {4, 14}, {5, 14}, {6, 14}, {7, 14}, {8, 14}, {9, 14}, {10, 14},
            {11, 14}, {12, 14}, {15, 15}, {15, 15}, {15, 15}, {15, 15}, {15, 15}, {15, 15}, {15, 15}, {15, 15}, {15, 15}, {15, 15}
    };

    public static int[][] pointsForOil = {
            {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {0, 7}, {0, 8}, {0, 9}, {0, 10}, {0, 11}, {0, 12},
            {0, 13}, {0, 14}, {0, 15}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {1, 8}, {1, 9}, {1, 10}, {1, 11}, {1, 12},
            {1, 13}, {1, 14}, {1, 15},{2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5}, {2, 6}, {2, 7}, {2, 8}, {2, 9}, {2, 10}, {2, 11}, {2, 12},
            {2, 13}, {2, 14}, {2, 15}, {14, 0}, {14, 1}, {14, 2}, {14, 3}, {14, 4}, {14, 5}, {14, 6}, {14, 7}, {14, 8}, {14, 9}, {14, 10}, {14, 11}, {14, 12},
            {14, 13}, {14, 14}, {14, 15}, {15, 0}, {15, 1}, {15, 2}, {15, 3}, {15, 4}, {15, 5}, {15, 6}, {15, 7}, {15, 8}, {15, 9}, {15, 10}, {15, 11}, {15, 12},
            {15, 13}, {15, 14}, {15, 15},
    };

    // Get coordinates of oil slicks
    public static void getOilSlickNumber() {

        for(int i = 0; i < oilArray.length; i ++) {
            for(int j = 0; j < algorithmAvailablePoints.size(); j++) {
                if((algorithmAvailablePoints.get(j).getX() == astarBlockedPoints[80 + i][0]) &&
                        algorithmAvailablePoints.get(j).getY() == astarBlockedPoints[80 + i][1]) {

//                    System.out.print(j + "Dla: X: " + astarBlockedPoints[80 + i][0] + " Y: " + astarBlockedPoints[80 + i][1] + "\n");
                    oilsToDraw[i] = j;
                }
            }
        }
    }



}
