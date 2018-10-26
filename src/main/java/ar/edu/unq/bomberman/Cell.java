package ar.edu.unq.bomberman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Cell {
	
	private CellContent content;
	private HashMap<Direction, Cell> surroundingCells;

	public Cell(CellContent type, HashMap<Direction, Cell> cells) {
		this.content = type;
		this.surroundingCells = cells;
	}
	
	public void explodeBomb(Integer range) {
		ArrayList<Direction> directions = new ArrayList<Direction>(Arrays.asList(Direction.values()));
		for(int i=0; i< directions.size(); i++) {
			Direction dir = directions.get(i);
			this.explodeNextNCells(dir, range);
		}
	}

	private void explodeNextNCells(Direction direction, Integer range) {
		Cell cell = surroundingCells.get(direction);
		CellContent previousType = cell.content;
		cell.destroy();
		if(previousType.equals(CellContent.Empty) && range>0) {
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
}