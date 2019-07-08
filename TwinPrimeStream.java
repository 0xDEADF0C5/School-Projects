/** 
  * A stream of two numbers that are prime.
  * 
  * @author Erik Neu
  *
  * */
public class TwinPrimeStream extends TwinNumbers{
  
  /** stores the filter for prime numbers */
  private NotMultipleFilter filter = null;
  
  /**
   * Main method to set the first filter for prime numbers.
   * @param args the command line arguments for java to execute
   * */
  public static void main(String[] args) {
    NotMultipleFilter filter = new NotMultipleFilter(2, null);
  }
  
  /**
   * Finds the next prime number for the second value to store.
   * @return the new prime number
   * */
  public int nextPrime() {
    int prime = 0;
    filter = new NotMultipleFilter(this.getValue1(), filter);
    prime = this.getValue2() + 1;
    if (this.getValue2() == 0) {
      prime = 2;
    }
    while ((filter.passFilter(prime) == false)) {
      filter = new NotMultipleFilter(prime, filter);
      prime = prime + 1;
    }
    return prime;
  }
  
  /**
   * Finds the next set of two prime numbers to display
   * @return the string of the two prime numbers
   * */
  public String next() {
    int old1 = this.getValue1();
    int old2 = this.getValue2();
    if (this.getValue1() == 0) {
      this.setValue1(3);
      this.setValue2(5);
      return this.toString();
    }
    this.setValue2(this.nextPrime());
    this.setValue1(old2);
    return this.toString();
  }
}
    
    