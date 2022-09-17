package com.zyj.chess.game.chessman;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Chessman {
    protected final int color;
    protected int index;
    protected int score;

    public abstract int calcDangerScore(Chessman[] board, int... params);
}