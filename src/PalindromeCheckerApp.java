public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Never Odd Or Even";

        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        int start = 0;
        int end = normalized.length() - 1;

        boolean isPalindrome = true;

        while (start < end) {

            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("Original Input : " + input);
        System.out.println("Normalized Input : " + normalized);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}