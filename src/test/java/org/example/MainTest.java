package org.example;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("MyTest - JUnit Annotations Example")
public class MainTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all tests");
    }

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        System.out.println("Before each test: " + testInfo.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        System.out.println("After each test: " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Equals Test")
    void testEquals() {
        assertEquals(4, 2 + 2);
    }

    @Test
    @DisplayName("Not Equals Test")
    void testNotEquals() {
        assertNotEquals(5, 2 * 3);
    }

    @Test
    @DisplayName("True Test")
    void testTrue() {
        assertTrue((2 * 2) > 3);
    }

    @Test
    @DisplayName("False Test")
    void testFalse() {
        assertFalse((2 * 2) > 5);
    }

    @Test
    @DisplayName("Null Test")
    void testNull() {
        Object obj = null;
        assertNull(obj);
    }

    @Test
    @DisplayName("Not Null Test")
    void testNotNull() {
        Object notNullObj = new Object();
        assertNotNull(notNullObj);
    }

    @Test
    @DisplayName("Same Test")
    void testSame() {
        String str1 = "hello";
        String str2 = "hello";
        assertSame(str1, str2);
    }

    @Test
    @DisplayName("Not Same Test")
    void testNotSame() {
        String str1 = "hello";
        String str3 = new String("hello");
        assertNotSame(str1, str3);
    }

    @Test
    @DisplayName("Array Equals Test")
    void testArrayEquals() {
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Iterable Equals Test")
    void testIterableEquals() {
        Iterable<String> expectedIterable = List.of("apple", "orange", "banana");
        Iterable<String> actualIterable = List.of("apple", "orange", "banana");
        assertIterableEquals(expectedIterable, actualIterable);
    }

    @Test
    @DisplayName("Lines Match Test")
    void testLinesMatch() {
        List<String> expectedLines = List.of("Hello", "World");
        List<String> actualLines = List.of("Hello", "World");
        assertLinesMatch(expectedLines, actualLines);
    }

    @Test
    @DisplayName("Throws Test")
    void testThrows() {
        assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0;
        });
    }

    @Test
    @DisplayName("Timeout Test")
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            // Code that should complete within 100 milliseconds
        });
    }

    @Test
    @DisplayName("Timeout Preemptively Test")
    void testTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            // Code that should complete within 100 milliseconds, preemptively interrupting if it exceeds
        });
    }

    @Test
    @DisplayName("All Test")
    void testAll() {
        assertAll("Multiple Assertions",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue((2 * 2) > 3),
                () -> assertNotEquals(5, 2 * 3)
        );
    }

    @Test
    @DisplayName("Hamcrest Matcher Test")
    void testHamcrestMatcher() {
        assertThat("Hello", containsString("ell"));
    }

    @Test
    @DisplayName("Fail Test")
    @Disabled("This test is disabled for demonstration purposes")
    void testFail() {
        fail("This test intentionally fails");
    }

    @RepeatedTest(3)
    @DisplayName("Repeated Test")
    void testRepeated(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running repeated test " + repetitionInfo.getCurrentRepetition());
        assertTrue(repetitionInfo.getCurrentRepetition() <= 3);
    }

    @Test
    @Tag("fast")
    @DisplayName("Tagged Test - Fast")
    void testTaggedFast() {
        // Test logic for the "fast" category
    }

    @Test
    @Tag("slow")
    @DisplayName("Tagged Test - Slow")
    void testTaggedSlow() {
        // Test logic for the "slow" category
    }
}
