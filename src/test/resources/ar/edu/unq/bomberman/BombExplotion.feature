Feature: Bomb Explotion

  Background: Bomberman
    Given a cell

   Scenario: A bomb explodes in a cell
     When a bomb with range 3 explodes
     Then destroys melamine walls 3 cells away