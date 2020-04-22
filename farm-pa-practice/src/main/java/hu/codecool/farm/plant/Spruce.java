package hu.codecool.farm.plant;


import hu.codecool.farm.MonthCount;

public class Spruce extends Evergreen {
    private final int SHROOM_CHANCE = 5;
    private final int SHROOM_PRODUCTION_BOOST = 15;
    private final int ROT_CHANCE = 4;
    private final int ROT_PRODUCTION_REDUCTION = 20;

    private Shroom shroom;
    private Rot rot;

    public Spruce(String name, MonthCount monthCount) {
        super(name, monthCount);
        this.production = 26;
        this.shroom = new Shroom(SHROOM_CHANCE, SHROOM_PRODUCTION_BOOST);
        this.rot = new Rot(ROT_CHANCE, ROT_PRODUCTION_REDUCTION);
        this.monthCount = monthCount;
    }

    @Override
    public int simulateMonthlyProduction() {
        this.actualProductionOfTheMonth = 0;
        this.actualProductionOfTheMonth += this.production;


        this.production += this.DEFAULT_PLANT_PRODUCTION_GROWTH;
        if (monthCount.getMonth()%GROW_LEAVES_INTERVAL == 0) {
            growLeaves();
        }

        this.production = shroom.boostedProduction(this.production);
        this.production = rot.reducedProduction(this.production);

        if (production >= MAX_PRODUCTION) {
            speak();
            production = MAX_PRODUCTION;
        }

        return this.actualProductionOfTheMonth;
    }

    @Override
    public boolean isItRotten() {
        return rot.isItRotten();
    }
}
