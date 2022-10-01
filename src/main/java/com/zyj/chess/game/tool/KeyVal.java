package com.zyj.chess.game.tool;

/**
 * 键值对
 */
public final class KeyVal<K, V> {
    public final K k;
    public final V v;

    private KeyVal(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public static <K, V> KeyVal<K, V> init(K k, V v) {
        return new KeyVal<>(k, v);
    }
}