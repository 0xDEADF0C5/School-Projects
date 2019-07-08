/** 
  * This is an abstract parent class for all numeric streams.
  * 
  * @author Erik Neu
  *
  * */
public abstract class NumberStream {
  
  /** The current value for the stream */
  private int currentValue = 0;
  
  /**
   * Method stub for next integer in stream.
   * */
  public abstract int next();
  
  /**
   * Method sets the current value to a new value.
   * @param value New value to set to.
   * */
  public void setCurrentValue(int value) {
    this.currentValue = value;
  }
  
  /**
   * Method returns current value.
   * @return the currentvalue of the stream
   * */
  public int getCurrentValue() {
    return this.currentValue;
  }
  
}