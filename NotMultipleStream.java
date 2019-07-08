/** 
  * This is a class for NotMultipleStream that can display the next value that is not a multiple of the input.
  * 
  * @author Erik Neu
  *
  * */
public class NotMultipleStream extends IntegerStream {
  
  /** field to store the current value of the stream */
  private int currentValue = 0;
  
  /** field to store the baseValue for the filter to test multiples against */
  private int baseValue = 0;
  
  /**
   * Constructor to set the base value and current value of the stream
   * @param baseValue the base value for the filter
   * @param currentValue the current value of the stream
   * */
  public NotMultipleStream(int baseValue, int currentValue) {
    super(currentValue);
    this.baseValue = baseValue;
  }
  
  /**
   * Gets the base value of the filter.
   * @return the filter's base value
   * */
  public int getBaseValue() {
    return this.baseValue;
  }
  
  /**
   * Overrides the IntegerStream next() method to only display the next number that passes the filter.
   * @return the next number of the stream that passed the filter
   * */
  @Override
  public int next() {
    /** filter for the stream*/
    NotMultipleFilter f = null;
    f = new NotMultipleFilter(this.getBaseValue(), f);
    /** check to see if the next number passes or not */
    if (f.passFilter(this.getCurrentValue() + 1) == false) {
      while ((f.passFilter(this.getCurrentValue() + 1)) == false) {
        this.setCurrentValue(this.getCurrentValue() + 1);
      }
      this.setCurrentValue(this.getCurrentValue() + 1);
      return this.getCurrentValue();
    }
    else
      this.setCurrentValue(this.getCurrentValue() + 1);
      return this.getCurrentValue();
  }
}
  