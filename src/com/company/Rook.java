package com.company;

import java.util.ArrayList;

public class Rook extends Piece{
    private boolean hasCastled;

    public Rook(String position, boolean isBlack) {
        super(position, isBlack);
        symbol = 'r';
        symbol = getSymbol();
    }

    public boolean isValidMove(String targetPos) {
        // Converts position to Row and Column
        int row = ChessUtils.getRowFromPosition(getPosition());
        int col = ChessUtils.getColumnFromPosititon(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPos);
        int targetCol = ChessUtils.getColumnFromPosititon(targetPos);
        // Can't stand still
        if(targetRow == row && targetCol == col) {
            return false;
        }
        /* Checks it doesn't move more than board length
        int colRemaining = 8 - col;
        int rowRemaining = 8 - row;
        if(rowRemaining < Math.abs(targetRow - row)){
            return false;
        }
        if(colRemaining < Math.abs(targetCol - col)){
            return false;
        }
        */
        // Checks it doesn't move diagonally
        if (row != targetRow && col != targetCol){
            return false;
        }
        return true;
    }

    // Return a list of all positions the piece moves through
    // excluding the start (and end?)
    public ArrayList<String> passesThrough(String targetPos){
        int row = ChessUtils.getRowFromPosition(getPosition());
        int col = ChessUtils.getColumnFromPosititon(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPos);
        int targetCol = ChessUtils.getColumnFromPosititon(targetPos);

        ArrayList<String> squares = new ArrayList<>();
        if(isValidMove(targetPos)){
            int startRow = row+1;
            do {
                int startCol = col+1;
                do {
                    squares.add(ChessUtils.getPositionFromCoords(row, col));
                    startCol++;
                } while (startCol<targetCol);
                startRow++;
            } while(startRow<targetRow);
        }
        return squares;
    }
}

