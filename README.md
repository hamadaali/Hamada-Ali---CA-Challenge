Project Overview: Automated Testing Framework for PetFinder
This project is a behavior-driven automated test framework designed to validate the registration and login functionalities of the PetFinder website. 
It uses Selenium WebDriver, Cucumber, and TestNG technologies and follows the Page Object Model (POM) for maintainable and scalable test automation.
We use a scenario outline with examples for Data-Driven test DDT 

Project Architecture
1. Page Objects (Located in src/test/java/pages)
Each page class encapsulates the web elements and interactions for a specific page on the website, promoting modularity and reuse.

RegisterPage.java
Encapsulates the registration form functionality. Provides methods to:

LoginPage.java
Encapsulates login functionality. Provides methods to:

2. Step Definitions (Located in src/test/java/stepdefinitions)
These classes connect Gherkin scenarios to executable Java methods, allowing natural-language test steps.

RegisterSteps.java
Implements test flows for: Registration

LoginSteps.java
Implements test flows for:Login

3. Utilities (Located in src/test/java/utilities)
DriverManager.java manages the WebDriver lifecycle:
Initializes browser drivers.
Handles browser setup and teardown.

4. Hooks (Located in src/test/java/hooks)
Hooks.java
Implements @Before and @After Cucumber hooks:
Launches and closes the browser per scenario.
Ensures clean test environments.

5. Configuration Files
config.properties stores global test settings:
Browser type (e.g., Chrome).

testng.xml
Specifies TestNG test suite configurations, enabling:

Parallel execution.

Test grouping or parameterization.

6. Cucumber Feature Files
register.feature & login.feature
Describe user behavior using Gherkin syntax:
Scenarios for valid and invalid login/registration.
Scenario Outlines for Data-Driven Testing.
Easy traceability for non-technical stakeholders.
