package com.zyj.chess.game.board;

import com.zyj.chess.ai.tool.Codec;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Params;

import java.util.Arrays;

public final class Board {
    public static final long[] BOARD = {0, 8010203040504030201L,
            8000000000000000000L, 8000600000000000600L, 8070007000700070007L,
            8000000000000000000L, 8000000000000000000L, 8170017001700170017L,
            8001600000000001600L, 8000000000000000000L, 8111213141514131211L
    };

    public static final long[] DIVISOR = {1000000000000000000L,
            10000000000000000L, 100000000000000L, 1000000000000L,
            10000000000L, 100000000L, 1000000L, 10000L, 100L, 1L
    };

    public int get(int y, int x) {
        return (int) (BOARD[y] / DIVISOR[x] % 100);
    }

    public void update(int y, int x, int id) {
        int sourceId = get(y, x);
        BOARD[y] += DIVISOR[x] * sourceId < id ? id - sourceId : sourceId - id;
    }

    public void clear(int y, int x) {
        BOARD[y] -= DIVISOR[x] * get(y, x);
    }

    public void move(int y, int x, Chessman chessman) {
        clear(chessman.getY(), chessman.getX());
        update(y, x, chessman.getId());
    }

    public String hash() {
        return Codec.complex(Arrays.toString(BOARD), Arrays.hashCode(BOARD));
    }

    public void view() {
        for (int i = 1; i < 11; ++i) {
            for (int j = 1; j < 10; ++j)
                System.out.print(Params.CHESSMAN_NAME[get(i, j)] + "\t");
            System.out.println();
        }
    }
}