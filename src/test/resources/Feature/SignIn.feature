@tag1
Feature: SignIn Page

  Background: user access to website
    Given User opens the Website
      | url | https://20.stage.insomniacookies.com/ |

  Scenario: Verify user is not able to login without entering any of the SignIn page fields
    Given Click on Log In link present in top right corner of the homepage
    And Click on the Log In button
    Then Alert should appear saying Please enter an email address
    And The password field is required

  Scenario: Verify user is able to login as current customer
    Given Click on Log In link present in top right corner of the homepage
    When User enters valid Email and Password
      | username | snigam@judge.com |
      | password | Judge@123        |
    And Click on the Log In button
    Then User must get login in and UserName should be displayed in the header
    When User clicks Logout button
    And User should logout successfully

  #And logout popup should be displayed
  Scenario: Verify user is not able to login with invalid credentials
    Given Click on Log In link present in top right corner of the homepage
    When User enters the invalid Email and Password
      | username | snigam@judge.com |
      | password | password         |
    And Click on the Log In button
    Then Error popup should appear stating Email and password do not match
