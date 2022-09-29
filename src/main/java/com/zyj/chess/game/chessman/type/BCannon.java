package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;

import java.util.List;

/**
 * 黑炮
 */
public final class BCannon extends Chessman {
    public BCannon(int y, int x) {
        super(6, x, y, 11);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        int i, id;
        for (i = this.x + 1; i < 10; ++i) {
            if (Game.BOARD.get(this.y, i) == 0) {
                list.add(this.y * 10 + i);
                continue;
            } else {
                for (++i; i < 10; ++i) {
                    if ((id = Game.BOARD.get(this.y, i)) == 0) {
                        continue;
                    } else if (id > 8) list.add(this.y * 10 + i);
                    break;
                }
            }
            break;
        }
        for (i = this.x - 1; i > 0; --i) {
            if (Game.BOARD.get(this.y, i) == 0) {
                list.add(this.y * 10 + i);
                continue;
            } else {
                for (--i; i > 0; --i) {
                    if ((id = Game.BOARD.get(this.y, i)) == 0) {
                        continue;
                    } else if (id > 8) list.add(this.y * 10 + i);
                    break;
                }
            }
            break;
        }
        for (i = this.y + 1; i < 11; ++i) {
            if (Game.BOARD.get(i, this.x) == 0) {
                list.add(i * 10 + this.x);
                continue;
            } else {
                for (++i; i < 11; ++i) {
                    if ((id = Game.BOARD.get(i, this.x)) == 0) {
                        continue;
                    } else if (id > 8) list.add(i * 10 + this.x);
                    break;
                }
            }
            break;
        }
        for (i = this.y - 1; i > 0; --i) {
            if (Game.BOARD.get(i, this.x) == 0) {
                list.add(i * 10 + this.x);
                continue;
            } else {
                for (--i; i > 0; --i) {
                    if ((id = Game.BOARD.get(i, this.x)) == 0) {
                        continue;
                    } else if (id > 8) list.add(i * 10 + this.x);
                    break;
                }
            }
            break;
        }
    }
}