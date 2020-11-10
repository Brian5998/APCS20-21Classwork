import java.util.Scanner;
public class MyFirstClass {

        public static void main(String [] args) {
            System.out.println("\"Dark theme is for the cool kids.\"");
            String name = "Brian";
            sayName(name);
            Scanner keyboard = new Scanner(System.in);
            int potato = keyboard.nextInt();
            System.out.println("File located at C:\\>\"My Documents\\APCS\\Test Review\\review1.docx\\\"");
        }

        public static void sayName(String name){
            System.out.println("Said by " + name);
        }
    }
