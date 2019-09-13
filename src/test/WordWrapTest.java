package test;

import main.WordWrap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordWrapTest {
    public static final int LINE_LENGH = 5;

    @Test
    public void lineShouldWrapOverLineLenght() {
        String result = WordWrap.wrap("The Sleepy", LINE_LENGH);
        Assert.assertEquals("The S\nleepy", result);
    }

    @Test
    public void shortLinesShouldNoWrap() {
        String result = WordWrap.wrap("The" , LINE_LENGH);
        Assert.assertEquals("The", result);
    }

    /*@Test
    public void */
}
