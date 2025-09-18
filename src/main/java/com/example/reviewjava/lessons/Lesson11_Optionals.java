package com.example.reviewjava.lessons;

import com.example.reviewjava.Lesson;

import java.util.*;

public class Lesson11_Optionals implements Lesson {
    @Override public String getName() { return "lesson11_optionals"; }
    @Override public String getDescription() { return "Optional: map/flatMap/filter, orElse vs orElseGet vs orElseThrow"; }

    @Override
    public void run() {
        /*
     * QUICK NOTES
     * - Optional is for return types, not fields/params; avoid Optional.get() without isPresent().
     * - orElse eagerly builds the default; orElseGet is lazy; orElseThrow throws if empty.
     * - map transforms when present; flatMap chains Optionals without nesting.
     */
        Optional<String> maybeName = Optional.of("Alice");
        Optional<Integer> maybeLen = maybeName.map(String::length);
        System.out.println("len? " + maybeLen.orElse(-1));

        Optional<String> empty = Optional.empty();
        System.out.println("isPresent=" + empty.isPresent());
        System.out.println("default=" + empty.orElse("unknown"));

        // orElse vs orElseGet: note the eager vs lazy behavior
        System.out.println("orElse immediate: " + empty.orElse(expensive("immediate")));
        System.out.println("orElseGet lazy:  " + empty.orElseGet(() -> expensive("lazy")));

        // flatMap chaining
        Optional<Integer> parsed = Optional.of("123").flatMap(Lesson11_Optionals::tryParseInt);
        System.out.println("parsed= " + parsed.orElse(-1));

        // filter
        Optional<String> filtered = Optional.of("bob").filter(s -> s.length() > 3);
        System.out.println("filtered present? " + filtered.isPresent());
    }

    

    static String expensive(String tag) {
        System.out.println("expensive(" + tag + ") called");
        return "default";
    }

    static Optional<Integer> tryParseInt(String s) {
        try { return Optional.of(Integer.parseInt(s)); }
        catch (NumberFormatException e) { return Optional.empty(); }
    }

    /*
     * PRACTICE
     * 1) Safe divide: Optional<Integer> safeDiv(int a, int b) returning empty on divide-by-zero.
     * 2) Given Optional<String> name, return uppercase if present, else "ANON" without branching.
     * 3) Chain: parse Optional<String> to Optional<Integer> then filter even.
     * 
     * ANSWERS
     * 1) static Optional<Integer> safeDiv(int a, int b) { return (b == 0) ? Optional.empty() : Optional.of(a / b); }
     * 2) String up = name.map(String::toUpperCase).orElse("ANON");
     * 3) Optional<Integer> even = maybeStr.flatMap(Lesson11_Optionals::tryParseInt).filter(n -> n % 2 == 0);
     * 
     * GOTCHAS
     * - Avoid Optional in fields/collections for performance and style; prefer null with docs or empty collection.
     * - Don't serialize Optional; it's not a bean property type.
     */

    public static void main(String[] args) { new Lesson11_Optionals().run(); }
}
