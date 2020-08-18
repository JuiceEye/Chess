package test;

import game.BoardPosition;
import game.King;

public class KingTest {
    public static void main(String[] args) {
        King k = new King(true, new BoardPosition(1, 2));
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

