package ar.edu.unq.bomberman;

import java.util.Arrays;
import java.util.HashMap;

public class Cell {
	
	private CellContent content;
	private HashMap<Direction, Cell> surroundingCells =  new HashMap<>();
	private Position position;
	private Entity entity = null;

	public Cell(CellContent type, Position position) {
		this.content = type;
		this.position = position;
	}

	public void addCell(Direction direction, Cell cell){
		surroundingCells.put(direction, cell);
	}
	
	public void explodeBomb(Integer range) {
		Arrays.stream(Direction.values())
				.forEach(direction -> this.explodeNextNCells(direction, range));
	}

	private void explodeNextNCells(Direction direction, Integer range) {
		Cell cell = surroundingCells.get(direction);
		CellContent previousType = cell.content;
		cell.destroy();
		if(previousType.equals(CellContent.Empty) && cell.getEntity()==null && range>1) {
			cell.explodeNextNCells(direction, range-1);
		}
	}
	
	private void destroy() {
		if(this.content.isDestroyable()) {
			this.content = CellContent.Empty;
		}
	}
	
	public Cell getNextCellTo(Direction dir){
		return surroundingCells.get(dir);
	}
	
	public CellContent getContent() {
		return content;
	}

	public void empty() {
		this.content = CellContent.Empty;
	}

	public Position getPosition() {
		return position;
	}
	
	public void addBomb() {
		this.content = CellContent.Bomb;
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public void removeEntity() {
		this.entity = null;
	}
}