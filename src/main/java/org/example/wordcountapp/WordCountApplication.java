package org.example.wordcountapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Console application that provides an occurrence count for each word in a given text file.
 */
public class WordCountApplication
{
    public static void main(String... args)
    {
        // Check file path has been supplied
        if(args.length < 1)
        {
            System.out.println("Input file location must be specified.");
            System.exit(1);
        }

        String inputFilePath = args[0];
        WordCounter wordCounter = new WordCounter();

        try
        {
            // Count words in given file and produce result
            WordCountResult wordCountResult = wordCounter.countWords(new File(inputFilePath));

            // Print result to console
            System.out.print(wordCountResult.toString());
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.out.println("Input file path could not be found.");
            System.exit(1);
        }
        catch (IOException ioException)
        {
            System.out.println("An error occurred reading the input file.");
            System.exit(1);
        }
    }
}
