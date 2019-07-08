/** 
  * This is an abstract class for filters to extend.
  * 
  * @author Erik Neu
  *
  * */

public abstract class Filter {
  /** variable to store the current filter */
  private Filter currentFilter;
  
  /**
   * Gets the current filter
   * @return the current filter
   * */
  public Filter getCurrentFilter() {
    return this.currentFilter;
  }
  
  /**
   * Sets the current filter
   * */
  public void setCurrentFilter(Filter filter) {
    this.currentFilter = filter;
  }
}

