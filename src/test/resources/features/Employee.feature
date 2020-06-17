Feature: Create Update Delete Employee

  Scenario: Verify employee is created successfully
    Given user gives employee name "krishna" salary "10000" age "25"
    When user calls "AddEmployeeAPI" with POST request
    Then AddEmployeeAPI is success with status code 200
    And "status" is "OK"