package ar.edu.unq.bomberman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class EnemyDiesGivesPowerStepdefs {
		
		Bomb bomb;
		Cell bombCell;
		Cell cellWithEnemy;
		Enemy enemy;
		Bomberman bomberman;
	
	@Given("^an enemy next to a bomb$")
	public void enemy_next_to_bomb() {
		BoardGenerator boardGenerator = new BoardGenerator();
		
		bombCell = new Cell(CellContent.Empty, new Position(0,0));
		
		boardGenerator.add(bombCell);
		cellWithEnemy = new Cell(CellContent.Empty, new Position(0,1));
		boardGenerator.add(cellWithEnemy);
	    boardGenerator.add(new Cell(CellContent.Empty, new Position(0, -1)));
	    boardGenerator.add(new Cell(CellContent.Empty, new Position(-1, 0)));
	    boardGenerator.add(new Cell(CellContent.Empty, new Position(1, 0)));
	    boardGenerator.linkCells();
	    
	    bomb = new Bomb(1,1,bombCell);
	    cellWithEnemy.setEntity(enemy);
	    
	    Cell mockCell = new Cell(CellContent.Empty, new Position(2,2));
	    bomberman = new Bomberman(mockCell);
	}
	
	@When("^an explotion kills Bagulaa$")
	public void bagulaa_dies() {
		enemy = new Bagulaa(this.bomberman);
		bomb.decreaseTick();
	}
	
	@Then("^it gives Bomberman THROW BOMBS power$")
	public boolean bomberman_can_throw_bombs() {
		return bomberman.getPowers().contains(Power.ThrowBombs);
	}
	
	@When("^an explotion kills Proto Max Jr$")
	public void proto_max_jr_dies() {
		enemy = new ProtoMaxJr(bomberman);
		bomb.decreaseTick();
	}
	
	@Then("^it gives Bomberman WALK THROUGH WALLS power$")
	public boolean bomberman_can_wall_through_walls() {
		return bomberman.getPowers().contains(Power.WalkThroughWalls);
	}
	
	@When("^an explotion kills Proto-Max Units$")
	public void proto_max_units_dies() {
		enemy = new ProtoMaxUnits(bomberman);
		bomb.decreaseTick();
	}
	
	@Then("^it gives Bomberman LAY MULTIPLE BOMBS power$")
	public boolean bomberman_can_lay_multiple_bombs() {
		return bomberman.getPowers().contains(Power.LayMultipleBombs);
	}
	
}
