package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 黑马
 */
public final class BHorse extends Chessman {
    public BHorse(int y, int x) {
        super(2, x, y, 11, new Navigate(2, 4, null));
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate() {
        navigate.clear();
        Params.getNavigate(Params.HORSE_NAVIGATE, navigate, id, x, y);
    }
}