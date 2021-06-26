Feature: CreateLead functionality for LeafTaps


@smoke @sanity
Scenario: TC003_CreateLead Functionality with mandatory information

And Enter1 the username as 'DemoSalesManager'
And Enter1 the password as 'crmsfa'
When Click1 on Login button
Then Homepage must be displayed
When Click on crmsfa link
Then My Homepage should be displayed 
When Click on leads link 

