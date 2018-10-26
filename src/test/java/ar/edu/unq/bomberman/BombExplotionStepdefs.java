package ar.edu.unq.bomberman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BombExplotionStepdefs {
	
	Cell cell;
	
	@Given("^a cell$")
	public void Add_Cell(){
		BoardGenerator boardGenerator = new BoardGenerator();
		Entity enemy = new Bagulaa();
		
		this.cell = new Cell(CellContent.Empty, new Position(0,0));
		boardGenerator.add(cell);

		boardGenerator.add(new Cell(CellContent.Steel, new Position(0, 1)));

		boardGenerator.add(new Cell(CellContent.Empty, new Position(0, -1)));
		Cell cellWithEnemy = new Cell(CellContent.Empty, new Position(0,-2));
		cellWithEnemy.setEntity(enemy);
		boardGenerator.add(cellWithEnemy);
		boardGenerator.add(new Cell(CellContent.Empty, new Position(0, -3)));

		boardGenerator.add(new Cell(CellContent.Empty, new Position(-1, 0)));
		boardGenerator.add(new Cell(CellContent.Melamine, new Position(-2, 0)));
		boardGenerator.add(new Cell(CellContent.Empty, new Position(-3, 0)));

		boardGenerator.add(new Cell(CellContent.Empty, new Position(1, 0)));
		boardGenerator.add(new Cell(CellContent.Empty, new Position(2, 0)));
		boardGenerator.add(new Cell(CellContent.Melamine, new Position(3, 0)));

		boardGenerator.linkCells();
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
		return (cell.getNextCellTo(Direction.South).getEntity() == null);
	}

}
