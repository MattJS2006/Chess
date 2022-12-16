package com.company;

public class Pawn extends Piece{
    boolean notMoved = true;
    boolean capture = false;

    public Pawn(String position, boolean isBlack){
        super(position,isBlack);
        symbol = 'p';
        symbol = getSymbol();
    }

    public boolean isValidMove(String targetPos) {
        // Converts position to Row and Column
        int row = ChessUtils.getRowFromPosition(getPosition());
        int col = ChessUtils.getColumnFromPosititon(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPos);
        int targetCol = ChessUtils.getColumnFromPosititon(targetPos);
        capture = Chess.isCapture(getPosition(),targetPos);
        // Can't stand still
        if(targetRow == row && targetCol == col) {
            return false;
        }
        if (col != targetCol){
            return false;
        }
        if(notMoved){
            if(Math.abs(targetRow-row) == 2) {
                notMoved = false;
                return true;
            }
        }
        if (Math.abs(targetRow-row) == 1){
            notMoved = false;
            return true;
        }
        return false;
    }
}
