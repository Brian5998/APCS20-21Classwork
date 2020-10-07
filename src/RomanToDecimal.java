import java.util.Scanner;
/**
 * RomanToDecimal.java is a class that takes roman numerals through command line arguments and
 * converts them into decimals if they are valid.
 * @version 10/6/20
 * @author Brian Zhou
 */
public class RomanToDecimal {
    // no private data, only helper methods

    /**
     * main method for Class RomantoDecimal
     * @param args
     */
    public static void main(String [] args) {

        for(String roman : args){
            roman = roman.toUpperCase();
            int decimal = romanToDecimal(roman);
            System.out.print("Input: " + roman +" ==> output: ");
            if(decimal == -1){
                System.out.println("invalid");
            }
            else if(roman.equals(decimalToRoman(decimal))){
                System.out.println(decimal);
            }
            else{
                System.out.println("illogical number");
            }
        }
    }

    /**
     * Converts a string to a valid decimal (base-10 value)
     * @param roman Must be an uppercase string
     * @return
     */
    public static int romanToDecimal(String roman)  {
        int sum = 0;
        for(int i = 0; i < roman.length(); i++) {
            String letter = roman.substring(i, i+1);
            switch (letter) {
                case "M":
                    sum += 1000;
                    break;
                case "D":
                    sum += 500;
                    break;
                case "C":
                    sum += 100;
                    break;
                case "L":
                    sum += 50;
                    break;
                case "X":
                    sum += 10;
                    break;
                case "V":
                    sum += 5;
                    break;
                case "I":
                    sum += 1;
                    break;
                default:
                    return -1;
            }
        }

        for(int i =0; i< roman.length()-1; i++){
            String invariant = roman.substring(i, i + 2);
            switch(invariant)   {
                case "CM": case "CD":
                    sum -= 200;
                    break;
                case "XC": case "XL":
                    sum -= 20;
                    break;
                case "IX": case "IV":
                    sum -= 2;
                    break;
            }
        }
        return sum;
    }

    private static String decimalToRoman(int decimal) {
        String roman = "";
        while (decimal >= 1000) {
            roman += "M";
            decimal -= 1000;
        }
        while (decimal >= 900) {
            roman += "CM";
            decimal -= 900;
        }
        while (decimal >= 500) {
            roman += "D";
            decimal -= 500;
        }
        while (decimal >= 400) {
            roman += "CD";
            decimal -= 400;
        }
        while (decimal >= 100) {
            roman += "C";
            decimal -= 100;
        }
        while (decimal >= 90) {
            roman += "XC";
            decimal -= 90;
        }
        while (decimal >= 50) {
            roman += "L";
            decimal -= 50;
        }
        while (decimal >= 40) {
            roman += "XL";
            decimal -= 40;
        }
        while (decimal >= 10) {
            roman += "X";
            decimal -= 10;
        }
        while (decimal >= 9) {
            roman += "IX";
            decimal -= 9;
        }
        while (decimal >= 5) {
            roman += "V";
            decimal -= 5;
        }
        while (decimal >= 4) {
            roman += "IV";
            decimal -= 4;
        }
        while (decimal >= 1) {
            roman += "I";
            decimal -= 1;
        }

        return roman;
    }
}