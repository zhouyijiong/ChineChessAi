package com.zyj.chess.game.params;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.tool.BitList;

import java.util.*;

public final class Params {
    public static final String[] CHESSMAN_NAME = {"空位", "黑车", "黑马", "黑象", "黑士", "黑将", "黑炮", "黑兵", "空位", "空位", "空位", "红车", "红马", "红象", "红士", "红帥", "红炮", "红兵"};

    public static final Map<Integer, int[][]> HORSE_NAVIGATE;
    public static final Map<Integer, int[][]> BLACK_ELEPHANT_NAVIGATE;
    public static final Map<Integer, int[][]> RED_ELEPHANT_NAVIGATE;
    public static final Map<Integer, int[]> BLACK_SQUIRE_NAVIGATE;
    public static final Map<Integer, int[]> BLACK_KING_NAVIGATE;
    public static final Map<Integer, int[]> RED_SQUIRE_NAVIGATE;
    public static final Map<Integer, int[]> RED_KING_NAVIGATE;

    private static final int[][] BOARD_POINT = {{11, 12, 13, 14, 15, 16, 17, 18, 19}, {21, 22, 23, 24, 25, 26, 27, 28, 29}, {31, 32, 33, 34, 35, 36, 37, 38, 39}, {41, 42, 43, 44, 45, 46, 47, 48, 49}, {51, 52, 53, 54, 55, 56, 57, 58, 59}, {61, 62, 63, 64, 65, 66, 67, 68, 69}, {71, 72, 73, 74, 75, 76, 77, 78, 79}, {81, 82, 83, 84, 85, 86, 87, 88, 89}, {91, 92, 93, 94, 95, 96, 97, 98, 99}, {101, 102, 103, 104, 105, 106, 107, 108, 109}};

    static {
        HORSE_NAVIGATE = getHorseNavigate();
        BLACK_ELEPHANT_NAVIGATE = getBlackElephantNavigate();
        BLACK_SQUIRE_NAVIGATE = getBlackSquireNavigate();
        BLACK_KING_NAVIGATE = getBlackKingNavigate();
        RED_ELEPHANT_NAVIGATE = getRedElephantNavigate();
        RED_SQUIRE_NAVIGATE = getRedSquireNavigate();
        RED_KING_NAVIGATE = getRedKingNavigate();
    }

    public static void getNavigate(int[][] arrays, Navigate navigate, int id) {
        int[] point = arrays[0];
        int[] baffle = arrays[1];
        boolean key = id < 8;
        for (int i = 0, len = baffle.length; i < len; ++i) {
            int bp = baffle[i];
            if (Game.BOARD.get(bp / 10, bp % 10) == 0) {
                int p = point[i];
                if ((id = Game.BOARD.get(p / 10, p % 10)) == 0) {
                    navigate.moves.add(p);
                } else {
                    if (key ? id > 7 : id < 8) {
                        navigate.eats.put(p, id);
                    } else {
                        if (p % 5 != 0) navigate.protect.put(p, id);
                    }
                }
            }
        }
    }

    public static void calcCareNavigate(Navigate navigate, int id, int x, int y) {
        boolean key = id < 8;
        for (id = x + 1; id < 10; ++id) if (calcNavigateCore(navigate, id, y, key)) break;
        for (id = x - 1; id > 0; --id) if (calcNavigateCore(navigate, id, y, key)) break;
        for (id = y + 1; id < 11; ++id) if (calcNavigateCore(navigate, x, id, key)) break;
        for (id = y - 1; id > 0; --id) if (calcNavigateCore(navigate, x, id, key)) break;
    }

    private static void calcHorseNavigate(List<Integer> point, List<Integer> baffle, int x, int y, int t) {
        if (x - 2 > 0) {
            point.add(t * 10 + x - 2);
            baffle.add(y * 10 + x - 1);
        }
        if (x + 2 < 10) {
            point.add(t * 10 + x + 2);
            baffle.add(y * 10 + x + 1);
        }
    }

    private static Map<Integer, int[][]> getHorseNavigate() {
        Map<Integer, int[][]> map = new HashMap<>();
        for (int[] arrays : BOARD_POINT) {
            for (int i : arrays) {
                int y = i / 10, x = i % 10, t;
                List<Integer> point = new ArrayList<>();
                List<Integer> baffle = new ArrayList<>();
                if ((t = y - 1) > 0) calcHorseNavigate(point, baffle, x, y, t);
                if ((t = y + 1) < 11) calcHorseNavigate(point, baffle, x, y, t);
                if ((t = y - 2) > 0) {
                    if (x - 1 > 0) {
                        point.add(t * 10 + x - 1);
                        baffle.add((y - 1) * 10 + x);
                    }
                    if (x + 1 < 10) {
                        point.add(t * 10 + x + 1);
                        baffle.add((y - 1) * 10 + x);
                    }
                }
                if ((t = y + 2) < 11) {
                    if (x - 1 > 0) {
                        point.add(t * 10 + x - 1);
                        baffle.add((y + 1) * 10 + x);
                    }
                    if (x + 1 < 10) {
                        point.add(t * 10 + x + 1);
                        baffle.add((y + 1) * 10 + x);
                    }
                }
                int[] pa = new int[point.size()];
                int[] ba = new int[baffle.size()];
                for (int ti = 0, len = pa.length; ti < len; ++ti) pa[ti] = point.get(ti);
                for (int ti = 0, len = ba.length; ti < len; ++ti) ba[ti] = baffle.get(ti);
                map.put(i, new int[][]{pa, ba});
            }
        }
//        for (Map.Entry<Integer, int[][]> item : map.entrySet()) {
//            System.out.print("位置: " + item.getKey() + "\n");
//            int[][] temp = item.getValue();
//            for (int i = 0; i < temp.length; ++i) {
//                for (int j = 0; j < temp[i].length; ++j) {
//                    System.out.print(temp[i][j] + " ");
//                }
//                System.out.println();
//            }
//        }
        return map;
    }

    private static Map<Integer, int[][]> getBlackElephantNavigate() {
        Map<Integer, int[][]> map = new HashMap<>();
        map.put(13, new int[][]{{35, 31}, {24, 22}});
        map.put(17, new int[][]{{39, 35}, {28, 26}});
        map.put(31, new int[][]{{13, 53}, {22, 42}});
        map.put(35, new int[][]{{17, 57, 13, 53}, {26, 46, 24, 44}});
        map.put(39, new int[][]{{17, 57}, {28, 48}});
        map.put(53, new int[][]{{35, 31}, {44, 42}});
        map.put(57, new int[][]{{39, 35}, {48, 46}});
        return map;
    }

    private static Map<Integer, int[]> getBlackSquireNavigate() {
        Map<Integer, int[]> map = new HashMap<>();
        map.put(14, new int[]{25});
        map.put(16, new int[]{25});
        map.put(25, new int[]{16, 34, 14, 36});
        map.put(34, new int[]{25});
        map.put(36, new int[]{25});
        return map;
    }

    private static Map<Integer, int[]> getBlackKingNavigate() {
        Map<Integer, int[]> map = new HashMap<>();
        map.put(14, new int[]{15, 24});
        map.put(15, new int[]{14, 16, 25});
        map.put(16, new int[]{15, 26});
        map.put(24, new int[]{25, 34, 14});
        map.put(25, new int[]{24, 26, 35, 15});
        map.put(26, new int[]{25, 36, 16});
        map.put(34, new int[]{35, 24});
        map.put(35, new int[]{34, 36, 25});
        map.put(36, new int[]{35, 26});
        return map;
    }

    public static void calcCannonNavigate(Navigate navigate, int id, int x, int y) {
        boolean key = id < 8;
        for (id = x + 1; id < 10; ++id)
            if (calcCannonMoveCore(navigate.moves, id, y))
                for (++id; id < 10; ++id) if (calcCannonEatCore(navigate, id, y, key)) break;
        for (id = x - 1; id > 0; --id)
            if (calcCannonMoveCore(navigate.moves, id, y))
                for (--id; id > 0; --id) if (calcCannonEatCore(navigate, id, y, key)) break;
        for (id = y + 1; id < 11; ++id)
            if (calcCannonMoveCore(navigate.moves, x, id))
                for (++id; id < 11; ++id) if (calcCannonEatCore(navigate, x, id, key)) break;
        for (id = y - 1; id > 0; --id)
            if (calcCannonMoveCore(navigate.moves, x, id))
                for (--id; id > 0; --id) if (calcCannonEatCore(navigate, x, id, key)) break;
    }

    public static void calcSquireNavigate(Navigate navigate, boolean key, int x, int y, int pid) {
        int p;
        if ((p = x - 1) > 3 && Game.BOARD.get(y, p) == pid) navigate.protect.put(y * 10 + p, pid);
        if ((p = x + 1) < 7 && Game.BOARD.get(y, p) == pid) navigate.protect.put(y * 10 + p, pid);
        if ((p = y - 1) > 0 && Game.BOARD.get(p, x) == pid) navigate.protect.put(p * 10 + x, pid);
        if ((p = y + 1) < 11 && Game.BOARD.get(p, x) == pid) navigate.protect.put(p * 10 + x, pid);
        p = y * 10 + x;
        if ((x = Game.BOARD.get(y, x)) == 0) {
            navigate.moves.add(p);
        } else {
            if (key ? x > 7 : x < 8) {
                navigate.eats.put(p, x);
            } else {
                if (x % 5 != 0) navigate.protect.put(p, x);
            }
        }
    }

    public static void calcNavigate(Navigate navigate, boolean key, int x, int y) {
        int p = y * 10 + x;
        if ((x = Game.BOARD.get(y, x)) == 0) {
            navigate.moves.add(p);
        } else {
            if (key ? x > 7 : x < 8) {
                navigate.eats.put(p, x);
            } else {
                navigate.protect.put(p, x);
            }
        }
    }

    public static boolean calcNavigateCore(Navigate navigate, int x, int y, boolean key) {
        int p = y * 10 + x;
        if ((x = Game.BOARD.get(y, x)) == 0) {
            navigate.moves.add(p);
            return false;
        } else {
            if (key ? x > 7 : x < 8) {
                navigate.eats.put(p, x);
            } else {
                if (p % 5 != 0) navigate.protect.put(p, x);
            }
        }
        return true;
    }

    public static boolean calcCannonMoveCore(BitList point, int x, int y) {
        if (Game.BOARD.get(y, x) == 0) {
            point.add(y * 10 + x);
            return false;
        }
        return true;
    }

    public static boolean calcCannonEatCore(Navigate navigate, int x, int y, boolean key) {
        int id;
        if ((id = Game.BOARD.get(y, x)) == 0) {
            return false;
        } else {
            if (key ? id > 7 : id < 8) {
                navigate.eats.put(y * 10 + x, id);
            } else {
                x = y * 10 + x;
                if (x % 5 != 0) navigate.protect.put(x, id);
            }
        }
        return true;
    }

    private static Map<Integer, int[][]> getRedElephantNavigate() {
        Map<Integer, int[][]> map = new HashMap<>();
        map.put(103, new int[][]{{85, 81}, {94, 92}});
        map.put(107, new int[][]{{89, 85}, {98, 97}});
        map.put(81, new int[][]{{103, 63}, {92, 72}});
        map.put(85, new int[][]{{107, 67, 103, 63}, {96, 76, 94, 74}});
        map.put(89, new int[][]{{107, 67}, {98, 78}});
        map.put(63, new int[][]{{85, 81}, {74, 72}});
        map.put(67, new int[][]{{89, 85}, {78, 76}});
        return map;
    }

    private static Map<Integer, int[]> getRedSquireNavigate() {
        Map<Integer, int[]> map = new HashMap<>();
        map.put(104, new int[]{95});
        map.put(106, new int[]{95});
        map.put(95, new int[]{106, 84, 104, 86});
        map.put(84, new int[]{95});
        map.put(86, new int[]{95});
        return map;
    }

    private static Map<Integer, int[]> getRedKingNavigate() {
        Map<Integer, int[]> map = new HashMap<>();
        map.put(104, new int[]{105, 96});
        map.put(105, new int[]{104, 106, 95});
        map.put(106, new int[]{105, 96});
        map.put(94, new int[]{95, 84, 104});
        map.put(95, new int[]{94, 96, 85, 105});
        map.put(96, new int[]{95, 86, 106});
        map.put(84, new int[]{85, 94});
        map.put(85, new int[]{84, 86, 95});
        map.put(86, new int[]{85, 96});
        return map;
    }
}