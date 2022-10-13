package com.zyj.chess.game.chessman;

import com.zyj.chess.game.params.Navigate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Chessman {
    protected int id;
    protected int x;
    protected int y;
    protected int score;
    protected final Navigate navigate;

    public abstract int calcDangerScore(Chessman[] board, int... params);

    public abstract void navigate();
}