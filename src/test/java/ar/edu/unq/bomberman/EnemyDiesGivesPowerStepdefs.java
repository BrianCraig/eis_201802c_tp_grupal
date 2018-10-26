package ar.edu.unq.bomberman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class EnemyDiesGivesPowerStepdefs {

	@Given("^an enemy next to a bomb$")
	public void enemy_next_to_bomb() {
		
	}
	
	@When("^an explotion kills Bagulaa$")
	public void bagulaa_dies() {
		
	}
	
	@Then("^it gives Bomberman THROW BOMBS power$")
	public boolean bomberman_can_throw_bombs() {
		return true;
	}
	
	@When("^an explotion kills Proto Max Jr$")
	public void proto_max_jr_dies() {
		
	}
	
	@Then("^it gives Bomberman WALK THROUGH WALLS power$")
	public boolean bomberman_can_wall_through_walls() {
		return true;
	}
	
	@When("^an explotion kills Proto-Max Units$")
	public void proto_max_units_dies() {
		
	}
	
	@Then("^it gives Bomberman LAY MULTIPLE BOMBS power$")
	public boolean bomberman_can_lay_multiple_bombs() {
		return true;
	}
	
}
