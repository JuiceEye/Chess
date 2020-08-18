package test;

import game.BoardPosition;
import game.Bishop;

public class BishopTest {
    public static void main(String[] args) {
        Bishop b = new Bishop(true, new BoardPosition(4, 4));
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (b.possibleMove(new BoardPosition(i, j)) == false) {
                    System.out.println(i + "," + j + " False");
                } else {
                    System.out.println(i + "," + j + " True");
                }
            }
        }
    }
}
