package sample;

import javafx.scene.image.Image;
import static sample.astar.oilArray.*;
import static sample.gui.graphic.*;
import static sample.gui.map.*;
import static sample.gui.cases.*;
import static sample.gui.forklift.*;

public class Controller {


    public static void prepareActionHandlers() {
        mainScene.setOnKeyPressed(event -> currentlyActiveKeys.add(event.getCode().toString()));
        mainScene.setOnKeyReleased(event -> currentlyActiveKeys.remove(event.getCode().toString()));
    }
}
