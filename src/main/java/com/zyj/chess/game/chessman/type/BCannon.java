package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 黑炮
 */
public final class BCannon extends Chessman {
    public BCannon(int y, int x) {
        super(6, x, y, 11, new Navigate(2, 2, null));
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate() {
        navigate.clear();
        Params.calcCannonNavigate(navigate, id, x, y);
    }
}