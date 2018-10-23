Feature: Bomberman movement

  Background: Bomberman
    Given a map i just created

    Scenario: Bomberman moves to an empty cell
      When Bomberman moves to an empty cell
      Then Bomberman has changed position