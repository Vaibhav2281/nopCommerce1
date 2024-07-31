Feature: Customers

Background: Below are the common steps for each scenario
Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on login
Then User can view dashboad

@sanity
Scenario: Add a new customer
When User clicks on customers menu
And click on customers menu item
And click on Add new button
Then User can view Add new customer page
When user enter customer info
And click on save button
Then user van view confirmation message "The new customer has been added successfully"
And close browser

@regression
Scenario: Search customer by email id
When User clicks on customers menu
And click on customers menu item
And Enter customer Email
When click on search buttton
Then User should found Email in search table
And close browser

@regression
Scenario: Search customer by name
When User clicks on customers menu
And click on customers menu item
And Enter customer FirstName
And Enter customer LastName
When click on search buttton
Then user should found name in search table
And close browser
