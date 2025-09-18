package com.example.reviewjava.lessons;

import com.example.reviewjava.Lesson;

import java.util.*;
import java.util.stream.Collectors;

public class Lesson10_StreamsAdvanced implements Lesson {
    @Override public String getName() { return "lesson10_streams_advanced"; }
    @Override public String getDescription() { return "groupingBy, partitioningBy, flatMap, summarizing, joining"; }

    @Override
    public void run() {
        List<String> words = List.of("apple", "banana", "pear", "plum", "apricot", "blueberry");
        /*
         * QUICK NOTES
         * - groupingBy groups into Map<key, List<T>> by classifier; partitioningBy splits by boolean predicate.
         * - flatMap flattens nested streams (e.g., Stream<String[]> to Stream<String>).
         * - Collectors.summarizingDouble gives count/sum/min/max/avg; joining concatenates.
         */

        Map<Integer, List<String>> byLen = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("groupingBy length -> " + byLen);

        Map<Boolean, List<String>> partition = words.stream()
                .collect(Collectors.partitioningBy(w -> w.startsWith("p")));
        System.out.println("partition startsWith('p') -> " + partition);

        List<String> letters = words.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("distinct letters -> " + letters);

        DoubleSummaryStatistics stats = words.stream()
                .collect(Collectors.summarizingDouble(String::length));
        System.out.println("length stats -> " + stats);

        String joined = words.stream()
                .collect(Collectors.joining(", "));
        System.out.println("joined -> " + joined);
    }

        /*
         * PRACTICE
         * 1) Build Map<Character, Long> counting words by first letter (hint: groupingBy + counting()).
         * 2) Build a single string of words longer than 4, sorted, joined with " | ".
         * 3) From a list of sentences, get distinct letters ignoring spaces and case, sorted.
         * 
         * ANSWERS
         * 1) Map<Character, Long> m = words.stream()
         *        .collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()));
         * 2) String s = words.stream().filter(w -> w.length() > 4).sorted().collect(Collectors.joining(" | "));
         * 3) List<String> sentences = List.of("Hi there", "Streams Rock");
         *    List<Character> letters = sentences.stream()
         *        .map(String::toLowerCase)
         *        .map(str -> str.replace(" ", ""))
         *        .map(str -> str.chars().mapToObj(c -> (char)c))
         *        .flatMap(s2 -> s2)
         *        .distinct()
         *        .sorted()
         *        .toList();
         * 
         * GOTCHAS
         * - Don’t mutate external state inside stream operations; prefer collectors.
         * - Be careful with expensive operations inside map/filter; consider caching or precomputing.
         */

    public static void main(String[] args) { new Lesson10_StreamsAdvanced().run(); }
}
