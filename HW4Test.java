import org.junit.*;
import static org.junit.Assert.*;
/**
 * Testing Unit for Classes
 * @author Erik Neu
 */

public class HW4Test {
  
  /**
   * Test the append method
   */
  @Test
  public void testAppend() {
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    DoubleLinkedList<Integer> append = new DoubleLinkedList<Integer>();
    DLNode<Integer> list1 = new DLNode<Integer>(1, null, null);
    DLNode<Integer> list2 = new DLNode<Integer>(2, list1, null);
    DLNode<Integer> append1 = new DLNode<Integer>(4, null, null);
    DLNode<Integer> append2 = new DLNode<Integer>(5, append1, null);
    list.setFront(list1);
    list.setBack(list2);
    append.setFront(append1);
    append.setBack(append2);
    list.append(append);
    assertEquals("final node of append is final node of new list", list.getBack(), append.getBack());
    assertEquals("node after the final node of the old list is the first node of the append list", list.getFront().getNext().getNext(), append.getFront());
    assertEquals("second node of append list is still present in the new list as the node after the node after the old final node", list.getFront().getNext().getNext().getNext(), append.getFront().getNext());
  }
  
  /** 
    * Test WordCount constructor and getter/setters
    */
  @Test
  public void testWordCountGetSetCon() {
    WordCount dogs = new WordCount("dogs");
    assertEquals("starts with count 1", dogs.getCount(), 1);
    dogs.setCount(2);
    assertEquals("count is now 2", dogs.getCount(), 2);
    assertTrue("returns the input word", dogs.getWord().equals("dogs"));
  }
  
  /**
   * Test radixSort method
   */
  @Test
  public void testRadixSort() {
    
  }
  
  /**
   * Test loadFile method
   */
  @Test
  public void testLoadFile() {
    
    
    
  }
}