package com.zyj.chess.game.board;

import com.zyj.chess.ai.tool.Codec;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Params;
import com.zyj.chess.game.tool.BitList;

import java.util.Arrays;

public final class Board {
    BitList board = new BitList(new long[]{8000000000000000000L, 8010203040504030201L,
            8000000000000000000L, 8000600000000000600L, 8070007000700070007L,
            8000000000000000000L, 8000000000000000000L, 8170017001700170017L,
            8001600000000001600L, 8000000000000000000L, 8111213141514131211L
    }, 2, null);

    public int get(int y, int x) {
        return board.bit(y, x);
    }

    public void update(int y, int x, int id) {
        board.update(y, x, id);
    }

    public void clear(int y, int x) {
        board.clear(y, x);
    }

    public void move(int y, int x, Chessman chessman) {
        clear(chessman.getY(), chessman.getX());
        update(y, x, chessman.getId());
    }

    public String hash() {
        return Codec.complex(Arrays.toString(board.data()), Arrays.hashCode(board.data()));
    }

    public void view() {
        for (int i = 1; i < 11; ++i) {
            for (int j = 1; j < 10; ++j)
                System.out.print(Params.CHESSMAN_NAME[get(i, j)] + "\t");
            System.out.println();
        }
    }
}