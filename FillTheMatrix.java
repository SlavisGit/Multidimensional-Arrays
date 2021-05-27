import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[size][size];
        if(type.equals("A")) {
            fillMatrixA(matrix, size);
            printMatrix(matrix);
        } else if (type.equals("B")) {
            fillMatrixB(matrix, size);
            printMatrix(matrix);
        }
    }

    private static void fillMatrixB(int[][] matrix, int size) {
        int number = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = number++;
                }
            } else {
                for (int row = size - 1; row >= 0 ; row--) {
                    matrix[row][col] = number++;
                }
            }
        }
    }

    private static void fillMatrixA(int[][] matrix, int size) {
        int number = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = number++;
            }
        }
    }
    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
