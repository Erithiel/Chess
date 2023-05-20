package figures;

import main.Figure;

public class Pown extends Figure {
    private int ID = 1;
    public Pown(int x, int y, boolean colour) {
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
        if(y!=this.getY()){
            return false;
        }

        return true;
    }
}
