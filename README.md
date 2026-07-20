# Team Details

- Jam Rosales
- Isabelle Gallardo
- Kristel Austria

---

# MotorPH Employee App

## Project Overview

The MotorPH Employee App is a Java desktop application developed using Java Swing and Apache NetBeans. The system provides a file-based employee management and payroll processing solution for MotorPH. Employee and attendance information is stored using CSV files, eliminating the need for a database while allowing efficient management of employee records and payroll information.

The application supports employee management, payroll processing, payroll summary generation, and payroll summary export to CSV.

---

# Installation and Setup

## Prerequisites

Before running the application, ensure the following software is installed:

- Java Development Kit (JDK) 23 or later
- Apache NetBeans IDE 24 (or any IDE that supports Maven projects)
- Git (optional)

## Clone the Repository

```bash
git clone https://github.com/IAG-MMDC/MO-IT103-Group-21.git
```

Or download the repository as a ZIP file and extract it.

## Open the Project

1. Open **Apache NetBeans IDE**.
2. Select **File > Open Project**.
3. Open the folder named **MotorPHEmployeeApp_TA_Final.zip**.
4. Wait for NetBeans/Maven to load the project dependencies (if prompted).
5. Once the project loads successfully, it is ready to run.

## Run the Application

1. Right-click **MotorPHEmployeeApp_Final_v1** in the Projects window.
2. Select **Run** (or press **F6**).
3. The login window will appear.

---

# Login Credentials

The application provides two user roles.

## Payroll Staff

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

## Employee

Use this account to access employee information and payroll details.

**Username**

```text
employee
```

**Password**

```text
12345
```

---

# Application Modules

## Payroll Staff

### Employee Management

- View employee records
- Add employee records
- Update employee information
- Delete employee records
- Search employees by Employee Number
- Validate employee information
- Prevent duplicate Employee Numbers

### Payroll Processing

- Search employee records
- Process payroll for an individual employee
- Process payroll for all employees
- Calculate government deductions
- Generate payroll results

### Payroll Summary

- Display payroll statistics
- Display total employees processed
- Display total gross pay
- Display total deductions
- Display average net pay
- Export payroll summary to CSV

---

## Employee

Employees can:

- View personal information
- View payroll details
- Log out of the application

---

# CSV Files

The application uses CSV files as its primary data storage.

The system reads employee and attendance information from CSV files included with the project.

The application can also generate:

- Payroll Summary CSV

---

# Notes

- This application uses CSV files and does not require a database.
- Do not rename or delete the CSV files while the application is running.
- Close spreadsheet applications (such as Microsoft Excel or WPS Office) before editing or exporting CSV files to avoid file access conflicts.

---

# Input Validation

The application validates:

- Required fields
- Employee Number
- Duplicate Employee Number
- Birthday format
- Phone Number
- Government ID numbers
- Numeric salary fields

---

# Output

The application generates:

- Employee Directory
- Payroll Results
- Payroll Summary
- Payroll Summary CSV

---

# Features

## User Authentication

- User login
- Dashboard navigation
- Logout functionality

## Employee Management

- View employee records
- Add employee records
- Update employee records
- Delete employee records
- Search employee by Employee Number
- Input validation
- Duplicate Employee Number checking

## Payroll Processing

- Calculate hours worked
- Compute Gross Salary
- Compute SSS Contribution
- Compute PhilHealth Contribution
- Compute Pag-IBIG Contribution
- Compute Withholding Tax
- Compute Total Deductions

## Payroll Summary

- Display total employees processed
- Display total gross pay
- Display total deductions
- Display average net pay
- Export payroll summary to CSV

---

# Technologies Used

- Java
- Java Swing
- Apache NetBeans IDE
- Maven
- CSV File Handling
- Git
- GitHub

---

# Programming Concepts

- Object-Oriented Programming (OOP)
- MVC-inspired package organization (Model, Service, View)
- File-Based Data Management
- Input Validation
- Exception Handling

---

# Future Improvements

- MySQL database integration
- Enhanced role-based access control
- Attendance management module
- PDF payroll reports
- Analytics dashboard

---

# Repository

GitHub Repository:

https://github.com/IAG-MMDC/MO-IT103-Group-21

---

# Authors

**Group 21**

- Jam Rosales
- Isabelle Gallardo
- Kristel Austria

Bachelor of Science in Information Technology

MotorPH Employee App
