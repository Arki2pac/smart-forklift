package sample.DecisionTree;

/**
 * Created by infokomes on 06.06.16.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DecisionTree {
    private static final String CURRENT_PATH = getCurrentPath();
    private String[] cmd = {};
    private String answear = "";
    private String regal = "";
    private String regalAfterLearning = "";

    public DecisionTree(final String... params){
        this.cmd = params;
    }

    public void run() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(cmd);
        System.out.println("Starting process...");
        Process process = pb.start();
        process.waitFor();
        System.out.println("Process ended.");
        //Read result from file
        System.out.println("Start reading result file.");
        try {
            final String[] result = readResultFromFile();
            answear = result[0];
            regal = result[1];
            regalAfterLearning = result[2];
        } catch (IOException e){
            System.out.println("Error reading result.txt");
            e.printStackTrace();
        }
    }

    private String[] readResultFromFile() throws IOException{
        String result = new String(Files.readAllBytes(Paths.get(CURRENT_PATH + "/result.txt")));
        return result.split(",");
    }

    private static String getCurrentPath() {
        return Paths.get(".").toAbsolutePath().normalize().toString();
    }


    public int getRegalAfterLearning() {
        return Integer.parseInt(regalAfterLearning);
    }

    public String getAnswear() {
        return answear;
    }

    public String getRegal() {
        return regal;
    }
}

