import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner.nextLine());
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        //Чете се първата матрица
        int[][] matrix = readMatrix(rows, cols, scanner);
        List<int[]> list = new ArrayList<>();
        int number = Integer.parseInt(scanner.nextLine());
        if(findNumberInMatrix(matrix, number, list)) {
            for (int[] indexes : list) {
                System.out.println(indexes[0] + " " + indexes[1]);
            }
        } else {
            System.out.println("not found");
        }
    }
    private static boolean findNumberInMatrix(int[][] matrix, int number, List<int[]> list) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if(matrix[rows][cols] == number) {
                    list.add(new int[]{rows, cols});
                }
            }
        }
        return !list.isEmpty();
    }
    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner.nextLine());
        }
        return matrix;
    }

    private static int[] readArray(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
