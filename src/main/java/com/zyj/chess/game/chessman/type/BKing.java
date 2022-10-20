package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 将
 */
public final class BKing extends Chessman {
    public BKing(int y, int x) {
        super(5, x, y, 100, 1, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        boolean key = true;
        for (int p : Params.BLACK_KING_NAVIGATE.get(y * 10 + x)) {
            for (Chessman chessman : Game.RED.getChessArray()) {
                if (chessman.getNormalNavigate().eats.get(p) == null) continue;
                key = false;
                break;
            }
            if (key) {
                int chess = Game.BOARD.get(p / 10, p % 10);
                if (chess == 0 || chess > 7) navigate.moves.add(p);
            }
        }
    }
}