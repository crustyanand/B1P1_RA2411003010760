import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Never Odd Or Even";

        PalindromeStrategy strategy;

        strategy = new StackStrategy();

        boolean result = strategy.checkPalindrome(input);

        System.out.println("Using Stack Strategy");
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);

        strategy = new DequeStrategy();

        result = strategy.checkPalindrome(input);

        System.out.println("\nUsing Deque Strategy");
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}