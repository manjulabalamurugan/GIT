Feature: Login functionality for LeafTaps


#used to run before every scenario
#Background:
#Given Open the Chrome Browser
#And Load the application URL

#scenario outline will be used to pass multiple examples
@functional
Scenario Outline: TC001_Login with positive and negative credential 

And Enter the username as <username>
And Enter the password as <password>
When Click on Login button
Then Homepage should be displayed

Examples:
|username|password|
|'DemoSalesManager'|'crmsfa'|
|'Democsr'|'crmsfa'|




