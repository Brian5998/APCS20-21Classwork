import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * ISBNValidator validates data files of ISBN numbers using a few specific criteria.
 * @version 01/15/2021
 * @author Brian Zhou
 */
public class ISBNValidator {

    private String[] validNums; // initialize to hold 1000 items
    private String[] invalidNums; // initialize to hold 1000 items

    /**
     * Main entry point for class ISBNValidator
     * @param args command line arguments, if needed
     */
    public static void main(String[] args){
        ISBNValidator app = new ISBNValidator ();
        System.out.println("* ISBN Validator Program *");
        System.out.println("...Importing data...");
        app.importData(); // imports data from the text file
        app.runProgram(); // runs using a while loop; see examples
        System.out.println("* End of Program *");
    }

    /**
     * simple constructor; initializes arrays
     */

    public ISBNValidator() {
        validNums = new String[1500];
        invalidNums = new String[500];
    }
    /** imports .dat file, calls isValidISBN method and stores Strings into
     * corresponding arrays
     */
    public void importData() {
        Scanner in = null;

        try {

            int valid = 0;
            int invalid = 0;
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File("isbn_files/"));
            int result = jFileChooser.showOpenDialog(new JFrame());

            File file = null;
                if(result == JFileChooser.APPROVE_OPTION)   {
                    file = jFileChooser.getSelectedFile();
                }
            in = new Scanner(file);
            while(in.hasNext()) {
                String isbnNum = in.nextLine();
                if(isValidISBN(isbnNum)) {
                    validNums[valid++] = isbnNum;
                } else {
                    invalidNums[invalid++] = isbnNum;
                }
            }
            //System.out.println("Valid nums: " + valid);
            //System.out.println("Invalid nums: " + invalid);
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * determines validity of supplied ISBN number; called inside importData
     * @param isbn a String representing a ISBN number
     * @return true if ISBN is valid, false if not
     */

    public boolean isValidISBN(String isbn) {
        //auto-boxing means promote int to Integer
        //auto-unboxing means promote Integer to int
        isbn = isbn.replace("-","");
        int prefix = Integer.parseInt(isbn.substring(0,3));
        if(prefix != 978 && prefix !=979) {
            return false;
        } else {
            for(int i = 0; i < isbn.length(); i ++){
                if(Character.isDigit(isbn.charAt(i)) == false)
                    return false;
            }
            int digitSum = 0;
            for(int i = 0; i < isbn.length(); i++) {
                if(i%2 == 0) {
                    digitSum += Integer.parseInt(""+isbn.charAt(i));
                } else {
                    digitSum += 3 * Integer.parseInt(""+isbn.charAt(i));
                }
            }
            return digitSum % 10 == 0;
        }
    }

    /**
     *  output the user-picked ISBN list or quit the application
     */
    public void runProgram() {
        while(true){
        System.out.println("All ISBN data has been imported and validated. Would you like to:\n" +
                "1) View all valid ISBN numbers\n" +
                "2) View all invalid ISBN numbers\n" +
                "3) Quit\n" +
                "Your selection: ");
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();
        switch(choice) {
            case 1:
                for(String num : validNums) {
                    if(num != null) {
                        System.out.println(num);
                    }
                }

                break;
            case 2:
                for(String num : invalidNums) {
                    if(num != null) {
                        System.out.println(num);
                    }
                }
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid menu selection.");
        }
        }
    }
}
