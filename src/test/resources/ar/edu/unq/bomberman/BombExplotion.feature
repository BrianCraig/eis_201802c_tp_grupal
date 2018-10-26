Feature: Bomb explotion destroys melamine cells, never destroys steel cells
				 and kills enemies.

  Background: Cell surrounded with a radius of 3 cells:
  
                    |_|        References:
                    |_|             B = Bomb
                    |S|             _ = Empty Cell
              |_|M|_|B|_|_|M|       M = Melanine Cell
                    |_|             S = Steel Cell
                    |E|             E = Enemy
                    |_|
  										
    Given a cell

	  Scenario: A bomb explodes in a cell
	    When a bomb with range 3 explodes
	    Then destroys melamine walls 3 cells away

		Scenario: A bomb explodes in a cell
			When a bomb with range 3 explodes
			Then the steel wall is not destroyed

		Scenario: A bomb explodes in a cell
		  When a bomb with range 3 explodes
		  Then kills an enemy 2 cells away

	