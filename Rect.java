/**
*This class saves the position and size of a rectangle
*/
public class Rect{
  private int x;
  private int y;
  private int width;
  private int height;

  public Rect(int w, int h){
    width = w;
    height = h;
  }
  /**
  *@return the x location of the most upper left point of the rectangle
  */
  int getX(){
    return x;
  }
  /**
  *@return the y location of the most upper left point of the rectangle
  */
  int getY(){
    return y;
  }
  /**
  *@return the width of the rectangle
  */
  int getWidth(){
    return width;
  }
  /**
  *@return the width of the rectangle
  */
  int getHeight(){
    return height;
  }
  /**
  * moves the rectangle by adjusting its x and y positions
  */
  public void translate(int dx, int dy){
    x += dx;
    y += dy;
  }
}