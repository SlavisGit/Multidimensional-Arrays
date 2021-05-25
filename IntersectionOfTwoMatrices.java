import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = readCharArray(rows, cols, scanner);
        char[][] secondMatrix = readCharArray(rows, cols, scanner);

        char[][] newMatrix = newMatrix(firstMatrix, secondMatrix, rows, cols);
        printMatrix(newMatrix);
    }
    private static char[][] newMatrix(char[][] firstMatrix, char[][] secondMatrix, int rows, int cols) {
        char[][] newMatrix = new char[rows][cols];
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                newMatrix[row][col] = firstMatrix[row][col] == secondMatrix[row][col]
                        ? firstMatrix[row][col]
                        : '*';
            }
        }
        return newMatrix;
    }
    private static char[][] readCharArray(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
        return matrix;
    }
    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
