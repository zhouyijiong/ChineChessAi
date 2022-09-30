package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Params;

import java.util.List;

/**
 * 黑炮
 */
public final class BCannon extends Chessman {
    public BCannon(int y, int x) {
        super(6, x, y, 11);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        Params.calcCannonNavigate(list, id, x, y);
    }
}