Feature: Bomberman is able to use all of his 3 powers

  Background: Bomberman in a board:

    Given a bomberman with all 3 powers

		Scenario: Bomberman can launch bombs 
			When bomberman launch a bomb 2 cells away to the east
			Then this cell contains a bomb
			
		Scenario: Bomberman can walk through melanine walls
			When bomberman walks into a melanine wall to the north
			Then bomberman changes his position
			
		Scenario: Bomberman can Lay multiple bombs
			When bomberman try to lay a second active bomb
			Then bomberman has two active bombs