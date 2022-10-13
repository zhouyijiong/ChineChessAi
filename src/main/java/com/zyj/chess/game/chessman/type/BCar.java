package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 黑车
 */
public final class BCar extends Chessman {
    public BCar(int y, int x) {
        super(1, x, y, 23, new Navigate(2, 2, null));
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate() {
        Params.calcCareNavigate(navigate.clear(), id, x, y);
    }
}