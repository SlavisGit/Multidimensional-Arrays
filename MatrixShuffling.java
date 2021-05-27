import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = readMatrix(rows, cols, scanner);
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split(" ");
            if(validateCoordinates(command, tokens, matrix, rows, cols)) {
                String action = tokens[0];
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);
                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];
                matrix[row2][col2] = element1;
                matrix[row1][col1] = element2;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static boolean validateCoordinates( String command,  String[] tokens, String[][] matrix, int rows, int cols) {
        if(tokens.length != 5) {
            return  false;
        }
        String action = tokens[0];
        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);
        if(!action.equals("swap")) {
            return false;
        }
        if(row1 < 0 || row1 >= rows || row2 < 0 || row2 > rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }
        return true;
    }

    private static void printMatrix(String[][] matrix) {
        Arrays.stream(matrix).forEach((arr) -> {
            Arrays.stream(arr).forEach((number) -> System.out.print(number + " "));
            System.out.println();
        });
    }

    private static String[][] readMatrix(int rows, int cols, Scanner scanner) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

}
