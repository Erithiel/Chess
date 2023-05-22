package figures;

import main.Board;
import main.Figure;

public class Rook extends Figure{
    private int ID = 5;


    public Rook(int x, int y, boolean colour) {
        super(x, y, colour);
        if(!colour){
            ID *= -1;
        }
    }

    @Override
    public int getFigureID() {
        return this.ID;

    }

    @Override
    protected boolean isFigureMove(int x, int y) {
        boolean verifierX = x != this.getX();
        boolean verifierY = y != this.getY();
        boolean isRightMove = verifierX ^ verifierY;
        
        if(!isRightMove){
            return false;
        }
        return isPathBlocked(x,y,verifierX);
    }

    private boolean isPathBlocked(int x, int y , boolean verifierX ){
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
    
}
