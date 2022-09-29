package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;

import java.util.List;

/**
 * 黑马
 */
public final class BHorse extends Chessman {
    public BHorse(int y, int x) {
        super(2, x, y, 11);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
    }
}