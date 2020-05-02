package main.java.test;

import main.LeapYear;
import org.junit.Assert;
import org.junit.Test;

public class LeapYearTest {

    @Test
    public void leapYearsAreDivisibleByFour() {
        Assert.assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void normalYearsAreNotDevisibleByFour() {
        Assert.assertFalse(LeapYear.isLeapYear(3));
    }

    @Test
    public void leapYearsAreNotDevisibleByOneHundred() {
        Assert.assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void leapYearsAreDevisibleByOneFourHundred() {
        Assert.assertTrue(LeapYear.isLeapYear(2000));
    }


}
