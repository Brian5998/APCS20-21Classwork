import java.util.Scanner;
/**
 * SimpleIOMath.java is a simple class that takes asks the user a few questions,
 * stores them in variables, and then defines some helper methods.
 * @version 09/24/2020
 * @author brian zhou
 */

public class SimpleIOMath {

    private String name;
    private String favWord;
    private int age;
    private int favNum;

    /**
     * main method for class SimpleIOMath
     * @param args Command line arguments, if needed.
     */
    public static void main(String [] args) {
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
    }

    /**
     * Asks the user some questions to get info.
     */
    public void promptUser(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        System.out.print("Question 1: What is your name? ");
        name = keyboard.nextLine();
        System.out.print("Question 2: How old are you? ");
        age = keyboard.nextInt();
        System.out.print("Question 3: What is your favorite number? ");
        favNum = keyboard.nextInt();
        System.out.print("Question 4: What is your favorite word? ");
        keyboard.nextLine();
        favWord = keyboard.nextLine();
    }

    /**
     * Prints out user's given info.
     */
    public void printInfo(){
        System.out.println("I'm gonna teach you how to sing it out");
        System.out.println("Come on, come on, come on");
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        int nextAge = age +1;
        System.out.println("At your next birthday, you will turn " + nextAge);
        System.out.println("The first prime factor of " + age + " is: "+smallestPrimeFactor(age));
        System.out.println("Your favorite number is: " + favNum);
        int favNumSquared = (int) Math.pow(favNum,2);
        System.out.println("Your favorite number squared is: " + favNumSquared);
        System.out.println("A password you could make with your favorite word is: " + getRandomPassword());
        System.out.println("* end of program *");
    }

    private int smallestPrimeFactor(int age){
        int[] primes = {2 , 3 , 5, 7, 11};
        for(int factor : primes){
            if(age % factor == 0)
                return factor;
        }
        return age;
    }

    private String getRandomPassword(){
        String[] colors = {"Red","Blue","Purple","White","Green"};
        String[] symbols = {"*",".","#","&","^"};
        String[] animals = {"panda","penguin","chicken","turtle","donkey"};
        String[] adjectives = {"fluffy","slimy","flaky","smooth","rough","soft"};
        int randomColor = (int) (Math.random() * (colors.length));
        int randomSymbol = (int) (Math.random() * (symbols.length));
        int randomAnimal = (int) (Math.random() * (animals.length));
        int randomAdjective = (int) (Math.random() * (adjectives.length));
        int randomNumber = (int) (Math.random() * 100);

        return(colors[randomColor] + adjectives[randomAdjective] + animals[randomAnimal] + favWord + symbols[randomSymbol] + randomNumber);
    }


}

