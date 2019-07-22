Feature: Online Purchase

  As a user i want to be able to register,login, perform online purchase and logout

  Background: User is on home page
    Given I am on tutotialninja home page

  Scenario: User Registration
    Given I navigate to registration page
    When I register with valid registration details
    Then I should be registered successfully

  Scenario: User Login
    Given I navigate to login page
    When I enter valid login credentials
    Then I should be logged in successfully

  Scenario: User Add Product To Purchase To Cart
    Given I logged in successfully
    And I navigate through products to buy
    When I select product
    Then The product should be added to cart

  Scenario: User Perform Checkout For The Product Selected
    Given The product is added to cart
    When I perform checkout for the product
    Then The product should be checked out successful

  Scenario: User Logout
    Given I am on home page
    When I click on logout
    Then I should be logged out successfully
