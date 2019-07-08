import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double linked list.
 * @author Erik Neu, taken from lab
 */
public class DoubleLinkedList<T> implements Iterable<T> {
  /** a reference to the first node of the double linked list */
  private DLNode<T> front;
  
  /** a reference to the last node of a double linked list */
  private DLNode<T> back;
  
  /** Create an empty double linked list. */
  public DoubleLinkedList() {
    front = back = null;
  }
  
  /** 
   * Returns true if the list is empty.
   * @return  true if the list has no nodes
   */
  public boolean isEmpty() {
    return (getFront() == null);
  }
  
  /**
   * Returns the reference to the first node of the linked list.
   * @return the first node of the linked list
   */
  protected DLNode<T> getFront() {
    return front;
  }
  
  /**
   * Sets the first node of the linked list.
   * @param node  the node that will be the head of the linked list.
   */
  protected void setFront(DLNode<T> node) {
    front = node;
  }
  
  /**
   * Returns the reference to the last node of the linked list.
   * @return the last node of the linked list
   */
  protected DLNode<T> getBack() {
    return back;
  }
  
  /**
   * Sets the last node of the linked list.
   * @param node the node that will be the last node of the linked list
   */
  protected void setBack(DLNode<T> node) {
    back = node;
  }
  
  /**
   * Add an element to the head of the linked list.
   * @param element  the element to add to the front of the linked list
   */
  public void addToFront(T element) {
    DLNode<T> node = new DLNode<T>(element, null, this.getFront());
    this.setFront(node);
    if(node.getPrevious() == null && node.getNext() == null)
    {
      this.setBack(node);
    }
  }
  
  /**
   * Add an element to the tail of the linked list.
   * @param element  the element to add to the tail of the linked list
   */
  public void addToBack(T element) {
    DLNode<T> node = new DLNode<T>(element, this.getBack(), null);
    this.setBack(node);
    if(node.getPrevious() == null && node.getNext() == null)
    {
      this.setFront(node);
    }
  }

  /**
   * Remove and return the element at the front of the linked list.
   * @return the element that was at the front of the linked list
   * @throws NoSuchElementException if attempting to remove from an empty list
   */
  public T removeFromFront() {
    if (this.getFront() == null && this.getBack() == null) {
      throw new NoSuchElementException();
    }
    if (this.getFront().equals(this.getBack())) {
      T temp = this.getFront().getElement();
      this.setFront(null);
      this.setBack(null);
      return temp;
    }
    T temp = this.getFront().getElement();
    this.setFront(this.getFront().getNext());
    return temp;
  }
  
  /**
   * Remove and return the element at the back of the linked list.
   * @return the element that was at the back of the linked list
   * @throws NoSuchElementException if attempting to remove from an empty list
   */
  public T removeFromBack() {
    if (this.getFront() == null && this.getBack() == null) {
      throw new NoSuchElementException();
    }
    if (this.getFront().equals(this.getBack())) {
      T temp = this.getBack().getElement();
      this.setFront(null);
      this.setBack(null);
      return temp;
    }
    T temp = this.getBack().getElement();
    this.setBack(this.getBack().getPrevious());
    return temp;
  }
  
  /**
   * Appends a new linked list to the end of the current one
   * @param appendList the list added to the end
   */
  public void append(DoubleLinkedList<T> appendList) {
    /** stores the old final node of the current list */
    DLNode<T> last = this.getBack();
    last = new DLNode<T>(last.getElement(), last.getPrevious(), appendList.getFront());
    this.setBack(last);
    this.setBack(appendList.getBack());
  }
     
  /**
   * Returns an interator for the linked list that starts at the head of the list and runs to the tail.
   * @return  the iterator that runs through the list from the head to the tail
   */
  @Override
  public Iterator<T> iterator() {
    return new DoubleLinkedListIterator<T>(this.getFront());
  }
}
