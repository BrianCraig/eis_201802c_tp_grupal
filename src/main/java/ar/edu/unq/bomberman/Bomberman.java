package ar.edu.unq.bomberman;

import java.util.ArrayList;

public class Bomberman implements Entity{
	
  private Cell position;
  private Boolean isAlive = true;
  private ArrayList<Bomb> activeBombs = new ArrayList<Bomb>();
  private Integer bombRange = 3;
  private Integer bombTicks = 3;
  
  public Bomberman(Cell initialPosition){
	  this.position = initialPosition;
	  position.setEntity(this);
  }

  public void moveTo(Direction direction) {
	Cell nextCell = position.getNextCellTo(direction);
	CellContent content = nextCell.getContent();
	if(content==CellContent.Empty && nextCell.getEntity()==null) {
		position.removeEntity();
		position = nextCell;
		position.setEntity(this);
		this.tickBombs();
		}
	if(nextCell.getEntity()!= null) {
		isAlive = false;
	}
  } 
  
  public Cell getPosition() {
	  return position;
  }
  
  public boolean isAlive() {
	  return isAlive;
  }

  public void layBomb() {
	  Bomb bomb = new Bomb(bombRange,bombTicks,position);
	  activeBombs.add(bomb);
	  this.position.addBomb();
  }
  
  public void tickBombs() {
	  for(int i=0; i<activeBombs.size();i++) {
		  Bomb bomb = activeBombs.get(i);
		  bomb.decreaseTick();
		  if(bomb.getTicks() == 0) {
			  activeBombs.remove(bomb);
		  }
	  }
  }
  
  public ArrayList<Bomb> getActiveBombs(){
	  return activeBombs;
  }
  
  public void setRange(Integer range) {
	  this.bombRange = range;
  }
  
}