package com.program.util;

import java.util.Comparator;
import java.util.Map;

/**
 * Sort the map by values in descending order first then sort by keys in
 * ascending order
 *
 * @param <K>
 * @param <V>
 */
public class ValueThenKeyComparator<K extends Comparable<? super K>, V extends Comparable<? super V>>
        implements Comparator<Map.Entry<K, V>> {

    public int compare(Map.Entry<K, V> first, Map.Entry<K, V> second) {
        // Sort by value first in descending order
        int compare = second.getValue().compareTo(first.getValue());
        if (compare != 0) {
            return compare;
        } else {
            // If values are same then sort by key in ascending order
            return first.getKey().compareTo(second.getKey());
        }
    }
}