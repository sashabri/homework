package block3.unit3.task2and3;

import java.io.Serializable;

public class GameProgress implements Serializable {

    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        GameProgress gameProgress = (GameProgress) ob;

        return health == gameProgress.health &&
                weapons == gameProgress.weapons &&
                lvl == gameProgress.lvl &&
                equalsDouble(distance, gameProgress.distance);
    }

    public boolean equalsDouble(double d1, double d2) {
        return Math.abs(d1 - d2) < 0.000000000001;
    }



}
