package figures;
import main.Figure;

import java.awt.Image;

import javax.swing.ImageIcon;

import main.Board;

public class Queen extends Figure {
    private int ID = 10;
    private ImageIcon image;
    private ImageIcon originalImage;


    public Queen(int x, int y, boolean colour) {
        super(x, y, colour);
        if(!colour){
            ID *= -1;
            originalImage = new ImageIcon("src/chess/black-queen.png");
        }else{
            originalImage = new ImageIcon("src/chess/white-queen.png");
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

        // queen logic is simply combination of rook and bishop 
        // this codes are from Bishop.java and Rook.java 

        boolean verifierX = x != this.getX();
        boolean verifierY = y != this.getY();
        
        // rook a like 
        boolean isRookLike = verifierX ^ verifierY;
        
        if(isRookLike){
            return isPathBlockedForRookLike(x,y,verifierX);
        }
        // bishob a like 
        double verifier = (this.getX() - x) / (this.getY() - y);
        boolean isBishopLike = verifier == 1 || verifier == -1 ;

        if (isBishopLike){
            return isPathBlockedForBishopLike(x, y,(int) verifier);
        }
        
        return false;
    }


    private boolean isPathBlockedForRookLike(int x, int y , boolean verifierX ){
        int corX,corY;
        int currentX = this.getX();
        int currentY = this.getY();

        int forX = verifierX ? 1:0;
        int forY = verifierX ? 0:1;

        int iterator = x*forX + y*forY;
        int iterator1= this.getX()*forX + this.getY()*forY;

        int dir = iterator > iterator1 ? 1:-1;
        int absIterator = Math.abs(iterator1-iterator);
        for (int i = 1; i <=absIterator; i++) {
            corX = currentX + i * forX * dir;
            corY = currentY + i * forY * dir;
            if (Board.getBoard()[corY][corX] != null  ) {
                return Board.getBoard()[corY][corX].colour != this.colour ;
            }
        }
        return true;
    }

    private boolean isPathBlockedForBishopLike(int x, int y, int verifier) {
        int currentX = this.getX();
        int currentY = this.getY();
        int dir = this.getX() < x ? 1: -1;
         while (currentX != x && currentY != y) {
            
            currentX += dir;
            currentY += dir*verifier;
            if (Board.getBoard()[currentY][currentX] != null  ) {
                return Board.getBoard()[currentY][currentX].colour != this.colour && currentX == x;
            }
            }
        return true;
    }

    @Override
    protected ImageIcon getImage() {
        return this.image;
    }
    
}
