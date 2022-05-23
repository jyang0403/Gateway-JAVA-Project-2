import java.util.Scanner;
import java.util.Random;

/**
 * Project 2: Gateway Computing: JAVA
 * -------------------------------------------------------------------
 * The program tells the user to input a line of text, which then 
 * opens a menu that allows for the text to be replaced, selectively 
 * altered, randomly transformed, or analyzed by character type, 
 * depending on the user's inputs. There is also an option to exit the 
 * program immediately. Enjoy!
 * 
 * @author: Jiashu Yang
 * @JHED: jyang166
 * @date: 02/13/2022
 *
 */
public class Proj2 {

   /**
    * Defining the only Random variable users may use.
    */
   static Random gen = new Random(10);
   
   /**
    * Prints the menu, presenting all possible actions for
    * the user to take. 
    */
   public static void printMenu() {
      System.out.println();
      System.out.println("u/U: Update");
      System.out.println("f/F: Find & Replace");
      System.out.println("t/T: Transform");
      System.out.println("s/S: Statistics");
      System.out.println("e/E: Exit");
      System.out.println("-------------");
      System.out.println("Enter your choice: ");
   }

   /**
    * This method determines if a character is special character or not.
    * A character is considered special if it is not a letter, not
    * a digit and not a punctuation.
    * @param c a character input taken from string text
    * @return true if the character c is special character, false otherwise
    */
   public static boolean isSpecial(char c) {
      if (!Character.isLetter(c) 
         && !Character.isDigit(c) 
         && !Character.isWhitespace(c) 
         && !(isPunctuation(c))) {
         return true;
      }
      return false;
   }

   /**
    * This method determines if a character is special character or not.
    * Punctuation characters are ! ? . , ' " : ; - _
    * @param c a character in string text
    * @return true if the character is punctuation, false otherwise
    */
   public static boolean isPunctuation(char c) {
      if (c == '!' || c == '?' || c == '.'
         || c == '\'' || c == '\"' || c == ':'
         || c == ';' || c == '-' || c == '_') {
         return true;
      }
      return false;
   }

   /**
    * This method counts a category of characters in a given piece of text,
    * those being letters, digits, punctuation, and special characters.
    * @param text the input text
    * @param category specifies character type to count in the input text
    * @return the count for the specified character category
    */
   public static int count(String text, char category) {
      int lettersCount = 0;
      int specialsCount = 0;
      int punctuationsCount = 0;
      int digitsCount = 0;
      
      if (category == 'l') {
         for (int i = 0; i < text.length(); i += 1) {
            if (Character.isLetter(text.charAt(i))) {
               lettersCount += 1;   
            }
         }  
         return lettersCount;         
      }
      else if (category == 's') {
         for (int i = 0; i < text.length(); i += 1) {
            if (isSpecial(text.charAt(i))) {
               specialsCount += 1;
            }
         }
         return specialsCount;          
      }
      
      else if (category == 'p') {
         for (int i = 0; i < text.length(); i += 1) {
            if (isPunctuation(text.charAt(i))) {
               punctuationsCount += 1;
            }
         }  
         return punctuationsCount;        
      }   
      
      else if (category == 'd') {
         for (int i = 0; i < text.length(); i += 1) {
            if (Character.isDigit(text.charAt(i))) {
               digitsCount += 1;
            }
         }
         return digitsCount;
      }
      return 0;
   }

   /**
    * This method prints the basic statistics for different character 
    * categories in the string text.
    * @param length length of text
    * @param letterCount the total number of letters in text
    * @param digitsCount the total number of digits in text
    * @param specialsCount the total number of special char in text
    * @param punctuationsCount the total number of punctuation char in text
    */
   public static void printStats(int length, int letterCount, int digitsCount,
                                 int specialsCount, int punctuationsCount) {
      double lengthTemp = (double) length;
     
      double percentLetters = letterCount / lengthTemp * 100;
      double percentDigits = digitsCount / lengthTemp * 100;
      double percentSpecials = specialsCount / lengthTemp * 100;
      double percentPunctuations = punctuationsCount / lengthTemp * 100;
     
      System.out.println("There are a total of " + length + 
                           " characters in the text.");
      System.out.print("Letter characters account for ");
      System.out.printf("%.2f percent in the text.\n", percentLetters);
      System.out.print("Digit characters account for ");
      System.out.printf("%.2f percent in the text.\n", percentDigits);
      System.out.print("Special characters account for ");
      System.out.printf("%.2f percent in the text.\n", percentSpecials);
      System.out.print("Punctuation characters account for ");
      System.out.printf("%.2f percent in the text.\n", percentPunctuations);
   }
   
   /**
    * This method breaks the input text into two halves, reverses each half,
    * and finally put them back together.
    * Examples: reverseHalves("hello") --> eholl, reverseHalves("keep") --> ekpe
    * @param text the input text
    * @return the "reversed halves" string
    */
   public static String reverseHalves(String text) {
      String wordHalf1 = "";
      String wordHalf2 = "";
      if (text.length() % 2 == 1) {
         for (int i = 1; i <= text.length() / 2; i += 1) {
            wordHalf1 += text.charAt(text.length() / 2 - i);
         }
         for (int i = 1; i - 1 <= text.length() / 2; i += 1) {
            wordHalf2 += text.charAt(text.length() - i);
         }
      }
      else {
         for (int i = 1; i <= text.length() / 2; i += 1) {
            wordHalf1 += text.charAt(text.length() / 2 - i);
            wordHalf2 += text.charAt(text.length() - i);
         }
      }
      return (wordHalf1 + wordHalf2);
   }   

   /**
    * This method reverse halves of the input text by putting the first
    * and last character next to each other, then the second and
    * second last, third and third last, so on so forth...
    * Examples: scramble("hello") --> hoell, scramble("world") --> wdolr
    * @param text the input text
    * @return the scrambled string
    */
   public static String scramble(String text) {
      
      String newScramble = "";
      if (text.length() % 2 == 1) {
         for (int i = 0; i <= text.length() / 2; i += 1) {
            newScramble += text.charAt(i);
            if (i == text.length() / 2) {
               break;
            }
            newScramble += text.charAt(text.length() - i - 1);
         }
      }
      else {
         for (int i = 0; i < text.length() / 2; i += 1) {
            newScramble += text.charAt(i);
            newScramble += text.charAt(text.length() - 1 - i);
         }
      }
      return newScramble;
   }

   /**
    * This method weaves the input text by putting
    * 1st and 3rd, 2nd and 4th, 5th and 7th etc. characters
    * of the input text next to each other.
    * Examples: weave("hello") --> hlelo, weave("keep") --> keep
    * @param text the input text
    * @return input text woven into a new string
    */
   public static String weave(String text) {
      String newWeave = "";
      for (int i = 0; i <= text.length(); i += 4) {
         if (i < text.length()) {
            newWeave += text.charAt(i);
         }
         if (i + 2 < text.length()) {
            newWeave += text.charAt(i + 2);
         }
         if (i + 1 < text.length()) {
            newWeave += text.charAt(i + 1);
         }
         if (i + 3 < text.length()) {
            newWeave += text.charAt(i + 3);
         }
      }
      return newWeave;
   }


   /**
    * The main method. It receives user inputs for menu options and
    * executes them, and gives an error whenever an invalid input is 
    * given.
    * @param args commandline args
    */
   public static void main(String[] args) {
      
      Scanner kb = new Scanner(System.in);

      System.out.println("Please enter the text: ");
      String text = kb.nextLine();
      
      int length = text.length();
      printMenu();
      boolean programOn = true;
      while (programOn) {
         String menuChoice = kb.next();
         
         // Calculates the statistics of each character to be printed
         if ("S".equals(menuChoice) || "s".equals(menuChoice)) {
            char l = 'l'; 
            char d = 'd'; 
            char s = 's'; 
            char p = 'p';
            int letterCount = count(text, l);
            int digitsCount = count(text, d);
            int specialsCount = count(text, s);
            int punctuationsCount = count(text, p);
            printStats(length, letterCount, digitsCount,
                       specialsCount, punctuationsCount);
            printMenu();
            continue;
         }
         
         // Replaces text with another user input.
         else if ("U".equals(menuChoice) || "u".equals(menuChoice)) {
            System.out.println("Please enter the text:");
            kb.nextLine();
            text = kb.nextLine();
            length = text.length();
            printMenu();
            continue;
         }
         
         // Replaces a sequence in text with another user input.
         else if ("F".equals(menuChoice) || "f".equals(menuChoice)) {
            System.out.println("Please enter the character sequence to find:");
            String findChoice = kb.next();
            System.out.println("Please enter the replacement sequence:");
            String replaceChoice = kb.next();
            text = text.replace(findChoice, replaceChoice);
            System.out.println("The new text is: " + text);
            length = text.length();
            printMenu();
            continue;
            

         }
         // Randomly transforms text using one of three methods.
         else if ("T".equals(menuChoice) || "t".equals(menuChoice)) {
            int randomTran = gen.nextInt(3);
            if (randomTran == 0) {
               System.out.println("The text is reverse-halved as: " 
                                 + reverseHalves(text));
               text = reverseHalves(text);
            }
            else if (randomTran == 1) {
               System.out.println("The text is scrambled as: " 
                                    + scramble(text));
               text = scramble(text);
            }
            else if (randomTran == 2) {
               System.out.println("The text is weaved as: " 
                                    + weave(text));
               text = weave(text);
            }
            printMenu();
            continue;
         }
         
         else if ("E".equals(menuChoice) || "e".equals(menuChoice)) {
            programOn = false;
         }
         
         else {
            System.out.println("Invalid option! Try again!");
            printMenu();
            continue;
         }
         
      }
      
   }
   
}
