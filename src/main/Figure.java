package main;

import javax.swing.ImageIcon;

public abstract class Figure {
    private int X,Y;
    private int figureID;
    public boolean colour;

    public Figure(int x, int y, boolean colour) {
        X = x;
        Y = y;
        this.colour = colour;
    }

    abstract public int getFigureID();

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public boolean getColour(){
        return this.colour;
    }

    public void setCor(int x,int y) {
        X = x;
        Y =y;
    }

    
    protected abstract ImageIcon getImage();
    protected abstract boolean isFigureMove(int x, int y);
   
}
