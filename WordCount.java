/**
 * Word count tracker
 * @author Erik Neu
 */
public class WordCount {
  
  /** field to store a word */
  private String word;
  
  /** field to keep track of the word count, which will always start at 1 */
  private int count = 1;
  
  /**
   * Creates a WordCount
   * @param word the word that is to be included in the count
   */
  public WordCount(String word) {
    this.word = word;
  }
  
  /**
   * Gets the word of WordCount
   * @return the word of WordCount
   */
  public String getWord() {
    return this.word;
  }
  
  /**
   * Updates the count for WordCount
   * @param count the new count to be set
   */
  public void setCount(int count) {
    this.count = count;
  }
  
  /**
   * Gets the current word count
   * @return the current count
   */
  public int getCount() {
    return this.count;
  }
}