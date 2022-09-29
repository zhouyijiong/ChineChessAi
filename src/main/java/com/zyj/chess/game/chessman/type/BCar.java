package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Params;

import java.util.List;

/**
 * 黑车
 */
public final class BCar extends Chessman {
    public BCar(int y, int x) {
        super(1, x, y, 23);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        int id, i;
        for (i = this.x + 1; i < 10; ++i) {
            if ((id = Game.BOARD.get(this.y, i)) == 0) {
                list.add(this.y * 10 + i);
                continue;
            } else if (id > 8) list.add(this.y * 10 + i);
            break;
        }
        for (i = this.x - 1; i > 0; --i) {
            if ((id = Game.BOARD.get(this.y, i)) == 0) {
                list.add(this.y * 10 + i);
                continue;
            } else if (id > 8) list.add(this.y * 10 + i);
            break;
        }
        for (i = this.y + 1; i < 11; ++i) {
            if ((id = Game.BOARD.get(i, this.x)) == 0) {
                list.add(i * 10 + this.x);
                continue;
            } else if (id > 8) list.add(i * 10 + this.x);
            break;
        }
        for (i = this.y - 1; i > 0; --i) {
            if ((id = Game.BOARD.get(i, this.x)) == 0) {
                list.add(i * 10 + this.x);
                continue;
            } else if (id > 8) list.add(i * 10 + this.x);
            break;
        }
    }
}