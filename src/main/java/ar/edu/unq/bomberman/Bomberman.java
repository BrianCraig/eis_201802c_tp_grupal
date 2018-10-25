package ar.edu.unq.bomberman;

public class Bomberman {
	
  private Cell position;
  
  public Bomberman(Cell initialPosition){
	  this.position = initialPosition;
  }

  public void moveTo(Direction direction) {
	Cell nextCell = position.getNextCellTo(direction);
	CellContent content = nextCell.getContent();
	if(content.canWalkThrough()) {
		position = nextCell;
	}
	if(content==CellContent.Enemy) {
		position.empty();
	}
  } 
}