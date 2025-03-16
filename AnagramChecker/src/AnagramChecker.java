import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {
    // Method to clean and format strings (remove special characters, numbers, spaces)
    public static String cleanString(String str) {
        return str.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Keep only letters
    }

    // Method to check if two strings are anagrams
    public static boolean isAnagram(String str1, String str2) {
        // Clean both strings
        str1 = cleanString(str1);
        str2 = cleanString(str2);

        // If lengths are not the same, not an anagram
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert to character arrays and sort
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Loop to allow multiple inputs
            // User input
            System.out.print("\nEnter first string (or type 'exit' to quit): ");
            String str1 = scanner.nextLine();

            if (str1.equalsIgnoreCase("exit")) { // Exit condition
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            System.out.print("Enter second string: ");
            String str2 = scanner.nextLine();

            // Check if they are anagrams
            if (isAnagram(str1, str2)) {
                System.out.println("✅ The strings are anagrams.");
            } else {
                System.out.println("❌ The strings are NOT anagrams.");
            }
        }

        scanner.close();
    }
}
