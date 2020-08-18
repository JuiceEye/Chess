package test;

import game.BoardPosition;
import game.Rook;

public class RookTest {
    public static void main(String[] args) {
        Rook r = new Rook(true, new BoardPosition(1, 2));
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (r.possibleMove(new BoardPosition(i, j)) == false) {
                    System.out.println(i +  "," + j + " False");
                } else {
                    System.out.println(i +  "," + j + " True");
                }
            }
        }
    }
}
