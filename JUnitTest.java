import org.junit.*;
import static org.junit.Assert.*;
/**
 * Test class for Project 3
 * 
 * @author Erik Neu
 */
public class JUnitTest {
  
  /**
   * Test the setValue methods of IntegerPair
   */
  @Test
  public void testIntegerPair() {
    int i = 10;
    int j = 15;
    IntegerPair pair = new IntegerPair(5,7);
    pair.setValue1(i);
    pair.setValue2(j);
    
    assertEquals(pair.getValue1(), i);
    assertEquals(pair.getValue2(), j);
  }
  
  /**
   * Test the next() method of IntegerStream and the constructor, getter, and setter methods
   * */
  @Test
  public void testIntegerStream() {
    int i = 1;
    int j = 2;
    int k = 3;
    IntegerStream stream = new IntegerStream(i);
    
    assertEquals(stream.getCurrentValue(), i);
    assertEquals(stream.next(), j);
    assertEquals(stream.next(), k);
    
    stream.setCurrentValue(7);
    assertEquals(stream.getCurrentValue(), 7);
    
    stream.setCurrentValue(19);
    assertEquals(stream.getCurrentValue(), 19);
  }
  
  /**
   * Test the prime stream next() method and nextPrime() method
   * */
  @Test
  public void testPrimeStream() {
    int[] i = new int[4];
    i[0] = 2;
    i[1] = 3;
    i[2] = 5;
    i[3] = 7;
    
    PrimeStream prime = new PrimeStream();
    
    assertEquals(prime.next(), i[0]);
    assertEquals(prime.nextPrime(), i[1]);
    assertEquals(prime.next(), i[1]);
    assertEquals(prime.next(), i[2]);
    assertEquals(prime.nextPrime(), i[3]);
    assertEquals(prime.next(), i[3]);
  }
  
  /**
   * Test the NotMultipleFilter with different base values, and test the pass filter for those values 
   * */
  @Test
  public void testNotMultipleFilter() {
    int[] i = {1, 2, 3, 4, 5, 6};
    NotMultipleFilter filter = new NotMultipleFilter(i[2], null);
    
    assertTrue(filter.passFilter(i[3]));
  }
}
  
  
  
  
  
  
  
  
  
  
  
