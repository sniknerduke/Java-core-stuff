package com.example.reviewjava;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.example.reviewjava.lessons.Lesson01_Basics;
import com.example.reviewjava.lessons.Lesson02_ControlFlow;
import com.example.reviewjava.lessons.Lesson03_OOP;
import com.example.reviewjava.lessons.Lesson04_Collections;
import com.example.reviewjava.lessons.Lesson05_Streams;
import com.example.reviewjava.lessons.Lesson06_Generics;
import com.example.reviewjava.lessons.Lesson07_Exceptions;
import com.example.reviewjava.lessons.Lesson08_DateTime;
import com.example.reviewjava.lessons.Lesson09_FilesNio;
import com.example.reviewjava.lessons.Lesson10_StreamsAdvanced;
import com.example.reviewjava.lessons.Lesson11_Optionals;
import com.example.reviewjava.lessons.Lesson12_Testing;

public class LessonRunner {
    private static final List<Lesson> LESSONS = List.of(
            new Lesson01_Basics(),
            new Lesson02_ControlFlow(),
            new Lesson03_OOP(),
        new Lesson04_Collections(),
        new Lesson05_Streams(),
        new Lesson06_Generics(),
        new Lesson07_Exceptions(),
        new Lesson08_DateTime(),
        new Lesson09_FilesNio(),
        new Lesson10_StreamsAdvanced(),
        new Lesson11_Optionals(),
        new Lesson12_Testing()
    );

    public static void main(String[] args) {
        Map<String, Lesson> map = new LinkedHashMap<>();
        for (Lesson l : LESSONS) {
            map.put(l.getName().toLowerCase(Locale.ROOT), l);
        }

        if (args.length == 0 || Arrays.asList(args).contains("--list")) {
            System.out.println("Java Core Lessons (run with: mvn -q exec:java -Dexec.args=\"<lesson>\"):\n");
            for (Lesson l : LESSONS) {
                System.out.printf("- %s: %s%n", l.getName(), l.getDescription());
            }
            return;
        }

        String key = String.join(" ", args).toLowerCase(Locale.ROOT).trim();
        Lesson chosen = map.get(key);
        if (chosen == null) {
            System.out.println("Unknown lesson: '" + String.join(" ", args) + "'\n");
            System.out.println("Available lessons:");
            for (Lesson l : LESSONS) {
                System.out.printf("- %s%n", l.getName());
            }
            System.exit(1);
        }

        System.out.printf("\n=== %s ===%n%s%n%n", chosen.getName(), chosen.getDescription());
        chosen.run();
    }
}
