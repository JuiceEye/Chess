package game;

import java.util.ArrayList;
import java.util.List;

public class King extends Chessmen {
    public King(boolean isWhite, BoardPosition position) {
        super(isWhite, position);
    }
    @Override
    public List<BoardPosition> trace(BoardPosition bp){
        List<BoardPosition> l = new ArrayList<>();
        return l;
    }
    @Override
    public boolean possibleMove(BoardPosition bp) {
        if (Math.abs(bp.getVertical() - getPosition().getVertical()) <= 1 && Math.abs(bp.getHorizontal() - getPosition().getHorizontal()) <= 1) {
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
