package com.zyj.chess.game.params;

public final class BitList {
    private int index = -1;

    private long[] data;

    public final CapacityMode capacityMode;

    interface CapacityMode {
        long[] capacity(int oldSize);
    }

    public BitList(int len, CapacityMode capacityMode) {
        data = new long[len];
        this.capacityMode = capacityMode;
    }

    public BitList(long[] data, CapacityMode capacityMode) {
        this.data = data;
        this.capacityMode = capacityMode;
    }

    public long get(int i) {
        return data[i];
    }

    public void put(long l) {
        if (++index + 1 > data.length) capacity();
        data[index] = l;
    }

    public void capacity() {
        long[] temp = capacityMode.capacity(data.length);
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }
}