package com.program.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.program.bean.ResponseBean;

public interface IProgrammingService {

    ResponseBean processData(String input);

    Map<String, Integer> sortByWords(String[] words);

    List<Entry<String, Integer>> sortByFrequency(Map<String, Integer> wordMap);

}
