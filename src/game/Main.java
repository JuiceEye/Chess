package game;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game g = new Game();
        ConsoleUI m = new ConsoleUI();
        List<Chessmen> chessmen = new ArrayList<>();
        g.setChessmen(chessmen);
        List<String> parameters;
        Pawn p1 = new Pawn(true, new BoardPosition(1, 2));
        Pawn p2 = new Pawn(true, new BoardPosition(2, 2));
        Pawn p3 = new Pawn(true, new BoardPosition(3, 2));
        Pawn p4 = new Pawn(true, new BoardPosition(4, 2));
        Pawn p5 = new Pawn(true, new BoardPosition(5, 2));
        Pawn p6 = new Pawn(true, new BoardPosition(6, 2));
        Pawn p7 = new Pawn(true, new BoardPosition(7, 2));
        Pawn p8 = new Pawn(true, new BoardPosition(8, 2));
        Pawn p9 = new Pawn(false, new BoardPosition(1, 7));
        Pawn p10 = new Pawn(false, new BoardPosition(2, 7));
        Pawn p11 = new Pawn(false, new BoardPosition(3, 7));
        Pawn p12 = new Pawn(false, new BoardPosition(4, 7));
        Pawn p13 = new Pawn(false, new BoardPosition(5, 7));
        Pawn p14 = new Pawn(false, new BoardPosition(6, 7));
        Pawn p15 = new Pawn(false, new BoardPosition(7, 7));
        Pawn p16 = new Pawn(false, new BoardPosition(8, 7));
        chessmen.add(p1);
        chessmen.add(p2);
        chessmen.add(p3);
        chessmen.add(p4);
        chessmen.add(p5);
        chessmen.add(p6);
        chessmen.add(p7);
        chessmen.add(p8);
        chessmen.add(p9);
        chessmen.add(p10);
        chessmen.add(p11);
        chessmen.add(p12);
        chessmen.add(p13);
        chessmen.add(p14);
        chessmen.add(p15);
        chessmen.add(p16);

        Rook r1 = new Rook(true, new BoardPosition(1, 1));
        Rook r2 = new Rook(true, new BoardPosition(8, 1));
        Rook r3 = new Rook(false, new BoardPosition(1, 8));
        Rook r4 = new Rook(false, new BoardPosition(8, 8));
        chessmen.add(r1);
        chessmen.add(r2);
        chessmen.add(r3);
        chessmen.add(r4);

        Knight n1 = new Knight(true, new BoardPosition(4, 5));
        Knight n2 = new Knight(true, new BoardPosition(7, 1));
        Knight n3 = new Knight(false, new BoardPosition(2, 8));
        Knight n4 = new Knight(false, new BoardPosition(7, 8));
        chessmen.add(n1);
        chessmen.add(n2);
        chessmen.add(n3);
        chessmen.add(n4);

        Bishop b1 = new Bishop(true, new BoardPosition(3, 1));
        Bishop b2 = new Bishop(true, new BoardPosition(6, 1));
        Bishop b3 = new Bishop(false, new BoardPosition(3, 8));
        Bishop b4 = new Bishop(false, new BoardPosition(6, 8));
        chessmen.add(b1);
        chessmen.add(b2);
        chessmen.add(b3);
        chessmen.add(b4);

        King k1 = new King(true, new BoardPosition(5, 1));
        King k2 = new King(false, new BoardPosition(5, 8));
        chessmen.add(k1);
        chessmen.add(k2);

        Queen q1 = new Queen(true, new BoardPosition(4, 1));
        Queen q2 = new Queen(false, new BoardPosition(4, 8));
        chessmen.add(q1);
        chessmen.add(q2);
        m.draw(g);

        while (true) {
            String move = sc.nextLine();
            parameters = Arrays.asList(move.split("-", 3));
            switch (move) {
                case "0-0":
                    g.handle(new Castling(true, true));
                    break;
                case "0-0-0":
                    g.handle(new Castling(true, false));
                    break;
                case "1-1":
                    g.handle(new Castling(false, true));
                    break;
                case "1-1-1":
                    g.handle(new Castling(false, false));
                    break;
                default:
                    if (parameters.size() == 2) {
                        int numOfFigure = 0;
                        boolean isItPawnEating = false;
                        Parse p = new Parse(parameters.get(0).charAt(0), (int) parameters.get(0).charAt(1) - 48, parameters.get(1).charAt(0), (int) parameters.get(1).charAt(1) - 48);
                        for (Chessmen startTileFigure : g.getChessmen()) {
                            if (startTileFigure.getIsWhite()) {
                                if (p.getEnd1() - p.getStart1() == Math.abs(1) && p.getEnd2() - p.getStart2() == 1) {
                                    if (startTileFigure.getPosition().getVertical() == p.getStart1() && startTileFigure.getPosition().getHorizontal() == p.getStart2() && startTileFigure.getClass().equals(Pawn.class)) {
                                        for (Chessmen endTileFigure : g.getChessmen()) {
                                            if (endTileFigure.getPosition().getVertical() == p.getEnd1() && endTileFigure.getPosition().getHorizontal() == p.getEnd2() && endTileFigure.getIsWhite() != startTileFigure.getIsWhite()) {
                                                numOfFigure = chessmen.indexOf(endTileFigure);
                                                startTileFigure.setPosition(new BoardPosition(p.getEnd1(), p.getEnd2()));
                                                isItPawnEating = true;
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (p.getEnd1() - p.getStart1() == Math.abs(1) && p.getEnd2() - p.getStart2() == -1) {
                                    if (startTileFigure.getPosition().getVertical() == p.getStart1() && startTileFigure.getPosition().getHorizontal() == p.getStart2() && startTileFigure.equals(Pawn.class)) {
                                        for (Chessmen endTileFigure : g.getChessmen()) {
                                            if (endTileFigure.getPosition().getVertical() == p.getEnd1() && endTileFigure.getPosition().getHorizontal() == p.getEnd2() && endTileFigure.getIsWhite() != startTileFigure.getIsWhite()) {
                                                chessmen.remove(endTileFigure);
                                                startTileFigure.setPosition(new BoardPosition(p.getEnd1(), p.getEnd2()));
                                                isItPawnEating = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (!isItPawnEating) {
                            g.handle(new StandardMove(new BoardPosition(p.getStart1(), p.getStart2()), new BoardPosition(p.getEnd1(), p.getEnd2())));
                        } else {
                            g.getChessmen().remove(numOfFigure);
                        }
                    }
                    if (parameters.size() == 3) {
                        Parse p = new Parse(parameters.get(0).charAt(0), (int) parameters.get(0).charAt(1) - 48, parameters.get(1).charAt(0), (int) parameters.get(1).charAt(1) - 48, parameters.get(2));
                        g.handle(new PawnTransformation(new BoardPosition(p.getStart1(), p.getStart2()), new BoardPosition(p.getEnd1(), p.getEnd2()), p.getTransformation()));
                    }
                    break;
            }
            m.draw(g);
        }
    }
}

