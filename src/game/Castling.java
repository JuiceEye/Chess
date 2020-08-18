package game;

public class Castling extends Move {
    boolean isWhite;
    boolean isShort;

    public static final int KING_FUTURE_TILE_SHORT_VERTICAL = 7;
    public static final int KING_FUTURE_TILE_LONG_VERTICAL = 3;
    public static final int WHITE_KING_FUTURE_TILE_HORIZONTAL = 1;
    public static final int BLACK_KING_FUTURE_TILE_HORIZONTAL = 8;
    public static final int ROOK_FUTURE_TILE_SHORT_VERTICAL = 6;
    public static final int ROOK_FUTURE_TILE_LONG_VERTICAL = 4;
    public static final int WHITE_ROOK_FUTURE_TILE_HORIZONTAL = 1;
    public static final int BLACK_ROOK_FUTURE_TILE_HORIZONTAL = 8;

    public boolean getIsShort() {
        return isShort;
    }

    public void setIsShort(boolean isShort) {
        this.isShort = isShort;
    }

    public boolean getIsWhite() {
        return isWhite;
    }

    public void setIsWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public Castling(boolean isWhite, boolean isShort) {
        this.isWhite = isWhite;
        this.isShort = isShort;
    }
}
