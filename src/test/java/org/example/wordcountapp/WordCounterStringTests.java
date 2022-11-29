package org.example.wordcountapp;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URL;

public class WordCounterStringTests
{
    /**
     * Basic test that the correct word counts are produced
     */
    @Test
    public void simpleWordCountTest()
    {
        String expected = "hello: 4\nworld: 3";
        WordCounter wordCounter = new WordCounter();

        String input = "hello hello world world world hello hello";
        WordCountResult result = wordCounter.countWords(input);
        Assert.assertEquals(expected, result.toString());
    }

    /**
     * Test that the same result is produced when the order of words is changed
     */
    @Test
    public void changingWordOrderTest()
    {
        String expected = "hello: 4\nworld: 3";
        WordCounter wordCounter = new WordCounter();

        String input1 = "hello world hello world hello world hello";
        WordCountResult result1 = wordCounter.countWords(input1);

        String input2 = "world hello hello world hello world hello";
        WordCountResult result2 = wordCounter.countWords(input2);

        String input3 = "world world hello world hello hello hello";
        WordCountResult result3 = wordCounter.countWords(input3);

        Assert.assertEquals(expected, result1.toString());
        Assert.assertEquals(expected, result2.toString());
        Assert.assertEquals(expected, result3.toString());
    }

    /**
     * Test that a variety of punctuation and formatting does not affect the result
     */
    @Test
    public void punctuationVarietyTest()
    {
        String expected = "hello: 4\nworld: 3";

        WordCounter wordCounter = new WordCounter();

        String input1 = "hello, world. hello - world\nhello world hello";
        WordCountResult result1 = wordCounter.countWords(input1);

        String input2 = "world (hello) hello [world] hello!!!! 'world' hello";
        WordCountResult result2 = wordCounter.countWords(input2);

        String input3 = "world world hello\t\tworld\thello\nhello hello";
        WordCountResult result3 = wordCounter.countWords(input3);

        Assert.assertEquals(expected, result1.toString());
        Assert.assertEquals(expected, result2.toString());
        Assert.assertEquals(expected, result3.toString());
    }

    /**
     * Test that letter casing does not affect the result
     */
    @Test
    public void letterCasingTest()
    {
        String expected = "hello: 4\nworld: 3";
        WordCounter wordCounter = new WordCounter();

        String input = "hello HELLO wORLd worlD World hello HELlo";
        WordCountResult result = wordCounter.countWords(input);
        Assert.assertEquals(expected, result.toString());
    }

    /**
     * Test that the output is consistent with multiple words with the same count
     */
    @Test
    public void wordsWithSameNumberOfOccurrenceTest()
    {
        String expected = "aaa: 3\nbbb: 3\nccc: 3\naa: 2\nbb: 2";

        WordCounter wordCounter = new WordCounter();

        String input1 = "aaa aaa aaa bbb bbb bbb ccc ccc ccc aa aa bb bb";
        WordCountResult result1 = wordCounter.countWords(input1);

        String input2 = "bb bb aa aa ccc ccc ccc bbb bbb bbb aaa aaa aaa";
        WordCountResult result2 = wordCounter.countWords(input2);

        String input3 = "ccc bbb aaa ccc bbb aaa ccc bbb aaa bb aa bb aa";
        WordCountResult result3 = wordCounter.countWords(input3);

        Assert.assertEquals(expected, result1.toString());
        Assert.assertEquals(expected, result2.toString());
        Assert.assertEquals(expected, result3.toString());
    }
}
