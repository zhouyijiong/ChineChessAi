package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 红帅
 */
public final class RKing extends Chessman {
    public RKing(int y, int x) {
        super(15, x, y, 100, 1, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        //boolean key = true;
        for (int p : Params.RED_KING_NAVIGATE.get(y * 10 + x)) {
            for (Chessman chessman : Game.BLACK.getChessArray()) {
                if (chessman.getNormalNavigate().eats.get(p) == null) continue;
                //key = false;
                break;
            }
            //if (key) {
                int chess = Game.BOARD.get(p / 10, p % 10);
                if (chess < 8) navigate.moves.add(p);
            //}
        }
    }
}