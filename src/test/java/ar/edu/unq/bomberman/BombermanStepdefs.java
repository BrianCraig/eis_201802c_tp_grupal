
package ar.edu.unq.bomberman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BombermanStepdefs {

    Bomberman bomberman;
    Board board;

    @Given("^a map i just created$")
    public void Add_bomberman(){
        this.bomberman = new Bomberman();
        this.board = new Board();
    }


    @When("^Bomberman moves to an empty cell$")
    public void Bomberman_moves_to_an_empty_cell() {
        this.bomberman.moveRight();
    }

    @Then("^it is at pos 1$")
    public boolean check_pos() {
        return false;
    }
}
