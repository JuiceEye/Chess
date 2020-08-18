package test;

import game.*;

import java.util.ArrayList;
import java.util.List;

import game.Chessmen;

public class CastlingTest {
    public static void main(String[] args) {
        Game g = new Game();
        ConsoleUI n = new ConsoleUI();
        List<Chessmen> chessmen = new ArrayList<>();
        g.setChessmen(chessmen);
        Rook r2 = new Rook(true, new BoardPosition(8, 1));
        Rook r4 = new Rook(false, new BoardPosition(8, 8));

        chessmen.add(r2);
        chessmen.add(r4);


        King k1 = new King(true, new BoardPosition(5, 1));
        King k2 = new King(false, new BoardPosition(5, 8));
        chessmen.add(k1);
        chessmen.add(k2);

        n.draw(g);
        g.handle(new Castling(true, true));
        g.handle(new Castling(false, true));
        n.draw(g);
    }
}