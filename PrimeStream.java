/** 
  * A stream that displays only prime numbers.
  * 
  * @author Erik Neu
  *
  * */

public class PrimeStream extends NumberStream{
  
  /** field to store the filter for prime numbers */
  private NotMultipleFilter filter = null;
  
  /**
   * Main method to set the first filter for future filters to incorporate.
   * @param args the command line arguments for java to execute
   * */
  public static void main(String[] args) {
    NotMultipleFilter filter = new NotMultipleFilter(2, null);
  }
  
  /**
   * Finds the next prime in the stream.
   * @return the next prime number
   * */
  public int nextPrime() {
    /** if statement to account for starting at value 0 so the stream may occur */
    if (this.getCurrentValue() == 0) {
      return 2;
    }
    /** variable to store the prime number that is being searched for */
    int prime = 0;
    filter = new NotMultipleFilter(this.getCurrentValue(), filter);
    prime = this.getCurrentValue() + 1;
    while ((filter.passFilter(prime) == false)) {
      filter = new NotMultipleFilter(prime, filter);
      prime = prime + 1;
    }
    return prime;
  }
  
  /**
   * Displays the next prime number for the stream. Overrides the next() method from number stream to only put
   * prime numbers in the stream.
   * @return the next prime number in the stream.
   * */
  @Override
  public int next() {
    if (this.getCurrentValue() == 0) {
      this.setCurrentValue(2);
    }
    else {
      this.setCurrentValue(this.nextPrime());
    }
    return this.getCurrentValue();
  }
}


