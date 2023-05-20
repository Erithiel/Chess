package main;


public abstract class Figure {
    private int X,Y;
    private int figureID;
    public int colour;

    public Figure(int x, int y, boolean colour) {
        X = x;
        Y = y;
        this.colour = colour ? 1 : -1;
    }

    abstract public int getFigureID();

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setCor(int x,int y) {
        X = x;
        Y =y;
    }

    

    protected abstract boolean isFigureMove(int x, int y);
   
}
