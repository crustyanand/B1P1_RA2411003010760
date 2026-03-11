import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static boolean twoPointerCheck(String input) {

        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static boolean stackCheck(String input) {

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

    public static boolean dequeCheck(String input) {

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

    public static void main(String[] args) {

        String input = "Never Odd Or Even";

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        startTime = System.nanoTime();
        boolean result2 = stackCheck(input);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        startTime = System.nanoTime();
        boolean result3 = dequeCheck(input);
        endTime = System.nanoTime();
        long time3 = endTime - startTime;

        System.out.println("Input : " + input);
        System.out.println();

        System.out.println("Two Pointer Result : " + result1);
        System.out.println("Execution Time : " + time1 + " ns");
        System.out.println();

        System.out.println("Stack Result : " + result2);
        System.out.println("Execution Time : " + time2 + " ns");
        System.out.println();

        System.out.println("Deque Result : " + result3);
        System.out.println("Execution Time : " + time3 + " ns");
    }
}