package stringpolindrome;

import java.util.Objects;
import java.util.Scanner;

import static util.ConsoleColor.*;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println(ANSI_YELLOW + "Enter word please: " + ANSI_RESET);
            final String word = new Scanner(System.in).next();
            //final boolean isWordPolindrom = isWordPolindrom(word);
            final boolean isWordPolindrom = isWordPolindromWithRecursion(word);
            System.out.println("--------------------------------");
            System.out.println(ANSI_CYAN + "Polindrom? - " + ANSI_RESET + (isWordPolindrom ?
                    ANSI_YELLOW + "Yes" + ANSI_RESET : ANSI_RED + "No" + ANSI_RESET));
            System.out.println("--------------------------------");
        }
    }

    private static boolean isWordPolindrom(final String word) {
        final char[] wordCharacters = word.toCharArray();
        final int wordLength = wordCharacters.length;
        if (wordCharacters[0] != wordCharacters[wordLength - 1]) {
            return false;
        }
        if (wordLength == 3) {
            return true;
        }
        final int halfWordLength = (int) Math.floor(wordLength / 2);
        for (int i = 2; i <= halfWordLength; i++) {
            if (wordCharacters[i] != wordCharacters[wordCharacters.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    // ----------------------------------------------------------------------------------

    private static boolean isWordPolindromWithRecursion(final String word) {
        final String reverse = getReverse(word);
        return reverse.equals(word);
    }

    private static String getReverse(final String word) {
        if (Objects.isNull(word) || word.isEmpty()) {
            return "";
        }
        return word.charAt(word.length() - 1) + getReverse(word.substring(0, word.length() - 1));
    }

}
