package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Params;

/**
 * 红炮
 */
public class RCannon extends Chessman {
    public RCannon(int y, int x) {
        super(16, x, y, 11, 2, 2, null);
    }

    @Override
    public void navigate(Navigate navigate) {
        Params.calcCannonNavigate(navigate, id, x, y);
    }
}
