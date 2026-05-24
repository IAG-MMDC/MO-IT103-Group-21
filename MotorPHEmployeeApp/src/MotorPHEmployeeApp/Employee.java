/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPHEmployeeApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Home
 */
public class Employee {
    
    private int empNo;
    private String lastName;
    private String firstName;
    private LocalDate birthday;
    private double hourlyRate;

    public Employee(int empNo, String lastName, String firstName, LocalDate birthday) {
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
    }

    public Employee(int empNo, String lastName, String firstName, LocalDate birthday, double hourlyRate) {
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.hourlyRate = hourlyRate;
    }

    public int getEmpNo() {return empNo;}
    
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    
    public LocalDate getBirthday() {return birthday;}
    public void setBirthday(LocalDate birthday) {this.birthday = birthday;}

    public double getHourlyRate() {return hourlyRate;}
    public void setHourlyRate(double hourlyRate) {this.hourlyRate = hourlyRate;}
    
    
    public String displayEmployeeInfo() {
        
        DateTimeFormatter birthdayFmt = DateTimeFormatter.ofPattern("MM//dd//yyyy");
        
        return """
            ======== EMPLOYEE DETAILS ========

            Employee Number    : %d
            Employee Name      : %s, %s
            Birthday           : %s
            Hourly Rate        : %.2f

            ===================================
            """
            .formatted(
                    empNo,
                    lastName,
                    firstName,
                    birthday.format(birthdayFmt),
                    hourlyRate
            );
    }
}
