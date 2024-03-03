Feature: Identify_Courses

  Scenario: Coursera Test
    Given User is on the home page of Coursera
    When User search for the Web Development (search_name : "Web Development Courses" )
    Then User prints the Availabel languages
    And User prints the Availabel levels
    When User selects the language(select_lang : "English")
    And User selects the level (select_level: "Beginner")
    Then print the course name with ratings
    And save data in Excel
    When user click on enterprice
    And user click on solution
    And user click on for campus
    And fill the form 
    And getting the error msg
