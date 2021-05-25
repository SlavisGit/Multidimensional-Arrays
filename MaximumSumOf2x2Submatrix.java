import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = readArray(scanner.nextLine(), ", ");
        int rows = input[0];
        int cols = input[1];
        int[][] matrix = readMatrix(scanner,rows, cols);
        int[][] matrix2x2= getElementsSubMatrix(matrix);
        printMatrix(matrix2x2);
        System.out.println(getSumInMatrix(matrix2x2));

    }

    private static int getSumInMatrix(int[][] matrix2x2) {
        int sum = 0;
        for (int i = 0; i < matrix2x2.length; i++) {
            for (int j = 0; j < matrix2x2[i].length; j++) {
                sum += matrix2x2[i][j];
            }
        }
        return sum;
    }

    private static int[][] getElementsSubMatrix(int[][] matrix) {
        int bestCol = 0;
        int bestRow = 0;
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = 0;
                sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if(sum > max) {
                    max = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return new int[][] { {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
                             {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
        };
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix= new int[rows][cols];
        for (int row = 0; row < rows; row++) {
           matrix[row] = readArray(scanner.nextLine(), ", ");
        }
        return matrix;
    }
    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
