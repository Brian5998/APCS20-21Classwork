import java.util.*;
import java.io.*;
/**
 * SubWordFinder.java takes a txt files of words and stores them in a dictionary. It then looks at the
 * sub words inside each word to see if they are in the dictionary and returns the total subwords
 * as well as the first instance of a word with the most subwords in it.
 *
 * @version 02/02/2021
 * @author Brian Zhou
 */
public class SubWordFinder implements WordFinder{
    private ArrayList<ArrayList <String>> dictionary;
    private String alpha;
    private int currentMaxSubwords = 0;
    private String maxSubWordString = "";

    public SubWordFinder() {
        alpha = "abcdefghijklmnopqrstuvwxyz";
        dictionary = new ArrayList<>();
        for(int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<String>());
        }
    }
    /**
     * Populates the dictionary from the text file contents
     * The dictionary object should contain 26 buckets, each
     * bucket filled with an ArrayList<String>
     * The String objects in the buckets are sorted A-Z because
     * of the nature of the text file words.txt
     */
    @Override
    public void populateDictionary() {
        Scanner in = null;
        try {
            in = new Scanner(new File("subwords/words_all_os.txt"));
            String word;
            while(in.hasNext()) {
                word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();

            for(ArrayList<String> bucket : dictionary) {
                Collections.sort(bucket);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve all SubWord objects from the dictionary.
     * A SubWord is defined as a word that can be split into two
     * words that are also found in the dictionary.  The words
     * MUST be split evenly, e.g. no unused characters.
     * For example, "baseball" is a SubWord because it contains
     * "base" and "ball" (no unused characters)
     * To do this, you must look through every word in the dictionary
     * to see if it is a SubWord object
     *
     * @return An ArrayList containing the SubWord objects
     * pulled from the file words.txt
     */
    @Override
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subwords = new ArrayList<>();
        for(ArrayList<String> bucket: dictionary) {
            for(String word: bucket) {
                int numSubwords = 0;
                for(int i = 2; i < word.length()-1; i++) {
                    String front = word.substring(0,i);
                    String back = word.substring(i);
                    if(inDictionary(front) && inDictionary(back)) {
                        subwords.add(new SubWord(word,front,back));
                        numSubwords++;
                        if(numSubwords > currentMaxSubwords) {
                            currentMaxSubwords = numSubwords;
                            maxSubWordString = word;
                        }
                    }
                }
            }
        }
        return subwords;
    }

    /**
     * Look through the entire dictionary object to see if
     * word exists in dictionary
     *
     * @param word The item to be searched for in dictionary
     * @return true if word is in dictionary, false otherwise
     * NOTE: EFFICIENCY O(log N) vs O(N) IS A BIG DEAL HERE!!!
     * You MAY NOT use Collections.binarySearch() here; you must use
     * YOUR OWN DEFINITION of a binary search in order to receive
     * the credit as specified on the grading rubric.
     */

    public boolean inDictionary(String word) {
        ArrayList<String> bucket = dictionary.get(alpha.indexOf(word.charAt(0)));
        return binarySearch(bucket,word) >= 0;
    }

    private int binarySearch(ArrayList<String> bucket, String word) {
        return indexOf(bucket,0,bucket.size()-1,word);
    }
    private int indexOf(ArrayList<String> bucket, int low, int high, String word) {
        int mid = (high + low) / 2;
        if (low > high) {
            return -1;
        }
        if (bucket.get(mid).compareTo(word) == 0) {
            return mid;
        } else if (bucket.get(mid).compareTo(word) < 0) {
            return indexOf(bucket, mid + 1, high, word);
        } else {
            return indexOf(bucket, low, mid - 1, word);
        }
    }
    public static void main(String [] args) {
        SubWordFinder app = new SubWordFinder();
        app.populateDictionary();
        System.out.println(" **List of all SubWord objects in the data file **");
        ArrayList<SubWord> arr = app.getSubWords();
        for(SubWord w : arr) {
            System.out.println(w);
        }
        System.out.println("Total SubWords in file: " + arr.size());
        System.out.println("The word with the most possible subwords is " + app.maxSubWordString);
        System.out.println("Exiting Program");
    }
}
