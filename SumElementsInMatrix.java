import java.util.Arrays;
import java.util.Scanner;

public class SumElementsInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols= readArray(scanner.nextLine(), ", ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = readMatrix(rows, cols, scanner, ", ");
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(findSumInMatrix(matrix));
    }
    public static int findSumInMatrix(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }
    private static int[] readArray(String nextLine, String pattern) {
        return Arrays.stream(nextLine.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }
        return matrix;
    }
    public static void printMatrix (int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int cols = 0; cols < matrix[row].length; cols++) {
                System.out.print(matrix[row][cols] + " ");
            }
            System.out.println();
        }
    }
}
