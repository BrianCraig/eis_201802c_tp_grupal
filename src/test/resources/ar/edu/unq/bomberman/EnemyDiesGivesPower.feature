Feature: An enemy dies in an explotion and gives bomberman a new power.
  
  Background: Bomb explodes next to an enemy and it dies, 
              giving bomberman a new power.
              
                   |_|    References:	
                 |_|B|X|      B = Bomb   X = Enemy  _ = Empty 
                   |_|

    Given an enemy next to a bomb

	Scenario: bomb explodes and kill Bagulaa
			When an explotion kills Bagulaa
			Then it gives Bomberman THROW BOMBS power
			
	Scenario: bomb explodes and kill Proto Max Jr
			When an explotion kills Proto Max Jr
			Then it gives Bomberman WALK THROUGH WALLS power
	
	Scenario: bomb explodes and kill Proto-Max Units
		When an explotion kills Proto-Max Units
		Then it gives Bomberman LAY MULTIPLE BOMBS power