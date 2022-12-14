package com.company;

import java.util.ArrayList;

public class Piece {
    private int row;
    private int column;
    private boolean isBlack;
    protected char symbol;

    public Piece(int row, int column, boolean isBlack) {
        this.row = row;
        this.column = column;
        this.isBlack = isBlack;
        symbol = 'x'; // Dummy Symbol, shouldn't ever appear on board
    }

    public Piece(String position, boolean isBlack) {
        this.isBlack = isBlack;
        symbol = 'x';
        row = ChessUtils.getRowFromPosition(position);
        column = ChessUtils.getColumnFromPosititon(position);
    }

    public char getSymbol(){
        if (isBlack){
            return Character.toLowerCase(symbol);
        }
        return Character.toUpperCase(symbol);
    }

    // Convert row and column value to Chess notation e.g. 0,0 -> A8
    public String getPosition(){
        return ChessUtils.columnToLetter(column) + ChessUtils.rowToNumber(row);
    }

    public boolean isValidMove(String targetPos){
        // Can't stand still
        if(getPosition().equals(targetPos)){
            return false;
        }
        return true;
    }

    //Set a new position for a Piece
    public void setPosition(String newPosition){
        row = ChessUtils.getRowFromPosition(newPosition);
        column = ChessUtils.getColumnFromPosititon(newPosition);
    }

    // return an empty list by default
    public ArrayList<String> passesThrough(String position) {
        return new ArrayList<>();
    }

}