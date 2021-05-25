import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //четем първат матрица
        int[] rowsAndCols = readArray(scanner.nextLine());
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        //Чете се първата матрица
        int[][] matrix = readMatrix(rows, cols, scanner);
        //Чете се втората матрица
        int[] rowsAndColsSecond = readArray(scanner.nextLine());
        //презаписваме променливите, за да не се иницализират нови
        rows = rowsAndColsSecond[0];
        cols = rowsAndColsSecond[1];
        int[][] secondMatrix = readMatrix(rows, cols, scanner);

        if(equalMatrix(matrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
    public static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine());
        }
        return matrix;
    }
    public static boolean equalMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length) {
            //ако матриците имат различни дължини, няма шанс да са еднакви
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if(firstMatrix[row].length != secondMatrix[row].length) {
                //ако в матриците, масивите са с различни дължи няма шанс да са еднакви
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if(firstMatrix[row][col] != secondMatrix[row][col]) {
                    //ако елемент в масив е различен от елемент в другия масив няма шанс да са еднакви
                    //firstMatrix[row][col] дава точно елемент с координатите си row & col
                    return false;
                }
            }
        }
        return true;
    }
    public static int[] readArray(String line) {
        return  Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            //2-рият цикък принтира масив(реда от матрицата) - matrix[row].length дава масива за принтиране
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            //минава на нов ред и принтира следващия масив (ако има такъв)
            System.out.println();
        }
    }
}
