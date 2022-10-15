package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 红象
 */
public final class RElephant extends Chessman {
    public RElephant(int y, int x) {
        super(13, x, y, 6, new Navigate(1, 4, null));
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate() {
        navigate.clear();
        Params.getNavigate(Params.RED_ELEPHANT_NAVIGATE.get(y * 10 + x), navigate, id, x, y);
    }
}