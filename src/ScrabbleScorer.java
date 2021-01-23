
import java.io.*;
import java.text.Normalizer;
import java.util.*;

/**
 * ScrabbleScorer.java is a program that takes a word as user input in Spanish, French, or English.
 * It then compares the user input to the respective language dictionary and scores the word if it
 * is valid.
 * @version 1/22/2021
 * @author Brian Zhou
 */
public class ScrabbleScorer {
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int[] points = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    ArrayList<String> dictionary;
    File file;
    /**
     * Main method for ScrabbleScorer.java
     * @param args command line args if needed
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        while (true){

            System.out.print("Enter a word to score or 0 to quit: ");
            String word = keyboard.nextLine();
            if(word.equals("0")) {
                System.out.println("Exiting the program thanks for playing");
                break;
            } else {
                if (app.isValidWord(word.toUpperCase())) {
                    System.out.println(word + " = " + app.getWordScore(word.toUpperCase()) + " points");
                } else {
                    System.out.println(word + " is not a valid word in the dictionary");
                }
            }
        }
    }

    /**
     * Constructor for ScrabbleScorer.java
     * Asks user which language they want to score in and builds the dictionary
     */
    public ScrabbleScorer() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Choose a language to play in! \n (E for English, S for Spanish, or F for French) " +
                "[Default is English]: ");
        String language = keyboard.nextLine();
        if(language.toUpperCase().equals("S")) {
            file = new File("S_SCRABBLE_WORDS.txt");
            System.out.println("You chose Spanish!");
        } else if(language.toUpperCase().equals("F")) {
            file = new File("F_SCRABBLE_WORDS.txt");
            System.out.println("You chose French!");
        } else {
            file = new File("SCRABBLE_WORDS.txt");
            System.out.println("You chose English!");
        }
        dictionary = new ArrayList<>();
        buildDictionary();
    }

    /**
     * builds the dictionary by scanning a file and storing it in an ArrayList
     */
    public void buildDictionary() {
        Scanner in = null;
        try {
            in = new Scanner(file);
            while(in.hasNext()) {
                String word = Normalizer.normalize(in.nextLine(), Normalizer.Form.NFD);
                word = word.replaceAll("\\p{M}", "");
                dictionary.add(word.toUpperCase());
            }
            in.close();
            Collections.sort(dictionary);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * checks if the word is in the ArrayList dictionary
     * @param word a String user entered word
     * @return true if word is valid
     */
    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     * Scores the word based on the letters in the word
     * @param word a String user entered word
     * @return an int score
     */
    public int getWordScore(String word) {
        int score = 0;
        for(int i =0; i < word.length(); i++) {
            score += points[alphabet.indexOf(word.charAt(i))];
        }
        return score;
    }

}
