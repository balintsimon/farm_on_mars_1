package hu.codecool.farm.plant;

import hu.codecool.farm.MonthCount;

public abstract class Evergreen extends Plant {
    protected final int GROW_LEAVES_AMOUNT = 8;
    protected final int GROW_LEAVES_INTERVAL = 5;
    protected final int MAX_PRODUCTION = 70;

    public Evergreen(String name, MonthCount monthCount) {
        super(name, monthCount);
    }

    @Override
    public int simulateMonthlyProduction() {
        this.actualProductionOfTheMonth = 0;
        this.actualProductionOfTheMonth += this.production;


        this.production += this.DEFAULT_PLANT_PRODUCTION_GROWTH;
        if (monthCount.getMonth()%GROW_LEAVES_INTERVAL == 0) {
            growLeaves();
        }

        if (production >= MAX_PRODUCTION) {
            speak();
            production = MAX_PRODUCTION;
        }

        return this.actualProductionOfTheMonth;
    }

    protected void growLeaves() {
        this.production += GROW_LEAVES_AMOUNT;
    }

    protected void speak() {
        System.out.println(this.name + " at full production!");
    }
}
