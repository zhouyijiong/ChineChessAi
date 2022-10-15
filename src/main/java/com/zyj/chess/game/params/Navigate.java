package com.zyj.chess.game.params;

import com.zyj.chess.game.tool.BitList;

import java.util.HashMap;
import java.util.Map;

//TODO 寻路空位取消BitList，采用HashMap，空位是待工击，友方是保护，敌方是吃子，吃子需要棋子信息和棋子位置，评估多个吃子哪个更有利，减少收敛次数
public final class Navigate {
    public final BitList point;

    public final Map<Integer, Integer> eat = new HashMap<>();

    public final Map<Integer, Integer> protect = new HashMap<>();

    public Navigate(int len, int width, BitList.CapacityMode capacityMode) {
        this.point = new BitList(len, 1, width, capacityMode);
    }

    public void clear() {
        point.clearAll();
        eat.clear();
    }
}