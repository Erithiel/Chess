package main;
import javax.swing.*;
import java.awt.*;

public class Render extends JFrame {
    private final int boardSize = 8;
    private JLabel[][] grid;

    public Render(Figure[][] figures) {
        setLayout(new GridLayout(boardSize, boardSize));
        grid = new JLabel[boardSize][boardSize];

        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                grid[i][j] = new JLabel();
                grid[i][j].setOpaque(true);

                // Color the chess board
                if((i + j) % 2 == 0) {
                    grid[i][j].setBackground(Color.WHITE);
                } else {
                    grid[i][j].setBackground(Color.GRAY);
                }

                // Place the figures on the chess board
                if(figures[i][j] != null) {
                    grid[i][j].setIcon(figures[i][j].getImage());
                }

                add(grid[i][j]);
            }
        }

        setPreferredSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

