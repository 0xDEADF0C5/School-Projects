import java.io.*;

/**
 * A text analysis that sees word usage in a given document.
 * @author Erik Neu
 */

public class TextAnalyze {
  
  /**
   * Performs a radix sort on a list of strings, ordering them alphabetically
   * @param inputList the list of strings to alphabetize
   * @return the new list that is sorted
   */
  public static DoubleLinkedList<WordCount> radixSort(DoubleLinkedList<WordCount> inputList) {
    /** stores the current index to alphabetize based on */
    int index = 0;
    /** stores the input list as a flexible temp list */
    DoubleLinkedList<WordCount> tempList = inputList;
    /** creation of a type to be able to store generic double linked list into an array */
    class WordCountList extends DoubleLinkedList<WordCount>{}
    /** array of linked lists to store based on the alphabet */
    WordCountList[] warray = new WordCountList[27];
    /** loop finds the longest string, and sets index based on the longest length */
    for (WordCount x : inputList) {
      if (x.getWord().length() > index)
        index = x.getWord().length() - 1;
    }
    /** loop runs until the index is exhausted (alphabetization is over) */
    for (int i = index + 1; i > 0; i--) {
      warray = new WordCountList[27];
      /** saves the array list as one that can be appended to after sorting is over for each run of the loop */
      WordCountList appendedArrayList = new WordCountList();
      /** loop indexes each word into their location in the array based on the alphabet */
      for (WordCount word : tempList) {
        if (word.getWord().length() < (index + 1)) {
          warray[26].addToFront(word);
        }
        else
          warray[(word.getWord().charAt(index)) - 97].addToFront(word);
      }
      /** loop appends the alphabetized words in the array list to a double linked list for future runs,
        * or increases word count if there are duplicate words*/
      for (WordCountList arrayElement : warray) {
        if (appendedArrayList.getBack().getElement().equals(arrayElement)) {
          // this code increments the word count of an element by one
          appendedArrayList.getBack().getElement().setCount(appendedArrayList.getBack().getElement().getCount() + 1);
        }
        else
          appendedArrayList.append(arrayElement);
      }
      tempList = appendedArrayList;
    }
    return tempList;
  }
  
  /**
   * Loads a text file and reads it
   * @param fileName the name of the input file
   * @return the double linked list of words in the file, not sorted
   * @throws IOException if there is an error loading the file
   */
  public static DoubleLinkedList<WordCount> loadFile(String fileName) throws IOException {
    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
    String a = br.readLine();
    String[] words;
    DoubleLinkedList<WordCount> wordList = new DoubleLinkedList<WordCount>();
    // loop runs until there are no lines left to read, "a" being the current, running string that is being read
    while (a != null) {
      words = a.split(" ");
      // loop will run for each string to put them into the linked list
      for (String x : words) {
        wordList.addToBack(new WordCount(x));
      }
    }
    return wordList;
  }
  
  /**
   * Writes into a text file from a double linked list
   * @param fileName the name of the output file
   * @param writeList the list of strings to be written into the output file
   * @throws IOException if there is an error writing to the file
   */
  public static void writeData(String fileName, DoubleLinkedList<WordCount> writeList) throws IOException{
    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
    for (WordCount word : writeList) {
      bw.write(word.getWord() + word.getCount() + "\n");
    }
  }
  
  /**
   * Main method to execute TextAnalyze
   * @param args the arguments for loadFile and writeData
   * @throws IOException if writeData or loadFile has an error writing to or pulling data from a file
   */
  public static void main(String[] args) throws IOException{
    writeData(args[1] , TextAnalyze.radixSort(loadFile(args[0])));
  }
}