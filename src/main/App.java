package main;

import figures.Bishop;
import figures.King;

public class App {
    public static void main(String[] args) throws Exception {
        // MyFrame frame = new MyFrame();
        // Game rame = new Game();
        // rame.start();
        Figure[][] rame = new Figure[8][8];
        rame[0][1] = new King(0, 1, false);
        rame[3][4] = new Bishop(3, 4, true);
        new Render(rame);
    }
}
