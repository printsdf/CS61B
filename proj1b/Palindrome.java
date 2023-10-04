public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> str = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            str.addLast(word.charAt(i));
        }
        return str;
    }

    public boolean isPalindromeIterative(String word) {
        Deque<Character> d = wordToDeque(word);
        if (d.size() <= 1) {
            return true;
        }
        for (int i = 0; i < d.size() / 2; i++) {
            if (d.removeFirst() != d.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return isPalindromeRecursionHelper(d);
    }

    private boolean isPalindromeRecursionHelper(Deque<Character> d) {
        if (d.size() <= 1) {
            return true;
        }
        if (d.removeFirst() != d.removeLast()) {
            return false;
        }
        return isPalindromeRecursionHelper(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        if (d.size() <= 1) {
            return true;
        }
        for (int i = 0; i < d.size() / 2; i++) {
            if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
