package sample.gui;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Random;

import static sample.astar.OilArray.*;
import static sample.gui.Gui.*;
import static sample.gui.Cases.*;
import static sample.gui.Forklift.*;
import static sample.Main.*;

/**
 * Created by infokomes on 03.06.16.
 */
public class Graphic {

    // Etc
    public static Image background;
    public static Image conveyor;
    public static Image cover;


    public static void loadGraphics() {
        forklift = new Image("img/forklift.png");
        forklift2 = new Image("img/forklift2.png");
        background = new Image("img/background.png");
        conveyor = new Image("img/conveyor.png");
        cover = new Image("img/cover.png");
        //Cases
        caseOne = new Image("img/case1.png");    // Metal
        caseTwo = new Image("img/case2.png");   // Paper
        caseThree = new Image("img/case5.png"); //Gas
        caseFour = new Image("img/case3.png"); //Wood
        caseFive = new Image("img/case4.png"); //Flemable
        caseSix = new Image("img/case6.png"); //Cool
        //Extra
        caseSeven = new Image("img/case7.png");
        caseEight = new Image("img/case8.png");
        oilSlick = new Image("img/oil.png");
    }
//    String ActualProperties[] = new String[4];
//    for (int i = 0; i < 4; i++){
//        ActualProperties[i] = knowledgeBase.getKnowledgeBase().get(ActualKey).get(i);
//        System.out.println(ActualProperties[i]);
//    }
    //Gui
    public static void setStatement() {
        Font theFont = Font.font("Helvetica", FontWeight.BOLD, 16);
        graphicsContext.setFont(theFont);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(1);

        graphicsContext.fillText("X: " + (int)actualPositionW, 800, 50);
        graphicsContext.fillText("Y: " + (int)actualPositionH, 900, 50);

        graphicsContext.fillText("Output:", 800, 90);
        graphicsContext.fillText("Actual Case: "+ RandCaseName[RandTypeCase], 800, 130);
        Font theFont2 = Font.font("Helvetica", FontWeight.BOLD, 14);
        graphicsContext.setFont(theFont2);
        graphicsContext.fillText("Actual Properities 1: "+ ActualPropertiesName[0], 800, 170);
        graphicsContext.fillText("Actual Properities 2: "+ ActualPropertiesName[1], 800, 200);
        graphicsContext.fillText("Actual Properities 3: "+ ActualPropertiesName[2], 800, 230);
        graphicsContext.fillText("Actual Properities 4: "+ SpecialName, 800, 260);

        graphicsContext.fillText("Regal Correctly Properities 1: ", 800, 300);
        graphicsContext.fillText( RegalGood[0], 800, 330);
        graphicsContext.fillText("Regal Correctly Properities 2: ", 800, 360);
        graphicsContext.fillText( RegalGood[1], 800, 390);
        graphicsContext.fillText("Regal Correctly Properities 3: ", 800, 420);
        graphicsContext.fillText( RegalGood[2], 800, 450);
        graphicsContext.fillText("Regal Correctly Properities 4: ", 800, 480);
        graphicsContext.fillText( RegalGood[3], 800, 510);


        graphicsContext.setFont(theFont);
        graphicsContext.fillText("Actual CaseType: "+ TypeCase, 800, 550); // TypeCase CaseTypeName
        graphicsContext.fillText("Actual RegalType: "+ RegalTypeName, 800, 590);

    }

    public static void conveyorAnimated() {
        graphicsContext.drawImage(conveyor, 5, conveyorPos - 600);
        graphicsContext.drawImage(conveyor, 5, conveyorPos);
        conveyorPos = conveyorPos + 0.5;
        graphicsContext.drawImage(cover, 5, 618);
        if (conveyorPos >= 600) {
            conveyorPos = 0;
        }
    }
}
