import java.util.Scanner;

/**
 * This simple program asks for user input to print a line of the poem
 * @author Brian Zhou
 * @version 11/2/20
 */
public class OneTwo {

    /**
     * This is the main method that uses a while loop
     * @param args
     */
    public static void main(String args []) {
        Scanner keyboard = new Scanner(System.in);
        int num;
        while(true){
            System.out.println("Enter a number 1-10 ( or 0 to quit): ");
            try{
                num = keyboard.nextInt();
                if(num == 0){
                    break;
                }
                printLine(num);
            }
            catch(Exception e){
                System.out.println("Error detail: " + e.toString());
                keyboard.nextLine();
            }
        }
        System.out.println("Bye");
    }

    /**
     * This uses a switch statement to print the lines of the poem.
     * @param line
     */
    public static void printLine(int line)  {
        switch(line)    {
            case 1: case 2:
                System.out.println("Buckle my shoe");
                break;
            case 3: case 4:
                System.out.println("Close the door");
                break;
            case 5: case 6:
                System.out.println("Pick up sticks");
                break;
            case 7: case 8:
                System.out.println("Don\'t be late");
                break;
            case 9: case 10:
                System.out.println("Do it again");
                break;
            default:
                System.out.println("You potato enter something else");
        }

    }
}
