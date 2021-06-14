package Snake;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class MySnake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[n][n];
        fillField(field, scanner, n);
        int[] position = getPositionOfSnake(field);
        int foodQuantity = 0;
        boolean isOut = false;
        String command = scanner.nextLine();
        while (true) {
            switch (command) {
                case "up":
                    //row
                    try {
                        field[position[0]][position[1]] = ".";
                        position[0] -= 1;
                        if(isInB(field, position)) {
                            moveOtherB(field, position);
                            field[position[0]][position[1]] = ".";
                        }
                        if(isFood(field, position)) {
                            foodQuantity++;
                        }
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        isOut = true;
                        break;
                    }
                    field[position[0]][position[1]] = "S";
                    break;
                case "down":
                    //row
                    field[position[0]][position[1]] = ".";
                    position[0] = position[0] + 1;
                    try {
                        if(isInB(field, position)) {
                            moveOtherB(field, position);
                            field[position[0]][position[1]] = ".";
                        }
                        if(isFood(field, position)) {
                            foodQuantity++;
                        }
                        field[position[0]][position[1]] = "S";
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        isOut = true;
                        break;
                    }
                    break;
                case "right":
                    try {
                        field[position[0]][position[1]] = ".";
                        position[1] = position[1] + 1;
                        if(isInB(field, position)) {
                            moveOtherB(field, position);
                            field[position[0]][position[1]] = ".";
                        }
                        if(isFood(field, position)) {
                            foodQuantity++;
                        }
                        field[position[0]][position[1]] = "S";
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        isOut = true;
                        break;
                    }
                    //col
                    break;
                case "left":
                    try {
                        field[position[0]][position[1]] = ".";
                        position[1] = position[1] - 1;
                        if(isInB(field, position)) {
                            moveOtherB(field, position);
                            field[position[0]][position[1]] = ".";
                        }
                        if(isFood(field, position)) {
                            foodQuantity++;
                        }
                        field[position[0]][position[1]] = "S";
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        isOut = true;
                        break;
                    }
                    //col
                    break;
            }

            if (isOut) {
                break;
            }
            if(foodQuantity < 10) {
                command = scanner.nextLine();
            } else {
                break;
            }
        }
        if(isOut) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodQuantity);
        printField(field);
    }

    private static void printField(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isFood(String[][] field, int[] position) {
        return field[position[0]][position[1]].equals("*");
    }

    private static int[] moveOtherB(String[][] field, int[] position) {
        field[position[0]][position[1]] = ".";
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("B")) {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }
        return position;
    }

    private static boolean isInB(String[][] field, int[] position) {
        return field[position[0]][position[1]].equals("B");
    }

    private static int[] getPositionOfSnake(String[][] field) {
        int[] position = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if(field[row][col].equals("S")) {
                    position[0] = row;
                    position[1] = col;
                    break;
                }
            }
        }
        return position;
    }

    private static void fillField(String[][] field, Scanner scanner, int n) {
        for (int i = 0; i < n; i++) {
            field[i] = scanner.nextLine().split("");
        }
    }
}
