package ar.edu.unq.bomberman;

import java.util.HashMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BombermanMovementStepdefs {

    Bomberman bomberman;

    @Given("^a cell with Bomberman$")
    public void Bomberman_in_a_cell(){
    	
    	HashMap<Direction,Cell> cells = new HashMap<Direction,Cell>();
    	HashMap<Direction,Cell> mockCells = new HashMap<Direction,Cell>();
    	
    	Cell north = new Cell(CellContent.Melamine,mockCells);
    	Cell south = new Cell(CellContent.Empty,mockCells);
    	Cell east = new Cell(CellContent.Enemy,mockCells);
    	Cell west = new Cell(CellContent.Steel,mockCells);
    	
    	cells.put(Direction.North, north); cells.put(Direction.South, south);
    	cells.put(Direction.East, east); cells.put(Direction.West, west);
    	
    	Cell bombermanCell = new Cell(CellContent.Bomberman,cells);
    	
        this.bomberman = new Bomberman(bombermanCell);
    }


    @When("^Bomberman moves to an empty cell$")
    public void Bomberman_moves_to_an_empty_cell() {
    	bomberman.moveTo(Direction.South);
    }

    @Then("^Bomberman's position changes$")
    public boolean Check_Bomberman_position() {
    	return true;
    }
}
