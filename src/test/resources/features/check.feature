@ui @check @automationpractice
Feature: Validate the functionality of E-commerse shopping website

@homepage
Scenario Outline: Validate that user is able to verify url redirecion functionality of application
   Given user have valid "<Application_URL>"
   When user open the application
   Then user should be redirected to index page of application

   Examples:
        |Application_URL|
        | http://automationpractice.com|

@checklogo
Scenario Outline: Validate that user is able to view visisbility of Application logo
       Given user have valid "<Application_URL>"
       When user open the application
       Then Application logo should be visible
       And Logo width should be "<width>" and height should be "<height>"

  Examples:
     |Application_URL              |width|height|
     |http://automationpractice.com|350  | 99   |


@checkmaincat    
Scenario Outline: Validate that user is able to validate product category list from application
      Given user have valid "<Application_URL>"
      When user open the application
      Then user should validate that main category count should be "<count>"
      And user should be validate category as below
      |Cat_Name |
      | Dresses |
      |T-shirts |
    
   Examples:
     |Application_URL              |count|
     |http://automationpractice.com|  3  | 
      

@searchproduct
Scenario Outline: Validate that user is able to test search functinality of product
      Given user have valid "<Application_URL>"
      When user open the application
      And User Search for product "<product_name>"
      Then Search Result page is displayed
   Examples:
     |product_name|Application_URL              |
     |  T-shirt   |http://automationpractice.com |
     
 
@footerlink
Scenario Outline: Validate that user is able to test Social media handles validation
        Given user have valid "<Application_URL>"
        When user open the application
        And user clicks on footerlink Twitter
        Then user should be validate new tab opens with url "seleniumfrmwrk"
        And account name should be "<name>"
        
   Examples:
   |Application_URL               |name              |
   |http://automationpractice.com |Selenium Framework|