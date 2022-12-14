package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 黑士
 */
public final class BSquire extends Chessman {
    public BSquire(int y, int x) {
        super(4, x, y, 6, 1, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        for (int p : Params.BLACK_SQUIRE_NAVIGATE.get(y * 10 + x))
            Params.calcSquireNavigate(navigate, true, p % 10, p / 10, 5);
    }
}