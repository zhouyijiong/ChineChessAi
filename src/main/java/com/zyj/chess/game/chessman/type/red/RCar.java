package com.zyj.chess.game.chessman.type.red;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 红车
 */
public final class RCar extends Chessman {
    public static RCar initLeft() {
        return new RCar(Color.RED.val, 0, 23);
    }

    public static RCar initRight() {
        return new RCar(Color.RED.val, 8, 23);
    }

    private RCar(int color, int index, int score) {
        super(color, index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        if (params[0] / 9 == index / 9) {

        }
        //x,y
        return 0;
    }
}