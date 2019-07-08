import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

/**
 * A program that makes a bootleg Bejeweled / Candy Crush game.
 * @author Erik Neu
 */

public class FakeBejeweled extends Application{
  
  /** stores array of jewels */
  private Button[][] jewels;
  
  /** stores different jewel types the user wants */
  private static int jewelTypes;
  
  /** stores the amount of rows in the board */
  private static int boardRows;
  
  /** stores the number of columns in the board */
  private static int boardColumns;
  
  /** stores the randomly generated colors */
  private Color[] colors;
  
  /** stores the color of a button */
  private int buttonColor;
  
  /** stores the previous button clicked in the game */
  private static Button previousButton;

  /**
   * Starts the program
   * @param primaryStage sets the stage for the game to take place in
   */
  public void start(Stage primaryStage) {
    /** initializes borderpane to take a gridpane to center in the window*/
    BorderPane pane = new BorderPane();
    /** initializes board */
    GridPane board = new GridPane();
    board = this.createBoard();
    pane.setCenter(board);
    
    /** loops through the first dimension of jewels[][] to set button locations */
    for (int i = 0; i < jewels.length; i++) {
      /** loops through the second dimension of jewels[][] to set button locations */
      for (int j = 0; j < jewels[i].length; j++) {
        jewels[i][j].setOnAction(new Click());
      }
    }
    
    /** sets the stage and shows the window */
    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /**
   * Sets and stores randomized colors to be used as jewel colors in game
   */
  public void setColors() {
    /** loops only for as many colors as the user wants */
    for (int i = 0; i < FakeBejeweled.getJewelTypes(); i++) {
      this.colors[i] = Color.color(Math.random(), Math.random(), Math.random());
    }
  }
  
  public Color[] getColors() {
    return this.colors;
  }
  
  /**
   * Creates the board for the game
   * @return provides the board made for the game from user input
   */
  public GridPane createBoard() {
    /** initializes a gridpane to store buttons/jewels in */
    GridPane board = new GridPane();
    jewels = new Button[FakeBejeweled.getBoardColumns()][FakeBejeweled.getBoardRows()];
    this.colors = new Color[FakeBejeweled.getJewelTypes()];
    this.setColors();
    /** loops through first dimension of jewels[][] */
    for (int i = 0; i < jewels.length; i++) {
      /** loops through second dimension of jewels[][] creating the buttons and assigning colors */
      for (int j = 0; j < jewels[i].length; j++) {
        board.add((jewels[i][j] = new Button("  ")), i, j);
        jewels[i][j].setPadding(new Insets(30, 30, 30, 30));
        jewels[i][j].setBackground(new Background(new BackgroundFill(colors[(int)(Math.random() * 100 % FakeBejeweled.getJewelTypes() - 1)], new CornerRadii(100.0), null)));
      }
    }
    return board;
  }
  
  /**
   * Sets the jewel types to be used in the game
   */
  public static void setJewelTypes(int types) {
    FakeBejeweled.jewelTypes = types;
  }
  
  /**
   * Sets the amount of rows to be used in making a board
   */
  public static void setBoardRows(int rows) {
    FakeBejeweled.boardRows = rows;
  }
  
  /**
   * Sets the amount of columns to be used in making a board
   */
  public static void setBoardColumns(int columns) {
    FakeBejeweled.boardColumns = columns;
  }
  
  /**
   * Gets the number of types of jewels the user wants
   * @return the number of jewel types
   */
  public static int getJewelTypes() {
    return FakeBejeweled.jewelTypes;
  }
  
  /**
   * Gets the number of rows in a board the user wants
   * @return the number of rows in the board
   */
  public static int getBoardRows() {
    return FakeBejeweled.boardRows;
  }
  
  /**
   * Gets the number of columns in a board the user wants
   * @return the number of rows in the board
   */
  public static int getBoardColumns() {
    return FakeBejeweled.boardColumns;
  }
  
  /**
   * Main method to take arguments from the user and create the FakeBejeweled Game
   * @param args the arguments to launch the game
   */
  public static void main(String[] args) {
    FakeBejeweled.setBoardRows(Integer.parseInt(args[0]));
    FakeBejeweled.setBoardColumns(Integer.parseInt(args[1]));
    FakeBejeweled.setJewelTypes(Integer.parseInt(args[2]));
    
    if ((FakeBejeweled.getBoardRows() >= 22) || (FakeBejeweled.getBoardColumns() >= 22)) {
      System.out.println("Board dimensions too large! Please enter a value from 3 to 21 to build the board.");
    }
    else if ((FakeBejeweled.getBoardRows() <= 2) || (FakeBejeweled.getBoardColumns() <= 2)) {
      System.out.println("Board dimensions too small! Please enter a value from 3 to 21 to build the board.");
    }
    else if ((FakeBejeweled.getJewelTypes() <= 2) || (FakeBejeweled.getJewelTypes() >= 7)) {
      System.out.println("Invalid number of jewel types! Please enter a value from 3 to 6 to build the board.");
    }
    else
      Application.launch(args);
  }
  
  /**
   * A subclass of FakeBejeweled to have buttons/jewels respond to clicks
   * @author Erik Neu
   */
  public class Click implements EventHandler<ActionEvent> {
    
    /** stores a running click */
    private boolean runningClick = false;
    
    /** stores the location of a button */
    private int[] buttonLocation;
    
    /** stores the original color of a button */
    private Color originalColor;
    
    /**
     * Overwrites handle method to make buttons respond to clicks
     * @param e the click/event that occurs on a button
     */
    public void handle(ActionEvent e) {
      /** initializes a new click instance */
      Click c = new Click();
      Button b = (Button)e.getSource();
      if (this.getPreviousButton() != null) {
        this.revertColor(this.getPreviousButton());
      }
      if (this.getRunningClick() == true) {
        this.swap(this.getPreviousButton(), b);
        this.setRunningClick(false);
      }
      this.setOriginalColor((Color)b.getBackground().getFills().get(0).getFill());
      c.selectColor(b);
      this.setPreviousButton(b);
      this.setRunningClick(true);
    }
    
    /**
     * Darkens the color of a button/jewel upon clicking it
     * @param b the button that is pressed
     */
    public void selectColor(Button b) {
      Color buttonColor = (Color)b.getBackground().getFills().get(0).getFill();
      b.setBackground(new Background(new BackgroundFill(buttonColor.darker(), new CornerRadii(100.0), null)));
    }
    
    /**
     * Reverts the selected button/jewel color back to its original state
     * @param b the button that is pressed
     */
    public void revertColor(Button b) {
      Color buttonColor = (Color)b.getBackground().getFills().get(0).getFill();
      b.setBackground(new Background(new BackgroundFill(buttonColor.brighter(), new CornerRadii(100.0), null)));
    }
    
    /**
     * Sets the running click
     * @param bool the boolean to set
     */
    public void setRunningClick(boolean bool) {
      this.runningClick = bool;
    }
    
    /**
     * Gets the running click
     * @return the running click
     */
    public boolean getRunningClick() {
      return this.runningClick;
    }
    
    /**
     * Gets the previous button clicked in the game
     * @return the previous button
     */
    public Button getPreviousButton() {
      return FakeBejeweled.previousButton;
    }
    
    /**
     * Sets the previous button
     * @param b sets the previous button to a new button
     */
    public void setPreviousButton(Button b) {
      FakeBejeweled.previousButton = b;
    }
    
    /**
     * Sets the original color of a button
     * @param c the new color to set to
     */
    public void setOriginalColor(Color c) {
      this.originalColor = c;
    }
    
    /**
     * Gets the color of a button
     * @param b the button to get a color of
     * @return the color of the button
     */
    public Color getButtonColor(Button b) {
      return (Color)b.getBackground().getFills().get(0).getFill();
    }
    
    /**
     * Sets the color of a button
     * @param b the button to change color
     * @param c the new color of the button
     */
    public void setButtonColor(Button b, Color c) {
      b.setBackground(new Background(new BackgroundFill(c, new CornerRadii(100.0), null)));
    }
    
    /**
     * Swaps jewels/buttons in the game
     * @param a button 1 to swap
     * @param b button 2 to swap
     */
    public void swap(Button a, Button b) {
      Color colorA = this.getButtonColor(a);
      Color colorB = this.getButtonColor(b);
      this.setButtonColor(a, colorB);
      this.setButtonColor(b, colorA);
    }
    
    /**
     * Sets the location of a button
     * @param b the button to set location of
     */
    public void setButtonLocation(Button b) {
      for (int i = 0; i < jewels.length; i++) {
        for (int j = 0; j < jewels[i].length; j++) { 
          if (jewels[i][j].equals(b)) {
            int[] array = new int[2];
            this.buttonLocation = array;
          }
        }
      }
    }
    
    /**
     * Gets the location of a button
     * @return the array of the location of a button
     */
    public int[] getButtonLocation() {
      return this.buttonLocation;
    }
  }
}