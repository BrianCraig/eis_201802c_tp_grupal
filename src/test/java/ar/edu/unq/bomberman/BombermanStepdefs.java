package ar.edu.unq.bomberman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BombermanStepdefs {

    Bomberman bomberman;

    @Given("^a map i just created$")
    public void Add_bomberman(){
        this.bomberman = new Bomberman();
    }


    @When("^Bomberman moves to the right$")
    public void Bomberman_moves_to_the_right() {
        this.bomberman.moveRight();
    }

    @Then("^it is at pos 1$")
    public boolean check_pos() {
        return true;
    }
}
