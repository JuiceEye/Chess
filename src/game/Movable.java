package game;

import java.util.List;

public interface Movable {
    boolean possibleMove(BoardPosition bp);
    List<BoardPosition> trace(BoardPosition bp);
}
