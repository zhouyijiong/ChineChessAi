package com.zyj.chess.game.params;

import com.zyj.chess.game.tool.BitList;

import java.util.HashMap;
import java.util.Map;

public final class Navigate {
    public final BitList point;

    public final Map<Integer, Integer> eat = new HashMap<>();

    public Navigate(int len, int width, BitList.CapacityMode capacityMode) {
        this.point = new BitList(len, 1, width, capacityMode);
    }

    public void clear() {
        point.clearAll();
        eat.clear();
    }
}