package com.example.reviewjava.lessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.reviewjava.Lesson;

public class Lesson04_Collections implements Lesson {
    @Override
    public String getName() { return "lesson04_collections"; }

    @Override
    public String getDescription() { return "List, Set, Map basics; sort and iterate"; }

    @Override
    public void run() {
        List<String> names = new ArrayList<>(List.of("Zodde", "Ana", "Bob"));
        Collections.sort(names);
        System.out.println("sorted=" + names);

        Set<Integer> uniq = new HashSet<>(List.of(3,1,2,2,3));
        System.out.println("uniq size=" + uniq.size() + " -> " + uniq);

        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Carol", 28);

        // Iterate map entries
        for (Map.Entry<String, Integer> e : ages.entrySet()) {
            System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
        }

        // Custom sort by length desc then lexicographically
        names.sort(Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.naturalOrder()));
        System.out.println("custom-sorted=" + names);
    }
}
