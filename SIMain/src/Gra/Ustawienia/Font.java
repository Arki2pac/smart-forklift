package Gra.Ustawienia;

import Gra.Grafika.Screen;

/**
 * Created by Grzegorz on 2016-04-09.
 */
public class Font {

    private static String chars = "A";

    public static void render(String msg, Screen screen, int x, int y, int colour){
        msg = msg.toUpperCase();
        for (int i = 0; i < msg.length(); i++){
            int charIndex = chars.indexOf(msg.charAt(i));
            if(charIndex >= 0) screen.render(x + (i*8), y, charIndex + 30 * 16, colour);
        }
    }
}
