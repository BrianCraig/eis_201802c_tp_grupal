package ar.edu.unq.bomberman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BombermanUsePowersStepdefs {

	Bomberman bomberman;
	Cell cellWhereBombLands;
	Cell melamineCell;
	Cell cellWithBomb;
	
	@Given("^a bomberman with all 3 powers$")
	public void bomberman_with_powers() {
		BoardGenerator boardGenerator = new BoardGenerator();	
		Cell cell = new Cell(CellContent.Empty, new Position(0,0));
	
		boardGenerator.add(cell);
		melamineCell = new Cell(CellContent.Melamine, new Position(0, 1));
		boardGenerator.add(melamineCell);
	    boardGenerator.add(new Cell(CellContent.Empty, new Position(0, -1)));
	    cellWithBomb = new Cell(CellContent.Bomb, new Position(-1, 0));
	    boardGenerator.add(cellWithBomb);
	    cellWhereBombLands = new Cell(CellContent.Empty, new Position(1, 0));
	    boardGenerator.add(cellWhereBombLands);
	    boardGenerator.linkCells();
	    
	    bomberman = new Bomberman(cell);
	    bomberman.givePower(Power.LayMultipleBombs);
	    bomberman.givePower(Power.ThrowBombs);
	    bomberman.givePower(Power.WalkThroughWalls);
	    
	    Bomb bomb = new Bomb(3,3,cellWithBomb);
	    bomberman.getActiveBombs().add(bomb);
	}
	
	@When("^bomberman throw a bomb 1 cell away to the east$")
	public void bomberman_launch_bomb() {
		bomberman.throwBomb(Direction.East, 1);
	}
	
	@Then("^this cell contains a bomb$")
	public boolean contains_bomb() {
		return (cellWhereBombLands.getContent()==CellContent.Bomb);
	}
	
	@When("^bomberman walks into a melanine wall to the north$")
	public void bomberman_walks_into_melanine_wall() {
		bomberman.moveTo(Direction.North);
	}
	
	@Then("^bomberman changes his position$")
	public boolean bomberman_changed_position() {
		return bomberman.getPosition()==melamineCell;
	}
	
	@When("^bomberman try to lay a second active bomb$")
	public void bomberman_lay_a_second_bomb() {
		bomberman.layBomb();
	}
	
	@Then("^bomberman has two active bombs$")
	public boolean bomberman_has_two_active_bombs() {
		return bomberman.getActiveBombs().size()==2;
	}
}
