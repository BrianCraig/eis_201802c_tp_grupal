package ar.edu.unq.bomberman;

public enum Direction {
  RIGHT(1, 0),
  LEFT(-1, 0),
  TOP(1, 0),
  BOTTOM(-1, 0);

  private Integer x, y;

  Direction(Integer x, Integer y){
    this.x = x;
    this.y = y;
  }

  public Integer getX() {
    return x;
  }

  public Integer getY() {
    return y;
  }
}
