import java.util.Scanner;

public class HeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerRow = 7;
        int playerCol = 7;
        double heiganHp = 3000000;
        double playerHp = 18500;
        String spell = "";
        double damageDone = Double.parseDouble(scanner.nextLine());
        while ( true) {
            if (playerHp >= 0) {
                heiganHp -= damageDone;
            }
            if (spell.equals("Cloud")) {
                playerHp -= 3500;
            }
            if (heiganHp <= 0 || playerHp <= 0) {
                break;
            }
            String[] input = scanner.nextLine().split("\\s+");
            String attackSpell = input[0];
            //координати къде удря боса
            int hitRow = Integer.parseInt(input[1]);//
            int hitCol = Integer.parseInt(input[2]);
            if(isInHitArea(hitRow, hitCol, playerRow, playerCol)) {

                if(!isInHitArea(hitRow, hitCol, playerRow - 1, hitCol) && inTheDungeon(playerRow - 1)) {
                    //нагоре
                    spell = "";
                    playerRow--;
                } else if (!isInHitArea(hitRow, hitCol, playerRow, playerCol + 1) && inTheDungeon(playerCol + 1)) {
                    //надясно
                    spell = "";
                    playerCol++;
                } else if (!isInHitArea(hitRow, hitCol, playerRow + 1, playerCol) && inTheDungeon(playerRow + 1)) {
                    //надолу
                    spell = "";
                    playerRow++;
                } else if (!isInHitArea(hitRow, hitCol, playerRow, playerCol - 1) && inTheDungeon(playerCol - 1)) {
                    //наляво
                    spell = "";
                    playerCol--;
                } else {
                    //останалите 2 случая не е можел да се измести и понася съответния damage
                    if(attackSpell.equals("Eruption")) {
                        spell = attackSpell;
                        playerHp -= 6000;
                    } else if (attackSpell.equals("Cloud")) {
                        spell = attackSpell;
                        playerHp -= 3500;
                    }
                }
            }
        }
        if(heiganHp <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHp);
        }
        if(playerHp <= 0 && spell.equals("Cloud")) {
            System.out.printf("Player: Killed by Plague %s%n", spell);
        } else if (playerHp <= 0){
            System.out.printf("Player: Killed by %s%n", spell);
        } else {
            System.out.printf("Player: %.0f%n", playerHp);
        }
        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }

    private static boolean isInHitArea(int hitRow, int hitCol, int playerRow, int playerCol) {
        return hitCol - 1 <= playerCol && playerCol <= hitCol + 1 &&
                hitRow - 1 <= playerRow && playerRow <= hitRow + 1;
    }

    private static boolean inTheDungeon(int rowCol) {
        return rowCol >= 0 && rowCol <= 15;
    }
}