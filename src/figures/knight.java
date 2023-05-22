package figures;


import java.awt.Image;

import javax.swing.ImageIcon;

import main.Figure;

public class knight extends Figure {
    private int ID = 2;
    private ImageIcon image;
    private ImageIcon originalImage;
    public knight(int x, int y, boolean colour) {
        super(x, y, colour);
        if(!colour){
            ID *= -1;
            originalImage = new ImageIcon("src/chess/black-knight.png");
        }else{
            originalImage = new ImageIcon("src/chess/white-knight.png");
        }
        Image scaledImage = originalImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        this.image = new ImageIcon(scaledImage);
    }
    //chaks if figur can move in cordinats x and y and then game will move 
    // the figure if that move is lelgal

    @Override
    protected
    boolean isFigureMove(int x, int y) {
        return Math.pow((double)this.getX()-x,2) + Math.pow((double)this.getY()-y,2) == 5;
    }

    @Override
    public int getFigureID() {
        return ID;
    }

    @Override
    protected ImageIcon getImage() {
        return this.image;
    }
    
    
}
