package Gra.Ustawienia;

import Gra.Grafika.Colours;
import Gra.Grafika.Screen;
import Gra.Grafika.SpriteSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by Grzegorz on 2016-03-20.
 */
public class Game extends Canvas implements Runnable {

    private static final long serialversionUID = 1L;
    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 3;
    public static final String NAME = "WidelkiSI";

    private JFrame frame;

    public boolean running = false;
    public int tickCount = 0;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    private int[] colours = new int[216];



    private Screen screen;

    public InputHandler input;

    public Game(){
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void init(){
        int index = 0;

        for(int r=0; r<6;r++){
            for(int g=0; g<6;g++){
                for(int b=0; b<6;b++){
                    int rr =(r * 255/5);
                    int gg =(g * 255/5);
                    int bb =(b * 255/5);

                    colours[index++] = rr << 16 | gg << 8 | bb;
                }
            }
        }

        screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("Spritesheets\\spriteSheet.png"));
        input = new InputHandler(this);
    }

    public synchronized void start(){
        running = true;
        new Thread(this).start();
    }

    public synchronized void stop(){
        running = false;
    }

    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D/60D;

        int frames = 0;
        int ticks = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;

        init();

        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;

            while (delta >= 1) {
                ticks++;
                tick();
                delta -= 1;
                shouldRender = true;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if (shouldRender) {
                frames++;
                render();
            }
            if(System.currentTimeMillis() - lastTimer >= 1000){
                lastTimer += 1000;
                System.out.println(frames + "," + ticks);
                frames = 0;
                ticks = 0;
            }
        }
    }



    public void tick(){
        tickCount++;
        //screen.xOffset++;
        //screen.yOffset--;
        if (input.up.isPressed()){
            screen.yOffset--;
        }
        if (input.down.isPressed()){
            screen.yOffset++;
        }
        if (input.left.isPressed()){
            screen.xOffset--;
        }
        if (input.right.isPressed()){
            screen.xOffset++;
        }
    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        for(int y = 0; y < 32; y++){
            for(int x = 0; x < 32; x++){
                boolean flipX = x % 2 == 1;
                boolean flipY = y % 2 == 1;
                screen.render(x << 3, y << 3, 0, Colours.get(555, 505, 055, 550), flipX, flipY);
            }
        }

        String msg = "AAAAA";
        Font.render(msg, screen, screen.xOffset + screen.width / 2 - ((msg.length() * 8)/2), screen.yOffset + screen.height / 2, Colours.get(000, -1, -1, 555));
        for(int y = 0; y < screen.height; y++) {
            for (int x = 0; x < screen.width; x++) {
                int colourCode = screen.pixels[x + y * screen.width];
                if (colourCode < 255) {
                    pixels[x + y * WIDTH] = colours[colourCode];
                }
            }
        }
        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.dispose();
        bs.show();
    }
    public static void main(String[] args){
        new Game().start();
    }
}
