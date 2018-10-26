Feature: Bomberman lays a bomb in his current cell and it explodes
         after 3 ticks.

  Background: Bomberman in a cell lays a bomb

    Given a bomberman in a cell

		Scenario: 
			When bomberman lays a bomb in a cell
			Then it explodes after 3 ticks