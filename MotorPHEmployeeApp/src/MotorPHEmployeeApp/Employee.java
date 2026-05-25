/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPHEmployeeApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Group 21 - ComProg2 - H1101
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

    // Getter Methods 
    public int getEmpNo() {return empNo;}
    public String getLastName() {return lastName;}
    public String getFirstName() {return firstName;}
    public LocalDate getBirthday() {return birthday;}
    public double getHourlyRate() {return hourlyRate;}

    // Setter Methods
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setBirthday(LocalDate birthday) {this.birthday = birthday;}
    public void setHourlyRate(double hourlyRate) {this.hourlyRate = hourlyRate;}
}
