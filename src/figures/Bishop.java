package figures;

import main.Board;
import main.Figure;

public class Bishop extends Figure {
    private int ID = 3;

    public Bishop(int x, int y, boolean colour) {
        super(x, y, colour);
        if(!colour){
            ID *= -1;
        }
    }

    @Override
    protected boolean isFigureMove(int x, int y) {
        double verifier = (this.getX() - x) / (this.getY() - y);
        if (verifier == 1 || verifier == -1) {
           return isPathBlocked(x, y,(int) verifier);
        }
        return false;
    }

    private boolean isPathBlocked(int x, int y, int verifier) {
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
    public int getFigureID() {
        return ID;
    }

}
