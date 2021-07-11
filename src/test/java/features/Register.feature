Feature: Register new user
  In order to register
  As a new user
  I have to enter data in all the mandatory fields

  Scenario: verify new user registration by providing data in all mandatory fields
    Given i navigate to url "https://demo.nopcommerce.com/"
    Then  i should be navigated to home page
    When  i click on register link from the navbar
    Then  i should be navigated to register page
    When  i select gender as male
    And   i select day as "4"
    And   i enter firstName lastName email password ConfirmPassword
    | firstName  | lastName|     email           |password           |ConfirmPassword|
    |     user1  |  qa1    |   testqa1@nop.com   |   Testing@123     |    Testing@123|
    And    i click on register button
    Then   registration should be successful





