package com.zyj.chess.game.team;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.type.*;

public final class BlackTeam extends Team {
    public BlackTeam() {
        super(0, new Chessman[]{
                new BCar(1, 1), new BHorse(1, 2), new BElephant(1, 3), new BSquire(1, 4),
                new BKing(1, 5), new BSquire(1, 6), new BElephant(1, 7), new BHorse(1, 8),
                new BCar(1, 9), new BCannon(3, 2), new BCannon(3, 8), new BSoldier(4, 1),
                new BSoldier(4, 3), new BSoldier(4, 5), new BSoldier(4, 7), new BSoldier(4, 9)
        });
    }
}