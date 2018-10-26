package ar.edu.unq.bomberman;

public class Position {
  protected Integer x, y;

  public Position(Integer x, Integer y){
    this.x = x;
    this.y = y;
  }

  public Position sum(Position position){
    return new Position(this.x + position.x, this.y + position.y);
  }

  public Position getNextPosition(Direction direction){
    return this.sum(direction.getVector());
  }

  @Override
  public boolean equals(Object obj) {
    return obj.getClass().equals(Position.class)
      && this.x.equals(((Position) obj).x)
      && this.y.equals(((Position) obj).y);
  }
}
