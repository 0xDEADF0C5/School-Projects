import org.junit.*;
import static org.junit.Assert.*;
import java.lang.reflect.*;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JUnit tests for the knock-off Bejeweled game (FakeBejeweled class).
 * @author Erik Neu
 */

public class FakeBejeweledTester extends Application {
  
  @BeforeClass
  public static void initializeJFX() {
    Thread t = new Thread("JavaFX Initialize Thread") {
      @Override
      public void run() {
        Application.launch(FakeBejeweledTester.class, new String[0]);
      }
    };
    t.setDaemon(true);
    t.start();
  }
  
  /**
   * Tests the getter and setter methods of jewel types
   */
  @Test
  public void testSetGetJewelTypes() {
    FakeBejeweled.setJewelTypes(5);
    
    assertEquals("the getter method returns the same value that was set" , FakeBejeweled.getJewelTypes(), 5);
    
    FakeBejeweled.setJewelTypes(7);
    
    assertEquals("the getter method returns the new value that was set", FakeBejeweled.getJewelTypes() , 7);
    
    // invalid values are tested in the main method, not getters or setters
    
  }
   
  /**
   * Tests the getter and setter methods of board rows
   */
  @Test
  public void testSetGetBoardRows() {
    FakeBejeweled.setBoardRows(5);
    
    assertEquals("the getter method returns the same value that was set" , FakeBejeweled.getBoardRows() , 5);
    
    FakeBejeweled.setBoardRows(14);
      
    assertEquals("the getter method returns the new vaue that was set" , FakeBejeweled.getBoardRows() , 14);
  }
  
  /**
   * Tests the getter and setter methods of board columns
   */
  @Test
  public void testSetGetBoardColumns() {
    FakeBejeweled.setBoardColumns(7);
    
    assertEquals("the getter method returns the same value that was set" , FakeBejeweled.getBoardColumns() , 7);
    
    FakeBejeweled.setBoardColumns(17);
    
    assertEquals("the getter method returns the new value that was set" , FakeBejeweled.getBoardColumns() , 17);
  }
  
  /**
   * Tests the main method
   */
  @Test
  public void testMain() {
    String[] input = {"java", "FakeBejeweled" , "8", "8", "5"};
    FakeBejeweled.main(input);
    assertEquals("jewel types are the same amount the user asked for" , 5 , FakeBejeweled.getJewelTypes());
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    // had to override
  }
}
