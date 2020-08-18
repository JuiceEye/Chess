package game;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Chessmen {
    public Queen(boolean isWhite, BoardPosition position) {
        super(isWhite, position);
    }

    Bishop b = new Bishop(getIsWhite(), getPosition());
    Rook r = new Rook(getIsWhite(), getPosition());

    @Override
    public List<BoardPosition> trace(BoardPosition bp) {
        List<BoardPosition> l = new ArrayList<>();
        for (int i = 8; i >= 1; i--) {
            for (int j = 1; j <= 8; j++) {
                if (b.possibleMove(new BoardPosition(bp.getVertical(), bp.getHorizontal()))) {
                    if ((i < bp.getHorizontal() && i > getPosition().getHorizontal() && j < bp.getVertical() && j > getPosition().getVertical()) || (i < bp.getHorizontal() && i > getPosition().getHorizontal() && j > bp.getVertical() && j < getPosition().getVertical()) || (i > bp.getHorizontal() && i < getPosition().getHorizontal() && j < bp.getVertical() && j > getPosition().getVertical()) || (i > bp.getHorizontal() && i < getPosition().getHorizontal() && j > bp.getVertical() && j < getPosition().getVertical())) {
                        if (possibleMove(new BoardPosition(j, i))) {
                            l.add(new BoardPosition(j, i));
                        }
                    }
                } else if (r.possibleMove(new BoardPosition(bp.getVertical(), bp.getHorizontal()))) {
                    if ((i == getPosition().getHorizontal() && j < bp.getVertical() && j > getPosition().getVertical()) || (i == getPosition().getHorizontal() && j > bp.getVertical() && j < getPosition().getVertical()) || (((j == getPosition().getVertical() && i < bp.getHorizontal() && i > getPosition().getHorizontal()) || (j == getPosition().getVertical() && (i > bp.getHorizontal() && i < getPosition().getHorizontal()))))) {
                        l.add(new BoardPosition(j, i));
                    }
                }
            }
        }
        return l;
    }

    @Override
    public boolean possibleMove(BoardPosition bp) {
        if (bp.getVertical() == getPosition().getVertical() || bp.getHorizontal() == getPosition().getHorizontal()) {
            if (bp.getVertical() != getPosition().getVertical() || bp.getHorizontal() != getPosition().getHorizontal()) {
                return true;
            } else {
                return false;
            }
        } else if (Math.abs(bp.getVertical() - getPosition().getVertical()) == Math.abs(bp.getHorizontal() - getPosition().getHorizontal())) {
            if (bp.getVertical() != getPosition().getVertical() || bp.getHorizontal() != getPosition().getHorizontal()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
