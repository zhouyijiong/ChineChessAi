package com.zyj.chess.game.chessman;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.tool.BitList;
import com.zyj.chess.game.tool.KV;
import lombok.*;

import java.util.HashMap;
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

    static final double[] PROTECT_RATIO = new double[]{0, 0.65, 0.65, 0.6, 0.6, 0.7, 0.65, 0.35, 0, 0, 0, 0.65, 0.65, 0.6, 0.6, 0.7, 0.65, 0.35};

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

    public void probe(Map<Double, KV<Chessman, Integer>> map, double[] scores, int color) {
        int index;
        double score;
        System.out.println(this);
        BitList bitList = normalNavigate.moves;
        Game.BOARD.record();
        int size = bitList.size();
        for (int i = 0; i < size; ++i) {
            index = bitList.bit(i);
            int ty = y, tx = x;
            Game.BOARD.move(index / 10, index % 10, this);
            //System.out.println(this);
            score = Game.VALUATION.check(color);
            scores[i] = score;
            map.put(score, new KV<>(this, i));
            System.out.println("移动: " + index + ",分数: " + score);
            setY(ty);
            setX(tx);
            Game.rollback();
            //System.out.println(this);
            //if(i==1) throw new RuntimeException();
        }
        int i = -1;
        for (Map.Entry<Integer, Integer> item : normalNavigate.eats.entrySet()) {
            index = item.getKey();
            if (Game.BOARD.eat(index / 10, index % 10, this, color)) {
                score = Game.VALUATION.check(color);
                scores[size++] = score;
                map.put(score, new KV<>(this, ++i));
                System.out.println("吃子: " + index + ",分数: " + score);
                Game.BOARD.rollback();
            } else {
                System.out.println("游戏结束");
            }
        }

    }
}