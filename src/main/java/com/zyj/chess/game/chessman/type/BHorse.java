package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 黑马
 */
public final class BHorse extends Chessman {
    public BHorse(int y, int x) {
        super(2, x, y, 11, 2, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        Params.getNavigate(Params.HORSE_NAVIGATE.get(y * 10 + x), navigate, id, 5);
    }
}