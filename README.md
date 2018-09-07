# Maven-Amazon-Project
Scenario: Create Selenium Web browser tests using Java language for amazon.com with following details:
- Search Nikon and sort results from highest price to slowest.
- Select second product and click it for details.
- From details check (verify with assert) that product topic contains text “Nikon D3X”
- Creating cucumber scenario which is used for test execution/test step mapping.
- Implementing the webpage opening step so that Url is parameter
- Test is implemented as Maven project

Overview:
For achieving the above mentioned scenario, Maven Project has been created. Selenium has been used along with Cucumber and TestNg. For logging log4j has been used, and for reporting Cucumber Reports has been used.
The project achieves the following:
  1. It launches amazon.com and search Nikon in search bar
  2. It sorts the prices from Highest to Lowest
  3. Opens the first available product
  4. Verifies whether the brand in Nikon or not (as many times, when it is refurbished, then brand is shown as the seller name)
  5. Goes back to the Homepage
  6. Selects the second product in the queue
  7. Assert whether the product is Nikon D3X
  8. It also handles when Amazon gives some "Expert Recommendation". Expert Recommendations are bypassed and it scrolls down and selects the product as per above conditions
  9. Logs can be found out in target/Logs/Test.log
  10 Cucumber Reports can be found in target/cucumber-reports
  11. Code runs on both Chrome and Firefox
  
Steps to execute:
  1. Import the code from git
  2. Import in your local IDE as an existing Maven project
  3. Do Maven Install and build on pom.xml
  4. Run the testNg.xml
  
Improvement Scope:
  1. For reporting, libraries like Extent Reporting can be used
  2. Exception handling and Logging at more places
  3. Parametrization to run the test cases on multiple browsers. As of now, we will have to change the browser name(Chrome or Firefox) in Step file
  4. More usage of Implicit and Explicit Wait instead of Thread sleep
  
