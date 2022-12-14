package com.company;

import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop (String position, boolean isBlack){
        super(position,isBlack);
        symbol = 'b';
        symbol = getSymbol();
    }

    public boolean isValidMove(String targetPos){
        // Converts position to Row and Column
        int row = ChessUtils.getRowFromPosition(getPosition());
        int col = ChessUtils.getColumnFromPosititon(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPos);
        int targetCol = ChessUtils.getColumnFromPosititon(targetPos);
        // Can't stand still
        if(targetRow == row && targetCol == col){
            return false;
        }
        // Only moves diagonally
        if(Math.abs(targetRow-row) != Math.abs(targetCol-col)){
            return false;
        }
        return true;
    }

    public ArrayList<String> passesThrough(String targetPos){
        int row = ChessUtils.getRowFromPosition(getPosition());
        int col = ChessUtils.getColumnFromPosititon(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPos);
        int targetCol = ChessUtils.getColumnFromPosititon(targetPos);

        ArrayList<String> squares = new ArrayList<>();
        if(isValidMove(targetPos)){
            int startRow = row;
            do {
                int startCol = col;
                do {
                    squares.add(ChessUtils.getPositionFromCoords(row, col));
                    startCol++;
                } while (startCol<targetCol);
                startRow++;
            } while(startRow<targetRow);
        }
        squares.remove(0);
        return squares;
    }
}