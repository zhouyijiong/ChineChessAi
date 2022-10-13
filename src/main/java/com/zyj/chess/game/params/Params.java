package com.zyj.chess.game.params;

import com.zyj.chess.game.Game;
import com.zyj.chess.game.tool.BitList;

import java.util.HashMap;
import java.util.Map;

public final class Params {
    public static final String[] CHESSMAN_NAME = {"空位", "黑车", "黑马", "黑象", "黑士", "黑将", "黑炮", "黑兵", "空位", "空位", "空位", "红车", "红马", "红象", "红士", "红帥", "红炮", "红兵"};

    public static final Map<Integer, int[][]> HORSE_NAVIGATE;
    public static final Map<Integer, int[][]> BLACK_ELEPHANT_NAVIGATE;
    public static final Map<Integer, int[][]> RED_ELEPHANT_NAVIGATE;
    public static final Map<Integer, int[]> BLACK_SQUIRE_NAVIGATE;
    public static final Map<Integer, int[]> BLACK_KING_NAVIGATE;
    public static final Map<Integer, int[]> RED_SQUIRE_NAVIGATE;
    public static final Map<Integer, int[]> RED_KING_NAVIGATE;

    static {
        HORSE_NAVIGATE = getHorseNavigate();
        BLACK_ELEPHANT_NAVIGATE = getBlackElephantNavigate();
        BLACK_SQUIRE_NAVIGATE = getBlackSquireNavigate();
        BLACK_KING_NAVIGATE = getBlackKingNavigate();
        RED_ELEPHANT_NAVIGATE = getRedElephantNavigate();
        RED_SQUIRE_NAVIGATE = getRedSquireNavigate();
        RED_KING_NAVIGATE = getRedKingNavigate();
    }

    public static void getNavigate(Map<Integer, int[][]> map, Navigate navigate, int id, int x, int y) {
        int[][] arrays = map.get(y * 10 + x);
        int[] point = arrays[0];
        int[] baffle = arrays[1];
        boolean key = id < 8;
        for (int i = 0, len = baffle.length; i < len; ++i) {
            int bp = baffle[i];
            if (Game.BOARD.get(bp / 10, bp % 10) == 0) {
                int p = point[i];
                if ((id = Game.BOARD.get(p / 10, p % 10)) == 0) {
                    navigate.point.add(p);
                } else if (key ? id > 7 : id < 8) navigate.eat.put(p, id);
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

    private static Map<Integer, int[][]> getHorseNavigate() {
        Map<Integer, int[][]> map = new HashMap<>();
        map.put(11, new int[][]{{23, 32}, {12, 21}});
        map.put(12, new int[][]{{24, 33, 31}, {13, 22, 22}});
        map.put(13, new int[][]{{25, 34, 32, 21}, {14, 23, 23, 12}});
        map.put(14, new int[][]{{26, 35, 33, 22}, {15, 24, 24, 13}});
        map.put(15, new int[][]{{27, 36, 34, 23}, {16, 25, 25, 14}});
        map.put(16, new int[][]{{28, 37, 35, 24}, {17, 26, 26, 15}});
        map.put(17, new int[][]{{29, 38, 36, 25}, {18, 27, 27, 16}});
        map.put(18, new int[][]{{39, 37, 26}, {28, 28, 17}});
        map.put(19, new int[][]{{38, 27}, {29, 18}});
        map.put(21, new int[][]{{33, 13, 42}, {22, 22, 31}});
        map.put(22, new int[][]{{34, 14, 43, 41}, {23, 23, 32, 32}});
        map.put(23, new int[][]{{35, 15, 44, 42, 31, 11}, {24, 24, 33, 33, 22, 22}});
        map.put(24, new int[][]{{36, 16, 45, 43, 32, 12}, {25, 25, 34, 34, 23, 23}});
        map.put(25, new int[][]{{37, 17, 46, 44, 33, 13}, {26, 26, 35, 35, 24, 24}});
        map.put(26, new int[][]{{38, 18, 47, 45, 34, 14}, {27, 27, 36, 36, 25, 25}});
        map.put(27, new int[][]{{39, 19, 48, 46, 35, 15}, {28, 28, 37, 37, 26, 26}});
        map.put(28, new int[][]{{49, 47, 36, 16}, {38, 38, 27, 27}});
        map.put(29, new int[][]{{48, 37, 17}, {39, 28, 28}});
        map.put(31, new int[][]{{12, 43, 23, 52}, {21, 32, 32, 41}});
        map.put(32, new int[][]{{13, 11, 44, 24, 53, 51}, {22, 22, 33, 33, 42, 42}});
        map.put(33, new int[][]{{14, 12, 45, 25, 54, 52, 41, 21}, {23, 23, 34, 34, 43, 43, 32, 32}});
        map.put(34, new int[][]{{15, 13, 46, 26, 55, 53, 42, 22}, {24, 24, 35, 35, 44, 44, 33, 33}});
        map.put(35, new int[][]{{16, 14, 47, 27, 56, 54, 43, 23}, {25, 25, 36, 36, 45, 45, 34, 34}});
        map.put(36, new int[][]{{17, 15, 48, 28, 57, 55, 44, 24}, {26, 26, 37, 37, 46, 46, 35, 35}});
        map.put(37, new int[][]{{18, 16, 49, 29, 58, 56, 45, 25}, {27, 27, 38, 38, 47, 47, 36, 36}});
        map.put(38, new int[][]{{19, 17, 59, 57, 46, 26}, {28, 28, 48, 48, 37, 37}});
        map.put(39, new int[][]{{18, 58, 47, 27}, {29, 49, 38, 38}});
        map.put(41, new int[][]{{22, 53, 33, 62}, {31, 42, 42, 51}});
        map.put(42, new int[][]{{23, 21, 54, 34, 63, 61}, {32, 32, 43, 43, 52, 52}});
        map.put(43, new int[][]{{24, 22, 55, 35, 64, 62, 51, 31}, {33, 33, 44, 44, 53, 53, 42, 42}});
        map.put(44, new int[][]{{25, 23, 56, 36, 65, 63, 52, 32}, {34, 34, 45, 45, 54, 54, 43, 43}});
        map.put(45, new int[][]{{26, 24, 57, 37, 66, 64, 53, 33}, {35, 35, 46, 46, 55, 55, 44, 44}});
        map.put(46, new int[][]{{27, 25, 58, 38, 67, 65, 54, 34}, {37, 37, 48, 48, 57, 57, 46, 46}});
        map.put(47, new int[][]{{28, 26, 59, 39, 68, 66, 55, 35}, {37, 37, 48, 48, 57, 57, 46, 46}});
        map.put(48, new int[][]{{29, 27, 69, 67, 56, 36}, {38, 38, 58, 58, 47, 47}});
        map.put(49, new int[][]{{28, 68, 57, 37}, {39, 59, 48, 48}});
        map.put(51, new int[][]{{32, 63, 43, 72}, {41, 52, 52, 61}});
        map.put(52, new int[][]{{33, 31, 64, 44, 73, 71}, {42, 42, 53, 53, 62, 62}});
        map.put(53, new int[][]{{34, 32, 65, 45, 74, 72, 61, 41}, {43, 43, 54, 54, 63, 63, 52, 52}});
        map.put(54, new int[][]{{35, 33, 66, 46, 75, 73, 62, 42}, {44, 44, 55, 55, 64, 64, 53, 53}});
        map.put(55, new int[][]{{36, 34, 67, 47, 76, 74, 63, 43}, {45, 45, 56, 56, 65, 65, 54, 54}});
        map.put(56, new int[][]{{37, 35, 68, 48, 77, 75, 64, 44}, {46, 46, 57, 57, 66, 66, 55, 55}});
        map.put(57, new int[][]{{38, 36, 69, 49, 78, 76, 65, 45}, {47, 47, 58, 58, 67, 67, 56, 56}});
        map.put(58, new int[][]{{39, 37, 79, 77, 66, 46}, {48, 48, 68, 68, 57, 57}});
        map.put(59, new int[][]{{38, 78, 67, 47}, {49, 69, 58, 58}});
        map.put(61, new int[][]{{42, 73, 53, 82}, {51, 62, 62, 71}});
        map.put(62, new int[][]{{43, 41, 74, 54, 83, 81}, {52, 52, 63, 63, 72, 72}});
        map.put(63, new int[][]{{44, 42, 75, 55, 84, 82, 71, 51}, {53, 53, 64, 64, 73, 73, 62, 62}});
        map.put(64, new int[][]{{45, 43, 76, 56, 85, 83, 72, 52}, {54, 54, 65, 65, 74, 74, 63, 63}});
        map.put(65, new int[][]{{46, 44, 77, 57, 86, 84, 73, 53}, {55, 55, 66, 66, 75, 75, 64, 64}});
        map.put(66, new int[][]{{47, 45, 78, 58, 87, 85, 74, 54}, {56, 56, 67, 67, 76, 76, 65, 65}});
        map.put(67, new int[][]{{48, 46, 79, 59, 88, 86, 75, 55}, {57, 57, 68, 68, 77, 77, 66, 66}});
        map.put(68, new int[][]{{49, 47, 89, 87, 76, 56}, {58, 58, 78, 78, 67, 67}});
        map.put(69, new int[][]{{48, 88, 77, 57}, {59, 79, 68, 68}});
        map.put(71, new int[][]{{52, 83, 63, 92}, {61, 72, 72, 81}});
        map.put(72, new int[][]{{53, 51, 84, 64, 93, 91}, {62, 62, 73, 73, 82, 82}});
        map.put(73, new int[][]{{54, 52, 85, 65, 94, 92, 81, 61}, {63, 63, 74, 74, 83, 83, 72, 72}});
        map.put(74, new int[][]{{55, 53, 86, 66, 95, 93, 82, 62}, {64, 64, 75, 75, 84, 84, 73, 73}});
        map.put(75, new int[][]{{56, 54, 87, 67, 96, 94, 83, 63}, {65, 65, 76, 76, 85, 85, 74, 74}});
        map.put(76, new int[][]{{57, 55, 88, 68, 97, 95, 84, 64}, {66, 66, 77, 77, 86, 86, 75, 75}});
        map.put(77, new int[][]{{58, 56, 89, 69, 98, 96, 85, 65}, {67, 67, 78, 78, 87, 87, 76, 76}});
        map.put(78, new int[][]{{59, 57, 99, 97, 86, 66}, {68, 68, 88, 88, 77, 77}});
        map.put(79, new int[][]{{58, 98, 87, 67}, {69, 89, 78, 78}});
        map.put(81, new int[][]{{62, 93, 73, 102}, {71, 82, 82, 91}});
        map.put(82, new int[][]{{63, 61, 94, 74, 103, 101}, {72, 72, 83, 83, 92, 92}});
        map.put(83, new int[][]{{64, 62, 95, 75, 104, 102, 91, 71}, {73, 73, 84, 84, 93, 93, 82, 82}});
        map.put(84, new int[][]{{65, 63, 96, 76, 105, 103, 92, 72}, {74, 74, 85, 85, 94, 94, 83, 83}});
        map.put(85, new int[][]{{66, 64, 97, 77, 106, 104, 93, 73}, {75, 75, 86, 86, 95, 95, 84, 84}});
        map.put(86, new int[][]{{67, 65, 98, 78, 107, 105, 94, 74}, {76, 76, 87, 87, 96, 96, 85, 85}});
        map.put(87, new int[][]{{68, 66, 99, 79, 108, 106, 95, 75}, {77, 77, 88, 88, 97, 97, 86, 86}});
        map.put(88, new int[][]{{69, 67, 109, 107, 96, 76}, {78, 78, 98, 98, 87, 87}});
        map.put(89, new int[][]{{68, 108, 97, 77}, {79, 99, 88, 88}});
        map.put(91, new int[][]{{72, 103, 83}, {81, 92, 92}});
        map.put(92, new int[][]{{73, 71, 104, 84}, {82, 82, 93, 93}});
        map.put(93, new int[][]{{74, 72, 105, 85, 101, 81}, {83, 83, 94, 94, 92, 92}});
        map.put(94, new int[][]{{75, 73, 106, 86, 102, 82}, {84, 84, 95, 95, 93, 93}});
        map.put(95, new int[][]{{76, 74, 107, 87, 103, 83}, {85, 85, 96, 96, 94, 94}});
        map.put(96, new int[][]{{77, 75, 108, 88, 104, 84}, {86, 86, 97, 97, 95, 95}});
        map.put(97, new int[][]{{78, 76, 109, 89, 105, 85}, {87, 87, 98, 98, 96, 96}});
        map.put(98, new int[][]{{79, 77, 106, 86}, {88, 88, 97, 97}});
        map.put(99, new int[][]{{23, 32}, {12, 21}});
        map.put(101, new int[][]{{82, 113, 93}, {91, 102, 102}});
        map.put(102, new int[][]{{83, 81, 114, 94}, {92, 92, 103, 103}});
        map.put(103, new int[][]{{84, 82, 115, 95, 111, 91}, {93, 93, 104, 104, 102, 102}});
        map.put(104, new int[][]{{85, 83, 116, 96, 112, 92}, {94, 94, 105, 105, 103, 103}});
        map.put(105, new int[][]{{86, 84, 117, 97, 113, 93}, {95, 95, 106, 106, 104, 104}});
        map.put(106, new int[][]{{87, 85, 118, 98, 114, 94}, {96, 96, 107, 107, 105, 105}});
        map.put(107, new int[][]{{88, 86, 119, 99, 115, 95}, {97, 97, 108, 108, 106, 106}});
        map.put(108, new int[][]{{89, 87, 116, 96}, {98, 98, 107, 107}});
        map.put(109, new int[][]{{88, 117, 97}, {99, 108, 108}});
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
            if (calcCannonMoveCore(navigate.point, id, y))
                for (++id; id < 10; ++id) if (calcCannonEatCore(navigate.eat, id, y, key)) break;
        for (id = x - 1; id > 0; --id)
            if (calcCannonMoveCore(navigate.point, id, y))
                for (--id; id > 0; --id) if (calcCannonEatCore(navigate.eat, id, y, key)) break;
        for (id = y + 1; id < 11; ++id)
            if (calcCannonMoveCore(navigate.point, x, id))
                for (++id; id < 11; ++id) if (calcCannonEatCore(navigate.eat, x, id, key)) break;
        for (id = y - 1; id > 0; --id)
            if (calcCannonMoveCore(navigate.point, x, id))
                for (--id; id > 0; --id) if (calcCannonEatCore(navigate.eat, x, id, key)) break;
    }

    public static void calcNavigate(Navigate navigate, boolean key, int x, int y) {
        int p = y * 10 + x;
        if ((x = Game.BOARD.get(y, x)) == 0) {
            navigate.point.add(p);
        } else if (key ? x > 7 : x < 8) navigate.eat.put(p, x);
    }

    public static boolean calcNavigateCore(Navigate navigate, int x, int y, boolean key) {
        int p = y * 10 + x;
        if ((x = Game.BOARD.get(y, x)) == 0) {
            navigate.point.add(p);
            return false;
        } else if (key ? x > 7 : x < 8) navigate.eat.put(p, x);
        return true;
    }

    public static boolean calcCannonMoveCore(BitList point, int x, int y) {
        if (Game.BOARD.get(y, x) == 0) {
            point.add(y * 10 + x);
            return false;
        }
        return true;
    }

    public static boolean calcCannonEatCore(Map<Integer, Integer> eat, int x, int y, boolean key) {
        int id;
        if ((id = Game.BOARD.get(y, x)) == 0) {
            return false;
        } else if (key ? id > 7 : id < 8) eat.put(y * 10 + x, id);
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