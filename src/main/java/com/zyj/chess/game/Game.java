package com.zyj.chess.game;

import com.zyj.chess.game.board.Board;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.type.black.BCannon;
import com.zyj.chess.game.chessman.type.black.BCar;
import com.zyj.chess.game.chessman.type.black.BElephant;
import com.zyj.chess.game.chessman.type.black.BHorse;
import com.zyj.chess.game.chessman.type.black.BKing;
import com.zyj.chess.game.chessman.type.black.BSoldier;
import com.zyj.chess.game.chessman.type.black.BSquire;
import com.zyj.chess.game.chessman.type.red.RCannon;
import com.zyj.chess.game.chessman.type.red.RCar;
import com.zyj.chess.game.chessman.type.red.RElephant;
import com.zyj.chess.game.chessman.type.red.RHorse;
import com.zyj.chess.game.chessman.type.red.RKing;
import com.zyj.chess.game.chessman.type.red.RSoldier;
import com.zyj.chess.game.chessman.type.red.RSquire;

public final class Game {
    static final Board BOARD = new Board();

    public static final Chessman[] CHESSMEN = {null, BCar.initLeft(), BHorse.initLeft(), BElephant.initLeft(),
            BSquire.initLeft(), BKing.init(), BSquire.initRight(), BElephant.initRight(), BHorse.initRight(),
            BCar.initRight(), BCannon.initLeft(), BCannon.initRight(), BSoldier.init1(), BSoldier.init2(),
            BSoldier.init3(), BSoldier.init4(), BSoldier.init5(), null, null, null, RCar.initLeft(),
            RHorse.initLeft(), RElephant.initLeft(), RSquire.initLeft(), RKing.init(), RSquire.initRight(),
            RElephant.initRight(), RHorse.initRight(), RCar.initRight(), RCannon.initLeft(), RCannon.initRight(),
            RSoldier.init1(), RSoldier.init2(), RSoldier.init3(), RSoldier.init4(), RSoldier.init5()
    };

    public static void main(String[] args) {

    }
}