package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigates;
import com.zyj.chess.game.params.Params;

import java.util.List;

/**
 * 红象
 */
public final class RElephant extends Chessman {
    public RElephant(int y, int x) {
        super(13, x, y, 6, Navigates.LIMIT);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        Params.getNavigate(Params.RED_ELEPHANT_NAVIGATE, list, x, y);
    }
}