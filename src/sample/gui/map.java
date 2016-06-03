package sample.gui;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import sample.astar.AstarPoints;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by infokomes on 03.06.16.
 */
public class map {

    public  static ExecutorService mainPool = Executors.newFixedThreadPool(1);
    public  static ExecutorService pool = Executors.newFixedThreadPool(1);
    public  static int WIDTH = 1800;
    public  static int HEIGHT = 800;
    public  static Scene mainScene;

    public static GraphicsContext graphicsContext;
    public static HashSet<String> currentlyActiveKeys = new HashSet<String>();
    public static Map<Integer, AstarPoints> algorithmAvailablePoints = new HashMap<Integer, AstarPoints>();
}
