/** 
  * This is a stream to display the next lexicographic string.
  * 
  * @author Erik Neu
  *
  * */
public class StringStream extends LetterStream{
  
  /**
   * Constructor for the stream
   * @param s the string to be stored
   * */
  public StringStream(String s) {
    super();
    this.setString(s);
  }
  
  /**
   * Displays the next string in a stream.
   * @return the next string in the stream.
   * */
  public String nextString() {
    /** string builder to build the next string */
    StringBuilder b = new StringBuilder();
    if (this.getString().charAt(this.getString().length()) == 'z') {
      for (int i = 0; i < this.getString().length() - 1; i++) {
        b.append(this.getString().charAt(i));
      }
      b.append("a");
      return b.toString();
    }
    return b.toString();
  }
  
  /**
   * Puts the next string into the stream.
   * @return the next string in the stream
   * */
  @Override
  public String next() {
    StringBuilder b = new StringBuilder();
    return b.toString();
  }
}
    