/**
 * HolyGrail.java is the first lab I will write.
 * It is a simple UI program that talks to the user.
 * 09/15/2020
 * @author bzhou
 */

import java.util.Scanner;

public class HolyGrail {

    public static void main(String [] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
        System.out.print("Question 1: What is your name? ");
        String name = keyboard.nextLine();
        System.out.print("Question 2: What is your quest? ");
        String quest = keyboard.nextLine();
        System.out.print("Question 3: What is your favorite color? ");
        String color = keyboard.nextLine();
        System.out.println("King Arthur says, \"You have to know these things when you're a king, you know.\"");
        System.out.println("Your name is: " + name);
        System.out.println("Your quest is: " + quest);
        System.out.println("Your favorite color is: " + color);
        System.out.println("* end of program *");
    }

}

/*
        System.out.println("Hello " + name + ", nice to meet you!");
        System.out.print("How old are you " + name + ": ");
        int age = keyboard.nextInt();
        System.out.print("How many pets do you own " + name + ": ");
        int numPets = keyboard.nextInt();
        System.out.println("You are " +age+ " years old.");
        System.out.println("You have " +numPets+ " pets.");
 */