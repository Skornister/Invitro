Feature: Check city code response

  Scenario Outline : Verify city information
    Given I check city with code "<code>"
    Then the response city should be "<expectedCity>"
    And the response code should be "<expectedCode>"
    And the response guid should not be null

    Examples:
      | code   | expectedCity | expectedCode |
      | bajmak | Баймак       | bajmak       |
      | moscow | Москва       | moscow       |
      | london | Лондон       | london       |
