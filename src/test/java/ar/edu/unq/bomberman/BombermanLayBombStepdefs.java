package ar.edu.unq.bomberman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class BombermanLayBombStepdefs {

	Bomberman bomberman;
	Bomb bomb;
	
	@Given("^a bomberman in a cell$")
	public void bomberman_in_cell() {
		BoardGenerator boardGenerator = new BoardGenerator();
		
		Cell cell = new Cell(CellContent.Empty, new Position(0,0));
		bomberman = new Bomberman(cell);
		bomberman.setRange(1);
		
		boardGenerator.add(cell);
		boardGenerator.add(new Cell(CellContent.Empty, new Position(0, 1)));
	    boardGenerator.add(new Cell(CellContent.Empty, new Position(0, -1)));
	    boardGenerator.add(new Cell(CellContent.Empty, new Position(-1, 0)));
	    boardGenerator.add(new Cell(CellContent.Empty, new Position(1, 0)));
	    boardGenerator.linkCells();
	}
	
	@When("^bomberman lays a bomb in a cell$")
	public void bomberman_lay_bomb() {
		bomberman.layBomb();
		bomb = bomberman.getActiveBombs().get(0);
	}
	
	@Then("^it will not explode after 2 ticks$")
	public boolean bomb_dont_explodes() {
		bomb.decreaseTick();
		bomb.decreaseTick();
		return(bomberman.getActiveBombs().size() == 1);
	}
	
	@Then("^it explodes after 3 ticks$")
	public boolean bomb_explodes() {
		bomb.decreaseTick();
		bomb.decreaseTick();
		bomb.decreaseTick();
		return(bomberman.getActiveBombs().isEmpty());
	}
}