package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigates;
import com.zyj.chess.game.params.Params;

import java.util.List;

/**
 * 黑马
 */
public final class BHorse extends Chessman {
    public BHorse(int y, int x) {
        super(2, x, y, 11, Navigates.LIMIT);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        Params.getNavigate(Params.HORSE_NAVIGATE, list, x, y);
    }
}