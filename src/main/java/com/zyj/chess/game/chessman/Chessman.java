package com.zyj.chess.game.chessman;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Chessman {
    protected int id;
    protected int x;
    protected int y;
    protected int score;

    public abstract int calcDangerScore(Chessman[] board, int... params);

    public abstract void navigate(List<Integer> list);
}