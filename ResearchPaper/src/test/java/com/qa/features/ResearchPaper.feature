
Feature: Login to Reseach Paper Access and Download 
  
  Scenario: Accessing Full Paper without Institutional login
    Given User lanuch the Research Paper application
    When user is on the Research Paper screen
    And User clicks on "Full Page" link
    Then User gets "You do not have permission to do that"
  
  @ResearchPaper_Download
	Scenario Outline: Accessing the Full Paper by Institutional login
		Given User lanuch the Research Paper application
		When user is on the Research Paper screen
    And User clicks on "institutional login page" link
    And User enters Institutional Username : "<UserName>" and Institutional Password: "<Password>"
    And User clicks on Login button
    And User is navigates back to Research Paper Access page
    And User clicks on "Full Page" link
    Then User gets "<Results>" 
      
    
    Examples:
    |UserName|Password|Results|
    |instuser1|instpass1|paper.pdf|
    |instuser1|InvalidPass|You do not have permission to do that|
