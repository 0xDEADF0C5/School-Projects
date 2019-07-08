/** 
  * This is a class for IntegerStream that can display the next number.
  * 
  * @author Erik Neu
  *
  * */
public class IntegerStream extends NumberStream {
  
  /** 
   * Constructor for stream.
   * @param startValue Value to start the stream with.
   * */
  public IntegerStream(int currentValue) {
    super();
    /** sets the start value of the object to the input value */
    this.setCurrentValue(currentValue);
  }
  
  
  /**
   * Method displays the next integer in a stream. Overrides the next() method in NumberStream.
   * @return the next integer in the stream
   * */
  @Override
  public int next() {
    this.setCurrentValue(this.getCurrentValue() + 1);
    return this.getCurrentValue();
  }
}