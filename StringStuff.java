import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Program that counts the max run of consecutive letters.
 *
 * @author Jessah
 * @version 1.0 @2024-04-19
 */
public final class StringStuff {

  /** Private constructor to prevent instantiation of this utility class. */
  private StringStuff() {
    // whitespace
  }

  /**
   * MaxRun Function.
   *
   * @param input Reads file to see consecutive max run.
   * @return Returns the consecutive max run to main program.
   */
  public static Integer maxRun(String input) {
    // Initialize counters.

    // MaxCounter is used to store the highest counter.
    int maxCounter = 0;
    // Standard counter used for majority the function's use.
    int counter = 0;
    // Index is set to 1, so it can compare the next character.
    int index = 1;

    // While there are still characters to check.
    while (index < input.length()) {
      /* Compares the adjacent characters.
       * translates to (index(0)) == (index(1)).
       */
      if (input.charAt(index - 1) == input.charAt(index)) {
        // If characters match add to counter.
        counter++;
      } else {
        /* If the characters don't match it checks if the
         * counter is greater than the max counter.
         */
        if (counter > maxCounter) {
          // If the counter is greater is becomes the new maxCounter.
          maxCounter = counter;
        }
        /* Counter resets to 1 so it can account for the new character
         * Because if it is set to 0 it will count the new character.
         */
        counter = 1;
      }
      /* Allows to compare the next characters.
       * For example, before it compared 0 and 1
       * now it will be 1 and 2
       */
      index++;
    }
    // Returns the max counter.
    return maxCounter;
  }

  /**
   * Main program.
   *
   * @param args Command-line arguments (not used in program).
   */
  public static void main(final String[] args) throws IOException {

    /* Just in case there is issues with file directory.
     * A try catch is used to prevent the program from crashing.
     */
    try {
      // Create file with directory and scanner for input.
      final File inputFile = new File("Assign/Assign-02/Assign-02-Java-StringStuff/input.txt");
      final Scanner input = new Scanner(inputFile);

      // Create file with directory and fileWriter for output.
      final File outputFile = new File("Assign/Assign-02/Assign-02-Java-StringStuff/output.txt");
      final FileWriter output = new FileWriter(outputFile);

      // To check for contents in the file.
      if (input.hasNextLine()) {
        // Creates a variable for contents in the file.
        final String words = input.nextLine();
        // convert to int to be able to return integer value (max run).
        int maxAsInt = maxRun(words);
        // Displays the max run to console/terminal.
        System.out.println("The max run is: " + maxAsInt);
        // Convert contents back to string so it can be written in output.txt.
        String max = Integer.toString(maxAsInt);
        output.write(max);
      } else {
        // If there is nothing in the file.
        System.out.println("There is nothing in the file.");
      }
      // Will be displayed after the program is finish running.
      System.out.println("file reading is finished.");
      // close scanner and fileWriter.
      input.close();
      output.close();

    } catch (IOException e) {
      // To catch any invalid file directories.
      System.out.println("There is no existing file.");
    }
  }
}
