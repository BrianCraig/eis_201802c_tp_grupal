package ar.edu.unq.bomberman;

public class Bomberman {
	
  private Cell position;
  private Boolean isAlive = true;
  
  public Bomberman(Cell initialPosition){
	  this.position = initialPosition;
  }

  public void moveTo(Direction direction) {
	Cell nextCell = position.getNextCellTo(direction);
	CellContent content = nextCell.getContent();
	if(content==CellContent.Empty) {
		position = nextCell;
		position.empty();
		isAlive = false;
	}
  } 
  
  public Cell getPosition() {
	  return position;
  }
  
  public boolean isAlive() {
	  return isAlive;
  }
}