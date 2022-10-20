package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 黑车
 */
public final class BCar extends Chessman {
    public BCar(int y, int x) {
        super(1, x, y, 23, 2, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        Params.calcCareNavigate(navigate, id, x, y);
    }
}