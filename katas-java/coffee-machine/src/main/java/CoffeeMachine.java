public class CoffeeMachine {

    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void orderDrink(AvailableDrink availableDrink, int sugar) {
        drinkMaker.execute(generateProtocol(availableDrink, sugar));

    }

    public String generateProtocol(AvailableDrink availableDrink, int sugar) {
        return sugar > 0 ? String.format("%s:%s:%s", availableDrink.code, sugar, "0") : availableDrink.code + "::";
    }

}
