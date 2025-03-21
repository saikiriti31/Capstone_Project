Feature: User Registration, Login, and Password Recovery

@registration
Scenario: Register a new user
  Given I open Demowebshop
  When I navigate to the registration page
  When I register with "sai" and "kiriti" and unique email and "Sai@369" and "Sai@369" select male checkpoint in gender
  Then I should see the message "Your registration completed"
  And I click on continue
  And I verify the text of email and confirm the user is logged in
  And I click on logout button
  And I click on login button
  And I click on forget password
  And I enter the registered email in the email box
  And I click on the recover button
  Then receive this message "Email with instructions has been sent to you."