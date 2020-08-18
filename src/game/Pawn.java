package game;

import java.util.ArrayList;
import java.util.List;


public class Pawn extends Chessmen {
    public Pawn(boolean isWhite, BoardPosition position) {
        super(isWhite, position);
    }

    @Override
    public List<BoardPosition> trace(BoardPosition bp) {
        List<BoardPosition> l = new ArrayList<>();
        return l;
    }

    @Override
    public boolean possibleMove(BoardPosition bp) {
        if (getIsWhite()) {
            if (getIsFirstMove() && (bp.getHorizontal() - getPosition().getHorizontal() == 1 || bp.getHorizontal() - getPosition().getHorizontal() == 2) && bp.getVertical() == getPosition().getVertical()) {
                return true;
            } else {
                if (bp.getHorizontal() - getPosition().getHorizontal() == 1 && bp.getVertical() == getPosition().getVertical()) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (getIsFirstMove() && (bp.getHorizontal() - getPosition().getHorizontal() == -1 || bp.getHorizontal() - getPosition().getHorizontal() == -2) && bp.getVertical() == getPosition().getVertical()) {
                return true;
            } else {
                if (bp.getHorizontal() - getPosition().getHorizontal() == -1 && bp.getVertical() == getPosition().getVertical()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
