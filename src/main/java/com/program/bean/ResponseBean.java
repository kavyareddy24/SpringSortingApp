package com.program.bean;

import java.util.ArrayList;
import java.util.List;

public class ResponseBean {

    private List<Word> words = new ArrayList<>();

    private List<Word> frequencies = new ArrayList<>();

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public List<Word> getFrequencies() {
        return frequencies;
    }

    public void setFrequencies(List<Word> frequencies) {
        this.frequencies = frequencies;
    }

    public void addWord(String text, int count) {
        words.add(new Word(text, count));
    }
    
    public void addFrequency(String text, int count) {
        frequencies.add(new Word(text, count));
    }
}