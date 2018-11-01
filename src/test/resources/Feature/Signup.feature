@tag
Feature: Signup Page

  Background: user access to website
    Given User opens the Website
      | url | https://20.stage.insomniacookies.com/ |

  Scenario: Verify user is not able to signup with existing email
    Given Click on Log In link present in top right corner of the homepage
    When User enters an already registered emaid Id in email text box
      | email | snigam@judge.com |
    And Click on Create Account button
    Then Error popup should appear stating that The email has already been taken

  Scenario: Verify user is not able to SignUp if email id format is wrong
    Given Click on Log In link present in top right corner of the homepage
    When User enter valid inputs in all fields and invalid  emailid format
      | email | snigam@judge |
    And Click on Create Account button
    Then Error popup should appear stating that The email must be a valid email address

  Scenario: Verify validation message comes across all Mandatory fields
    Given Click on Log In link present in top right corner of the homepage
    And Click on Create Account button
    #Then Error popup should appears stating Please enter your first name
    #When User enter first Name
    #| firstname | Shaurya |
    #And Click on Create Account button
    #Then Error popup should appears stating Please enter your last name
    #When User enter last Name
    # | lastname | Nigam |
    # And Click on Create Account button
    Then Error popup should appears stating The email field is required
    When User enters emailid
      | email | test11@test.com |
    And Click on Create Account button
    #Then Error popup should appears stating The telephone field is required
    #When User enters The telephone number
    # | phone | 1111234534 |
    #And Click on Create Account button
    Then Error popup should appear stating The password field is required
    When User enter the password
      | newpassword | password |
    And Click on Create Account button
    Then Error popup should apppear stating The password confirmation does not match

  Scenario: Verify user is not able to SignUp if password is not matched with the confirm password fields
    Given Click on Log In link present in top right corner of the homepage
    When User enter valid inputs in all fields and uncommon inputs in Password and confirm password fields
      | email           | test12@test.com |
      | newpassword     | password        |
      | confirmpassword |             123 |
    And Click on Create Account button
    Then Error Validation messages should appear stating that The password confirmation does not match

  Scenario: Verify user is not able to SignUp if entered password length is less then 5
    Given Click on Log In link present in top right corner of the homepage
    When User enter valid inputs in all fields and 4 digit password in Password fields
      | email           | test12@test.com |
      | newpassword     |             123 |
      | confirmpassword |             123 |
    And Click on Create Account button
    Then Error Validation messages should appear stating that The password must be at least 5 characters

  #Scenario: Verify user is not able to SignUp if entered phone no. is greater than 10 digit
  # Given Click on Log In link present in top right corner of the homepage
  #When User enter valid inputs in all fields and phone no greater than 10
  # | firstname | Shaurya         |
  #| lastname  | Nigam           |
  # | email     | test12@test.com |
  # | phone     |    123456789012 |
  # Then Only 10 digits should be displayed in the textbox
  #@tag4
  #Scenario: Verify phone no text box accept only numbers not characters/Alphanumeric
  #Given Click on Login button in Header
  #When User enter valid inputs in all fields and phone no in characters
  #| firstname | Shaurya         |
  #| lastname  | Nigam           |
  #| email     | test12@test.com |
  #| phone     | sdggsgdfgdf     |
  #Then Nothing should be displayed in the textbox
  
  Scenario: Verify user  redirects to Forgot Password page on clicking Forgot password link.
    Given Click on Log In link present in top right corner of the homepage
    When User Click on Forgot Passoword
    Then user redirects to Forgot password Page
