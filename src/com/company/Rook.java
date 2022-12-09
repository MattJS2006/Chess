package com.company;

public class Rook extends Piece{
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
        if(Math.abs(targetRow - rowRemaining) > Math.abs(targetRow - row)){
            return false;
        }
        if(Math.abs(targetCol - colRemaining) > Math.abs(targetCol - col)){
            return false;
        }

         */
        // Checks it doesn't move diagonally
        if (row != targetRow && col != targetCol){
            return false;
        }
        return true;
    }
}

