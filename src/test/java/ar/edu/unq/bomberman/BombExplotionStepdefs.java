package ar.edu.unq.bomberman;

import java.util.HashMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class BombExplotionStepdefs {
	
	Cell cell;
	HashMap<Direction,Cell> cells;
	
	@Given("^a cell$")
	public void Add_bomberman(){
		this.cell = new Cell(CellType.Empty, cells);
	}

	@When("^a bomb with range 3 explodes$")
  	public void Explode_bomb(){
		this.cell.explodeBomb(3);
	}

	@Then("^destroys melamine walls 3 cells away$")
	public boolean Check_melamine_walls(){
		return true;
	}

}
