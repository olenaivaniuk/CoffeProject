package test;
import main.Cafe;
import main.Coffee;
import main.CoffeeType;
import org.junit.Assert;
import org.junit.Test;

public class CafeTest {

    @Test
    public void canBrewEspressso () {
        //given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        //when
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        //then
        Assert.assertEquals(CoffeeType.Espresso, coffee.getType());
        Assert.assertEquals(0, coffee.getMilk());
        Assert.assertEquals(7, coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        //when
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        //then
        Assert.assertEquals(0, cafe.getBeansInStock());
    }

    @Test
    (expected = IllegalStateException.class)
    public void latteIsRequireMilk() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        cafe.brew(CoffeeType.Latte);

    }

}
