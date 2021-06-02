import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CoffeeMachineTest {

    CoffeeMachine coffeeMachine;

    @Test
    void drink_maker_receive_instructions_for_tea_then() {
        DrinkMaker drinkMaker = Mockito.mock(DrinkMaker.class);

        coffeeMachine = new CoffeeMachine(drinkMaker);

        int sugar = 0;

        coffeeMachine.orderDrink(AvailableDrink.TEA, sugar);

        Mockito.verify(drinkMaker).execute("T::");
    }

    @Test
    void drink_maker_receive_instructions_for_chocolate_then() {
        DrinkMaker drinkMaker = Mockito.mock(DrinkMaker.class);

        coffeeMachine = new CoffeeMachine(drinkMaker);

        int sugar = 0;

        coffeeMachine.orderDrink(AvailableDrink.CHOCOLATE, sugar);

        Mockito.verify(drinkMaker).execute("H::");
    }

    @Test
    void drink_maker_receive_instructions_for_coffee_then() {
        DrinkMaker drinkMaker = Mockito.mock(DrinkMaker.class);

        coffeeMachine = new CoffeeMachine(drinkMaker);

        int sugar = 0;

        coffeeMachine.orderDrink(AvailableDrink.COFFEE, sugar);

        Mockito.verify(drinkMaker).execute("C::");
    }

    @Test
    void drink_maker_receive_instructions_for_tea_with_sugar_then() {
        DrinkMaker drinkMaker = Mockito.mock(DrinkMaker.class);

        coffeeMachine = new CoffeeMachine(drinkMaker);

        int sugar = 1;

        coffeeMachine.orderDrink(AvailableDrink.TEA, sugar);

        Mockito.verify(drinkMaker).execute("T:1:0");
    }
}
