import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(rows, scanner, " ");
        int[] coordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wrong = matrix[coordinates[0]][coordinates[1]];
        List<int[]> updated = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == wrong) {
                    //Изплозваме лист защото не трябва да променяме нищо докато итерираме
                    //В листа се запазват променените стойности
                    updated.add(new int[]{row, col, getSumElements(matrix, row, col, wrong)});
                }
            }
        }
        for (int[] updatedValue : updated) {
            //[updatedValue[0] -> ред
            //[updatedValue[1] -> колона
            //[updatedValue[2] -> променена стойност
            matrix[updatedValue[0]][updatedValue[1]] = updatedValue[2];
        }
        printMatrix(matrix);
    }

    private static int getSumElements(int[][] matrix, int row, int col, int wrong) {
        int sum = 0;
        if(col + 1 < matrix[row].length && matrix[row][col + 1] != wrong) {
            //проверка при отиване надясно дали не излизаме от масива и дали е различен от сгрешената стойност
            sum += matrix[row][col + 1];
        }
        if(col - 1 >= 0 && matrix[row][col - 1] != wrong) {
            //проверка при отиване наляво с колона дали не излизаме от масива и дали е различен от сгрешената стойност
            sum += matrix[row][col - 1];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrong) {
            //проверка при отиване надолу с ред дали не излизаме от масива и дали е различен от сгрешената стойност
            //При проверка за ред ползваме само matrix.length
            sum += matrix[row + 1][col];
        }
        if (row - 1 >= 0 && matrix[row - 1][col] != wrong) {
            //проверка при отиване нагоре с ред дали не излизаме от масива и дали е различен от сгрешената стойност
            sum += matrix[row - 1][col];
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int rows, Scanner scanner, String s) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(s)).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
