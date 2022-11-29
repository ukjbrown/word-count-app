package org.example.wordcountapp;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class WordCounterFileTests
{
    /**
     * Basic test that the correct word counts are produced
     */
    @Test
    public void simpleWordCountTestFromFile() throws Exception
    {
        String expected = "hello: 4\nworld: 3";
        WordCounter wordCounter = new WordCounter();

        String inputFilePath = getClass().getClassLoader().getResource("simple-word-count-test.txt").getFile();
        File input = new File(inputFilePath);

        WordCountResult result = wordCounter.countWords(input);
        Assert.assertEquals(expected, result.toString());
    }

    /**
     * Test that the same result is produced when the order of words is changed
     */
    @Test
    public void changingWordOrderTest() throws Exception
    {
        String expected = "hello: 4\nworld: 3";
        WordCounter wordCounter = new WordCounter();

        String inputFilePath1 = getClass().getClassLoader().getResource("changing-word-order-test-1.txt").getFile();
        String inputFilePath2 = getClass().getClassLoader().getResource("changing-word-order-test-2.txt").getFile();
        String inputFilePath3 = getClass().getClassLoader().getResource("changing-word-order-test-3.txt").getFile();
        File input1 = new File(inputFilePath1);
        File input2 = new File(inputFilePath2);
        File input3 = new File(inputFilePath3);

        WordCountResult result1 = wordCounter.countWords(input1);
        WordCountResult result2 = wordCounter.countWords(input2);
        WordCountResult result3 = wordCounter.countWords(input3);

        Assert.assertEquals(expected, result1.toString());
        Assert.assertEquals(expected, result2.toString());
        Assert.assertEquals(expected, result3.toString());
    }

    @Test
    public void multiLineFileTest() throws Exception
    {
        String expected = "hello: 4\nworld: 4\nlast: 1";
        WordCounter wordCounter = new WordCounter();

        String inputFilePath = getClass().getClassLoader().getResource("multi-line-file-test.txt").getFile();
        File input = new File(inputFilePath);

        WordCountResult result = wordCounter.countWords(input);

        Assert.assertEquals(expected, result.toString());
    }
}
