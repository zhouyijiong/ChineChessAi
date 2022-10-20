package com.zyj.chess.game;

import com.zyj.chess.ai.valuation.Valuation;
import com.zyj.chess.game.board.Board;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.team.BlackTeam;
import com.zyj.chess.game.team.RedTeam;
import com.zyj.chess.game.team.Team;

public final class Game {
    private boolean redCurrent;

    private GameModel model;

    public static final Team RED = new RedTeam();

    public static final Team BLACK = new BlackTeam();

    public static final Board BOARD = new Board();

    public static final Valuation VALUATION = new Valuation();

    interface GameModel {
        //public static final int GAME_TEST = 1;
        int GAME_LEARNING = 0;

        void start();
    }

    public Game(boolean redCurrent, GameModel model) {
        this.redCurrent = redCurrent;
        if (model == null) this.model = () -> {
            //BOARD.view();
            RED.score();
        };
        else this.model = model;
    }

    public void rebirth() {
        redCurrent = !redCurrent;
    }

    public boolean playingChess(Chessman chessman, int ty, int tx) {
        if (BOARD.eat(ty, tx, chessman) > 0) return redCurrent ? BLACK.delete(ty * 10 + tx) : RED.delete(ty * 10 + tx);
        return true;
    }

    public void start(Chessman chessman, int y, int x) {
        model.start();
    }

    public static void main(String[] args) {
        //Params.HORSE_NAVIGATE.size();
        new Game(true, null).start(RED.getChessArray()[9], 8, 5);
    }
}