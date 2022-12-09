package com.company;

import java.util.Scanner;

public class Chess {
    private Piece[][] board;
    char[] blackSetup = {'♜', '♞', '♝', '♛', '♚', '♝', '♞', '♜'};
    char[] whiteSetup = {'♖', '♘', '♗', '♔', '♕', '♗', '♘', '♖'};

    public Chess(){
        board = new Piece[8][8];
        // Create Pieces
        for (int c=0; c<8; c++){
            board[1][c] = new Piece(1, c, false);
            board[6][c] = new Piece(6, c, true);
        }
        board[0][4] = new King("E1",true);
        board[7][4] = new King("E8", false);
        board[0][0] = new Rook("A1", true);
        board[0][7] = new Rook("H1", true);
        board[7][0] = new Rook("A8", false);
        board[7][7] = new Rook("H8", false);

    }

    public void display(){
        for(int i=0; i<19; i++) {
            System.out.print("-");
        }
        System.out.println("");
        int asciiNum = 'A';
        System.out.print("  ");
        for(int i=0; i<8; i++) {
            char asciiLetter = (char) asciiNum;
            System.out.print(asciiLetter + " ");
            asciiNum = asciiNum + 1;
        }
        System.out.println("");
        for(int i=0; i<19; i++) {
            System.out.print("-");
        }
        System.out.println("");
        for(int r=0; r<8; r++){
            System.out.print("| ");
            for(int c=0; c<8; c++){
                if(board[r][c] != null){
                    System.out.print(board[r][c].getSymbol() + " ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("| " + (r+1));
            System.out.println();
        }
        for(int i=0; i<19; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    // Takes chess coordinates e.g. A8 and returns piece at location
    public Piece getPieceAt(String pos){
        int row = ChessUtils.getRowFromPosition(pos);
        int col = ChessUtils.getColumnFromPosititon(pos);
        return board[row][col];
    }

    // Take input from user and validate
    public void move(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the piece to move:");
        String startPosition = input.nextLine();
        System.out.print("Enter the square to move to:");
        String endPosition = input.nextLine();
        Piece toMove = getPieceAt(startPosition);
        boolean validMove = false;
        if (toMove != null){
            validMove = toMove.isValidMove(endPosition);
        }
        if (validMove){
            System.out.println(toMove.getSymbol() + " moves to " + endPosition);
            // Update board
            int startRow = ChessUtils.getRowFromPosition(startPosition);
            int startCol = ChessUtils.getColumnFromPosititon(startPosition);
            int targetRow = ChessUtils.getRowFromPosition(endPosition);
            int targetCol = ChessUtils.getColumnFromPosititon(endPosition);
            board[targetRow][targetCol] = board[startRow][startCol];
            board[startRow][startCol] = null;
        }else{
            System.out.println("You can't do that!");
        }
    }
}
