Feature: Login to nop commerce

  @sanity
Scenario Outline: Verify login with valid credentials

Given i navigate to url "https://demo.nopcommerce.com/"
Then  i should be navigated to home page
When  i click on login link from the navbar
Then  i should be navigated to login page
When  i enter email as "<email>"
And   i enter password "<password>"
And   i click on login button
Then  i should be logged in successfully

  Examples:

  | email                  |   password      |
  | user1@nop.com          | Testing@5       |
  | user2@nop.com          | Testing@5       |
  | user3@nop.com          | Testing@5       |






