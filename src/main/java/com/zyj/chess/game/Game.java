package com.zyj.chess.game;

import com.zyj.chess.game.board.Board;
import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.type.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Game {
    private boolean current = true;

    public static final Board BOARD = new Board();

    static final Chessman[] red = {
            new RCar(10, 1), new RHorse(10, 2), new RElephant(10, 3), new RSquire(10, 4),
            new RKing(10, 5), new RSquire(10, 6), new RElephant(10, 7), new RHorse(10, 8),
            new RCar(10, 9), new RCannon(8, 2), new RCannon(8, 8), new RSoldier(7, 1),
            new RSoldier(7, 3), new RSoldier(7, 5), new RSoldier(7, 7), new RSoldier(7, 9)
    };

    static final Chessman[] black = {
            new BCar(1, 1), new BHorse(1, 2), new BElephant(1, 3), new BSquire(1, 4),
            new BKing(1, 5), new BSquire(1, 6), new BElephant(1, 7), new BHorse(1, 8),
            new BCar(1, 9), new BCannon(3, 2), new BCannon(3, 8), new BSoldier(4, 1),
            new BSoldier(4, 3), new BSoldier(4, 5), new BSoldier(4, 7), new BSoldier(4, 9)
    };

    public Chessman[] schedule() {
        return current ? red : black;
    }

    public void navigate(int x, int y, Chessman chessman) {
        BOARD.move(y, x, chessman);
        current = !current;
    }

    public static void main(String[] args) {
        Game game = new Game();
        BOARD.view();
        List<Integer> location = new ArrayList<>();
        for (Chessman item : black) item.navigate(location);
        System.out.println(location.size());
        System.out.println(Arrays.toString(location.toArray()));
    }
}