
package de.codecentric.junit5bdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Stack Tests")
class StackTests {

    private static final String NOT_CONTAINED = "something else";
    private static final String ELEM = "elem";

    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Nested
    @DisplayName("Given an empty Stack")
    class GivenAnEmptyStack {

        @BeforeEach
        void setUp() {
            stack.clear();
        }

        @Test
        @DisplayName("then the size of the Stack should be zero")
        void thenTheSizeOfTheStackShouldBeZero() {
            assertEquals(0, stack.size());
        }

        @Test
        @DisplayName("then search for an element should return minus 1")
        void thenSearchForAnElementShouldReturnMinusOne() {
            assertEquals(-1, stack.search(ELEM));
        }

        @Test
        @DisplayName("then peek should throw an EmptyStackException")
        void thenPeekShouldThrowAnEmptyStackException() {
            assertThrows(EmptyStackException.class, () -> stack.peek());
        }

        @Test
        @DisplayName("then pop should throw an EmptyStackException")
        void thenPopShouldThrowAnEmptyStackException() {
            assertThrows(EmptyStackException.class, () -> stack.pop());
        }

        @Nested
        @DisplayName("when an element is added")
        class WhenAnElementIsAdded {

            @BeforeEach
            void setUp() {
                stack.add(ELEM);
            }

            @Test
            @DisplayName("then the size of the Stack should be one")
            void thenTheSizeOfTheStackShouldBeOne() {
                assertEquals(1, stack.size());
            }

            @Test
            @DisplayName("then search for that element should return one")
            void thenSearchForThatElementShouldReturnOne() {
                assertEquals(1, stack.search(ELEM));
            }

            @Test
            @DisplayName("then search for a different element should return -1")
            void thenSearchForDifferentElementShoudlReturnMinusOne() {
                assertEquals(-1, stack.search(NOT_CONTAINED));
            }

            @Test
            @DisplayName("then peek should return that element without removing it")
            void thenPeekShouldReturnThatElementWithoutRemovingIt() {
                assertAll(
                        () -> assertEquals(ELEM, stack.peek()),
                        () -> assertEquals(1, stack.size())
                );
            }

            @Test
            @DisplayName("then pop should return that element and remove it")
            void thenPopShouldReturnThatElementAndRemoveIt() {
                assertAll(
                        () -> assertEquals(ELEM, stack.pop()),
                        () -> assertEquals(0, stack.size())
                );
            }
        }
    }
}
