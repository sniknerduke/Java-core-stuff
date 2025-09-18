package com.example.reviewjava.lessons;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class Lesson11_OptionalsTest {
    @Test
    void tryParseInt_parsesValid() {
        Optional<Integer> ok = Lesson11_Optionals.tryParseInt("123");
        assertTrue(ok.isPresent());
        assertEquals(123, ok.get());
    }

    @Test
    void tryParseInt_emptyOnInvalid() {
        Optional<Integer> bad = Lesson11_Optionals.tryParseInt("x");
        assertTrue(bad.isEmpty());
    }
}
