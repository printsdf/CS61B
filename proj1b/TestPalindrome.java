import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        String word1 = "cat";
        boolean actual1 = palindrome.isPalindrome(word1);
        assertFalse(actual1);

        String word2 = "racecar";
        boolean actual2 = palindrome.isPalindrome(word2);
        assertTrue(actual2);

        String word3 = "persiflage";
        boolean actual3 = palindrome.isPalindrome(word3);
        assertFalse(actual3);

        assertTrue(palindrome.isPalindrome("a"));

        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testOffByOnePalindrome() {
        OffByOne cc = new OffByOne();
        String word1 = "cat";
        boolean actual1 = palindrome.isPalindrome(word1, cc);
        assertFalse(actual1);

        String word2 = "flake";
        boolean actual2 = palindrome.isPalindrome(word2, cc);
        assertTrue(actual2);

        String word3 = "persiflage";
        boolean actual3 = palindrome.isPalindrome(word3, cc);
        assertFalse(actual3);

        assertTrue(palindrome.isPalindrome("a", cc));

        assertTrue(palindrome.isPalindrome("", cc));
    }
}
