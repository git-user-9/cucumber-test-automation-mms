# Regression Testing Suite for NOVA Marks Management System

[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](LICENSE)

A robust automated regression testing framework developed for the **NOVA Marks Management Website**. This project utilizes **Selenium WebDriver** for browser automation and **Cucumber** for Behavior-Driven Development (BDD), ensuring that new code changes do not negatively impact existing functionalities.

## 📋 Table of Contents

- [Project Overview](#-project-overview)
- [Features Tested](#-features-tested)
- [Technologies Used](#-technologies-used)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [Project Structure](#-project-structure)
- [Running the Tests](#-running-the-tests)
- [Test Reports](#-test-reports)
- [Contributors](#-contributors)
- [License](#-license)

## Project Overview

The primary goal of this project is to automate the verification process of the NOVA Marks Management System. By implementing regression testing, we ensure stability across various modules such as user authentication, student/faculty management, and administrative dashboards.

The framework uses **Gherkin syntax** (Given-When-Then) to make test scenarios readable for both technical and non-technical stakeholders.

## Features Tested

The following functionalities of the NOVA website are covered by this test suite:

1.  **Site Accessibility**
    *   Verifies the application is up and reachable.
2.  **Authentication**
    *   Login: Valid & Invalid credentials.
    *   Logout: Functional verification.
    *   Password Management: Change Password / Forgot Password workflows.
3.  **Admin Operations**
    *   Making Announcements.
    *   Generating Analytics Reports.
4.  **User Management**
    *   Add Student.
    *   Add Faculty.
5.  **Academic Operations**
    *   Conduct Exams.
    *   Issue Creation (Student).

## Technologies Used

*   **Programming Language**: Java
*   **Automation Tool**: Selenium WebDriver (v4.14.1)
*   **BDD Framework**: Cucumber (v7.14.0)
*   **Testing Framework**: JUnit 5
*   **Build Management**: Maven

## ⚙️ Prerequisites

Before running the tests, ensure you have the following installed:

*   **Java Development Kit (JDK)**: Version 8 or higher.
*   **Maven**: For dependency management.
*   **Browser Driver**: ChromeDriver (compatible with your installed Chrome version) or EdgeDriver.
*   **IDE**: Eclipse (with Cucumber plugin) or IntelliJ IDEA.

## Installation & Setup

1.  **Clone the Repository**

    ```bash
    git clone https://github.com/git-user-9/CucumberTestingSPM.git
    cd CucumberTestingSPM
    ```

2.  **Install Dependencies**

    Navigate to the project root directory (where `pom.xml` is located) and run:

    ```bash
    mvn clean install
    ```

3.  **WebDriver Configuration**

    *   Download the chromedriver matching your browser version.
    *   Place the driver in `src/test/resources/drivers/` or update the system property path in your test code configuration.

## 📂 Project Structure

```text
├── src
│   ├── main
│   │   └── java
│   └── test
│       ├── java
│       │   └── StepDefinitions  # Java logic mapping to Gherkin steps
│       │       ├── Login.java
│       │       ├── OpenSite.java
│       │       ├── TestRunner.java
│       │       └── ...
│       └── resources
│           ├── features         # .feature files (Gherkin Scenarios)
│           │   ├── Login.feature
│           │   ├── Analytics.feature
│           │   └── ...
│           └── drivers          # WebDriver executables
├── pom.xml                      # Maven dependencies
├── README.md
└── LICENSE
```

## Running the Tests

### Option 1: Using Maven (Command Line)

To run all tests via the command line:

```bash
mvn test
```

### Option 2: Using JUnit Test Runner (IDE)

1.  Open the project in your IDE.
2.  Navigate to `src/test/java/StepDefinitions/TestRunner.java`.
3.  Right-click the file and select **Run As > JUnit Test**.

**Sample `TestRunner.java` Configuration:**

```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "StepDefinitions",
    plugin = {"pretty", "json:target/cucumber-reports/CucumberTestReport.json", "html:target/cucumber-reports/CucumberTestReport.html"}
)
public class TestRunner {
}
```

## 📊 Test Reports

After execution, Cucumber generates a readable HTML report indicating the status of test scenarios (Passed/Failed).

*   **Location**: `target/cucumber-reports/CucumberTestReport.html`

Open this file in any web browser to view detailed execution logs and screenshots (if configured).

## 📄 License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.
