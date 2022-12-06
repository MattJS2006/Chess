package com.company;

public class ChessUtils {

    // e.g. For a position A8 return row num 7
    public static int getRowFromPosition(String pos) {
        char posChar = pos.toCharArray()[1]; // "A8" -> "8"
        int rowNumber = Character.getNumericValue(posChar); // "8" -> 8
        return rowNumber - 1;
    }

    // e.g. For position A8 return column 0
    public static int getColumnFromPosititon(String pos) {
        char colChar = pos.toCharArray()[0]; // "A8" -> "A"
        int asciiValue = colChar;
        int colNumber = asciiValue - (int) 'A';
        return colNumber;
    }

    public static String columnToLetter(int c){
        char letter = (char)('A' + c);
        return Character.toString(letter);
    }

    public static String rowToNumber(int r){
        return Integer.toString(r+1);
    }

}
