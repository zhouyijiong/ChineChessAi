package com.zyj.chess.game.params;

import com.zyj.chess.game.tool.BitList;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
//TODO 寻路空位取消BitList，采用HashMap，空位是待工击，友方是保护，敌方是吃子，吃子需要棋子信息和棋子位置，评估多个吃子哪个更有利，减少收敛次数
public final class Navigate {
    public final BitList moves;

    public final Map<Integer, Integer> eats = new HashMap<>();

    public final Map<Integer, Integer> protect = new HashMap<>();

    public Navigate(int len, int width, BitList.CapacityMode capacityMode) {
        this.moves = new BitList(len, 1, width, capacityMode);
    }

    public Navigate clear() {
        moves.clearAll();
        eats.clear();
        protect.clear();
        return this;
    }
}