package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Params;

import java.util.List;
import java.util.Map;

/**
 * 黑象
 */
public final class BElephant extends Chessman {
    public BElephant(int y, int x) {
        super(3, x, y, 6);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        Map<List<Integer>, List<Integer>> map = Params.BLACK_ELEPHANT_NAVIGATE.get(y * 10 + x);
        for (Map.Entry<List<Integer>, List<Integer>> item : map.entrySet()) {
            List<Integer> point = item.getKey();
            List<Integer> baffle = item.getKey();
            for (int i = 0, len = baffle.size(); i < len; ++i) {
                int xy = baffle.get(i);
                if (Game.BOARD.get(xy / 10, xy % 10) == 0) list.add(point.get(i));
            }
        }
    }
}