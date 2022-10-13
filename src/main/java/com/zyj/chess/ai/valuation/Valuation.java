package com.zyj.chess.ai.valuation;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.team.Team;

import java.util.Map;

public final class Valuation {
    public static final int[] SCORES = new int[]{0, 23, 11, 6, 6, 100, 11, 4, 0, 0, 0, 23, 11, 6, 6, 100, 11, 4};
    public static final double[] RATIO = new double[]{0, 2, 1, 1, 1, 10, 0.2, 1, 0, 0, 0, 2, 1, 1, 1, 10, 0.2, 1};

    public double check(Team team) {
        double black = calcDangerScore(Game.BLACK.getChess())
                + calcChessmenScore(Game.BLACK.getChess());
        double red = calcDangerScore(Game.RED.getChess())
                + calcChessmenScore(Game.RED.getChess());
        return team.getColor() == 0 ? black - red : red - black;
    }

    //TODO 修改后Navigate会增加保护棋子，可以让局面评估更加细腻
    public double calcDangerScore(Chessman[] chessman) {
        int score = 0;
        for (Chessman item : chessman) {
            Navigate navigate = item.getNavigate();
            for (Map.Entry<Integer, Integer> eat : navigate.eat.entrySet()) {
                score += SCORES[eat.getValue()] * 1.5;
            }
            score += navigate.point.size() * RATIO[item.getId()];
        }
        return score;
    }

    public int calcChessmenScore(Chessman[] chessmen) {
        int score = 0;
        for (Chessman item : chessmen) score += item.getScore();
        return score;
    }

    public static void main(String[] args) {
        Valuation valuation = new Valuation();
        Game.BLACK.navigate();
        Game.RED.navigate();
        System.out.println(valuation.check(Game.RED));
    }
}