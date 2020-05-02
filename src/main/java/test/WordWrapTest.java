package main.java.test;

import main.WordWrap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordWrapTest {
    public static final int LINE_LENGH = 5;

    // method thet breaks words on specific space with new line

    @Test
    public void lineShouldWrapIfOverLineLenght() {
        String result = WordWrap.wrap("The Sleepy", LINE_LENGH);
        Assert.assertEquals("The S\nleepy", result);
    }

    @Test
    public void shortLinesShouldNoWrap() {
        String result = WordWrap.wrap("The", LINE_LENGH);
        Assert.assertEquals("The", result);
    }

    @Test
    public void longerLineShouldWrapTwice() {
        String result = WordWrap.wrap("The Sleepy Brow", LINE_LENGH);
        Assert.assertEquals("The S\nleepy\n Brow", result);

    }

    @Test
    public void evenLongerLineShouldWrapThrice() {
        String result = WordWrap.wrap("The Sleepy Brown Fox", LINE_LENGH);
        Assert.assertEquals("The S\nleepy\n Brow\nn Fox", result);

    }

    @Test
    public void LongLineDontHaveToBeMultipleOfLineLength() {
        String result = WordWrap.wrap("The Sleepy Brown Fox.", LINE_LENGH);
        Assert.assertEquals("The S\nleepy\n Brow\nn Fox\n.", result);

    }
}