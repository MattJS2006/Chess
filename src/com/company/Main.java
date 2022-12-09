package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome to Chess:");
        Piece test = new Piece(0,0,true);
        System.out.println(test.getPosition() + " is " + test.getSymbol());
        test = new Piece("C3", false);
        System.out.println(test.getPosition() + " is " + test.getSymbol());
        Chess game = new Chess();
        boolean win = false;
        while (win != true) {
            game.display();
            game.move();
        }
    }
}
