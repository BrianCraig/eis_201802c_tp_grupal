Feature: Bomb Explotion

  Background: Bomberman
    Given a cell

   Scenario: A bomb explodes in a cell
     When a bomb explodes
     Then destroys melamine walls 3 cells away