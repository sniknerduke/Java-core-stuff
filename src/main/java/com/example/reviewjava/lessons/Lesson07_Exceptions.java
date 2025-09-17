package com.example.reviewjava.lessons;

import com.example.reviewjava.Lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lesson07_Exceptions implements Lesson {
    @Override public String getName() { return "lesson07_exceptions"; }
    @Override public String getDescription() { return "Checked vs unchecked, try-with-resources, wrapping"; }

    @Override
    public void run() {
        /*
         * QUICK NOTES
         * - Checked (IOException) must be declared/handled; Unchecked (RuntimeException) indicate programmer errors.
         * - Prefer specific exception types and meaningful messages.
         * - Use try-with-resources to auto-close Closeable/AutoCloseable.
         */
        System.out.println("== Checked ==");
        try {
            Files.readString(Path.of("missing.txt"));
        } catch (IOException e) {
            System.out.println("Caught checked: " + e.getClass().getSimpleName());
        }

        System.out.println("\n== Unchecked ==");
        try {
            parseAge("-5");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught unchecked: " + e.getMessage());
        }

        System.out.println("\n== Try-with-resources ==");
        try (BufferedReader br = new BufferedReader(new StringReader("hello\nworld"))) {
            System.out.println("first line: " + br.readLine());
        } catch (IOException e) {
            System.out.println("TWR caught: " + e.getClass().getSimpleName());
        }

        System.out.println("\n== Wrap checked ==");
        try {
            mightThrowChecked();
        } catch (IOException e) {
            RuntimeException wrapped = new RuntimeException("wrap checked", e);
            System.out.println("wrapped cause: " + wrapped.getCause().getClass().getSimpleName());
        }
    }

    static void mightThrowChecked() throws IOException { throw new IOException("boom"); }

    static int parseAge(String s) {
        int age = Integer.parseInt(s); // NumberFormatException (unchecked) if bad
        if (age < 0) throw new IllegalArgumentException("age must be >= 0");
        return age;
    }

    /*
     Practice:
     1) Change parseAge to return OptionalInt instead of throwing for negatives; when would you prefer that?
        - Answer: Return OptionalInt when "missing/invalid" is part of normal flow and not exceptional. Throw when it's truly exceptional or a programmer error.

     2) Wrap IOException into a custom unchecked exception AppIoException. When is wrapping useful?
        - Answer: Useful to avoid propagating checked exceptions across layers that can't handle them; centralize handling at boundaries.

     3) Why try-with-resources instead of finally?
        - Answer: TWR guarantees close() even with exceptions, is less error-prone, and handles suppressed exceptions correctly.
     
     GOTCHAS
     - Don't swallow exceptions silently; at minimum log with context.
     - Avoid throwing Exception or Throwable; keep throws lists tight.
     - Wrap lower-level exceptions to add context, but preserve original cause.
    */

    public static void main(String[] args) { new Lesson07_Exceptions().run(); }
}
