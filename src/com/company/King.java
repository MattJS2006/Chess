package com.company;

public class King extends Piece{
    private boolean inCheck;

    public King(String position, boolean isBlack){
        super(position,isBlack);
        symbol = 'k';
        // symbol = getSymbol();
        inCheck = false;
    }

    // Kings can move in 1 square any direction
    public boolean isValidMove(String targetPos){
        String pos = getPosition();
        int row = ChessUtils.getRowFromPosition(pos);
        int col = ChessUtils.getColumnFromPosititon(pos);
        int targetRow = ChessUtils.getRowFromPosition(targetPos);
        int targetCol = ChessUtils.getColumnFromPosititon(targetPos);
        if (board[targetRow][targetCol] == board[row+1][col] || board){
    }
}
