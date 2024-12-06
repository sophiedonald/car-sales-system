package carsalessystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import carsalessystem.TryParseInt;

public class TryParseIntTest {

    @Test
    public void testValidInteger() {
        // Test when the string represents a valid integer
        assertEquals(123, TryParseInt.tryParseInt("123"));
    }

    @Test
    public void testNegativeInteger() {
        // Test when the string represents a valid negative integer
        assertEquals(-123, TryParseInt.tryParseInt("-123"));
    }

    @Test
    public void testZero() {
        // Test when the string represents zero
        assertEquals(0, TryParseInt.tryParseInt("0"));
    }

    @Test
    public void testEmptyString() {
        // Test when the string is empty (should return -1)
        assertEquals(-1, TryParseInt.tryParseInt(""));
    }

    @Test
    public void testNonNumericString() {
        // Test when the string does not represent a number (should return -1)
        assertEquals(-1, TryParseInt.tryParseInt("abc"));
    }

    @Test
    public void testStringWithWhitespace() {
        // Test when the string contains leading or trailing whitespaces (should return -1)
        assertEquals(-1, TryParseInt.tryParseInt("  123  "));
    }

    @Test
    public void testNull() {
        // Test when the string is null (should return -1)
        assertEquals(-1, TryParseInt.tryParseInt(null));
    }
}
