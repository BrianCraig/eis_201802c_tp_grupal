Feature: Bomberman moves to an empty cell, will not move to a wall cell and will die if 
	       the cell contains an enemy.

  Background: Bomberman in a cell surrounded with a radius of 1 cell:
  
  							  |M|			References:
  							|E|B|S|								B = Bomberman   S = Steel cell
  								|_|								  E = Enemy       M = Melamine cell 
  								
    Given a cell with Bomberman


    Scenario: Bomberman moves to the south and changes his position
      When Bomberman moves to an empty cell
      Then Bomberman's position changes

		Scenario: Bomberman try to move to a cell with a wall
			When Bomberman moves to a cell with a wall
			Then Bomberman will not change his position 
			
		Scenario: Bomberman moves to a cell that contains an enemy
			When Bomberman moves to a cell with an enemy
			Then Bomberman will die