package com.zyj.chess.game.params;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Params {
    public static final String[] CHESSMAN_NAME = {"空位",
            "黑车", "黑马", "黑象", "黑士", "黑将", "黑炮", "黑兵", "空位", "空位", "空位",
            "红车", "红马", "红象", "红士", "红帥", "红炮", "红兵"
    };

    public static final int[] BLACK_KING_AROUND = {1, -1, -9};
    public static final int[] BLACK_KING_LOCATION = {14, 15, 16, 24, 25, 26, 34, 35, 36};
    public static final int[] BLACK_SQUIRE_LOCATION = {14, 16, 25, 34, 36};
    public static final int[] BLACK_SOLDIER_LOCATION = {54, 56, 58, 60, 62};
    public static final int[] BLACK_ELEPHANT_LOCATION = {13, 17, 31, 35, 39, 53, 57};
    public static final Map<Integer, List<Integer>> BLACK_HORSE_NAVIGATE;
    public static final Map<Integer, Map<List<Integer>, List<Integer>>> BLACK_ELEPHANT_NAVIGATE;
    public static final Map<Integer, List<Integer>> BLACK_SQUIRE_NAVIGATE;
    public static final Map<Integer, List<Integer>> BLACK_KING_NAVIGATE;
    public static final Map<Integer, List<Integer>> BLACK_SOLDIER_NAVIGATE;
    public static final Map<Integer, List<Integer>> RED_HORSE_NAVIGATE;
    //public static final Map<Integer, List<Integer>> RED_ELEPHANT_NAVIGATE;
    public static final Map<Integer, List<Integer>> RED_SQUIRE_NAVIGATE;
    public static final Map<Integer, List<Integer>> RED_KING_NAVIGATE;
    public static final Map<Integer, List<Integer>> RED_SOLDIER_NAVIGATE;

    static {
        BLACK_HORSE_NAVIGATE = calcHorseNavigate();
        BLACK_ELEPHANT_NAVIGATE = calcElephantNavigate();
        BLACK_SQUIRE_NAVIGATE = calcSquireNavigate();
        BLACK_KING_NAVIGATE = calcKingNavigate();
        BLACK_SOLDIER_NAVIGATE = calcSoldierNavigate();
        RED_HORSE_NAVIGATE = calcHorseNavigate();
        //RED_ELEPHANT_NAVIGATE = mirrorNavigate(BLACK_ELEPHANT_NAVIGATE);
        RED_SQUIRE_NAVIGATE = mirrorNavigate(BLACK_SQUIRE_NAVIGATE);
        RED_KING_NAVIGATE = mirrorNavigate(BLACK_KING_NAVIGATE);
        RED_SOLDIER_NAVIGATE = mirrorNavigate(BLACK_SOLDIER_NAVIGATE);
    }

    static Map<Integer, List<Integer>> calcHorseNavigate() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 90; ++i) {
            int y = i / 9;
            int x = i % 9;
            List<Integer> point = new ArrayList<>();
            if (y - 2 > -1 && x - 2 > -1) point.add((y - 2) * 9 + (x - 2) % 9);
            if (y - 2 > -1 && x - 1 > -1) point.add((y - 2) * 9 + (x - 1) % 9);
            if (y - 2 > -1 && x + 1 < 9) point.add((y - 2) * 9 + (x + 1) % 9);
            if (y - 2 > -1 && x + 2 < 9) point.add((y - 2) * 9 + (x + 2) % 9);
            if (y + 2 < 10 && x - 2 > -1) point.add((y + 2) * 9 + (x - 2) % 9);
            if (y + 2 < 10 && x - 1 > -1) point.add((y + 2) * 9 + (x - 1) % 9);
            if (y + 2 < 10 && x + 1 < 9) point.add((y + 2) * 9 + (x + 1) % 9);
            if (y + 2 < 10 && x + 2 < 9) point.add((y + 2) * 9 + (x + 2) % 9);
            map.put(i, point);
        }
        return map;
    }

    static Map<Integer, Map<List<Integer>, List<Integer>>> calcElephantNavigate() {
        Map<Integer, Map<List<Integer>, List<Integer>>> map = new HashMap<>();
        for (int i : BLACK_ELEPHANT_LOCATION) {
            int y = i / 10, x = i % 10, t;
            List<Integer> point = new ArrayList<>();
            List<Integer> baffle = new ArrayList<>();
            if (x + 2 < 10 && (t = y - 2) > 0) {
                point.add(t * 10 + x + 2);
                baffle.add((y - 1) * 10 + x + 1);
            }
            if (x + 2 < 10 && (t = y + 2) < 6) {
                point.add(t * 10 + x + 2);
                baffle.add((y + 1) * 10 + x + 1);
            }
            if (x - 2 > 0 && (t = y - 2) > 0) {
                point.add(t * 10 + x - 2);
                baffle.add((y - 1) * 10 + x - 1);
            }
            if (x - 2 > 0 && (t = y + 2) < 6) {
                point.add(t * 10 + x - 2);
                baffle.add((y + 1) * 10 + x - 1);
            }
            map.put(i, new HashMap<List<Integer>, List<Integer>>() {
                {
                    put(point, baffle);
                }
            });
        }
        return map;
    }

    static Map<Integer, List<Integer>> calcSquireNavigate() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : BLACK_SQUIRE_LOCATION) {
            int y = i / 10, x = i % 10, t;
            List<Integer> point = new ArrayList<>();
            if (x + 1 < 7 && (t = y - 1) > 0) point.add(t * 10 + x + 1);
            if (x - 1 > 3 && (t = y - 1) > 0) point.add(t * 10 + x - 1);
            if (x + 1 < 7 && (t = y + 1) < 4) point.add(t * 10 + x + 1);
            if (x - 1 > 3 && (t = y + 1) < 4) point.add(t * 10 + x - 1);
            map.put(i, point);
        }
        return map;
    }

    static Map<Integer, List<Integer>> calcKingNavigate() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : BLACK_KING_LOCATION) {
            int y = i / 10, x = i % 10, t;
            List<Integer> point = new ArrayList<>();
            if ((t = x - 1) > 3) point.add(y * 10 + t);
            if ((t = x + 1) < 7) point.add(y * 10 + t);
            if ((t = y + 1) < 4) point.add(t * 10 + x);
            if ((t = y - 1) > 0) point.add(t * 10 + x);
            map.put(i, point);
        }
        return map;
    }

    static Map<Integer, List<Integer>> calcSoldierNavigate() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 62; i > -1; i--) {
            int y = i / 9;
            int x = i % 9;
            List<Integer> point = new ArrayList<>();
            if (y < 5) {
                if (x - 1 > -1) point.add(y * 9 + (x - 1) % 9);
                if (x + 1 < 9) point.add(y * 9 + (x + 1) % 9);
                if (y - 1 > -1) point.add((y - 1) * 9 + x % 9);
            } else {
                for (int item : BLACK_SOLDIER_LOCATION) {
                    int itemX = item % 9;
                    if (x != itemX) continue;
                    point.add((y - 1) * 9 + x % 9);
                }
            }
            if (point.size() > 0) map.put(i, point);
        }
        return map;
    }

    static Map<Integer, List<Integer>> mirrorNavigate(Map<Integer, List<Integer>> map) {
        Map<Integer, List<Integer>> mirrorMap = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> item : map.entrySet()) {
            List<Integer> point = new ArrayList<>();
            item.getValue().forEach((i) -> point.add((9 - i / 9) * 9 + i % 9));
            mirrorMap.put((9 - item.getKey() / 9) * 9 + item.getKey() % 9, point);
        }
        return mirrorMap;
    }
}