package com.zyj.chess.game.tool;

import java.util.Arrays;

public final class BitList {
    private long[] data;

    private int size, index, current;

    private final int base, width, rounds;

    private final long remainder, defaultValue;

    private final CapacityMode capacityMode;

    static final long[] DIGITS = {1000000000000000000L, 100000000000000000L, 10000000000000000L, 1000000000000000L, 100000000000000L, 10000000000000L, 1000000000000L, 100000000000L, 10000000000L, 1000000000L, 100000000L, 10000000L, 1000000L, 100000L, 10000L, 1000L, 100L, 10L, 1L};

    public interface CapacityMode {
        long[] capacity(int oldSize);
    }

    private BitList(BitList bitList) {
        this.data = new long[bitList.data.length];
        System.arraycopy(bitList.data,0,data,0,data.length);
        this.width = bitList.width;
        this.rounds = bitList.rounds;
        this.base = bitList.base;
        this.capacityMode = bitList.capacityMode;
        this.remainder = bitList.remainder;
        this.defaultValue = bitList.defaultValue;
        this.index = bitList.index;
        this.size = bitList.size;
        this.current = bitList.current;
    }

    public BitList(int len, int head, int width, CapacityMode capacityMode) {
        this.data = new long[len];
        this.width = width;
        this.rounds = 18 / width;
        this.base = width * rounds;
        this.capacityMode = capacityMode;
        if (head < 1 || head > 9) throw new RuntimeException("head range 1-9");
        this.remainder = DIGITS[18 - width];
        this.defaultValue = head * 1000000000000000000L;
        for (int i = 0; i < len; ++i) data[i] = defaultValue;
    }

    public BitList(long[] data, int width, CapacityMode capacityMode) {
        this.data = data;
        this.width = width;
        this.rounds = 18 / width;
        this.base = width * rounds;
        this.capacityMode = capacityMode;
        this.remainder = DIGITS[18 - width];
        this.defaultValue = 1000000000000000000L;
    }

    public BitList mirror() {
        return new BitList(this);
    }

    public void add(int n) {
        if (++current > rounds) {
            current = 1;
            if (++index + 1 > data.length) capacity();
        }
        ++size;
        data[index] += DIGITS[current * width] * n;
    }

    public long get(int n) {
        return data[n];
    }

    public int bit(int i) {
        return (int) (data[i / rounds] / DIGITS[i * width % base + width] % remainder);
    }

    public int bit(int y, int x) {
        return (int) (data[y] / DIGITS[x * width] % remainder);
    }

    public void update(int i, int n) {
        long l = data[i / rounds];
        long base = DIGITS[i * width % this.base + width];
        data[i / rounds] = l + base * (n - l / base % remainder);
    }

    public void update(int y, int x, int n) {
        long l = data[y];
        long base = DIGITS[x * width];
        data[y] = l + base * (n - l / base % remainder);
    }

    public void clear(int i) {
        long l = data[i / rounds];
        long base = DIGITS[i * width % this.base + width];
        data[i / rounds] = l - base * (l / base % remainder);
    }

    public void clear(int y, int x) {
        long l = data[y];
        long base = DIGITS[x * width];
        data[y] = l - base * (l / base % remainder);
    }

    public void clearAll() {
        size = 0;
        index = 0;
        current = 0;
        for (int i = 0, len = data.length; i < len; i++) data[i] = defaultValue;
    }

    public int size() {
        return size;
    }

    public long[] data() {
        return data;
    }

    public void capacity() {
        int oldLength = data.length;
        long[] temp = capacityMode.capacity(oldLength);
        System.arraycopy(data, 0, temp, 0, oldLength);
        for (int i = oldLength, len = temp.length; i < len; ++i) temp[i] = defaultValue;
        data = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(data[0]);
        for (int i = 1; i < index; ++i) sb.append(", ").append(data[i]);
        return sb.append("]").toString();
    }
}