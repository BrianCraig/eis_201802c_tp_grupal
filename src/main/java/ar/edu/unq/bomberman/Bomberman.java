package ar.edu.unq.bomberman;

public class Bomberman {
  private Integer positionX = 0;
  public Bomberman(){}

  public void moveRight(){
    positionX += 1;
  }

  public Integer getPositionX() {
    return positionX;
  }
}
