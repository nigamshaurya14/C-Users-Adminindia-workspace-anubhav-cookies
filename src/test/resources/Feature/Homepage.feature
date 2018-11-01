@tag1
Feature: HomePage

  Scenario: Verify Website is opening or not
    Given I entered  website url in browser
      | url | https://20.stage.insomniacookies.com/ |
    Then I should be able to access the site with given "url" successfully

  Scenario: Verify HomePage images are loading or not
    And Insomnia cookies HomePage images should load successfully
