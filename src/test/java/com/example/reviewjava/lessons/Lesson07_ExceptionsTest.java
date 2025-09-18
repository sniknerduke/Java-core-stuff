package com.example.reviewjava.lessons;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Lesson07_ExceptionsTest {
    @Test
    void parseAge_throwsOnNegative() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> Lesson07_Exceptions.parseAge("-1"));
        assertTrue(ex.getMessage().contains("age must be"));
    }

    @Test
    void parseAge_parsesPositive() {
        assertEquals(10, Lesson07_Exceptions.parseAge("10"));
    }
}
