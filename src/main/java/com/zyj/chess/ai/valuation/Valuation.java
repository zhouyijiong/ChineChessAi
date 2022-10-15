package com.zyj.chess.ai.valuation;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.team.Team;

import java.util.Map;

//TODO 分数细化，智能则分，目前只有总分
public final class Valuation {
    public static final int[] SCORES = new int[]{0, 23, 11, 6, 6, 100, 11, 4, 0, 0, 0, 23, 11, 6, 6, 100, 11, 4};

    public static final double[] POINT_RATIO = new double[]{0, 2, 1, 1, 1, 10, 0.2, 1, 0, 0, 0, 2, 1, 1, 1, 10, 0.2, 1};

    public static final double[] EAT_RATIO = new double[]{0, 5.75, 2.75, 1.5, 1.5, 0xff, 2.75, 1, 0, 0, 0, 5.75, 2.75, 1.5, 1.5, 0xff, 2.75, 1};

    public static final double[] PROTECT_RATIO = new double[]{0, 1.5, 3, 4, 4, 0xff, 3, 0.8, 0, 0, 0, 1.5, 3, 4, 4, 0xff, 3, 0.8};

    public double check(Team team) {
        double black = calcDangerScore(Game.BLACK.getChess())
                + calcChessmenScore(Game.BLACK.getChess());
        double red = calcDangerScore(Game.RED.getChess())
                + calcChessmenScore(Game.RED.getChess());
        return team.getColor() == 0 ? black - red : red - black;
    }

    public double calcDangerScore(Chessman[] chessman) {
        int score = 0, id;
        for (Chessman item : chessman) {
            Navigate navigate = item.getNavigate();
            for (Map.Entry<Integer, Integer> eat : navigate.eat.entrySet()) {
                id = eat.getValue();
                score += SCORES[id] * EAT_RATIO[id];
            }
            for (Map.Entry<Integer, Integer> protect : navigate.protect.entrySet()) {
                id = protect.getValue();
                score += SCORES[id] * PROTECT_RATIO[id];
            }
            score += navigate.point.size() * POINT_RATIO[item.getId()];
        }
        return score;
    }

    public int calcChessmenScore(Chessman[] chessmen) {
        int score = 0;
        for (Chessman item : chessmen) score += item.getScore();
        return score;
    }
}