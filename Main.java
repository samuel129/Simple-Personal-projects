import java.util.Scanner;
/**
* CECS 277 LAB #4 - Classes
* This program uses a Rect class to create a rectangle that is movable in a 20x20 grid.
* Samuel Kim
* 02/24/2022
*/

class Main {  
  public static void main(String args[]) {
    String[][] grid = new String[20][20];
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the height of the rectangle. (1-5)");
    int height = CheckInput.getInt();
    System.out.println("Please enter the width of the rectangle. (1-5)");
    int width = CheckInput.getInt();
    Rect r1 = new Rect(width, height);
    resetGrid(grid);
    placeRect(grid, r1);
    displayGrid(grid);
    menu(in, grid, r1);
  }
  /**
   * Method description
   * @param grid: passes in the grid
   */
  static void displayGrid(String[][] grid){
    /*Nested for loop to iterate through all 400 elements*/
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[0].length; j++){
        System.out.print(grid[i][j] + " ");
      }
      System.out.println("");
    }
  } 
  /**
   * Method description
   * @param grid: passes in the grid
   * @param r1: passes in the rectangle 
   */
  static void placeRect(String[][] grid, Rect r1){
    /*Nested for loop to iterate through all 400 elements*/
    for (int i = 0; i < r1.getHeight(); i++){
      for (int j = 0; j < r1.getWidth(); j++){
        grid[r1.getY() + i][r1.getX() + j] = "*";
      }
    }
  }
  /**
   * Method description
   * @param grid: passes in the grid
   */
  static void resetGrid(String[][] grid){
    /*Nested for loop to iterate through all 400 elements*/
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[0].length; j++){
        grid[i][j] = ".";
        }
      }
  }
  /**
   * @param grid: passes in the grid
   * @param r1: passes in the rectangle
   * @param in: passes in the scanner
   */
  static void menu(Scanner in, String [][] grid, Rect r1){
    while (true){
      System.out.println("Enter direction: \n1. Up\n2. Down\n3. Left\n4. Right\n5. Quit");
      /*This "xy" variable is to save the rectangles position, and if the rectangle does not move at all, then the error message down below will be printed.*/
      int xy = r1.getX() + r1.getY();
      int selection = CheckInput.getInt();
      /*These if statements are all to check whether the rectangle will be out of bounds or not*/
      if (selection == 1 && r1.getY() != 0){
        r1.translate(0, -1);
      }
      else if (selection == 2 && r1.getY() + r1.getHeight() < grid.length){
        r1.translate(0, 1);
        }
      else if (selection == 3 && r1.getX() != 0){
        r1.translate(-1, 0);
      }
      else if (selection == 4 && r1.getX() + r1.getWidth() < grid.length){
        r1.translate(1, 0);
      }
      else if (selection == 5){
        break;
      }
      else if (r1.getX() + r1.getY() == xy){
        System.out.println("You cannot go that way.");
      }
      resetGrid(grid);
      placeRect(grid, r1);
      displayGrid(grid);
    }
  }
}