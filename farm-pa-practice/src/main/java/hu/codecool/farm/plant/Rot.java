package hu.codecool.farm.plant;

import java.util.Random;

public class Rot {
    private int rotChance;
    private int productionReduction;
    private boolean isItRotten;

    private static Random random = new Random();

    public Rot(int rotChance, int productionReduction) {
        this.rotChance = rotChance;
        this.productionReduction = productionReduction;
        this.isItRotten = false;
    }

    public int reducedProduction(int actualProduction) {
        if (decideIfToRot()) {
            System.out.println("There is rot!");
            return actualProduction - actualProduction * productionReduction / 100;
        }
        return actualProduction;
    }

    private boolean decideIfToRot() {
        isItRotten = random.nextInt(100) < rotChance;
        return isItRotten;
    }

    public boolean isItRotten() {
        return isItRotten;
    }
}
