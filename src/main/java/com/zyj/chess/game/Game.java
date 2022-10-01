package com.zyj.chess.game;

import com.zyj.chess.game.board.Board;
import com.zyj.chess.game.chessman.Chessman;
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
        Game.BOARD.view();
        List<Integer> list = BLACK.navigate();
        System.out.println(list);
    }
}