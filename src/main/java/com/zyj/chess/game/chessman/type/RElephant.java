package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 红象
 */
public final class RElephant extends Chessman {
    public RElephant(int y, int x) {
        super(13, x, y, 6, 1, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        int ty = y + 1;
        if (ty < 11 && Game.BOARD.get(ty, x) == 15) {
            navigate.protect.put(ty * 10 + x, 15);
        } else if ((ty = y + 2) < 11 && Game.BOARD.get(ty, x) == 15) {
            navigate.protect.put(ty * 10 + x, 15);
        }
        Params.getNavigate(Params.RED_ELEPHANT_NAVIGATE.get(y * 10 + x), navigate, id);
    }
}