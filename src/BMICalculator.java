import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * BMICalculator.java is a simple program that asks for height and weight as user input to compute their BMI
 * @version 11/10/20
 * @author Brian Zhou
 */
public class BMICalculator {

    /**
     * Main method for class BMICalculator
     * @param args command line arguments, if needed
     */
    public static void main(String[] args)  {
        Scanner keyboard = new Scanner(System.in);
        String textHeight = "";
        int weight = 0;
        int intHeight, qtPos, dblQtPos;
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {
            try {
                System.out.print("Enter your height in feet and inches (Ex. 6'1\") or \"Q\" to quit: ");
                textHeight = keyboard.nextLine();
                if(textHeight.toUpperCase().equals("Q"))
                    break;
                qtPos = textHeight.indexOf("'");
                dblQtPos = textHeight.indexOf("\"");
                if(qtPos != -1 && dblQtPos != -1) {
                    intHeight = Integer.parseInt(textHeight.substring(0,qtPos)) * 12 + Integer.parseInt(textHeight.substring(qtPos+1,dblQtPos));
                    System.out.print("Enter your weight in pounds: ");
                    weight = keyboard.nextInt();
                    System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(intHeight,weight)) + " kg/m^2");
                    keyboard.nextLine();
                }
                else    {
                    System.out.println("Invalid input");
                }

            }
            catch(Exception e)  {
                System.out.println("Error: " + e);
            }

        }

    }
    /** Convert English to metric units, perform the BMI calculation.
     * NOTE: this method must properly handle bad data
     * @param inches height
     * @param pounds weight
     * @return the user's BMI, expressed in weight/height^2
     */
    public static double computeBMI(int inches, int pounds) {
        if(inches <= 0 || pounds <= 0)
            return 0.0;
        return (pounds * 0.454)/Math.pow(inches * 0.0254,2);
    }

}
