@ui @check @automationpractice
Feature:E-commerse shopping website checking

Scenario: User open browser and navigate to home URL
    Given user have valid application URL
    When user open the url and validate
    Then user navigate to the index page

Scenario: Application logo visisbility
     Given user have valid application URL
     And user navigate to the index page
     When Application logo should be visible
     Then Logo width as 350 and height as 99 
    
Scenario: Application main category list validation
     Given user have valid application URL
     And user navigate to the index page
     When User find the main category list on Index page
     Then User hover the mouse on main category

Scenario Outline: User doing search functinality
     Given user have valid application URL
     And user navigate to the index page
     When User Search for product "<product_name>"
     Then Search Result page is displayed
    Examples:
      |product_name|
      |  T-shirt   |
 
Scenario: Social media handles validation
      Given user have valid application URL
      When User click on footer link
      Then Twitter account will open in new tab
      
      
     
     