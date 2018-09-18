package de.codecentric.junit5bdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassicStackTests {

    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void emptyStackShouldHaveSizeZero() {
        // given
        stack.clear();

        // when
        int size = stack.size();

        // then
        assertEquals(0, size);
    }
}
