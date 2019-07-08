/** 
  * This is a class for NotMultipleFilter to create filters that remove the multiples of numbers from a stream.
  * 
  * @author Erik Neu
  *
  * */

public class NotMultipleFilter extends Filter {
  
  /** field to store the base value that numbers cannot be a multiple of */
  private int baseValue = 0;
  
  /** field to store the upstream filter */
  private NotMultipleFilter upstreamFilter = null;
  
  /**
   * Constructor for the filter.
   * @param baseValue sets the baseValue field, which is the number that filters out multiples of this number
   * @param filter the upstream filter that is incorporated into the current filter
   * */
  public NotMultipleFilter(int baseValue, NotMultipleFilter filter) {
    super();
    this.baseValue = baseValue;
    this.upstreamFilter = filter;
  }
  
  /**
   * Tests if a value passes the filter of not being a multiple
   * @param testValue the value that is being tested in the filter
   * @return true or false if the value passed
   * */
  public boolean passFilter(int testValue) {
    if (upstreamFilter == null) {
      if (testValue % baseValue == 0) {
        return false;
      }
      else
        return true;
    }
    else if ((testValue % baseValue != 0) && (upstreamFilter.passFilter(testValue) == true)) {
      return true;
    }
    else
      return false;
  }

}