package org.example.wordcountapp;

import java.io.*;
import java.util.stream.Stream;

/**
 * A class that produces a WordCountResult for a given file or string input.
 */
public class WordCounter
{
    public WordCounter() {}

    /**
     * Count the number of occurrences of each word in a given text file
     * @param inputFile file to count words in
     * @return word count result object
     * @throws FileNotFoundException
     * @throws IOException
     */
    public WordCountResult countWords(File inputFile) throws FileNotFoundException, IOException
    {
        WordCountResult result = new WordCountResult();

        // Create a file reader to stream in the file content
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        // Read in the file, and process line by line
        String line;
        while((line = reader.readLine()) != null)
        {
            // Get array of words from the current line
            String[] words = getWords(line);

            // Add each word to the word count result
            Stream.of(words).forEach(result::addWordToCount);
        }

        return result;
    }

    /**
     * Count the number of occurrences of each word in an input string.
     *
     * @param inputString string to count words in
     * @return word count result object
     */
    public WordCountResult countWords(String inputString)
    {
        WordCountResult result = new WordCountResult();

        // Get array of words from the input string
        String[] words = getWords(inputString);

        // Add each word to the word count result
        Stream.of(words).forEach(result::addWordToCount);

        return result;
    }

    /**
     * Sanitise and split the string input into individual words
     *
     * @param input to produce array of words from
     * @return array of words
     */
    private String[] getWords(String input)
    {
        // Remove all punctuation characters, convert to lower case, and split on any non-alphanumeric (e.g. spaces, tabs, newlines)
        return input.replaceAll("\\p{P}", "")
                .toLowerCase()
                .split("\\W+");
    }
}
