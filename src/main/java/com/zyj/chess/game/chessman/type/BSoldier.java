package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 黑兵
 * 过河之后分数翻倍
 */
public final class BSoldier extends Chessman {
    public BSoldier(int y, int x) {
        super(7, x, y, 4, 1, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        int t = y + 1;
        if (t < 11) Params.calcNavigate(navigate, true, x, t);
        if (y > 5) {
            if ((t = x + 1) < 10) Params.calcNavigate(navigate, true, t, y);
            if ((t = x - 1) > 0) Params.calcNavigate(navigate, true, t, y);
        }
    }
}