package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 红马
 */
public final class RHorse extends Chessman {
    public RHorse(int y, int x) {
        super(12, x, y, 11, new Navigate(2, 4, null));
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate() {
        navigate.clear();
        Params.getNavigate(Params.HORSE_NAVIGATE.get(y * 10 + x), navigate, id, x, y);
    }
}