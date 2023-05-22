package figures;

import java.awt.Image;

import javax.swing.ImageIcon;

import main.Board;
import main.Figure;

public class Pown extends Figure {
    private boolean isMoved = false;
    private int intColour = 1;
    private ImageIcon image;
    private ImageIcon originalImage;

    private int ID = 1;
    public Pown(int x, int y, boolean colour) {
        super(x, y, colour);
        if(!colour){
            ID *= -1;
            originalImage = new ImageIcon("src/chess/black-pown.png");
        }else{
            originalImage = new ImageIcon("src/chess/white-pown.png");
        }
        Image scaledImage = originalImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        this.image = new ImageIcon(scaledImage);
    }

    @Override
    public int getFigureID() {
        
        return this.ID;

    }

    @Override
    protected boolean isFigureMove(int x, int y) {
        int currentX = this.getX();
        int currentY = this.getY();

        // depend on color we have ID  1 or -1 we can use it to specify direction of pown
        //                                            currentY - y is 1 or -1  
        if((currentX + 1 == x || currentX -1 == x) && (currentY - y == ID)){
            return Board.getBoard()[y][x] != null && Board.getBoard()[y][x].colour != this.colour ; 
        }
        return (currentY - y == ID) && currentX == x;
    
    }

    @Override
    protected ImageIcon getImage() {
        return this.image;
    }
}
