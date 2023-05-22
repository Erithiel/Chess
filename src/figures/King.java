package figures;
import java.awt.Image;

import javax.swing.ImageIcon;

import main.Board;
import main.Figure;


public class King extends Figure {
    private int ID = 6;
    private ImageIcon image;

    public King(int x, int y,boolean colour) {
        super(x, y, colour);
        if(!colour){
            ID *= -1;
            ImageIcon originalImage = new ImageIcon("src/chess/black-king.png");
            Image scaledImage = originalImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            this.image = new ImageIcon(scaledImage);
        }else{
            ImageIcon originalImage = new ImageIcon("src/chess/white-king.png");
            Image scaledImage = originalImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            this.image = new ImageIcon(scaledImage);
        }
    }

    @Override
    protected boolean isFigureMove(int x, int y) {
        //the length of move should setisfy this properties:
        // the verifier should be 2 or 1 for king otherwise it will not be corecct move 
        double verifier =Math.pow((double)this.getX()-x,2)+ Math.pow((double)this.getY()-y,2);

        return (verifier == 2 || verifier == 1)
                && (Board.getBoard()[y][x] == null || Board.getBoard()[y][x].colour != colour);
    }

    @Override
    public int getFigureID() {
        return ID;
    }

    @Override
    protected ImageIcon getImage() {
        return image;
    }
    
}
