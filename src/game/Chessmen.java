package game;

public abstract class Chessmen implements Movable {
    private boolean isWhite;
    private BoardPosition position;
    private char picture;
    private boolean isFirstMove = true;

    public boolean getIsFirstMove() {
        return isFirstMove;
    }

    public void setIsFirstMove(boolean IsFirstMove) {
        this.isFirstMove = isFirstMove;
    }

    public BoardPosition getPosition() {
        return position;
    }

    public void setPosition(BoardPosition position) {
        this.position = position;
    }

    public Chessmen(boolean isWhite, BoardPosition position) {
        this.isWhite = isWhite;
        this.position = position;
    }

    public char getPicture() {
        return picture;
    }

    public void setPicture(char picture) {
        this.picture = picture;
    }

    public boolean getIsWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }
}
