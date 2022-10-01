package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.team.Team;

import java.util.List;

/**
 * 黑兵
 * 过河之后分数翻倍
 */
public final class BSoldier extends Chessman {
    public BSoldier(int y, int x) {
        super(7, x, y, 4);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        int t = y + 1;
        if (t < 11 && Game.BOARD.get(t, x) == 0) list.add(t * 10 + x);
        if (y > 5) {
            if ((t = x + 1) < 10 && Game.BOARD.get(y, t) > 8) list.add(y * 10 + t);
            if ((t = x - 1) > 0 && Game.BOARD.get(y, t) > 8) list.add(y * 10 + t);
        }
    }
}