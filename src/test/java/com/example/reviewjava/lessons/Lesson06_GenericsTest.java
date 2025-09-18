package com.example.reviewjava.lessons;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Lesson06_GenericsTest {
    @Test
    void maxOf_choosesLongestString() {
        String best = Lesson06_Generics.maxOf(
                List.of("a", "abcd", "abc"),
                Comparator.comparingInt(String::length)
        );
        assertEquals("abcd", best);
    }

    @Test
    void sumAll_handlesEmptyAndNumbers() {
        double s1 = Lesson06_Generics.sumAll(List.of());
        double s2 = Lesson06_Generics.sumAll(List.of(1, 2, 3));
        assertEquals(0.0, s1);
        assertEquals(6.0, s2);
    }
}
