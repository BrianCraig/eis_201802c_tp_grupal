package ar.edu.unq.bomberman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BombermanUsePowersStepdefs {

	@Given("^a bomberman with all 3 powers$")
	public void bomberman_with_powers() {
	}
	
	@When("^bomberman launch a bomb 2 cells away to the east$")
	public void bomberman_launch_bomb() {
		
	}
	
	@Then("^this cell contains a bomb$")
	public boolean contains_bomb() {
		return true;
	}
	
	@When("^bomberman walks into a melanine wall to the north$")
	public void bomberman_walks_into_melanine_wall() {
		
	}
	
	@Then("^bomberman changes his position$")
	public boolean bomberman_changed_position() {
		return true;
	}
	
	@When("^bomberman try to lay a second active bomb$")
	public void bomberman_lay_a_second_bomb() {
		
	}
	
	@Then("^bomberman has two active bombs$")
	public boolean bomberman_has_two_active_bombs() {
		return true;
	}
}
