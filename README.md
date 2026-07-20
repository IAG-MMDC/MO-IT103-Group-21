# Team Details:

Jam Rosales

Isabelle Gallardo

Kristel Austria

# Program Details:

MotorPH Employee App

## Project Overview

The MotorPH Employee App is a Java desktop application developed using Java Swing in NetBeans. It provides a file-based employee management and payroll processing system for MotorPH. Employee and attendance records are stored in CSV files, allowing the application to manage data without requiring a database.

The project was developed as part of the MotorPH Payroll System activities and includes employee record management, payroll computation, payroll summary generation, and CSV export functionality.

---

## Installation and Setup

### Prerequisites

Before running the application, make sure you have the following installed:

- Java Development Kit (JDK) 23 or later
- Apache NetBeans IDE 24 (or any IDE that supports Maven projects)
- Git (optional, for cloning the repository)

### Clone the Repository

```bash
git clone https://github.com/<your-username>/MotorPHEmployeeApp.git
```

Or download the project as a ZIP file and extract it.

### Open the Project

1. Open **Apache NetBeans IDE**.
2. Select **File > Open Project**.
3. Browse to the extracted **MotorPHEmployeeApp** folder.
4. Click **Open Project**.
5. Wait for Maven to download the required dependencies (if prompted).

### Run the Application

1. Right-click the project.
2. Select **Run** (or press **F6**).
3. The login window will appear.

---

## Login Credentials

The application provides two user roles.

### Payroll Staff

Use this account to access employee management, payroll processing, and payroll summary features.

**Username**

```text
payroll_staff
```

**Password**

```text
12345
```

---

### Employee

Use this account to access the employee dashboard and view payroll information.

**Username**

```text
employee
```

**Password**

```text
12345
```

---

## Application Modules

### Payroll Staff

After logging in as **Payroll Staff**, you can access:

- Employee Management
  - View employee records
  - Add employees
  - Update employee information
  - Delete employee records
  - Search employees
- Payroll Processing
  - Generate employee payslips
  - Calculate salary and deductions
- Payroll Summary
  - Generate payroll statistics
  - Export payroll summary to CSV

### Employee

After logging in as an **Employee**, you can:

- View employee information
- View payroll details
- Generate and view payslips
- Log out of the application

---

## CSV Files

This application uses CSV files for data storage.

The required files are located in the project's **resources** directory.

- Employee Details CSV
- Attendance Record CSV

Payroll summaries can also be exported as:

- Payroll_Summary.csv

---

## Notes

- This application is file-based and does not require a database.
- Ensure the CSV files remain in the project's resources folder.
- Do not rename or remove the CSV files while the application is running.
- Close any spreadsheet application (such as Excel or WPS Office) before modifying or exporting CSV files to avoid file access errors.
---

## Input Validation

The application validates:

- Required fields
- Numeric salary fields
- Employee Number
- Birthday format
- Phone Number
- Government IDs
- Duplicate Employee Number

---
## Output

The application generates:

- Employee Directory
- Employee Payslip
- Payroll Summary
- Payroll Summary CSV

---

## Features

User Authentication
- User login
- Dashboard navigation
- Logout functionality

Employee Management
- View employee records
- Add new employees
- Update employee information
- Delete employee records
- Search employee by Employee Number
- Input validation
- Duplicate Employee Number checking

Payroll Processing
- Calculate hours worked
- Compute Gross Salary
- Compute SSS Contribution
- Compute PhilHealth Contribution
- Compute Pag-IBIG Contribution
- Compute Withholding Tax
- Compute Total Deductions
- Generate Employee Payslip

Payroll Summary
- Display total number of employees
- Display total gross pay
- Display total deductions
- Display average net pay
- Export payroll summary to CSV

---

## Technologies Used

- Java
- Java Swing
- Apache NetBeans IDE
- Maven
- CSV File Handling
- Git & GitHub

---

## Programming Concepts

- Object-Oriented Programming (OOP)
- File-Based Data Management
- MVC-inspired package organization (Model, Service, View)
- Input Validation

---

## Future Improvements

- Database integration (MySQL)
- User role management
- Attendance management module
- PDF payslip generation
- Reports and analytics dashboard

---

## Author

Developed by: Group 21

Bachelor of Science in Information Technology

MotorPH Payroll System Project

