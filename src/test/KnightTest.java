package test;

import game.BoardPosition;
import game.Knight;

public class KnightTest {
    public static void main(String[] args) {
        Knight k = new Knight(true, new BoardPosition(5, 5));
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (k.possibleMove(new BoardPosition(i, j)) == false) {
                    System.out.println(i + "," + j + " False");
                } else {
                    System.out.println(i + "," + j + " True");
                }
            }
        }
    }
}
