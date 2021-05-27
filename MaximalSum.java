import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = fillMatrix(rows, cols, scanner);
        int[][] matrix3x3 = find3X3Matrix(matrix);
        int sumOfMatrix3x3 = sum3x3(matrix3x3);
        System.out.println("Sum = " + sumOfMatrix3x3);
        printMatrix(matrix3x3);
    }

    private static int sum3x3(int[][] matrix3x3) {
        return Stream.of(matrix3x3).flatMapToInt(IntStream::of).sum();

    }

    private static int[][] find3X3Matrix(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if(sum > max) {
                    max = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return new int[][] { {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1], matrix[bestRow][bestCol + 2]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1], matrix[bestRow + 1][bestCol + 2]},
                {matrix[bestRow + 2][bestCol],matrix[bestRow + 2][bestCol + 1], matrix[bestRow + 2][bestCol + 2]}
        };
    }

    private static int[][] fillMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
           matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                   .mapToInt(Integer::parseInt)
                   .toArray();
        }
        return matrix;
    }
    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach((num) -> {
            Arrays.stream(num).forEach((number) -> System.out.print(number + " "));
            System.out.println();
        });
    }
}
