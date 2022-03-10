/*
LAB #6
Samuel Kim - CECS 277 - 03/02/2022
Yahtzee game - Composition
*/

class Main {  
  public static void main(String args[]) {
    Player p1 = new Player();
    System.out.println("Yahtzee\n");
    takeTurn(p1);
    System.out.println("Game Over.\nFinal Score = " + p1.getPoints() + " points.");
  }
  /**
   * Method description
   * @param p: passing in p of the Player class.
   */
  static void takeTurn(Player p){
    boolean again = true;
    while (again){
      System.out.println("Rolling Dice...");
      p.roll();
      System.out.println(p.tostring());
      if (p.series()){
        System.out.println("You got a series of 3!");
      }
      else if (p.threeOfAKind()){
        System.out.println("You got 3 of a kind!");
      }
      else if (p.pair()){
        System.out.println("You got a pair!");
      }
      else {
        System.out.println("Aww. Too Bad.");
      }
      System.out.println("Score = " + p.getPoints() + " points.");
      System.out.println("Play Again? (Y/N) ");
      again = CheckInput.getYesNo();
    }
  }
}