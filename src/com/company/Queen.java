package com.company;

public class Queen extends Piece{
    public Queen (String position, boolean isBlack){
        super(position,isBlack);
        symbol = 'q';
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
        // Can move diagonally
        if(Math.abs(targetRow-row) == Math.abs(targetCol-col)){
            return true;
        }
        // Can move in straight lines
        if (row == targetRow || col == targetCol){
            return true;
        }
        return false;
    }
}
