package com.zyj.chess.game.params;

import com.zyj.chess.game.Game;

import java.util.*;

public final class Params {
    public static final String[] CHESSMAN_NAME = {"空位",
            "黑车", "黑马", "黑象", "黑士", "黑将", "黑炮", "黑兵", "空位", "空位", "空位",
            "红车", "红马", "红象", "红士", "红帥", "红炮", "红兵"
    };

    private static final int[] BLACK_ELEPHANT_LOCATION = {13, 17, 31, 35, 39, 53, 57};

    private static final int[] BLACK_SQUIRE_LOCATION = {14, 16, 25, 34, 36};

    private static final int[] BLACK_KING_LOCATION = {14, 15, 16, 24, 25, 26, 34, 35, 36};

    private static final int[][] BOARD_POINT = {
            {11, 12, 13, 14, 15, 16, 17, 18, 19},
            {21, 22, 23, 24, 25, 26, 27, 28, 29},
            {31, 32, 33, 34, 35, 36, 37, 38, 39},
            {41, 42, 43, 44, 45, 46, 47, 48, 49},
            {51, 52, 53, 54, 55, 56, 57, 58, 59},
            {61, 62, 63, 64, 65, 66, 67, 68, 69},
            {71, 72, 73, 74, 75, 76, 77, 78, 79},
            {81, 82, 83, 84, 85, 86, 87, 88, 89},
            {91, 92, 93, 94, 95, 96, 97, 98, 99},
            {101, 102, 103, 104, 105, 106, 107, 108, 109}
    };

    public static final Map<Integer, Map<List<Integer>, List<Integer>>> HORSE_NAVIGATE;
    public static final Map<Integer, Map<List<Integer>, List<Integer>>> BLACK_ELEPHANT_NAVIGATE;
    public static final Map<Integer, Map<List<Integer>, List<Integer>>> RED_ELEPHANT_NAVIGATE;
    public static final Map<Integer, List<Integer>> BLACK_SQUIRE_NAVIGATE;
    public static final Map<Integer, List<Integer>> BLACK_KING_NAVIGATE;
    public static final Map<Integer, List<Integer>> RED_SQUIRE_NAVIGATE;
    public static final Map<Integer, List<Integer>> RED_KING_NAVIGATE;

    static {
        HORSE_NAVIGATE = calcHorseNavigate();
        BLACK_ELEPHANT_NAVIGATE = calcElephantNavigate();
        BLACK_SQUIRE_NAVIGATE = calcSquireNavigate();
        BLACK_KING_NAVIGATE = calcKingNavigate();
        RED_ELEPHANT_NAVIGATE = mirrorElephantNavigate();
        RED_SQUIRE_NAVIGATE = mirrorNavigate(BLACK_SQUIRE_NAVIGATE);
        RED_KING_NAVIGATE = mirrorNavigate(BLACK_KING_NAVIGATE);
    }

    public static void getNavigate(Map<Integer, Map<List<Integer>, List<Integer>>> maps, List<Integer> list, int x, int y) {
        Map<List<Integer>, List<Integer>> map = maps.get(y * 10 + x);
        for (Map.Entry<List<Integer>, List<Integer>> item : map.entrySet()) {
            List<Integer> point = item.getKey();
            List<Integer> baffle = item.getValue();
            for (int i = 0, len = baffle.size(); i < len; ++i) {
                int xy = baffle.get(i);
                if (Game.BOARD.get(xy / 10, xy % 10) == 0) list.add(point.get(i));
            }
        }
    }

    public static void calcCareNavigate(List<Integer> list, int id, int x, int y) {
        boolean key = id < 8;
        for (id = x + 1; id < 10; ++id) if (calcCareNavigateCore(list, id, y, key)) break;
        for (id = x - 1; id > 0; --id) if (calcCareNavigateCore(list, id, y, key)) break;
        for (id = y + 1; id < 11; ++id) if (calcCareNavigateCore(list, x, id, key)) break;
        for (id = y - 1; id > 0; --id) if (calcCareNavigateCore(list, x, id, key)) break;
    }

    private static Map<Integer, Map<List<Integer>, List<Integer>>> calcHorseNavigate() {
        Map<Integer, Map<List<Integer>, List<Integer>>> map = new HashMap<>();
        for (int[] arrays : BOARD_POINT) {
            for (int i : arrays) {
                int y = i / 10, x = i % 10, t;
                List<Integer> point = new ArrayList<>();
                List<Integer> baffle = new ArrayList<>();
                if ((t = y - 2) > 0) {
                    if (x + 1 < 10) {
                        point.add(t * 10 + x + 1);
                        baffle.add((y - 1) * 10 + x);
                    }
                    if (x - 1 > 0) {
                        point.add(t * 10 + x - 1);
                        baffle.add((y - 1) * 10 + x);
                    }
                }
                if (x + 2 < 10) {
                    baffle.add(t = y * 10 + x + 1);
                    point.add((y + 1) * 10 + x + 2);
                    if ((y - 1) > 0) {
                        point.add((y - 1) * 10 + x + 2);
                        baffle.add(t);
                    }
                }
                if ((t = y + 2) < 11) {
                    if (x + 1 < 10) {
                        point.add(t * 10 + x + 1);
                        baffle.add((y + 1) * 10 + x);
                    }
                    if (x - 1 > 0) {
                        point.add(t * 10 + x - 1);
                        baffle.add((y + 1) * 10 + x);
                    }
                }
                if (x - 2 > 0) {
                    point.add((y + 1) * 10 + x - 2);
                    baffle.add(t = y * 10 + x - 1);
                    if ((y - 1) > 0) {
                        point.add((y - 1) * 10 + x - 2);
                        baffle.add(t);
                    }
                }
                map.put(i, new HashMap<List<Integer>, List<Integer>>() {
                    {
                        put(point, baffle);
                    }
                });
            }
        }
        return map;
    }

    private static Map<Integer, Map<List<Integer>, List<Integer>>> calcElephantNavigate() {
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

    private static Map<Integer, List<Integer>> calcSquireNavigate() {
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

    private static Map<Integer, List<Integer>> calcKingNavigate() {
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

    public static void calcCannonNavigate(List<Integer> list, int id, int x, int y) {
        boolean key = id < 8;
        for (id = x + 1; id < 10; ++id) if (calcCannonMoveCore(list, id, y))
            for (++id; id < 10; ++id) if (calcAttackCore(list, id, y, key)) break;
        for (id = x - 1; id > 0; --id) if (calcCannonMoveCore(list, id, y))
            for (--id; id > 0; --id) if (calcAttackCore(list, id, y, key)) break;
        for (id = y + 1; id < 11; ++id) if (calcCannonMoveCore(list, x, id))
            for (++id; id < 11; ++id) if (calcAttackCore(list, x, id, key)) break;
        for (id = y - 1; id > 0; --id) if (calcCannonMoveCore(list, x, id))
            for (--id; id > 0; --id) if (calcAttackCore(list, x, id, key)) break;
    }

    private static boolean calcCareNavigateCore(List<Integer> list, int x, int y, boolean key) {
        int id;
        if ((id = Game.BOARD.get(y, x)) == 0) {
            list.add(y * 10 + x);
            return false;
        } else if (key ? id > 7 : id < 8) list.add(y * 10 + x);
        return true;
    }

    public static boolean calcCannonMoveCore(List<Integer> list, int x, int y) {
        if (Game.BOARD.get(y, x) == 0) {
            list.add(y * 10 + x);
            return false;
        }
        return true;
    }

    public static boolean calcAttackCore(List<Integer> list, int x, int y, boolean key) {
        int id;
        if ((id = Game.BOARD.get(y, x)) == 0) {
            return false;
        } else if (key ? id > 7 : id < 8) list.add(y * 10 + x);
        return true;
    }

    private static List<Integer> mirrorList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        list.forEach((i) -> result.add((11 - i / 10) * 10 + i % 10));
        return result;
    }

    private static Map<Integer, List<Integer>> mirrorNavigate(Map<Integer, List<Integer>> map) {
        Map<Integer, List<Integer>> mirrorMap = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> item : map.entrySet()) {
            mirrorMap.put((11 - item.getKey() / 10) * 10 + item.getKey() % 10, mirrorList(item.getValue()));
        }
        return mirrorMap;
    }

    private static Map<Integer, Map<List<Integer>, List<Integer>>> mirrorElephantNavigate() {
        Map<Integer, Map<List<Integer>, List<Integer>>> mirrorMap = new HashMap<>();
        for (Map.Entry<Integer, Map<List<Integer>, List<Integer>>> item : BLACK_ELEPHANT_NAVIGATE.entrySet()) {
            for (Map.Entry<List<Integer>, List<Integer>> p_b : item.getValue().entrySet()) {
                mirrorMap.put((11 - item.getKey() / 10) * 10 + item.getKey() % 10, new HashMap<List<Integer>, List<Integer>>() {
                    {
                        put(mirrorList(p_b.getKey()), mirrorList(p_b.getValue()));
                    }
                });
            }
        }
        return mirrorMap;
    }
}