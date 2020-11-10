import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Number 25 for chapter 7 homework
 * @version 11/04/2020
 * @author Brian Zhou
 */
public class Chapter7 {
    /**
     *
     * @param args
     */
    public static void main(String args []) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter total cents: ");
            int cents = keyboard.nextInt();
            printPermutations(cents);
            printCheckerboard(3);
        }
        catch(Exception e) {
            System.out.println("Error details: " + e.toString());
        }
    }

    /**
     *
     * @param cents an int
     */
    public static void printPermutations(int cents) {
        int perms = 0;
        for(int q = 0; q*25 <= cents; q++){
            for(int d = 0; q*25 + d*10 <= cents; d ++){
                for(int n = 0; q*25+d*10+n*5 <= cents; n++){
                    int p = cents - (q*25+d*10+n*5);
                    System.out.println(cents + " cents = " + q + " quarters " + d + " dimes " + n + " nickels " + p + " pennies ");
                    perms++;
                }
            }
        }
        System.out.println(cents + " cents has " + perms + " permutations");
    }

    public static void printCheckerboard(int n) {
        for (int column = 0; column < n; column++) {
            for (int row = 0; row < n; row++) {
                System.out.print(((row+column)%2 == 0) ? '#' : '0');
            }
            System.out.println();
        }
    }
}
