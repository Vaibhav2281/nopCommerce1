Feature: Login

@sanity
Scenario: Successful login with valid credentials
Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on login
Then page title should be "Dashboard / nopCommerce administration"
When user click on Log out link
Then page title should be "Your store. Login"
And close browser

@regression
Scenario Outline: Login Data Driven
Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "<email>" and Password as "<password>"
And Click on login
Then page title should be "Dashboard / nopCommerce administration"
When user click on Log out link
Then page title should be "Your store. Login"
And close browser

Examples: 
		| email | password |
		| admin@yourstore.com | admin |
		| admin@yourstore.com | admin123 |
		