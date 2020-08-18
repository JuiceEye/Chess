package game;

public class ConsoleUI implements UI {
    @Override
    public void draw(Game game) {
        boolean isTileFree = true;
        for (int i = 8; i >= 1; i--) {
            for (int j = 1; j <= 8; j++) {
                for (Chessmen n : game.getChessmen()) {
                    if (n.getPosition().getVertical() == j && n.getPosition().getHorizontal() == i) {
                        isTileFree = false;
                        if (n.getClass().equals(Pawn.class)) {
                            if (n.getIsWhite()) {
                                System.out.print('\u2659' + "\t"); //Белая пешка
                            } else {
                                System.out.print('\u265F' + "\t"); //Черная пешка
                            }
                        } else if (n.getClass().equals(Rook.class)) {
                            if (n.getIsWhite()) {
                                System.out.print('\u2656' + "\t"); //Белая Ладья
                            } else {
                                System.out.print('\u265C' + "\t"); //Черная Ладья
                            }
                        } else if (n.getClass().equals(Bishop.class)) {
                            if (n.getIsWhite()) {
                                System.out.print('\u2657' + "\t"); //Белый слон
                            } else {
                                System.out.print('\u265D' + "\t"); //Черный слон
                            }
                        } else if (n.getClass().equals(Queen.class)) {
                            if (n.getIsWhite()) {
                                System.out.print('\u2655' + "\t"); //Белый ферзь
                            } else {
                                System.out.print('\u265B' + "\t"); //Черный ферзь
                            }
                        } else if (n.getClass().equals(Knight.class)) {
                            if (n.getIsWhite()) {
                                System.out.print('\u2658' + "\t"); //Белый конь
                            } else {
                                System.out.print('\u265E' + "\t"); //Черный конь
                            }
                        } else if (n.getClass().equals(King.class)) {
                            if (n.getIsWhite()) {
                                System.out.print('\u2654' + "\t"); //Белый король
                            } else {
                                System.out.print('\u265A' + "\t"); //Черный король
                            }
                        }
                    }
                }
                if (isTileFree) {
                    System.out.print('\u2B1C' + "\t");
                }
                isTileFree = true;
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }
}
