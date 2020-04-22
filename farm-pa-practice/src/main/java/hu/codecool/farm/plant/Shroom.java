package hu.codecool.farm.plant;

import java.util.Random;

public class Shroom {
    private int shroomChance;
    private int productionBoost;
    private static Random random = new Random();

    public Shroom(int shroomChance, int productionBoost) {
        this.shroomChance = shroomChance;
        this.productionBoost = productionBoost;
    }

    public int boostedProduction(int actualProduction) {
        if (random.nextInt(100) < shroomChance) {
            return actualProduction + actualProduction * productionBoost / 100;
        }
        return actualProduction;
    }
}
