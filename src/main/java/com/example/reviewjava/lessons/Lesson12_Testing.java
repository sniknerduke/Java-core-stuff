package com.example.reviewjava.lessons;

import com.example.reviewjava.Lesson;

public class Lesson12_Testing implements Lesson {
    @Override public String getName() { return "lesson12_testing"; }
    @Override public String getDescription() { return "JUnit 5 basics, assertions, and mocking overview"; }

    @Override
    public void run() {
        System.out.println("This lesson is mostly code under src/test/java. Run tests with: mvn -q test");
        System.out.println("Concepts: @Test, assertions, parameterized tests, mocking with Mockito.");
        /*
         * QUICK NOTES
         * - Tests live in src/test/java. Methods annotated with @Test are executed by Maven Surefire.
         * - Prefer small, focused tests: Arrange -> Act -> Assert.
         * - Assertions: org.junit.jupiter.api.Assertions.* and AssertJ/Truth/Hamcrest alternatives.
         * - Parameterized tests reduce repetition for similar inputs.
         * - Mockito helps isolate units by mocking dependencies.
         */
    }

    public static void main(String[] args) { new Lesson12_Testing().run(); }
}
