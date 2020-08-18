package game;

import java.util.ArrayList;
import java.util.List;


public class Rook extends Chessmen {
    public Rook(boolean isWhite, BoardPosition position) {
        super(isWhite, position);
    }

    @Override
    public List<BoardPosition> trace(BoardPosition bp) {
        List<BoardPosition> l = new ArrayList<>();
        for (int i = 8; i >= 1; i--) {
            for (int j = 1; j <= 8; j++) {
                if ((i == getPosition().getHorizontal() && j < bp.getVertical() && j > getPosition().getVertical()) || (i == getPosition().getHorizontal() && j > bp.getVertical() && j < getPosition().getVertical()) || (((j == getPosition().getVertical() && i < bp.getHorizontal() && i > getPosition().getHorizontal()) || (j == getPosition().getVertical() && (i > bp.getHorizontal() && i < getPosition().getHorizontal()))))) {
                    l.add(new BoardPosition(j, i));
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
        } else {
            return false;
        }
    }
}
