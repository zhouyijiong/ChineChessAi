package com.zyj.chess.game.tool;

import com.zyj.chess.game.params.Params;

public final class BitList {
    private long[] data;

    private int size, index, current;

    private final int width, rounds;

    private final long remainder, defaultValue;

    private final CapacityMode capacityMode;

    interface CapacityMode {
        long[] capacity(int oldSize);
    }

    public BitList(int len, int head, int width, CapacityMode capacityMode) {
        this.data = new long[len];
        this.width = width;
        this.rounds = 18 / width;
        this.capacityMode = capacityMode;
        if (head < 1 || head > 9) throw new RuntimeException("head range 1-9");
        this.remainder = Params.DIGITS[18 - width];
        this.defaultValue = head * 1000000000000000000L;
        for (int i = 0; i < len; ++i) data[i] = defaultValue;
    }

    public BitList(long[] data, int width, CapacityMode capacityMode) {
        this.data = data;
        this.width = width;
        this.rounds = 18 / width;
        this.capacityMode = capacityMode;
        this.remainder = Params.DIGITS[18 - width];
        this.defaultValue = 1000000000000000000L;
    }

    public void put(int n) {
        if (++current > rounds) {
            current = 1;
            if (++index + 1 > data.length) capacity();
        }
        ++size;
        data[index] += Params.DIGITS[current * width] * n;
    }

    public long get(int n) {
        return data[n];
    }

    public int bit(int i) {
        return (int) (data[i / rounds] / Params.DIGITS[i * width % 18 + width] % remainder);
    }

    public int bit(int y, int x) {
        return (int) (data[y] / Params.DIGITS[x * width] % remainder);
    }

    public void update(int i, int n) {
        long l = data[i / rounds];
        long base = Params.DIGITS[i * width % 18 + width];
        data[i / rounds] = l + base * (n - l / base % remainder);
    }

    public void update(int y, int x, int n) {
        long l = data[y];
        long base = Params.DIGITS[x * width];
        data[y] = l + base * (n - l / base % remainder);
    }

    public void clear(int i) {
        long l = data[i / rounds];
        long base = Params.DIGITS[i * width % 18 + width];
        data[i / rounds] = l - base * (l / base % remainder);
    }

    public void clear(int y, int x) {
        long l = data[y];
        long base = Params.DIGITS[x * width];
        data[y] = l - base * (l / base % remainder);
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
        for (int i = oldLength, len = temp.length; i < len; ++i) temp[i] = defaultValue;
        System.arraycopy(data, 0, temp, 0, oldLength);
        data = temp;
    }
}