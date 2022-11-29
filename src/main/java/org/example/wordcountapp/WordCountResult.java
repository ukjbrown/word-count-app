package org.example.wordcountapp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stores the result of a word counter run, includes basic logic for adding/counting a word and converting the
 * result to a human-readable string for output.
 */
public class WordCountResult
{
    private Map<String, Integer> wordCounts = new HashMap<>();
    private Map<String, Integer> sortedWordCounts = new LinkedHashMap<>();
    private boolean sorted = true;

    public WordCountResult() {}

    /**
     * Count a single word
     *
     * @param word to be counted
     */
    public void addWordToCount(String word)
    {
        if(word.length() == 0) return;
        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        sorted = false;
    }

    /**
     * Create a sorted copy of the word count map to be used for printed output
     */
    private void sort()
    {
        // Sort the map by value (descending), using the key (word) as secondary sort to ensure consistency
        sortedWordCounts = wordCounts.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    int result = entry2.getValue().compareTo(entry1.getValue());
                    return result == 0 ? entry1.getKey().compareTo(entry2.getKey()) : result;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (entry1, entry2) -> entry1, LinkedHashMap::new));
        
        sorted = true;
    }

    /**
     * Convert the results map to a string of newline-separated "key: value" pairs
     *
     * @return string representation of the result
     */
    @Override
    public String toString()
    {
        // Sort the map if it hasn't already been sorted
        if(!sorted) sort();

        // Join each map entry into a newline-separated "key: value" pairs.
        return sortedWordCounts.entrySet()
                .stream()
                .map(entry -> String.format("%s: %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
