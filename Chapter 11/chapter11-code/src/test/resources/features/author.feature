Feature: Manage Authors
  As a admin
  I want to manage authors information
  
  Scenario Outline: Call Add Author API
    When the client calls /author/add with name "<name>" , url "<url>" and bio "<bio>"
    Then the client receives status code of <status>
  Examples:
    |name       |url                  |bio                   |status|
    |John       |http://johnauthor.com|this is bio for John  |200   |
    |Shagun     |http://shagun.in     |this is bio for Shagun|200   |
    
    
  Scenario Outline: User calls GET /author for getting author information
    When the client calls /author with name "<name>" and url "<url>"
    Then the client receives status code of <status>
  Examples:
    |name       |url               | status|
    |dummy      |http://unknown.com|404    |
    |Shagun     |http://shagun.in  |200    |
    |Shagun     |http://mybook.com |404    |