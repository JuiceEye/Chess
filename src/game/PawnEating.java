package game;

public class PawnEating extends Move{
    private BoardPosition start;
    private BoardPosition end;

    public BoardPosition getStart() {
        return start;
    }

    public void setStart(BoardPosition start) {
        this.start = start;
    }

    public BoardPosition getEnd() {
        return end;
    }

    public void setEnd(BoardPosition end) {
        this.end = end;
    }

    public PawnEating(BoardPosition start, BoardPosition end) {
        this.start = start;
        this.end = end;
    }
}
