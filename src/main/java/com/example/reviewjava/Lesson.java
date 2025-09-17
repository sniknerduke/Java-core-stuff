package com.example.reviewjava;

/**
 * Tiny contract for a runnable lesson.
 */
public interface Lesson {
    String getName();
    String getDescription();
    void run();
}
