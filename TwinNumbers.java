/** 
  * This is an abstract class for two number streams to extend.
  * 
  * @author Erik Neu
  *
  * */
public abstract class TwinNumbers {
  
  /** field to store the first value */
  private int value1 = 0;
  /** field to store the second value */
  private int value2 = 0;
  
  /**
   * Gets the first value of two numbers.
   * @return the first value of two numbers
   * */
  public int getValue1() {
    return this.value1;
  }
  
  /**
   * Sets the first value of two numbers.
   * */
  public void setValue1(int value) {
    this.value1 = value;
  }
  
  /**
   * Gets the second value of two numbers.
   * @return the second value of two numbers.
   * */
  public int getValue2() {
    return this.value2;
  }
  
  /**
   * Sets the second value of two numbers.
   * */
  public void setValue2(int value) {
    this.value2 = value;
  }
  
  /**
   * Puts the two numbers into a string to be displayed.
   * @return the string of the two numbers
   * */
  @Override
  public String toString() {
    return "(" + value1 + "," + value2 + ")";
  }
}