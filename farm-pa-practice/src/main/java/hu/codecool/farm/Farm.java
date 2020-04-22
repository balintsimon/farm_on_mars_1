package hu.codecool.farm;

import hu.codecool.farm.plant.Almond;
import hu.codecool.farm.plant.Plant;
import hu.codecool.farm.plant.Spruce;

import java.util.ArrayList;
import java.util.List;

public class Farm implements MonthCount {
    private int totalFoodProduced, monthCount;
    private List<Plant> plants = new ArrayList<>();

    public Farm() {
        this.totalFoodProduced = 0;
        this.monthCount = 0;
    }

    public void simulateMonth() {
        monthCount++;
        int actualMonthlyProduction = 0;
        for (Plant plant : plants) {
            actualMonthlyProduction += plant.simulateMonthlyProduction();
            if (plant.isItRotten()) {
                System.out.println("There is rot somewhere...");
                System.out.println("Previous production: " + totalFoodProduced);
                actualMonthlyProduction = 0;
                break;
            }
        }
        totalFoodProduced += actualMonthlyProduction;
        System.out.println("Total production after month: " + totalFoodProduced);
    }

    public void generatePlants() {
        Plant spruce1 = new Spruce("spruce1", this);
        Plant spruce2 = new Spruce("spruce2", this);
        Plant almond1 = new Almond("almond1", this);
        Plant almond2 = new Almond("almond2", this);
        Plant juniper1 = new Almond("juniper1", this);
        Plant juniper2 = new Almond("juniper2", this);

        plants.add(spruce1);
        plants.add(spruce2);
        plants.add(almond1);
        plants.add(almond2);
        plants.add(juniper1);
        plants.add(juniper2);
    }

    public int getTotalFoodProduced() {
        return totalFoodProduced;
    }

    @Override
    public int getMonth() {
        return monthCount;
    }
}
