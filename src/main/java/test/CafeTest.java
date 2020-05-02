package main.java.test;
import main.Cafe;
import main.Coffee;
import main.CoffeeType;
import org.junit.*;

import static main.CoffeeType.Espresso;
import static main.CoffeeType.Latte;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CafeTest {
    public final static int ESPRESSO_BEANS = Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int  NO_BEANS = 0;
    private Cafe cafe;

    @Before
    public void before () {
        cafe = new Cafe();
    }

    // can brew espresso
    @Test
    public void canBrewEspresso() {
        withBeans();
        // given
         cafe.restockBeans(7);
        // when
        Coffee coffee = cafe.brew(Espresso);

        // it is espresso
        //don't have milk
        //we have enough coffee

        // then
        Assert.assertEquals("Wrong coffee type", Espresso, coffee.getType());
        Assert.assertEquals("Wrong anount of milk", NO_MILK, coffee.getMilk());
        Assert.assertEquals("Wrong number of beans", ESPRESSO_BEANS, coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        withBeans();
        cafe.brew(Espresso);
        Assert.assertEquals(NO_BEANS, cafe.getBeansInStock());
    }

   @Test(expected = IllegalStateException.class)
     public void latteRequiredMilk () {
       withBeans() ;
        cafe.brew(Latte);

    }

    @Test
    public void canBrewLatte() {
        withBeans();
        cafe.restockMilk(Latte.getRequiredMilk());
        Coffee coffee = cafe.brew(Latte);
        assertEquals("Wrong coffee type", Latte, coffee.getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk() {
        withBeans();
        cafe.restockMilk(NO_MILK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestocBeans() {
        withBeans();
        cafe.restockBeans(NO_BEANS);
    }

    private void withBeans() {
        cafe.restockBeans(ESPRESSO_BEANS);
    }
}


