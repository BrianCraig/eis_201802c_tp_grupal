Feature: Bomberman movement

  Background: Bomberman
    Given a map i just created


    Scenario: Bomberman moving to the right
      When Bomberman moves to the right
      Then it is at pos 1

