/**
*Player class
*/
public class Player{
  private int points;
  private Die dice[] = new Die[3];
  /**
  *Constructor: Die class is assigned to all three variables
  */
  public Player(){
    for (int i = 0; i < 3; i++){
      dice[i] = new Die(6);
    }
  }
  /**
  *@return points
  */
  int getPoints(){
    return points;
  }
  /**
  *Sorts all of the die in the array in ascending order
  * if dice 0 is less than dice 1: it returns true
  */
  void sort(){
    if (dice[1].lessThan(dice[0])){
      Die temp = dice[0];
      dice[0] = dice[1];
      dice[1] = temp;
    }
    if (dice[2].lessThan(dice[0])){
      Die temp = dice[2];
      dice[2] = dice[1];
      dice[1] = dice[0];
      dice[0] = temp;
    }
    if ((dice[2].lessThan(dice[1]) || dice[2].equals(dice[1])) && (dice[0].lessThan(dice[2]) || dice[0].equals(dice[2]))){
      Die temp = dice[1];
      dice[1] = dice[2];
      dice[2] = temp;
    }
  }
  /**
  *@return true - if there is a pair in the array
  */
  boolean pair(){
    if (dice[0].equals(dice[1])){
      points += 1;
      return true;
    }
    else if (dice[0].difference(dice[2]) == 0){
      points += 1;
      return true;
    }
    else if (dice[1].difference(dice[2]) == 0){
      points += 1;
      return true;
    }
    return false;
  }
  /**
  *@return true - if the dice are a three of a kind.
  */
  boolean threeOfAKind(){
    if (dice[0].equals(dice[1]) && dice[1].equals(dice[2])){
      points += 3;
        return true;
    }
    return false;
  }
  /**
  * @return true - if the dice are in a series.
  */
  boolean series(){
    if (dice[1].difference(dice[0]) == 1 && dice[2].difference(dice[1]) == 1){
      points += 2;
      return true;
    }
    return false;
  }
  /**
   * rolls all three dice
   */
  void roll(){
    for (int i = 0; i < 3; i++){
      dice[i].roll();
    }
    sort();
  }
  /**
   * @return All of the dice values in a nice string.
   */
  String tostring(){
    return "D1 = " + dice[0].value + " D2 = " + dice[1].value + " D3 = " +  dice[2].value;
  }
}