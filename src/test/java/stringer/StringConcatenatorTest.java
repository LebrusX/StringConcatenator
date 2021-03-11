package stringer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        assertAll("throws",
                () -> assertThrows(NullPointerException.class, () -> StringConcatenator.concat(null, "b", 0)),
                () -> assertThrows(NullPointerException.class, () -> StringConcatenator.concat(null, null, 12))
        );
    }


}