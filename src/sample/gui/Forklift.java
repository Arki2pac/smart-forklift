package sample.gui;

import javafx.scene.image.Image;

/**
 * Created by infokomes on 03.06.16.
 */
public class Forklift {

    // Forklifts
    public static Image forklift;
    public static Image forklift2;

    // actual case on Forklift
    public static Image actualCase;
    public  static int locOfCases[] = new int[20];

    // Forklift Speed
    public static int movingTicks = 3;

    // state if Forklift is busy
    public static Boolean caseNotToSpawn = false;

    // number of case that is on Forklift
    public static int numberOfCase;

}
