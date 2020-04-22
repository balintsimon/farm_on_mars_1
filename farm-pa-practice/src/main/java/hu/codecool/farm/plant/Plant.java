package hu.codecool.farm.plant;

import hu.codecool.farm.MonthCount;

public abstract class Plant {
    protected boolean isItRotten = false;
    protected MonthCount monthCount;
    protected final int DEFAULT_PLANT_PRODUCTION_GROWTH = 4;
    protected int production;
    protected int actualProductionOfTheMonth;
    protected String name;

    public Plant(String name, MonthCount monthCount) {
        monthCount = monthCount;
        this.name = name;
    }

    public abstract int simulateMonthlyProduction();

    public boolean isItRotten() {
        return isItRotten;
    }
}
