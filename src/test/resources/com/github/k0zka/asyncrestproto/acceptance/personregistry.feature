Feature: Person Registry

    Scenario: Save a person
    When I save a person
    Then I get a positive response
    And I can see the person saved

    Scenario: