package com.company;

public class Knight extends Piece{
    public Knight(String position, boolean isBlack){
        super(position,isBlack);
        symbol = 'n';
        symbol = getSymbol();
    }

    // Knights can move in L shape
    public boolean isValidMove(String targetPos){
        if(super.isValidMove(targetPos) == false){
            return false;
        }
        // convert position to row and column
        int row = ChessUtils.getRowFromPosition(getPosition());
        int col = ChessUtils.getColumnFromPosititon(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPos);
        int targetCol = ChessUtils.getColumnFromPosititon(targetPos);
        // Can move L shape in any direction
        // either 2 rows and 1 column
        // or 2 columns and 1 row
        int rowDifference = Math.abs(row - targetRow);
        int colDifference = Math.abs(col - targetCol);
        if ((rowDifference == 2 && colDifference == 1) ||
           (rowDifference == 1 && colDifference == 2)) {
            return true;
        }
        return false;
    }
}
