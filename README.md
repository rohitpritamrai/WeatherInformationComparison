# WeatherInformationComparison
This framework is designed and developed for Web and API Automation Testing.

===============================================================================

1. Automation testing tool - Selenium WebDriver, Rest Assured
2. Programming language - Java
3. IDE - IntelliJ
4. Design Pattern - Page Object Model (With Page Factories)
5. Testing framework - TestNG
6. Build and Dependency Management Tool - Maven
7. Reports - ExtentReports, TestNG reports (Emailable-reports.html)

===============================================================================

Test Report - Extent Report

<img width="1369" alt="Screenshot 2021-09-14 at 13 51" src="https://user-images.githubusercontent.com/40173628/133223464-f660b088-337e-49c3-b2aa-d16e377d96bf.png">


===============================================================================

Files Location -

1. Properties (City name, URL, APP_ID : Project Directory/src/test/java/resources/properties/Env.properties
2. TestNG.XML Runner files : Project Directory/src/test/java/resources/runner/testng.xml
3. ExtentReports : Project Directory/extent_reports/
4. TestNG Report/E-mailable Report : Project Directory/target/surefire-reports
5. Test scripts : Project Directory/src/test/java/com/weatherInformation/testScripts/Tests.java

===============================================================================

To Run this project:
1. Clone this project into your local workspace
2. Provide the CITY name (for which you want to compare the weather) in Env.properties file
3. Options to Run :
   a. mvn test (test suite is provided in POM.xml, it will run the test)
   b. Run through testng.xml file
   c. You can run the tests mentioned in testScripts folder by running the testNG methods having @Test annotation
