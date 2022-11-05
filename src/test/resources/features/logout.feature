@NVF-723
Feature: User should be able to log out

    Background: user is expected to be on the home page
        Given user logins successfully as "Driver" and is on the homePage

    @NVF-718
    Scenario: User can log out by using log out button inside profile info and ends up in login page.
        When user clicks username profile menu on the upright
        And user clicks log out button
        Then user lands on login page

    @NVF-719
    Scenario: User cannot go to the home page again by clicking the step back button after successfully logged out.
        When user logs out successfully
        And user clicks navigate back button
        And user still stays on the login page

    @NVF-720
    Scenario: User must be logged out if the user close one open tab
        When user closes the open tab-tabs
        And user navigates to app's home page
        Then user lands on login page

    @NVF-721
    Scenario: User must be logged out if the user close multiple open tabs in the app
        When user opens the second tab
        And user navigates to the home page while on the second tab
        And user closes the open tab-tabs
        And user navigates to app's home page
        Then user lands on login page

    @NVF-722 @wip
    Scenario: User must be logged out if the user is away from keyboard for 3 minutes (AFK)
        When user is away from keyboard for three minutes
        Then user lands on login page
