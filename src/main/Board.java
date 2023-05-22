package main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static Figure[][] board;
    private List<Figure> allFiguresOnBoard = new ArrayList<>();
    private List<Figure> allBlackFigures = new ArrayList<>();
    private List<Figure> allWhiteFigures = new ArrayList<>();
    
    
    
    public Board() {
        this.board = new Figure[8][8];
    }

    //getters
    public static Figure[][] getBoard(){
        return board;
    }
    private int getIDFromBoard(Figure figure){
        return figure == null ? 0: figure.getFigureID();
    }
    public List<Figure> getallFiguresOnBoard(){
        return allFiguresOnBoard;
    }
    public List<Figure> getAllBlackFigures(){
        return this.allBlackFigures;
    }
    public List<Figure> getAllWhiteFigures(){
        return this.allWhiteFigures;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j == board.length - 1) {
                    System.out.println("|"+ getIDFromBoard(board[i][j]) + "|");
                } else {
                    System.out.print("|"+getIDFromBoard(board[i][j]) );
                }
            }
        }
    }
   

    public void changeBoard(int x,int y , Figure figure){
        allFiguresOnBoard.add(figure);
        
        board[y][x] = figure;
        if(figure.colour){
            allWhiteFigures.add(figure);
        }else{
            allBlackFigures.add(figure);
        }
    }

}
