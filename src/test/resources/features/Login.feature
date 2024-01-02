Feature:


  Scenario: As a user should login with valid credentials
    Given I make a request with valid credentials
    Then Verify response with status code 200 and response body
  @wip
  Scenario Outline: negative login
    Given I make a request with invalid "<email>" and  "<password>"
    Then Verify response with status code 400

    Examples:
      | email                | password    |
      | ayazilitasgmail.com  | Test123456! |
      | ayazilitas@gmail.com |             |
      |                      | Test123456! |
      | ayazilitas@gmailcom | Test123456  |
      | ayazilitas@gmail     | Test123456 |
      | ayazilitaş@gmail.com | test123456 |
