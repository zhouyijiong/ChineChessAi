package com.zyj.chess.game.chessman;

import com.zyj.chess.ai.valuation.Valuation;
import com.zyj.chess.game.Game;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.team.Team;
import com.zyj.chess.game.tool.BitList;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Chessman {
    protected int id;
    protected int x;
    protected int y;
    protected double score;
    protected final Navigate normalNavigate;
    protected final Navigate referenceNavigate;

    static final int[] SCORES = new int[]{0, 23, 11, 6, 6, 100, 11, 4, 0, 0, 0, 23, 11, 6, 6, 100, 11, 4};

    static final double[] MOVE_RATIO = new double[]{0, 9, 7, 3, 3, 2.5, 0.35, 1, 0, 0, 0, 9, 7, 3, 3, 2.5, 0.35, 1};

    static final double[] EAT_RATIO = new double[]{0, 5.75, 2.75, 1.5, 1.5, 0xff, 2.75, 1, 0, 0, 0, 5.75, 2.75, 1.5, 1.5, 0xff, 2.75, 1};

    static final double[] PROTECT_RATIO = new double[]{0, 0.65, 0.65, 0.6, 0.6, 1.3, 0.65, 0.35, 0, 0, 0, 0.65, 0.65, 0.6, 0.6, 1.3, 0.65, 0.35};

    public Chessman(int id, int x, int y, double score, int len, int width, BitList.CapacityMode capacityMode) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.score = score;
        this.normalNavigate = new Navigate(len, width, capacityMode);
        this.referenceNavigate = new Navigate(len, width, capacityMode);
    }

    public abstract void navigate(Navigate navigate);

    public void normalNavigate() {
        navigate(normalNavigate.clear());
    }

    public void referenceNavigate() {
        navigate(referenceNavigate.clear());
    }

    public double calcMoveScore(BitList moves) {
        return moves.size() * MOVE_RATIO[id];
    }

    public double calcEatScore(Map<Integer, Integer> eats, double score) {
        for (Map.Entry<Integer, Integer> item : eats.entrySet()) {
            int id = item.getValue();
            score += SCORES[id] * EAT_RATIO[id];
        }
        return score;
    }

    public double calcProtectScore(Map<Integer, Integer> protect, double score) {
        for (Map.Entry<Integer, Integer> item : protect.entrySet()) {
            int id = item.getValue();
            score += SCORES[id] * PROTECT_RATIO[id];
        }
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<< pro : " + score + ", " + SCORES[id] + ", " + PROTECT_RATIO[id] + ", " + id);
//        if (tid == 12 && protect.size() > 0) {
//            System.out.println(protect);
//            throw new RuntimeException();
//        }
        return score;
    }

    public double probe(Team red, Team black, int color) {
        int index;
        double score;
        System.out.println(this);
        normalNavigate();
        BitList bitList = normalNavigate.moves;
        System.out.println(bitList.get(0));
        Game.BOARD.record();
        for (int i = 0, len = bitList.size(); i < len; ++i) {
            index = bitList.bit(i);
            int ty = y, tx = x;
            Game.BOARD.move(index / 10, index % 10, this);
            //System.out.println(this);
            score = Game.VALUATION.check(red, black, color);
            System.out.println("移动: " + index + ",分数: " + score);
            setY(ty);
            setX(tx);
            Game.BOARD.rollback();
            Game.RED.rollback();
            Game.BLACK.rollback();
            //System.out.println(this);
            //if(i==1) throw new RuntimeException();
        }
        Map<Integer, Integer> eats = normalNavigate.eats;
        for (Map.Entry<Integer, Integer> item : eats.entrySet()) {
            index = item.getKey();
            if (Game.BOARD.eat(index / 10, index % 10, this) > 0) {
                score = Game.VALUATION.check(red, black, color);
                //System.out.println("吃子: " + index + ",分数: " + score);
                Game.BOARD.rollback();
            } else {
                System.out.println("游戏结束");
            }
        }
        return -1;
    }
}