package ar.edu.unq.bomberman;

import java.util.HashMap;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class BombExplotionStepdefs {
	
	Cell cell;
	
	@Given("^a cell$")
	public void Add_Cell(){
		HashMap<Direction,Cell> mockCells = new HashMap<Direction,Cell>();
		
		//North Cell
		Cell northCell = new Cell(CellType.Steel,mockCells);
		
		//South Cell
		Cell southCell3 = new Cell(CellType.Empty,mockCells);
		
		HashMap<Direction,Cell> cellsForSouthCell2 = new HashMap<Direction,Cell>();
		cellsForSouthCell2.put(Direction.South, southCell3);
		Cell southCell2 = new Cell(CellType.Enemy,cellsForSouthCell2);
		
		HashMap<Direction,Cell> cellsForSouthCell1 = new HashMap<Direction,Cell>();
		cellsForSouthCell1.put(Direction.South,southCell2);
		Cell southCell1 = new Cell(CellType.Empty,cellsForSouthCell1);
		
		HashMap<Direction,Cell> southCells = new HashMap<Direction,Cell>();
		southCells.put(Direction.South, southCell1);
		Cell southCell = new Cell(CellType.Empty,southCells);
		
		//East Cell
		Cell eastCell3 = new Cell(CellType.Empty,mockCells);
		
		HashMap<Direction,Cell> cellsForEastCell2 = new HashMap<Direction,Cell>();
		cellsForEastCell2.put(Direction.East, eastCell3);
		Cell eastCell2 = new Cell(CellType.Empty,cellsForEastCell2);
		
		HashMap<Direction,Cell> cellsForEastCell1 = new HashMap<Direction,Cell>();
		cellsForEastCell1.put(Direction.East,eastCell2);
		Cell eastCell1 = new Cell(CellType.Melamine,cellsForEastCell1);
		
		HashMap<Direction,Cell> eastCells = new HashMap<Direction,Cell>();
		eastCells.put(Direction.East, eastCell1);
		Cell eastCell = new Cell(CellType.Empty,eastCells);
		
		//West Cell
		Cell westCell3 = new Cell(CellType.Melamine,mockCells);
		
		HashMap<Direction,Cell> cellsForWestCell2 = new HashMap<Direction,Cell>();
		cellsForWestCell2.put(Direction.West, westCell3);
		Cell westCell2 = new Cell(CellType.Empty,cellsForWestCell2);
		
		HashMap<Direction,Cell> cellsForWestCell1 = new HashMap<Direction,Cell>();
		cellsForWestCell1.put(Direction.West,westCell2);
		Cell westCell1 = new Cell(CellType.Empty,cellsForWestCell1);
		
		HashMap<Direction,Cell> westCells = new HashMap<Direction,Cell>();
		westCells.put(Direction.West, westCell1);
		Cell westCell = new Cell(CellType.Empty,westCells);
		
		//Main Cell
		HashMap<Direction,Cell> cells = new HashMap<Direction,Cell>();
		cells.put(Direction.North, northCell);
		cells.put(Direction.South, southCell);
		cells.put(Direction.East, eastCell);
		cells.put(Direction.West, westCell);
		
		this.cell = new Cell(CellType.Empty, cells);
	}

	@When("^a bomb with range 3 explodes$")
  	public void Explode_bomb(){
		this.cell.explodeBomb(3);
	}

	@Then("^destroys melamine walls 3 cells away$")
	public boolean Check_melamine_walls(){
		return (cell.getNextCellTo(Direction.West).getNextCellTo(Direction.West)
			   .getNextCellTo(Direction.West).getType() == CellType.Empty) &&
				(cell.getNextCellTo(Direction.East).getNextCellTo(Direction.East)
			   .getType() == CellType.Empty);
	}
	
	@Then("^the steel wall is not destroyed$")
	public boolean Check_steel_wall() {
		return (cell.getNextCellTo(Direction.North).getType() == CellType.Steel);
	}
	
	@Then("^kills an enemy 2 cells away$")
	public boolean check_enemy() {
		return (cell.getNextCellTo(Direction.South).getType() == CellType.Empty);
	}

}
