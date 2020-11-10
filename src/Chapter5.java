public class Chapter5 {
    private final int year = 465, leapYear = year +1;
    public final double pi = 3.14159;
    char mi; int age;
    char tab = '\t', newline = '\n',a = 'a';
    int name;
    public static void main(String [] args) {
        // static -- utility method, it just does something?
        // non-static methods typically provide us with info about an object
        System.out.println(switchDigits(4));
        System.out.println(newSwitchDigits(10));
        int a = Math.max(1,2);
        int b,c,d;
        b = 1;
        c = 2;
        d = 3;
        if(d != 0 && b != 0 && c != 0 && a * c == b*b){
            System.out.println("this is geometric sequence");
        }
        System.out.println(totalWages());

    }

    public static double totalWages(){
        double wages;
        double hours = 45;
        double rate = 12.5;
        if(hours > 40) {
            wages = (hours-40) * rate * 1.5 + 40 * rate;
            return wages;
        }
        else{
            wages = hours * rate;
        }
        return wages;
    }
    public static int switchDigits(int num){
        int onesDigit = num % 10;
        int tensDigit = (num%100)/10;
        int newnum = num - tensDigit*10 - onesDigit + onesDigit*10 + tensDigit;
        return newnum;
    }

    public static String newSwitchDigits(int num){
        String newnum = Integer.toString(num);
        if(newnum.length() == 1){

        }
        newnum = newnum.substring(0,newnum.length()-2) +newnum.charAt(newnum.length()-1) + newnum.charAt(newnum.length()-2);
        return newnum;
    }
}
