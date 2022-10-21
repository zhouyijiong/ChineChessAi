package com.zyj.chess.ai.valuation;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.team.Team;

//TODO 分数细化，智能则分，目前只有总分
public final class Valuation {
    //TODO 把棋子分数存储到Team下，删除一个棋子就删除对应分数
    public double check(int color) {
        Game.RED_MIRROR.referenceNavigate();
        Game.BLACK_MIRROR.referenceNavigate();
        double redScore = calcDangerScore(Game.RED_MIRROR.getChessArray());
        double blackScore = calcDangerScore(Game.BLACK_MIRROR.getChessArray());
        return color > 0 ? redScore - blackScore : blackScore - redScore;
    }

    public double calcDangerScore(Chessman[] chessman) {
        double chessScore = 0, eatScore = 0, protectScore = 0, moveScore = 0;
        for (Chessman item : chessman) {
            if (item == null) continue;
            Navigate navigate = item.getReferenceNavigate();
            chessScore += item.getScore();
            moveScore += item.calcMoveScore(navigate.moves);
            eatScore += item.calcEatScore(navigate.eats, 0);
            protectScore += item.calcProtectScore(navigate.protect, 0);
        }
        System.out.println("棋子分数: " + chessScore);
        System.out.println("移动分数: " + moveScore);
        System.out.println("吃子分数: " + eatScore);
        System.out.println("保护分数: " + protectScore);
        return chessScore + moveScore + eatScore + protectScore;
    }
}