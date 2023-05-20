package main;

import java.util.List;
import java.util.Scanner;

import figures.Bishop;
import figures.King;
import figures.Rook;
import figures.knight;

public class Game {

    private Board chessBoard;
    private Figure[][] board;

    public Game(Board chessBoard) {
        this.chessBoard = chessBoard;
        this.board = this.chessBoard.getBoard();
    }

    public Game() {
        this.chessBoard = new Board();
        this.board = this.chessBoard.getBoard();
    }

    public void start() {
        int X = -1;
        int Y = -1;

        chessBoard.changeBoard(1, 0, new knight(1, 0, false));
        chessBoard.changeBoard(5, 5, new Bishop(5, 5, true));
        chessBoard.changeBoard(3, 3, new King(3, 3, false));
        chessBoard.changeBoard(4,4,new Rook(4,4, true));
        chessBoard.printBoard();

        while (true) {


            // first Move
            X = input("X:");
                if (X == -1)
                    return;
            Y = input("Y:");

            //checking if the cordinats are valid 
            while (!isFiguresCordinates(X, Y)) {
                chessBoard.printBoard();
                System.out.println( "It is not valid cordinates of figure pls try again!");
                X = input("X:");
                if (X == -1)
                    return;
                Y = input("Y:");
            }

            // making the move 
            int newX = input("new X");
            int newY = input("new Y");


            // moving the figure on the provided cordinates
            if (board[Y][X].isFigureMove(newX, newY)) {
                chessBoard.getBoard()[Y][X].setCor(newX, newY);
                chessBoard.getBoard()[newY][newX] = chessBoard.getBoard()[Y][X];
                chessBoard.getBoard()[Y][X] = null;
                chessBoard.printBoard();

            } else {
                chessBoard.printBoard();
                System.out.println("illegal move");
            }
        }

    }

    private boolean isCheck(int kingX, int kingY, List<Figure> listOfFigures){
        for (Figure figure : listOfFigures) {
            if(figure.isFigureMove(kingX, kingY))
                return true;
        }
        return false;
    }

    private boolean isFiguresCordinates(int x, int y) {
        if (x > board.length - 1 || x < 0 || y > board.length - 1 || y < 0)
            return false;
        if (board[y][x] == null)
            return false;

        return true;
    }



    public int input(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

}
