package com.program.bean;

public class Word {

    private String text;
    private int count;

    public Word(String text, int count) {
        this.text = text;
        this.count = count;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Word [text=" + text + ", count=" + count + "]";
    }
}