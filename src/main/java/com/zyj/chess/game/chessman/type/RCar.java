package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Params;

import java.util.List;

/**
 * 红车
 */
public final class RCar extends Chessman {
    public RCar(int y, int x) {
        super(11, x, y, 23);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        Params.calcCareNavigate(list, id, x, y);
    }
}