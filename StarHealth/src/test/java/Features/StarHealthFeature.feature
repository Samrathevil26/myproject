Feature: Test the starHealth page on Chrome Browser

  Scenario Outline: Validate the Star Health Buy Now flow
    Given User launches the Star Health application with "<URL>"
    Then User waits for the Welcome to Star Health pop-up and closes it
    Then User validates the Star Health home page title using a JUnit assertion
    When User clicks on the Buy Now button
    Then User types Name as "<FullName>"
    Then User types Phone as "<PhNo>"
    Then User types the PIN as "<PIN>"
    Then User clicks on I need health insurance from the drop-down menu
    When User selects the option "<optionPlan>"
    Then User sees the Plan for My Family page
    When User validates that the mobile number is the same as the previously entered number using a JUnit assertion
    Then User clicks on the Star Health logo
    Then The Application should redirect to the home page
    When User closes the child tab
    Then User navigates back to the parent tab

    Examples: 
      | URL                         | FullName    | PhNo       | PIN    | OptionPlan      |
      | https://www.starhealth.in// | Gaurav Mall | 9793477123 | 273008 | My Family |
