package test;
import main.Cafe;
import main.Coffee;
import main.CoffeeType;
import org.junit.Assert;
import org.junit.Test;

public class CafeTest {

    @Test
    public void canBrewEspressso () {
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // it is espresso;
        // no milk
        // that we got enought coffee
        Assert.assertEquals(CoffeeType.Espresso, coffee.getType());
        Assert.assertEquals(0, coffee.getMilk());
        Assert.assertEquals(7, coffee.getBeans());


    }

}
