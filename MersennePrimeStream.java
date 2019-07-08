/** 
  * Prints the next Mersenne Prime.
  * 
  * @author Erik Neu
  *
  * */
public class MersennePrimeStream extends PrimeStream {
  
  /** field stores the filter for primes */
  private NotMultipleFilter filter;
  
  /** 
   * Main method to set the first upstream filter.
   * @param args the command line arguments for java to execute
   * */
  public static void main(String[] args) {
    /** sets the starting filter */
    NotMultipleFilter filter = new NotMultipleFilter(2, null);
  }
  
  /**
   * Checks if a value is a factor of two.
   * @param value the value to test for being a factor
   * @return whether the input is a factor of two or not
   * */
  public boolean isTwoFactor(int value) {
    /** variable to store "value" because this variable changes in the method, but input cannot be changed*/
    int dividend = value;
    /** loop divides multiple times by two to check if all numbers divided out are two */
    for (int i = 0; i < 20; i++) {
      if (((dividend % 2) == 0) || (dividend % 2 == 2)) {
        dividend = dividend / 2;
        if ((dividend % 2 == 0) && (dividend / 2 == 1)) {
          return true;
        }
      }
      else
        return false;
    }
    return false;
  }
  
  /**
   * Gives the next Mersenne Prime.
   * @return the next marsenne prime
   * */
  public int nextMersennePrime() {
    /** object created to not change the fields of the class outside the method
      * it will act similarly to "this" */
    PrimeStream prime = new PrimeStream();
    prime.setCurrentValue(this.getCurrentValue() + 1);
    if (this.getCurrentValue() == 0) {
      prime.setCurrentValue(2);
    }
    /** checks for the prime's next number if it is a power of two */
    while (this.isTwoFactor(prime.getCurrentValue() + 1) == false) {
      prime.setCurrentValue(prime.next());
    }
    return prime.getCurrentValue();
  }
  
  /**
   * Displays the next MarsennePrime in the stream. Overrides Prime Stream's next() method.
   * @return the next Marsenne Prime
   * */
  @Override
  public int next() {
    if (this.getCurrentValue() == 0) {
      this.setCurrentValue(2);
      return this.getCurrentValue();
    }
    this.setCurrentValue(this.nextMersennePrime());
    return this.getCurrentValue();
  }
}

