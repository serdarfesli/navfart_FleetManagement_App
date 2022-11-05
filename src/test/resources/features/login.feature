@NVF-695 @login @regression
Feature: Login Feature

    Background: user is expected to be on the login page
        Given user is on the login page

    @NVF-683 @smoke
    Scenario Outline: login with valid credentials
        When user enters username as "<username>" and password as "<password>"
        And user clicks login button
        Then user lands on "<homePage>"
        Examples:
            | username        | password    | homePage        |
            | user1           | UserUser123 | Quick Launchpad |
            | user2           | UserUser123 | Quick Launchpad |
            | salesmanager101 | UserUser123 | Dashboard       |
            | salesmanager102 | UserUser123 | Dashboard       |
            | storemanager51  | UserUser123 | Dashboard       |
            | storemanager52  | UserUser123 | Dashboard       |

    @NVF-684 @smoke
    Scenario Outline:  User see "Invalid username or password." message when login with invalid credentials
        When user enters username as "<username>" and password as "<password>"
        And user clicks login button
        Then user see "Invalid user name or password." message
        Examples:
            | username | password    |
            | user1    | asdlkaj123  |
            | user6546 | UserUser123 |
            | user534  | 435345zxc   |

    @NVF-685
    Scenario Outline:  User see "Please fill in this field" message from empty field while logging in. if both username and password are empty,
    username field throws the message
        When user enters username as "<username>" and password as "<password>"
        And user clicks login button
        Then user see "Please fill in this field." message from "<empty field>"
        Examples:
            | username        | password    | empty field |
            | user1           |             | password    |
            |                 | UserUser123 | username    |
            |                 |             | username    |
            | storemanager51  |             | password    |
            | salesmanager101 |             | password    |

    @NVF-686 @smoke
    Scenario: User see their password in bullet signs while typing (like ****)
        When user types in password field
        Then user see bullet signs while typing

    @NVF-687 @smoke
    Scenario: User lands on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
        When user clicks ‘Forgot Password’ link
        Then user lands on ‘Forgot Password’ page

    @NVF-688 @smoke
    Scenario Outline: User can change his/her password with their "username" after clicking on REQUEST link
        When user clicks ‘Forgot Password’ link
        And user enters his "<username>" into username-email inputBox
        And user click request button
        Then user gets successfully changed message.
        Examples:
            | username        |
            | user1           |
            | salesmanager101 |
            | storemanager51  |

    @NVF-689
    Scenario: When "Remember me on this computer" checkbox is clicked , user can see his/her credentials already entered
    in the login page in their next attempt (after clicking log out)
        When user clicks remember_me_on_this_computer checkbox
        And user enters "user1" as username and "UserUser123" as password
        And user clicks login button
        And user clicks username profile menu on the upright
        And user clicks log out button
        Then user sees username and password inputboxes are already filled with credentials "user1" and "UserUser123"

    @NVF-690
    Scenario: When "Remember me on this computer" checkbox is clicked , user can see his/her credentials already entered
    in the login page in their next attempt (after closing the tab/page)
        When user clicks remember_me_on_this_computer checkbox
        And user enters "user1" as username and "UserUser123" as password
        And user clicks login button
        And user closes the tab-window
        And user is on the login page
        Then user sees username and password inputboxes are already filled with credentials "user1" and "UserUser123"

    @NVF-691
    Scenario Outline: User can use Enter key from his_her keyboard to switch to next field and to login
        When user enters his "<username>" and "<password>" switching by Enter key
        And user hits enter key in the password field
        Then user lands on "<homePage>"

        Examples:
            | username        | password    | homePage        |
            | user1           | UserUser123 | Quick Launchpad |
            | user2           | UserUser123 | Quick Launchpad |
            | salesmanager101 | UserUser123 | Dashboard       |
            | salesmanager102 | UserUser123 | Dashboard       |
            | storemanager51  | UserUser123 | Dashboard       |
            | storemanager52  | UserUser123 | Dashboard       |

    @NVF-692
    Scenario:  User gets "Please fill in this field." message from username field
    when he/she hits "Enter" key while it is blank
        Given username field is empty
        When user hits Enter key in the username field
        Then username field throws "Please fill in this field." message

    @NVF-693
    Scenario:  User gets "Please fill in this field." message from password field when he/she hits "Enter" key in password field while username field is full but
    password field is blank
        When user enters "user1" as username and hits Enter
        When user hits enter key in the password field
        Then password field throws "Please fill in this field." message

    @NVF-694
    Scenario Outline: User can see his own "username" (what he/she types in the username field) in the profile menu, after login
        When user enters username as "<username>" and password as "<password>"
        And user clicks login button
        Then user sees his-her username as "<nameInTheProfile>" in the profile menu
        Examples:
            | username        | password    | nameInTheProfile |
            | user1           | UserUser123 | user1            |
            | storemanager51  | UserUser123 | storemanager51   |
            | salesmanager101 | UserUser123 | salesmanager101  |