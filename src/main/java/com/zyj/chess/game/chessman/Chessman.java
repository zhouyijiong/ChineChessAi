package com.zyj.chess.game.chessman;

import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.params.Navigates;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public abstract class Chessman {
    protected int id;
    protected int x;
    protected int y;
    protected int score;
    protected final Navigate navigate;

    public Chessman(int id, int x, int y, int score, Navigates navigates) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.score = score;
        this.navigate = navigates.navigate;
    }

    public abstract int calcDangerScore(Chessman[] board, int... params);

    public abstract void navigate(List<Integer> list);
}