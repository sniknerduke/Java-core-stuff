package com.example.reviewjava.lessons;

import com.example.reviewjava.Lesson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.Stream;

public class Lesson09_FilesNio implements Lesson {
    @Override public String getName() { return "lesson09_files_nio"; }
    @Override public String getDescription() { return "Path/Files: write/read text, list directory, delete"; }

    @Override
    public void run() {
        /*
         * QUICK NOTES
         * - Path is an abstract path; Files has static helpers for IO.
         * - Prefer UTF-8 when reading/writing text (StandardCharsets.UTF_8).
         * - Use try-with-resources (Files.newBufferedReader/newBufferedWriter/lines) for streams.
         */
        try {
            Path tmp = Files.createTempDirectory("nio-demo");
            Path file = tmp.resolve("hello.txt");

            Files.writeString(file, "hello nio\nline2", StandardCharsets.UTF_8);
            String content = Files.readString(file, StandardCharsets.UTF_8);
            System.out.println("read:\n" + content);

            System.out.println("list dir:");
            try (Stream<Path> s = Files.list(tmp)) {
                s.forEach(p -> System.out.println("- " + p.getFileName()));
            }

            Files.deleteIfExists(file);
            Files.deleteIfExists(tmp);
            System.out.println("cleaned up: " + tmp);
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
    }

    /*
     * PRACTICE
     * 1) Append a second line to hello.txt without truncating (hint: StandardOpenOption.APPEND).
     * 2) List only .txt files in the temp dir using Files.list + filter.
     * 3) Copy hello.txt to hello-copy.txt, then move it to subdir/hello-moved.txt (create subdir first).
     * 
     * ANSWERS
     * 1) Files.writeString(file, "\nSecond line", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
     * 2) try (Stream<Path> s = Files.list(tmp)) { s.filter(p -> p.toString().endsWith(".txt")).forEach(System.out::println); }
     * 3) Path copy = tmp.resolve("hello-copy.txt");
     *    Files.copy(file, copy, StandardCopyOption.REPLACE_EXISTING);
     *    Path sub = tmp.resolve("subdir"); Files.createDirectories(sub);
     *    Files.move(copy, sub.resolve("hello-moved.txt"), StandardCopyOption.REPLACE_EXISTING);
     * 
     * GOTCHAS
     * - Always close streams/directories (use try-with-resources) to avoid leaks/locks.
     * - On Windows, a file cannot be moved/deleted if an open handle exists.
     * - Use Files.createDirectories for nested dirs; createDirectory fails if parent missing.
     */

    public static void main(String[] args) { new Lesson09_FilesNio().run(); }
}
