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
		Cell northCell = new Cell(CellContent.Steel,mockCells);
		
		//South Cell
		Cell southCell3 = new Cell(CellContent.Empty,mockCells);
		
		HashMap<Direction,Cell> cellsForSouthCell2 = new HashMap<Direction,Cell>();
		cellsForSouthCell2.put(Direction.South, southCell3);
		Cell southCell2 = new Cell(CellContent.Enemy,cellsForSouthCell2);
		
		HashMap<Direction,Cell> cellsForSouthCell1 = new HashMap<Direction,Cell>();
		cellsForSouthCell1.put(Direction.South,southCell2);
		Cell southCell1 = new Cell(CellContent.Empty,cellsForSouthCell1);
		
		HashMap<Direction,Cell> southCells = new HashMap<Direction,Cell>();
		southCells.put(Direction.South, southCell1);
		Cell southCell = new Cell(CellContent.Empty,southCells);
		
		//East Cell
		Cell eastCell3 = new Cell(CellContent.Empty,mockCells);
		
		HashMap<Direction,Cell> cellsForEastCell2 = new HashMap<Direction,Cell>();
		cellsForEastCell2.put(Direction.East, eastCell3);
		Cell eastCell2 = new Cell(CellContent.Empty,cellsForEastCell2);
		
		HashMap<Direction,Cell> cellsForEastCell1 = new HashMap<Direction,Cell>();
		cellsForEastCell1.put(Direction.East,eastCell2);
		Cell eastCell1 = new Cell(CellContent.Melamine,cellsForEastCell1);
		
		HashMap<Direction,Cell> eastCells = new HashMap<Direction,Cell>();
		eastCells.put(Direction.East, eastCell1);
		Cell eastCell = new Cell(CellContent.Empty,eastCells);
		
		//West Cell
		Cell westCell3 = new Cell(CellContent.Melamine,mockCells);
		
		HashMap<Direction,Cell> cellsForWestCell2 = new HashMap<Direction,Cell>();
		cellsForWestCell2.put(Direction.West, westCell3);
		Cell westCell2 = new Cell(CellContent.Empty,cellsForWestCell2);
		
		HashMap<Direction,Cell> cellsForWestCell1 = new HashMap<Direction,Cell>();
		cellsForWestCell1.put(Direction.West,westCell2);
		Cell westCell1 = new Cell(CellContent.Empty,cellsForWestCell1);
		
		HashMap<Direction,Cell> westCells = new HashMap<Direction,Cell>();
		westCells.put(Direction.West, westCell1);
		Cell westCell = new Cell(CellContent.Empty,westCells);
		
		//Main Cell
		HashMap<Direction,Cell> cells = new HashMap<Direction,Cell>();
		cells.put(Direction.North, northCell);
		cells.put(Direction.South, southCell);
		cells.put(Direction.East, eastCell);
		cells.put(Direction.West, westCell);
		
		this.cell = new Cell(CellContent.Empty, cells);
	}

	@When("^a bomb with range 3 explodes$")
  	public void Explode_bomb(){
		this.cell.explodeBomb(3);
	}

	@Then("^destroys melamine walls 3 cells away$")
	public boolean Check_melamine_walls(){
		return (cell.getNextCellTo(Direction.West).getNextCellTo(Direction.West)
			   .getNextCellTo(Direction.West).getContent() == CellContent.Empty) &&
				(cell.getNextCellTo(Direction.East).getNextCellTo(Direction.East)
			   .getContent() == CellContent.Empty);
	}
	
	@Then("^the steel wall is not destroyed$")
	public boolean Check_steel_wall() {
		return (cell.getNextCellTo(Direction.North).getContent() == CellContent.Steel);
	}
	
	@Then("^kills an enemy 2 cells away$")
	public boolean check_enemy() {
		return (cell.getNextCellTo(Direction.South).getContent() == CellContent.Empty);
	}

}
