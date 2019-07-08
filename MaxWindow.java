/* Lab 3 Haoyou Cheng 
         Erik Neu */
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
    
/* A subclass of JFrame to move a window */
public class MaxWindow extends JFrame{
  
  boolean heightMaxmized = false;
  
  private int originalHeight = 0;
  private int originalWidth = 0;
  
  /* a method to move a window to the top */
  public void snapToTop(){
    this.setLocation(this.getX(),0);
  }
  
  /* a method to move a window to the left */
  public void snapToLeft(){
    this.setLocation(0,this.getY());
  }
  
  /* gets the screen size */
  public void maximizeHeight(boolean heightMaxmized) {
    
    if heightMaxmized = true
    // used the Toolkit to get the screen dimensions
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();
    
       
    this.setLocation(this.getX(), 0);
    this.setSize(this.getWidth() , (int)d.getHeight());
  }
  // a mthod to move window to the left and make it as wide as the screen
  public void maximizeWidth() {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();
    
    this.setLocation(0, this.getY());
    this.setSize((int)d.getWidth() , this.getHeight());
  }
  
  
}
 