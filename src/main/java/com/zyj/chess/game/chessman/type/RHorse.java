package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;

import java.util.List;

/**
 * 红马
 */
public final class RHorse extends Chessman {
    public RHorse(int y, int x) {
        super(12, x, y, 11);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
    }
}