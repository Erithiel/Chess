package figures;


import main.Figure;

public class knight extends Figure {
    private int ID = 2;

    public knight(int x, int y, boolean colour) {
        super(x, y, colour);
        if(!colour){
            ID *= -1;
        }
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
    
    
}
