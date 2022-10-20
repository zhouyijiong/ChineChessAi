package com.zyj.chess.ai.model;

import java.math.BigInteger;
import java.util.List;

public final class Model {
    /**
     * 局面
     */
    private BigInteger state;

    /**
     * 走法
     */
    private List<BigInteger> next;

    /**
     * 概率
     */
    private List<Double> probability;

    /**
     * 胜率
     */
    private List<Double> winRate;
}