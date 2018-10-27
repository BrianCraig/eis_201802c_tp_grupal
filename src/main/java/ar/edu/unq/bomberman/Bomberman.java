package ar.edu.unq.bomberman;

import java.util.ArrayList;

public class Bomberman implements Entity{
	
  private Cell position;
  private Boolean isAlive = true;
  private ArrayList<Power> powers = new ArrayList<Power>();
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
	if((content==CellContent.Empty && nextCell.getEntity()==null)
	||(content==CellContent.Melamine && powers.contains(Power.WalkThroughWalls))) {
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
	  if(activeBombs.isEmpty() || powers.contains(Power.LayMultipleBombs)) {
	  Bomb bomb = new Bomb(bombRange,bombTicks,position);
	  activeBombs.add(bomb);
	  this.position.addBomb();
	  }
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

  @Override
  public void kill() {
	this.isAlive = false;
  }

  public void givePower(Power power) {
	  if(!powers.contains(power)) {
		  this.powers.add(power);
	  }
  }
  
  public ArrayList<Power> getPowers(){
	  return powers;
  }
  
  public void throwBomb(Direction direction, Integer cells) {
	  if(powers.contains(Power.ThrowBombs)) {
		  Cell target =  position;
		  int counter = cells;
		  while(counter>0) {
			  target = target.getNextCellTo(direction);
			  counter --;
		  }
		  this.throwBombIntoCell(target);
	  }
  }
  
  private void throwBombIntoCell(Cell target) {
	  Bomb bomb = new Bomb(bombRange,bombTicks,target);
	  activeBombs.add(bomb);
	  target.addBomb();  
  }
  
}