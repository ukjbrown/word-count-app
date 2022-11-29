package org.example.wordcountapp;

public class TestHelper
{
    public static String fixNewlines(String input)
    {
        return input.replaceAll("\n", System.lineSeparator());
    }
}
