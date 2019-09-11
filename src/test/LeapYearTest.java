package test;

import main.LeapYear;
import org.junit.Assert;
import org.junit.Test;

public class LeapYearTest {

    @Test
    public void leapYearsAreDivisibleByFour() {
        Assert.assertTrue(LeapYear.isLeapYear(2016));
    }
}
