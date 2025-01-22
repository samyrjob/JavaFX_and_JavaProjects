import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;




public class PalindromeTest {

    String user_input = "j72626$ù$rrj";

    @Test
    @DisplayName("Display error when it's not alphanumeric input or null or length < 3 ")
    void testThrowError() {
        Exception error;
        error = assertThrows(IllegalArgumentException.class, () -> Palindrome.try_method(user_input));
    }

    @Test
    public void testMethodDoesNotThrowException() {
        try {
            Palindrome.try_method("leveppppl");
        } catch (Exception e) {
            fail("Expected no exception to be thrown, but got: " + e.getMessage());
        }
}


    @Test
    @DisplayName("Ensure no exception is thrown when the try method programme works  ")
    void testMain() {
        assertDoesNotThrow(() -> { Palindrome.try_method("level");}, "Expected no exception, but an exception was thrown.");
    }



    @Test
    @DisplayName("Test non valid palindrome")
    void testNonValidPalindrome() {
        assertFalse(Palindrome.isPalindrome(user_input));
        assertNotEquals("Palindrome", Palindrome.checkPalindrome(user_input));
    }

    

    @Test
    @DisplayName("Test valid palindrome")
    void testValidPalindrome() {
        assertTrue(Palindrome.isPalindrome("levelmkoihjioh"));
        assertEquals("Palindrome", Palindrome.checkPalindrome("levehbfuyqfbl"));
    }



    @Test
    @DisplayName("Test non-palindrome")
    void testNonPalindrome() {
        assertEquals("Not a Palindrome", Palindrome.checkPalindrome(user_input));
    }
}
