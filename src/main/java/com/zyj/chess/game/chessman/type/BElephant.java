package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 黑象
 */
public final class BElephant extends Chessman {
    public BElephant(int y, int x) {
        super(3, x, y, 6, new Navigate(1, 4, null));
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate() {
        navigate.clear();
        Params.getNavigate(Params.BLACK_ELEPHANT_NAVIGATE.get(y * 10 + x), navigate, id, x, y);
    }
}