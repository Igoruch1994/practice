package formattext;

public class Main {

    private static final int COLUMNS = 3;
    private static final int DEFAULT_SPACES_BETWEEN = 4;
    final static int[] maxColumnElementLength = new int[3];

    public static void main(String[] args) {
        printFormattedText();
    }

    private static void printFormattedText() {
        final String[] words = new String[]{"a", "as", "dsd", "sdfsdafs", "s", "a", "the end", "Hey"};
        getMaxElementLengthByColumns(words);
        System.out.println("Result : ");
        for (int i = 0; i < words.length; i++) {
            final int column = i % COLUMNS;
            if (column == 0) {
                System.out.print(words[i] + getSpaces(words[i], column));
            } else if (column == 1) {
                System.out.print(words[i] + getSpaces(words[i], column));
            } else {
                System.out.println(words[i]);
            }
        }
        System.out.println("");
        System.out.println("The end!");
    }

    private static String getSpaces(final String word,
                                    final int column) {
        final int spaces = maxColumnElementLength[column] - word.length() + DEFAULT_SPACES_BETWEEN;
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= spaces; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private static void getMaxElementLengthByColumns(final String[] words) {
        for (int i = 0; i < words.length; i++) {
            final int column = i % COLUMNS;
            maxColumnElementLength[column] = Math.max(words[i].length(), maxColumnElementLength[column]);
        }
    }


}
