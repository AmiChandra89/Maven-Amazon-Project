Feature: Finding a Nikon Camera on Amazon.com
@chrome @firefox
  Scenario: Find Nikon Camera and assert if Nikon D3x is present
    Given : The user is able to navigate to "https://www.amazon.com"
    When : User tried to search "Nikon" in search filter and sort in "descending" order
    Then : Verify the seller brand
    Then : Verify that the second entry is "Nikon D3X"
