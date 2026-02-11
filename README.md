# 🚀 Login Automation Framework – Selenium + Java

Automated testing framework for Login functionality using **Selenium WebDriver**, **TestNG**, **WebDriverManager**, and **Maven**, following clean architecture principles and industry best practices.

---

## 📖 Project Overview

This project demonstrates a professional and scalable automation testing framework designed to validate login functionality for a real-world web application.

The framework is built using:

- Page Object Model (POM)
- Base Test class architecture
- WebDriverManager for dynamic driver setup
- Clean project structure
- Explicit & Implicit waits
- Structured TestNG execution

The goal of this project is to simulate how login automation is implemented in real QA environments.

---

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- WebDriverManager
- Maven
- Allure Reports (Optional Integration)

---

## 📂 Project Structure

Login-Functionality-Automation-Selenium
│
├── src
│ ├── main
│ │ └── java
│ │ └── pages
│ │ └── LoginPage.java
│ │
│ └── test
│ └── java
│ ├── base
│ │ └── BaseTest.java
│ │
│ └── tests
│ └── LoginTest.java
│
├── pom.xml
└── testng.xml



---

## 🧱 Framework Design

### ✅ BaseTest
- Initializes WebDriver
- Handles browser setup and teardown
- Integrates WebDriverManager for automatic driver configuration
- Centralizes test environment configuration

### ✅ Page Object Model (POM)
- Separates locators and actions from test logic
- Improves maintainability
- Enhances readability
- Makes the framework scalable

### ✅ Test Classes
- Contain test scenarios only
- Implement assertions for validation
- Follow clean and structured naming conventions

---

## 🧪 Test Scenarios Covered

| Test Case | Description | Priority |
|-----------|------------|----------|
| Valid Login | Login with correct credentials | High |
| Invalid Username | Incorrect username validation | High |
| Invalid Password | Wrong password validation | High |
| Empty Username | Required field validation | Medium |
| Empty Password | Required field validation | Medium |
| Empty Fields | Login with empty username & password | Medium |

---

## ⚙️ Setup & Installation

### 1️⃣ Clone Repository

```bash
git clone https://github.com/MaHmOuD11997/Login-Functionality-Automation-Selenium.git
2️⃣ Open Project

Open the project using:

IntelliJ IDEA

Eclipse

Import it as a Maven Project.

3️⃣ Install Dependencies

Maven will automatically download required dependencies.

Or run manually: mvn clean install
▶️ How to Run Tests
Run using Maven:mvn test

Run using TestNG:

Open testng.xml

Right-click → Run

📊 Reports 

If Allure is configured: allure serve allure-results

💡 Key Features

✔ Clean & scalable automation framework
✔ Real-world login validation scenarios
✔ Separation of concerns
✔ Maintainable architecture
✔ Professional project structure
✔ Easily extendable for regression testing

👨‍💻 Author

Mahmoud Hadiha
Software Quality Assurance Engineer
Automation Testing Specialist

🔗 GitHub: https://github.com/MaHmOuD11997

🎯 Future Improvements

Implement Data-Driven Testing (TestNG DataProvider)

Integrate CI/CD (GitHub Actions)

Add Cross-browser testing support

Capture screenshots on failure

Add logging framework (Log4j / SLF4J)

Dockerize test execution
