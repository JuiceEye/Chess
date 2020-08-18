package game;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Chessmen {
    public Bishop(boolean isWhite, BoardPosition position) {
        super(isWhite, position);
    }

    @Override
    public List<BoardPosition> trace(BoardPosition bp) {
        List<BoardPosition> l = new ArrayList<>();
        for (int i = 8; i >= 1; i--) {
            for (int j = 1; j <= 8; j++) {
                if ((i < bp.getHorizontal() && i > getPosition().getHorizontal() && j < bp.getVertical() && j > getPosition().getVertical()) || (i < bp.getHorizontal() && i > getPosition().getHorizontal() && j > bp.getVertical() && j < getPosition().getVertical()) || (i > bp.getHorizontal() && i < getPosition().getHorizontal() && j < bp.getVertical() && j > getPosition().getVertical()) || (i > bp.getHorizontal() && i < getPosition().getHorizontal() && j > bp.getVertical() && j < getPosition().getVertical())) {
                    if (possibleMove(new BoardPosition(j, i))) {
                        l.add(new BoardPosition(j, i));
                    }
                }
            }
        }
        return l;
    }

    @Override
    public boolean possibleMove(BoardPosition bp) {
        if (Math.abs(bp.getVertical() - getPosition().getVertical()) == Math.abs(bp.getHorizontal() - getPosition().getHorizontal())) {
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
