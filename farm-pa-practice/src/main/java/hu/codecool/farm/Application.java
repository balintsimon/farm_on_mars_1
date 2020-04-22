package hu.codecool.farm;

public class Application {
    public static void main(String[] args) {
        Farm farm = new Farm();
        farm.generatePlants();

        for (int month = 0; month < 80; month++) {
            farm.simulateMonth();
        }

        System.out.println("Our farm has produced "
                + farm.getTotalFoodProduced()
                + " amounts of food. Good job."
        );

    }
}
