package com.zyj.chess.game.board;

import com.zyj.chess.ai.tool.Codec;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Params;

import java.util.Arrays;

public final class Board{
    static final long[] BOARD = {8010203040504030201L,
            8000000000000000000L, 8000600000000000600L, 8070007000700070007L,
            8000000000000000000L, 8000000000000000000L, 8170017001700170017L,
            8160000000000001600L, 8000000000000000000L, 8111213141514131211L
    };

    static final long[] DIVISOR = {1000000000000000000L,
            10000000000000000L, 100000000000000L, 1000000000000L,
            10000000000L, 100000000L, 1000000L, 10000L, 100L, 1L
    };

    public int get(long l, int index) {
        return (int) (l / DIVISOR[index] % 100);
    }

    public void delete(int x) {}

    public void move(int index, Chessman chessman) {}

    public String hash() {
        return Codec.complex(Arrays.toString(BOARD), 0);
    }

    public void view() {
        for (long l : BOARD) {
            for (int i = 1; i < 10; ++i) {
                System.out.print(Params.CHESSMAN_NAME[get(l, i)] + "\t");
            }
            System.out.println();
        }
    }
}