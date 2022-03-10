import java.util.Random;

/**
*Die class
*/
public class Die{
  private int sides;
  public int value;
  /**
  *Constructor: sets sides to s and value to 0
  *@param s - the number of sides on the die
  */
  public Die(int s){
    sides = s;
    value = 0;
  }
  /**
  *@return the value
  */
  int roll(){
    Random rand = new Random();
    value = rand.nextInt(6) + 1;
    return value;
  }
  int val(){
    return value;
  }
  /**
  *@returns true if the implicit == explicit, else false
  *@param d - Any Die object
  */
  boolean equals(Die d){
    if (this.value == d.value){
      return true;
    }
    else{
      return false;
    }
  }
  /**
  *@param d - Any Die object
  *@return true if implicit is less than the explicit parameter
  */
  boolean lessThan(Die d){
    if (this.value < d.value){
      return true;
    }
    else{
      return false;
    }
  }
  /**
  *@return the difference between the implicit and explicit parameters
  *@param d - Any Die object
  */
  int difference(Die d){
    return this.value - d.value;
  }
  /**
  * @return the value of the die converted to a string
  */
  String tostring(){
    return Integer.toString(value);
  }
}