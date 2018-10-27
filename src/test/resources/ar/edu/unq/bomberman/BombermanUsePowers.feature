Feature: Bomberman is able to use all of his 3 powers

  Background: Bomberman in a board:
  
                  |M|      References:
                |O|B|_|         B = Bomberman  O = Cell with a bomb
                  |_|           _ = Empty cell M = Melamine cell
                                                    
    Given a bomberman with all 3 powers

		Scenario: Bomberman can throw bombs 
			When bomberman throw a bomb 1 cell away to the east
			Then this cell contains a bomb
			
		Scenario: Bomberman can walk through melanine walls
			When bomberman walks into a melanine wall to the north
			Then bomberman changes his position
			
		Scenario: Bomberman can Lay multiple bombs
			When bomberman try to lay a second active bomb
			Then bomberman has two active bombs