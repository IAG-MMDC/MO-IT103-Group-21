# Team Details:

Jam Rosales

Isabelle Gallardo

Kristel Austria

# Program Details:

MotorPH Employee App

Project Overview

The MotorPH Employee App is a Java desktop application developed using Java Swing in NetBeans. It provides a file-based employee management and payroll processing system for MotorPH. Employee and attendance records are stored in CSV files, allowing the application to manage data without requiring a database.

The project was developed as part of the MotorPH Payroll System activities and includes employee record management, payroll computation, payroll summary generation, and CSV export functionality.

---

Features

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

Technologies Used

- Java
- Java Swing
- NetBeans IDE
- CSV File Handling
- Object-Oriented Programming (OOP)

---

Project Structure


---

How to Run

1. Open the project in NetBeans.
2. Ensure the CSV files are located inside the `resources` folder.
3. Build the project.
4. Run `Main.java`.
5. Log in using the configured credentials.
6. Navigate through the application using the dashboard.

---

CSV Files

The application uses CSV files for persistent storage.

Employee File

Contains:

- Employee Number
- Employee Information
- Position
- Salary Information
- Government IDs

Attendance File

Contains:

- Employee Number
- Date
- Time In
- Time Out

---

Payroll Computation

The application computes:

Gross Salary

= Hours Worked × Hourly Rate

Total Deductions

= SSS + PhilHealth + Pag-IBIG + Withholding Tax

Net Salary

= Gross Salary − Total Deductions

---

Input Validation

The application validates:

- Required fields
- Numeric salary fields
- Employee Number
- Birthday format
- Phone Number
- Government IDs
- Duplicate Employee Number

---
Output

The application generates:

- Employee Directory
- Employee Payslip
- Payroll Summary
- Payroll Summary CSV

---

Future Improvements

- Database integration (MySQL)
- User role management
- Attendance management module
- PDF payslip generation
- Reports and analytics dashboard

---

Author

Developed by: Group 21

Bachelor of Science in Information Technology

MotorPH Payroll System Project

