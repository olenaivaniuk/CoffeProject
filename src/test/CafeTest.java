package test;
import main.Cafe;
import main.Coffee;
import main.CoffeeType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static main.CoffeeType.Espresso;
import static main.CoffeeType.Latte;
import static org.junit.Assert.assertEquals;

public class CafeTest {

    public static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;
    private Cafe cafe;

    @Before
    public void before() {
        cafe = new Cafe();
    }

    @Test
    public void canBrewEspressso () {
        //given
        withBeans();

        //when
        Coffee coffee = cafe.brew(Espresso);

        //then
        assertEquals("Wrong number of beans", ESPRESSO_BEANS, coffee.getBeans());
        assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
        assertEquals("Wrong coffee type", Espresso, coffee.getType());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        withBeans();

        //when
        Coffee coffee = cafe.brew(Espresso);

        //then
        assertEquals(NO_BEANS, cafe.getBeansInStock());
    }

    @Test
    public void canBrewLatte() {
        //given
        withBeans();
        cafe.restockMilk(Latte.getRequiredMilk());

        //when
        Coffee coffee = cafe.brew(Latte);

        //then
        assertEquals("Wrong type of coffee", Latte, coffee.getType());
    }

    @Test (expected = IllegalArgumentException.class)
    public void mustRestockMilk() {
        //when
        cafe.restockMilk(NO_MILK);
    }

    @Test (expected = IllegalArgumentException.class)
    public void mustRestockBeans() {
        //when
        cafe.restockBeans(NO_BEANS);
    }

    @Test
            (expected = IllegalStateException.class)
    public void lattesRequireMilk() {
        withBeans();

        cafe.brew(Latte);

    }

    private void withBeans() {
        cafe.restockBeans(ESPRESSO_BEANS);
    }



}
