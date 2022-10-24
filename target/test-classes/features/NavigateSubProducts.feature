Feature: Navigate Sub Products

  Scenario: Verify navigate Sub Catagory
    Given User on the Trendyol page
    When User navigates "Tişört" from "Erkek"
    And User selects First Male Tshirt

    @test
    Scenario: Verify login and search product on searchbox
      Given User on the Trendyol page
      When User navigates the login page
      And User types username and password on Login page
      And User searches "Ayakkabi" on searchbox
