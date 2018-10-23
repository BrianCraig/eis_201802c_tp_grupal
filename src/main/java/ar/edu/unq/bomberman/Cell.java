package ar.edu.unq.bomberman;

import java.util.ArrayList;
import java.util.HashMap;

public class Cell {
	
	private CellType type;
	private HashMap<Direction, Cell> surroundingCells;

	public Cell(CellType type, HashMap<Direction, Cell> cells) {
		this.type = type;
		this.surroundingCells = cells;
	}
	
	public void explodeBomb(Integer range) {
		ArrayList<Direction> directions = this.directions();
		for(int i=0; i< 4; i++) {
			Direction dir = directions.get(i);
			this.explodeNextNCells(dir, range);
		}
	}

	private void explodeNextNCells(Direction direction, Integer range) {
		Cell cell = surroundingCells.get(direction);
		cell.explotionFire();
		if(cell.type.equals(CellType.Empty) && range>0) {
			cell.explodeNextNCells(direction, range-1);
		}
	}
	
	private void explotionFire() {
		this.type = CellType.Empty; 
	}
	
	private ArrayList<Direction> directions() {
		ArrayList<Direction> dirs = new ArrayList<Direction>();
		dirs.add(Direction.North); dirs.add(Direction.South);
		dirs.add(Direction.East); dirs.add(Direction.West);
		return dirs;
	}
}
