package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 红兵
 * 过河之后分数翻倍
 */
public final class RSoldier extends Chessman {
    public RSoldier(int y, int x) {
        super(17, x, y, 4, 1, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        int t = y - 1;
        if (t > 0) Params.calcNavigate(navigate, false, x, t);
        if (y < 6) {
            if ((t = x + 1) < 10) Params.calcNavigate(navigate, false, t, y);
            if ((t = x - 1) > 0) Params.calcNavigate(navigate, false, t, y);
        }
    }
}