package com.zyj.chess.game.team;

import com.zyj.chess.game.chessman.Chessman;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Team {
    protected int color;

    protected Chessman[] chess;

    public void navigate() {
        for (Chessman item : chess) item.navigate();
    }
}