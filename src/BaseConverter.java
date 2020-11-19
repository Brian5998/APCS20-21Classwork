import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
/**
 * BaseConverter.java converts numbers of base 2 - 16 to other bases in that range. It has an algorithm that
 * converts the num to a base 10 int and then converts that int to a new base.
 * It reads in from a .dat file of choice using JFileChooser as an extra
 * and writes the values to converted.dat
 * @version 11/19/20
 * @author Brian Zhou
 */
public class BaseConverter {

    private String hex = "0123456789ABCDEF";
    /**
     * Main method for class BaseConverter.
     * @param args command-line args if needed
     */

    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }


    /**
     * Constructor for class.
     */

    public BaseConverter() {

    }

    /**
     * Convert a String num in fromBase to base-10 int.
     * @param num a String representing the original value
     * @param fromBase a String representing the original base
     * @return a base-10 integer representation of num in fromBase
     */
    public int strToInt(String num, String fromBase) {
        int currentnum = 0, currentpow = 0;
        int index;
        for (int i = num.length() - 1; i >= 0; i--) {
            index = hex.indexOf(num.charAt(i));
            currentnum += (int) Math.pow(Integer.parseInt(fromBase), currentpow) * index;
            currentpow++;
        }
        return currentnum;
    }

    /**
     * Convert a base-10 int to a String number of base toBase.
     * @param num a base-10 int
     * @param toBase an int that tells which base to convert to
     * @return a String of the num of toBase
     */
    public String intToStr(int num, int toBase) {
        String currentnum = "";
        while (num > 0) {
            currentnum = hex.charAt(num % toBase) + currentnum;
            num /= toBase;
        }
        return currentnum.equals("") ? "0" : currentnum;
    }

    /**
     * Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite()    {
        Scanner scanner = null;
        PrintWriter pw = null;
        String [] numstuff;
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("datafiles/"));
        int result = jFileChooser.showOpenDialog(new JFrame());
        File file = null;
        try{
            if(result == JFileChooser.APPROVE_OPTION)   {
                file = jFileChooser.getSelectedFile();
            }
            scanner = new Scanner(file);
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while(scanner.hasNext()) {
                numstuff = scanner.nextLine().split("\t");
                if(Integer.parseInt(numstuff[1]) < 2 || Integer.parseInt(numstuff[1]) > 16) {
                    System.out.println("Invalid input base " + numstuff[1]);
                }
                else if(Integer.parseInt(numstuff[2]) < 2 || Integer.parseInt(numstuff[2]) > 16) {
                    System.out.println("Invalid output base " + numstuff[2]);
                }
                else {
                    System.out.println(numstuff[0] + " base " + numstuff[1] + " = " +
                            intToStr(strToInt(numstuff[0], numstuff[1]), Integer.parseInt(numstuff[2]))
                            + " base " + numstuff[2]);
                    pw.println(numstuff[0] + "\t" + numstuff[1] + "\t"
                            + intToStr(strToInt(numstuff[0], numstuff[1]), Integer.parseInt(numstuff[2]))
                            + "\t" + numstuff[2]);
                }
            }
            scanner.close();
            pw.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}

