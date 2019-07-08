import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator for the double linked list
 * @author Erik Neu
 */
public class DoubleLinkedListIterator<T> implements Iterator<T> {
 
  /** the nodeptr stores where we are in the list */
  private DLNode<T> nodeptr;
  
  /**
   * Create the iterator
   * @param firstNode  the first node whose data is returned by the iterator
   */
  public DoubleLinkedListIterator(DLNode<T> firstNode) {
    nodeptr = firstNode;
  }

  /**
   * Returns true if there is still more data in the list
   * @return true if more data
   */
  public boolean hasNext() {
    return nodeptr != null;
  }
  
  /**
   * Returns the next element stored in the list and increments.
   * @return the next element
   */
  public T next() {
    if (hasNext()) {
      T save = nodeptr.getElement();
      nodeptr = nodeptr.getNext();
      return save;
    }
    else
      throw new NoSuchElementException();
  }
}
