package hu.codecool.farm.plant;

import hu.codecool.farm.MonthCount;

public class Almond extends Plant {
    private final int MINIMUM_PRODUCTION_THRESHOLD = 40;
    private final int SHROOM_CHANCE = 8;
    private final int SHROOM_PRODUCTION_BOOST = 10;
    private final int ROT_CHANCE = 13;
    private final int ROT_PRODUCTION_REDUCTION = 18;

    private Shroom shroom;
    private Rot rot;

    public Almond(String name, MonthCount monthCount) {
        super(name, monthCount);
        this.production = 50;
        this.shroom = new Shroom(SHROOM_CHANCE, SHROOM_PRODUCTION_BOOST);
        this.rot = new Rot(ROT_CHANCE, ROT_PRODUCTION_REDUCTION);
    }

    @Override
    public int simulateMonthlyProduction() {
        this.actualProductionOfTheMonth = 0;
        this.actualProductionOfTheMonth += this.production;

        this.production += this.DEFAULT_PLANT_PRODUCTION_GROWTH;

        this.production = shroom.boostedProduction(this.production);
        this.production = rot.reducedProduction(this.production);

        if (this.production < MINIMUM_PRODUCTION_THRESHOLD) {
            this.production *= 2;
        }

        return this.actualProductionOfTheMonth;
    }

    @Override
    public boolean isItRotten() {
        return rot.isItRotten();
    }
}
