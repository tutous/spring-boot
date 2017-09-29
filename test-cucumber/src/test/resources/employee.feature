Feature: employee integration tests

  Scenario: get version
    Given   valid version 1.0
    When    get version
    Then    version response status code is 200
    And     receives version 1.0

  Scenario Outline: get employee by id
    When    get employee <id>
    Then    the employee response status code is <status>
    And     the employee value contains <firstName>, <lastName>
    Examples:
      | id | firstName |  lastName   | status |
      | 1  | "Uwe"     |  "Sluga"    | 200    |
      | 2  | "Anni"    |  "Sluga"    | 200    |
      | 3  | "Anton"   |  "Sluga"    | 200    |
      | 5  |           |             | 404    |