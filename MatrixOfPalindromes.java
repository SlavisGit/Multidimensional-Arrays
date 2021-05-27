import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char start = 'a';
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] palindromes = new String[rows][cols];
        fillPalindromeMatrix(rows, cols, start, palindromes);
        printPalindromeMatrix(palindromes);
    }

    private static void fillPalindromeMatrix(int rows, int cols, char start, String[][] palindromes) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                palindromes[row][col] = "" + start + (char)(start + col) + start;
            }
            start = (char)(start + 1);
        }
    }
    private static void printPalindromeMatrix(String[][] palindrome) {
        for (int row = 0; row < palindrome.length; row++) {
            for (int col = 0; col < palindrome[row].length; col++) {
                System.out.print(palindrome[row][col] + " ");
            }
            System.out.println();
        }
    }
}
