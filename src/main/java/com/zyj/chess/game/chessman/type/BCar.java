package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigates;
import com.zyj.chess.game.params.Params;

import java.util.List;

/**
 * 黑车
 */
public final class BCar extends Chessman {
    public BCar(int y, int x) {
        super(1, x, y, 23, Navigates.NO_LIMIT);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        Params.calcCareNavigate(navigate, id, x, y);
    }
}