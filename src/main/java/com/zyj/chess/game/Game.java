package com.zyj.chess.game;

import com.zyj.chess.game.board.Board;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigate;
import com.zyj.chess.game.team.BlackTeam;
import com.zyj.chess.game.team.RedTeam;
import com.zyj.chess.game.team.Team;

import java.util.*;

public final class Game {
    boolean current = true;

    static final Team RED = new RedTeam();

    static final Team BLACK = new BlackTeam();

    public static final Board BOARD = Board.init();

    public Chessman[] schedule() {
        return current ? RED.getChess() : BLACK.getChess();
    }

    public static void main(String[] args) {
        long a = System.nanoTime();
        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        long b = System.nanoTime();
        System.out.println(b - a);
        for (int i = 0; i < 1000000; ++i) {
            if (i % 2 == 0) {
                t1.add(i);
            } else t2.add(i);
        }
        //Navigate navigate = Navigate.init_no_limit(t1, t2);

        //5590401 7725300 5228299
//        Game.BOARD.view();
//        List<Integer> list = BLACK.navigate();
//        System.out.println(list);
    }
}