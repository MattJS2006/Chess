package com.company;

public class King extends Piece{
    private boolean inCheck;

    public King(String position, boolean isBlack){
        super(position,isBlack);
        symbol = 'k';
        symbol = getSymbol();
        inCheck = false;
    }

    // Kings can move in 1 square any direction
    public boolean isValidMove(String targetPos){
        // convert position to row and column
        int row = ChessUtils.getRowFromPosition(getPosition());
        int col = ChessUtils.getColumnFromPosititon(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPos);
        int targetCol = ChessUtils.getColumnFromPosititon(targetPos);
        // Can't stand still
        if(targetRow == row && targetCol == col){
            return false;
        }
        // Can only move 1 square in any diretion
        if (Math.abs(row - targetRow) > 1){
            return false;
        }
        if(Math.abs(col - targetCol) > 1){
            return false;
        }
        return true;
    }
}
