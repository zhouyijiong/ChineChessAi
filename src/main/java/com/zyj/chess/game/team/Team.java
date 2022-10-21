package com.zyj.chess.game.team;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.tool.KV;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class Team {
    protected int color;

    protected Chessman[] chessArray;

    protected final Map<Integer, Chessman> chessMap;

    protected Team(Team team) {
        this.color = team.color;
        int len = team.chessArray.length;
        this.chessArray = new Chessman[len];
        System.arraycopy(team.chessArray, 0, chessArray, 0, len);
        this.chessMap = new HashMap<>();
        for (Chessman chessman : chessArray) this.chessMap.put(chessman.getY() * 10 + chessman.getX(), chessman);
    }

    public Team(int color, Chessman[] chess) {
        this.color = color;
        this.chessArray = chess;
        this.chessMap = new HashMap<>();
        for (Chessman chessman : chess) this.chessMap.put(chessman.getY() * 10 + chessman.getX(), chessman);
    }

    public int normalNavigate() {
        int size = 0;
        for (Chessman chessman : chessArray) {
            chessman.normalNavigate();
            size += chessman.getNormalNavigate().moves.size() + chessman.getNormalNavigate().eats.size();
        }
        return size;
    }

    public void referenceNavigate() {
        for (Chessman chessman : chessArray) {
            if (chessman == null) continue;
            chessman.referenceNavigate();
        }
    }

    public void playingChess() {
        double[] scores = new double[normalNavigate()];
        Map<Double, KV<Chessman, Integer>> map = new HashMap<>();
        for (Chessman chessman : chessArray) chessman.probe(map, scores, color);
        for (int j = 0; j < scores.length; ++j) {
            for (int n = 0; n < scores.length - 1; ++n) {
                if (scores[n] < scores[n + 1]) {
                    double tmp = scores[n];
                    scores[n] = scores[n + 1];
                    scores[n + 1] = tmp;
                }
            }
        }
        //TODO bugs
        KV<Chessman, Integer> s = map.get(scores[0]);
        Chessman tempChessman = s.getK();
        Navigate tempNavigate = tempChessman.getNormalNavigate();
        if (tempNavigate.moves.size() > s.getV()) {
            int p = tempNavigate.moves.bit(s.getV());
            Game.BOARD.move(p / 10, p % 10, tempChessman);
        } else {
            Map<Integer, Integer> eat = tempNavigate.eats;
            int i = -1, ti = s.getV() - tempNavigate.moves.size();
            for (Map.Entry<Integer, Integer> item : tempNavigate.eats.entrySet()) {
                if (i != ti) continue;
            }
            Game.BOARD.eat(0, 0, null, -1);
        }
    }

    public boolean delete(int key) {
        Chessman chess = chessMap.get(key);
        int id = chess.getId();
        if (id == 5 || id == 15) return false;
        chessMap.put(key, null);
        for (int i = 0, len = chessArray.length; i < len; ++i) {
            if (chess.equals(chessArray[i])) {
                chessMap.remove(key);
                chessArray[i] = null;
                break;
            }
        }
        return true;
    }

    public abstract Team mirror();
}