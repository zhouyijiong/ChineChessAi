package com.zyj.chess.game.team;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.type.*;

public final class RedTeam extends Team {
    public RedTeam() {
        super(1, new Chessman[]{
                new RCar(10, 1), new RHorse(10, 2), new RElephant(10, 3), new RSquire(10, 4),
                new RKing(10, 5), new RSquire(10, 6), new RElephant(10, 7), new RHorse(10, 8),
                new RCar(10, 9), new RCannon(8, 2), new RCannon(8, 8), new RSoldier(7, 1),
                new RSoldier(7, 3), new RSoldier(7, 5), new RSoldier(7, 7), new RSoldier(7, 9)
        });
    }
}