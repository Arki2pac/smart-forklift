package sample.Neural;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by infokomes on 06.06.16.
 */

public class Neural {
    private String answear = "";

    public void Neuralrun() throws IOException, InterruptedException {
        //Read result from file
        System.out.println("Start reading result file.");
        try {
            final String result = readResultFromFile();
            answear = result;
        } catch (IOException e){
            System.out.println("Error reading result.txt");
            e.printStackTrace();
        }
    }

    private String readResultFromFile() throws IOException{
        String result = new String(Files.readAllBytes(Paths.get("/home/infokomes/Desktop/Project/smart-forklift/src/Neural/rodzaj.txt")));
        return result;
    }

    public int getRegalAfterLearning() {
        return Integer.parseInt(answear);
    }

}
