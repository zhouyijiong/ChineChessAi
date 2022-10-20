package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 红士
 */
public final class RSquire extends Chessman {
    public RSquire(int y, int x) {
        super(14, x, y, 6, 1, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        for (int p : Params.RED_SQUIRE_NAVIGATE.get(y * 10 + x))
            Params.calcSquireNavigate(navigate, false, p % 10, p / 10, 15);
    }
}