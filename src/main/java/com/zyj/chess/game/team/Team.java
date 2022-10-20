package com.zyj.chess.game.team;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class Team {
    protected int color;

    protected Chessman[] chessArray;

    protected final Map<Integer, Chessman> chessMap;

    protected Team mirrorTeam;

    public Team(int color, Chessman[] chess) {
        this.color = color;
        this.chessArray = chess;
        this.chessMap = new HashMap<>();
        for (Chessman chessman : chess) this.chessMap.put(chessman.getY() * 10 + chessman.getX(), chessman);
        this.mirrorTeam = this;
    }

    public void normalNavigate() {
        for (Chessman chessman : chessArray) chessman.normalNavigate();
    }

    public void referenceNavigate() {
        for (Chessman chessman : chessArray) chessman.referenceNavigate();
    }

    public void rollback() {
        this.mirrorTeam = this;
    }

    public void score() {
        for (Chessman chessman : chessArray) {
            chessman.probe(Game.RED.mirrorTeam, Game.BLACK.mirrorTeam, color);
        }
    }

    public boolean delete(int key) {
        Chessman chess = chessMap.get(key);
        int id = chess.getId();
        if (id == 5 || id == 15) return false;
        chessMap.put(key, null);
        for (int i = 0, len = chessArray.length; i < len; ++i) {
            if (chess.equals(chessArray[i])) {
                chessArray[i] = null;
                break;
            }
        }
        return true;
    }
}