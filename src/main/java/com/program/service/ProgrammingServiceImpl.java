package com.program.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.program.bean.ResponseBean;
import com.program.util.ProcessUtility;
import com.program.util.ValueThenKeyComparator;

/**
 * 1) Alphabetical list (with counts in parentheses) 
 * 2) Frequency list (with counts in parentheses)
 */
@Service
public class ProgrammingServiceImpl implements IProgrammingService {

    @Autowired
    private ProcessUtility utility;

    public static void main(String[] args) {
        String input = "This is a test input for a program:22 $$ history, one two#two or, three*three*three four!four!four!four!";
        ProgrammingServiceImpl task = new ProgrammingServiceImpl();
        task.processData(input);
    }

    /**
     * Core logic of the program that takes input string and displays 
     * 1) Alphabetical list (with counts in parentheses) 
     * 2) Frequency list (with counts in parentheses)
     * 
     * @param input
     */
    @Override
    public ResponseBean processData(String input) {
        ResponseBean bean = new ResponseBean();
        // Remove Special characters from input string
        input = utility.removeSpecialChars(input);

        // Convert string to individual words
        String[] words = input.split(" ");

        // Sort by words
        Map<String, Integer> wordMap = sortByWords(words);
        
        for (String word : wordMap.keySet()) {
            bean.addWord(word, wordMap.get(word));
        }
        
        // Sort by frequency
        List<Map.Entry<String, Integer>> list = sortByFrequency(wordMap);

        for (Map.Entry<String, Integer> entry : list) {
            bean.addFrequency(entry.getKey(), entry.getValue());
        }
        return bean;
    }

    /**
     * Logic to perform - Alphabetical list (with counts in parentheses)
     * 
     * @param words
     * @return
     */
    @Override
    public Map<String, Integer> sortByWords(String[] words) {
        // TreeMap with key as the input word and value as the number of times
        // the word occurred
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        return wordMap;
    }

    /**
     * Logic to perform - Frequency list (with counts in parentheses)
     * 
     * @param wordMap
     * @return
     */
    @Override
    public List<Map.Entry<String, Integer>> sortByFrequency(Map<String, Integer> wordMap) {
        // Convert the map to an array list
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(wordMap.entrySet());
        // Sort the list based on the frequency of each word
        Collections.sort(list, new ValueThenKeyComparator<String, Integer>());
        return list;
    }

}