package game;

public class PawnTransformation extends Move {
    private BoardPosition start;
    private BoardPosition end;
    private String transformation;

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

    public String getTransformation() {
        return transformation;
    }

    public void setTransformation(String transformation) {
        this.transformation = transformation;
    }

    public PawnTransformation(BoardPosition start, BoardPosition end, String transformation) {
        this.start = start;
        this.end = end;
        this.transformation = transformation;
    }
}
