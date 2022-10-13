package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 将
 */
public final class BKing extends Chessman {
    public BKing(int y, int x) {
        super(5, x, y, 100, new Navigate(1, 2, null));
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate() {
        for (Integer i : Params.BLACK_KING_NAVIGATE.get(y * 10 + x)) {
            int y = i / 10;
            int x = i % 10;
            Game.BOARD.get(y, x);
            //计算位置是否安全
        }
    }
}