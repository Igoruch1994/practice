package stringpermutation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter word please: ");
            final String word = new Scanner(System.in).next();
            if (word.equalsIgnoreCase("exit")) {
                break;
            }
            mix("", word);
        }
    }

    private static void mix(final String firstPart, final String secondPart) {
        if (secondPart.isEmpty()) {
            System.out.println(firstPart);
        }
        for (int i = 0; i < secondPart.length(); i++) {
            final char currentChar = secondPart.charAt(i);
            mix(firstPart + currentChar, secondPart.substring(0, i) + secondPart.substring(i + 1));
        }
    }

}
