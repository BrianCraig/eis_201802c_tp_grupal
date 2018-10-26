package ar.edu.unq.bomberman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BombermanMovementStepdefs {

    Bomberman bomberman;
    Cell initialCell;

    @Given("^a cell with Bomberman$")
    public void Bomberman_in_a_cell(){
      BoardGenerator boardGenerator = new BoardGenerator();

      Cell initialCell = new Cell(CellContent.Bomberman, new Position(0, 0));
      this.bomberman = new Bomberman(initialCell);

      boardGenerator.add(initialCell);

      boardGenerator.add(new Cell(CellContent.Melamine, new Position(0, 1)));
      boardGenerator.add(new Cell(CellContent.Empty, new Position(0, -1)));
      boardGenerator.add(new Cell(CellContent.Enemy, new Position(-1, 0)));
      boardGenerator.add(new Cell(CellContent.Steel, new Position(1, 0)));

      boardGenerator.linkCells();
    }

    @When("^Bomberman moves to an empty cell$")
    public void Bomberman_moves_to_an_empty_cell() {
    	bomberman.moveTo(Direction.South);
    }

    @Then("^Bomberman position changes$")
    public boolean Check_Bomberman_position() {
    	return (bomberman.getPosition() == initialCell);
    }
    
    @When("^Bomberman try to move to a cell with a wall$")
    public void Bomberman_moves_to_a_wall() {
    	bomberman.moveTo(Direction.North);
    }
    
    @Then("^Bomberman will not change his position$")
    public boolean Bomberman_has_same_position() {
    	return(bomberman.getPosition() == initialCell);
    }
    
    @When("^Bomberman moves to a cell with an enemy$")
    public void Bomberman_moves_to_enemy() {
    	bomberman.moveTo(Direction.East);
    }
    
    @Then("^Bomberman will die$")
    public boolean Bomberman_is_dead() {
    	return bomberman.isAlive();
    }
}
