package sample;

import static sample.gui.Gui.*;

public class Controller {


    public static void prepareActionHandlers() {
        mainScene.setOnKeyPressed(event -> currentlyActiveKeys.add(event.getCode().toString()));
        mainScene.setOnKeyReleased(event -> currentlyActiveKeys.remove(event.getCode().toString()));
    }
}
