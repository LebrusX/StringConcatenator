package stringer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("class StringConcatenator")
class StringConcatenatorTest {

    @Test
    @DisplayName("returned right result")
    void concatenationReturnedRightResult() {
        assertAll("concat",
                () -> assertEquals("ab", StringConcatenator.concat("a", "b", 1)),
                () -> assertEquals("b", StringConcatenator.concat("", "b", 1)),
                () -> assertEquals("a", StringConcatenator.concat("a", "", 1)),
                () -> assertEquals("abbbbbb", StringConcatenator.concat("a", "b", 6)),
                () -> assertEquals("a", StringConcatenator.concat("a", "bsgrdfstgdgt", 0))
        );
    }

    @Test
    @DisplayName("throws NullPointerException (why??:D)")
    void throwsException() {
        assertThrows(NullPointerException.class, () -> StringConcatenator.concat(null, "b", 0));
    }

    @ParameterizedTest
    @DisplayName("doesn't throws NullPointerException")
    @EmptySource
    @ValueSource(strings = {"\nd", " ", "\tr", "a"})
    void parametrizedTest1(String s) {
        assertDoesNotThrow(() -> StringConcatenator.concat(s, "vvv", 12));
    }

    @ParameterizedTest
    @CsvSource({"a,b,1,ab", "d,f,3,dfff", "one,f,-12,one"})
    void parametrizedTest2(String s1, String s2, int n, String expected) {
        String actualValue = StringConcatenator.concat(s1, s2, n);
        assertEquals(expected, actualValue);
    }

    @RepeatedTest(10)
    void repeatedTest() {
        assertEquals("aabbbbbbbbbb", StringConcatenator.concat("aa", "b", 10));
    }

}