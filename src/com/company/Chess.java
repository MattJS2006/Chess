package com.company;

import java.util.Scanner;

public class Chess {
    private Piece[][] board;

    public Chess(){
        board = new Piece[8][8];
        // Create Pieces
        for (int c=0; c<8; c++){
            board[1][c] = new Piece(1, c, false);
            board[6][c] = new Piece(6, c, true);
        }
    }

    public void display(){
        for(int r=0; r<8; r++){
            for(int c=0; c<8; c++){
                if(board[r][c] != null){
                    System.out.print(board[r][c].getSymbol() + " ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
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
        }else{
            System.out.println("You can't do that!");
        }
    }
}
