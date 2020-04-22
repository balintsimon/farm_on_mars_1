package hu.codecool.farm.plant;

import hu.codecool.farm.MonthCount;

public class Juniper extends Evergreen {

    public Juniper(String name, MonthCount monthCount) {
        super(name, monthCount);
        this.production = 14;
    }
}
