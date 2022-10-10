package com.zyj.chess.game.team;

import com.zyj.chess.game.chessman.Chessman;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Team {
    protected int color;

    protected Chessman[] chess;
    public List<Integer> navigate() {
        List<Integer> list = new ArrayList<>();
        for (Chessman item : chess) item.navigate(list);
        return list;
    }
}