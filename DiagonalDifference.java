import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = fillMatrix(size, scanner);
        int sumPrimeDiagonal = primeDiagonal(matrix, size);
        int sumSecondDiagonal = secondDiagonal(matrix, size);
        System.out.println(Math.abs(sumPrimeDiagonal - sumSecondDiagonal));
    }

    private static int[][] fillMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static int secondDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(col == size - row - 1) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int primeDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }
}
