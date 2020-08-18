package test;

import game.BoardPosition;
import game.Queen;

public class QueenTest {
    public static void main(String[] args) {
        Queen q = new Queen(true, new BoardPosition(4, 4));
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (q.possibleMove(new BoardPosition(i, j)) == false) {
                    System.out.println(i +  "," + j + " False");
                } else {
                    System.out.println(i +  "," + j + " True");
                }
            }
        }
    }
}
