package ar.edu.unq.bomberman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class BombExplotionStepdefs {
	
	Cell cell;
	
	@Given("^a cell$")
	public void Add_bomberman(){
		this.cell = new Cell();
	}

	@When("^bomb explodes$")
  	public void Explode_bomb(){
		this.cell.explodeBomb();
	}

	@Then("^destroy melamine walls 3 cells away$")
	public boolean Destory_walls(){
		this.cell.anyMelamineWallsThreeCellsAway()
	}

}
