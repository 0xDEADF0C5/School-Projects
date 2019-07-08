/** 
  * This is an abstract parent class for all letter-based streams.
  * 
  * @author Erik Neu
  *
  * */
public abstract class LetterStream {
  
  /** field to store the string */
  private String string;
  
  /**
   * Changes the string field.
   * @param s the new string to be stored
   * */
  public void setString(String s) {
    this.string = s;
  }
  
  /**
   * Gets the string stored.
   * @return the stored string
   * */
  public String getString() {
    return this.string;
  }
  /**
   * Method stub for next letter set of a stream.
   * */
  abstract String next();
}