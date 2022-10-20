package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 红车
 */
public final class RCar extends Chessman {
    public RCar(int y, int x) {
        super(11, x, y, 23, 2, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        Params.calcCareNavigate(navigate, id, x, y);
    }
}