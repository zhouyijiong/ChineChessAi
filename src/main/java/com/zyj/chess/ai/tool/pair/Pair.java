package com.zyj.chess.ai.tool.pair;

public interface Pair<K, V> {
    V put(K key, V val);

    void get();
}