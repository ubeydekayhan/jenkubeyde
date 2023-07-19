@US04Api @Api
Feature: Add_Dean

  Scenario Outline: US04 Add Dean (Api)
    Given Post request for add dean with username="<username>", name="<name>", surname="<surname>", birthDay="<birthDay>", ssn="<ssn>", birthPlace="<birthPlace>", phoneNumber="<phoneNumber>", gender="<gender>", password="<password>"
    Then verify addition
    Examples:
      | username  | name | surname | birthDay   | ssn  | birthPlace   | phoneNumber  | gender | password  |
      | username  | name | surname | birthDay   | ssn  | birthPlace   | phoneNumber  | gender | password  |

