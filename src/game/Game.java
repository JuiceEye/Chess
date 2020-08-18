package game;

import java.util.List;

public class Game {
    private List<Chessmen> chessmen;

    public List<Chessmen> getChessmen() {
        return chessmen;
    }

    private int numOfFigure;

    public void setChessmen(List<Chessmen> chessmen) {
        this.chessmen = chessmen;
    }

    public void handle(Move m) {
        if (m instanceof StandardMove) {
            StandardMove sm = (StandardMove) m;
            pieceMoving(sm.getStart(), sm.getEnd());
        }
        if (m instanceof Castling) {
            boolean castlingIsPossible = false;
            boolean isTileFree = true;
            Castling cs = (Castling) m;
            if (cs.isWhite) {
                if (cs.isShort) {   //Если рокировка белая и короткая:
                    for (Chessmen n : getChessmen()) {
                        if ((n.getPosition().getVertical() == Castling.ROOK_FUTURE_TILE_SHORT_VERTICAL && n.getPosition().getHorizontal() == Castling.WHITE_ROOK_FUTURE_TILE_HORIZONTAL)
                                || (n.getPosition().getVertical() == Castling.KING_FUTURE_TILE_SHORT_VERTICAL && n.getPosition().getHorizontal() == Castling.WHITE_KING_FUTURE_TILE_HORIZONTAL)) {
                            isTileFree = false;
                            break;
                        }
                    }
                    boolean possibleCastlingRook = false;
                    boolean possibleCastlingKing = false;
                    for (Chessmen n : getChessmen()) {
                        if (isTileFree && n.getClass().equals(King.class) && n.getIsFirstMove() && n.getPosition().getVertical() == 5 && n.getPosition().getHorizontal() == 1 && n.getIsWhite()) {
                            possibleCastlingKing = true;
                        }
                        if (isTileFree && n.getClass().equals(Rook.class) && n.getIsFirstMove() && n.getPosition().getVertical() == 8 && n.getPosition().getHorizontal() == 1 && n.getIsWhite()) {
                            possibleCastlingRook = true;
                        }
                        if (possibleCastlingKing && possibleCastlingRook) {
                            for (Chessmen l : getChessmen()) {
                                if (l.getClass().equals(King.class) && l.getIsWhite() && l.getPosition().getVertical() == 5 && l.getPosition().getHorizontal() == 1) {
                                    l.setPosition(new BoardPosition(Castling.KING_FUTURE_TILE_SHORT_VERTICAL, Castling.WHITE_KING_FUTURE_TILE_HORIZONTAL));
                                    castlingIsPossible = true;
                                }
                                if (l.getClass().equals(Rook.class) && l.getIsWhite() && l.getPosition().getVertical() == 8 && l.getPosition().getHorizontal() == 1) {
                                    l.setPosition(new BoardPosition(Castling.ROOK_FUTURE_TILE_SHORT_VERTICAL, Castling.WHITE_ROOK_FUTURE_TILE_HORIZONTAL));
                                    castlingIsPossible = true;
                                }
                            }
                        }
                    }
                } else {  //Если рокировка белая и длинная:
                    for (Chessmen n : getChessmen()) {
                        if ((n.getPosition().getVertical() == Castling.ROOK_FUTURE_TILE_LONG_VERTICAL && n.getPosition().getHorizontal() == Castling.WHITE_ROOK_FUTURE_TILE_HORIZONTAL)
                                || (n.getPosition().getVertical() == Castling.KING_FUTURE_TILE_LONG_VERTICAL && n.getPosition().getHorizontal() == Castling.WHITE_KING_FUTURE_TILE_HORIZONTAL)) {
                            isTileFree = false;
                            break;
                        }
                    }
                    boolean possibleCastlingRook = false;
                    boolean possibleCastlingKing = false;
                    for (Chessmen n : getChessmen()) {
                        if (isTileFree && n.getClass().equals(King.class) && n.getIsFirstMove() && n.getPosition().getVertical() == 5 && n.getPosition().getHorizontal() == 1 && n.getIsWhite()) {
                            possibleCastlingKing = true;
                        }
                        if (isTileFree && n.getClass().equals(Rook.class) && n.getIsFirstMove() && n.getPosition().getVertical() == 1 && n.getPosition().getHorizontal() == 1 && n.getIsWhite()) {
                            possibleCastlingRook = true;
                        }
                        if (possibleCastlingKing && possibleCastlingRook) {
                            for (Chessmen l : getChessmen()) {
                                if (l.getClass().equals(King.class) && l.getIsWhite() && l.getPosition().getVertical() == 5 && l.getPosition().getHorizontal() == 1) {
                                    l.setPosition(new BoardPosition(Castling.KING_FUTURE_TILE_LONG_VERTICAL, Castling.WHITE_KING_FUTURE_TILE_HORIZONTAL));
                                    castlingIsPossible = true;
                                }
                                if (l.getClass().equals(Rook.class) && l.getIsWhite() && l.getPosition().getVertical() == 1 && l.getPosition().getHorizontal() == 1) {
                                    l.setPosition(new BoardPosition(Castling.ROOK_FUTURE_TILE_LONG_VERTICAL, Castling.WHITE_ROOK_FUTURE_TILE_HORIZONTAL));
                                    castlingIsPossible = true;
                                }
                            }
                        }
                    }
                }
            } else {
                if (cs.isShort) {   //Если рокировка черная и короткая:
                    for (Chessmen n : getChessmen()) {
                        if ((n.getPosition().getVertical() == Castling.ROOK_FUTURE_TILE_SHORT_VERTICAL && n.getPosition().getHorizontal() == Castling.BLACK_ROOK_FUTURE_TILE_HORIZONTAL)
                                || (n.getPosition().getVertical() == Castling.KING_FUTURE_TILE_SHORT_VERTICAL && n.getPosition().getHorizontal() == Castling.BLACK_KING_FUTURE_TILE_HORIZONTAL)) {
                            isTileFree = false;
                            break;
                        }
                    }
                    boolean possibleCastlingRook = false;
                    boolean possibleCastlingKing = false;
                    for (Chessmen n : getChessmen()) {
                        if (isTileFree && n.getClass().equals(King.class) && n.getIsFirstMove() && n.getPosition().getVertical() == 5 && n.getPosition().getHorizontal() == 8 && !n.getIsWhite()) {
                            possibleCastlingKing = true;
                        }
                        if (isTileFree && n.getClass().equals(Rook.class) && n.getIsFirstMove() && n.getPosition().getVertical() == 8 && n.getPosition().getHorizontal() == 8 && !n.getIsWhite()) {
                            possibleCastlingRook = true;
                        }
                        if (possibleCastlingKing && possibleCastlingRook) {
                            for (Chessmen l : getChessmen()) {
                                if (l.getClass().equals(King.class) && !l.getIsWhite() && l.getPosition().getVertical() == 5 && l.getPosition().getHorizontal() == 8) {
                                    l.setPosition(new BoardPosition(Castling.KING_FUTURE_TILE_SHORT_VERTICAL, Castling.BLACK_KING_FUTURE_TILE_HORIZONTAL));
                                    castlingIsPossible = true;
                                }
                                if (l.getClass().equals(Rook.class) && !l.getIsWhite() && l.getPosition().getVertical() == 8 && l.getPosition().getHorizontal() == 8) {
                                    l.setPosition(new BoardPosition(Castling.ROOK_FUTURE_TILE_SHORT_VERTICAL, Castling.BLACK_ROOK_FUTURE_TILE_HORIZONTAL));
                                    castlingIsPossible = true;
                                }
                            }
                        }
                    }
                } else {  //Если рокировка черная и длинная:
                    for (Chessmen n : getChessmen()) {
                        if ((n.getPosition().getVertical() == Castling.ROOK_FUTURE_TILE_LONG_VERTICAL && n.getPosition().getHorizontal() == Castling.BLACK_ROOK_FUTURE_TILE_HORIZONTAL)
                                || (n.getPosition().getVertical() == Castling.KING_FUTURE_TILE_LONG_VERTICAL && n.getPosition().getHorizontal() == Castling.BLACK_KING_FUTURE_TILE_HORIZONTAL)) {
                            isTileFree = false;
                            break;
                        }
                    }
                    boolean possibleCastlingRook = false;
                    boolean possibleCastlingKing = false;
                    for (Chessmen n : getChessmen()) {
                        if (isTileFree && n.getClass().equals(King.class) && n.getIsFirstMove() && n.getPosition().getVertical() == 5 && n.getPosition().getHorizontal() == 8 && !n.getIsWhite()) {
                            possibleCastlingKing = true;
                        }
                        if (isTileFree && n.getClass().equals(Rook.class) && n.getIsFirstMove() && n.getPosition().getVertical() == 1 && n.getPosition().getHorizontal() == 8 && !n.getIsWhite()) {
                            possibleCastlingRook = true;
                        }
                        if (possibleCastlingKing && possibleCastlingRook) {
                            for (Chessmen l : getChessmen()) {
                                if (l.getClass().equals(King.class) && !l.getIsWhite() && l.getPosition().getVertical() == 5 && l.getPosition().getHorizontal() == 8) {
                                    l.setPosition(new BoardPosition(Castling.KING_FUTURE_TILE_LONG_VERTICAL, Castling.BLACK_KING_FUTURE_TILE_HORIZONTAL));
                                    castlingIsPossible = true;
                                }
                                if (l.getClass().equals(Rook.class) && !l.getIsWhite() && l.getPosition().getVertical() == 1 && l.getPosition().getHorizontal() == 8) {
                                    l.setPosition(new BoardPosition(Castling.ROOK_FUTURE_TILE_LONG_VERTICAL, Castling.BLACK_ROOK_FUTURE_TILE_HORIZONTAL));
                                    castlingIsPossible = true;
                                }
                            }
                        }
                    }
                }
            }
            if (!castlingIsPossible) {
                System.out.println("Рокировка невозможна");
            }
        }

        if (m instanceof PawnTransformation) {
            Chessmen figure = null;
            boolean isPawnTransformationExist = false;
            PawnTransformation pt = (PawnTransformation) m;
            for (Chessmen n : getChessmen()) {
                if (n.getPosition().getHorizontal() == 7 && n.getPosition().getHorizontal() == pt.getStart().getHorizontal()) {
                    if (pt.getStart().getHorizontal() == 7 && pt.getEnd().getHorizontal() == 8 && n.getClass().equals(Pawn.class)) {
                        isPawnTransformationExist = true;
                        if (n.getIsWhite()) {
                            if (pt.getTransformation().equals("Rook")) {
                                figure = new Rook(true, new BoardPosition(n.getPosition().getVertical(), 8));
                                numOfFigure = chessmen.indexOf(n);
                                break;
                            }
                            if (pt.getTransformation().equals("Bishop")) {
                                figure = new Bishop(true, new BoardPosition(n.getPosition().getVertical(), 8));
                                numOfFigure = chessmen.indexOf(n);
                                break;
                            }
                            if (pt.getTransformation().equals("Knight")) {
                                figure = new Knight(true, new BoardPosition(n.getPosition().getVertical(), 8));
                                numOfFigure = chessmen.indexOf(n);
                                break;
                            }
                            if (pt.getTransformation().equals("Queen")) {
                                figure = new Queen(true, new BoardPosition(n.getPosition().getVertical(), 8));
                                numOfFigure = chessmen.indexOf(n);
                                break;
                            }
                        } else {
                            if (pt.getTransformation().equals("Rook")) {
                                figure = new Rook(false, new BoardPosition(n.getPosition().getVertical(), 8));
                                numOfFigure = chessmen.indexOf(n);
                                break;
                            }
                            if (pt.getTransformation().equals("Bishop")) {
                                figure = new Bishop(false, new BoardPosition(n.getPosition().getVertical(), 8));
                                numOfFigure = chessmen.indexOf(n);
                                break;
                            }
                            if (pt.getTransformation().equals("Knight")) {
                                figure = new Knight(false, new BoardPosition(n.getPosition().getVertical(), 8));
                                numOfFigure = chessmen.indexOf(n);
                                break;
                            }
                            if (pt.getTransformation().equals("Queen")) {
                                figure = new Queen(false, new BoardPosition(n.getPosition().getVertical(), 8));
                                numOfFigure = chessmen.indexOf(n);
                                break;
                            }
                        }
                    }
                }
            }
            if (!isPawnTransformationExist) {
                System.out.println("Это не трансформация");
            } else {
                chessmen.add(figure);
                getChessmen().remove(numOfFigure);
            }
        }

        if (m instanceof PawnEating) {
            PawnEating pe = (PawnEating) m;
            pieceMoving(pe.getStart(), pe.getEnd());
        }
    }

    private void pieceMoving(BoardPosition start, BoardPosition end) {
        int numOfDeletingFigure = 0;
        int numOfMovingFigure = 0;
        boolean isMovingCorrect = false;
        boolean isThisFigureExist = false;
        boolean isRemovingCorrect = false;
        boolean isEndTileFigureSameColor = false;
        boolean isTraceFree = true;
        for (Chessmen startTileFigure : getChessmen()) {
            if (startTileFigure.getPosition().getVertical() == start.getVertical() && startTileFigure.getPosition().getHorizontal() == start.getHorizontal()) {
                isThisFigureExist = true;
                if (startTileFigure.possibleMove(end)) {
                    List<BoardPosition> pieceTrace = startTileFigure.trace(end);
                    for (BoardPosition bp : pieceTrace) {
                        for (Chessmen onTraceFigure : getChessmen()) {
                            if (onTraceFigure.getPosition().equals(bp)) {
                                System.out.println("Вы не можете прыгать через фигуры");
                                isTraceFree = false;
                            }
                        }
                    }
                } else {
                    System.out.println("Вы не можете ходить сюда");
                    break;
                }
            }
            if (isThisFigureExist) {
                if (isTraceFree) {
                    isMovingCorrect = true;
                    for (Chessmen endTileFigure : getChessmen()) {
                        if (endTileFigure.getPosition().getVertical() == end.getVertical() && endTileFigure.getPosition().getHorizontal() == end.getHorizontal()) {
                            if (endTileFigure.getIsWhite() != startTileFigure.getIsWhite()) {
                                numOfMovingFigure = chessmen.indexOf(startTileFigure);
                                numOfDeletingFigure = getChessmen().indexOf(endTileFigure);
                                isRemovingCorrect = true;
                                break;
                            } else {
                                isEndTileFigureSameColor = true;
                            }
                        }
                    }
                    startTileFigure.setIsFirstMove(false);
                    break;
                }
            }
        }
        if (isMovingCorrect) {
            chessmen.get(numOfMovingFigure).setPosition(new BoardPosition(end.getVertical(), end.getHorizontal()));
        }
        if (isRemovingCorrect) {
            getChessmen().remove(numOfDeletingFigure);
        }
        if (!isThisFigureExist) {
            System.out.println("Выбранная клетка пуста");
        }
        if (isEndTileFigureSameColor) {
            System.out.println("Эта клетка уже занята вашей фигурой");
        }
    }
}