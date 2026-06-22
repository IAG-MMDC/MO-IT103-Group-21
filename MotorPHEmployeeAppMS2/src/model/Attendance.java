/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Home
 */
public class Attendance {
    
    int empNo;
    LocalDate date;
    LocalTime logIn;
    LocalTime logOut;
    
    public Attendance(int empNo, LocalDate date, LocalTime logIn, LocalTime logOut) {
        this.empNo = empNo;
        this.date = date;
        this.logIn = logIn;
        this.logOut = logOut;
    }
    
    // Getter Methods
    public int getEmpNo() {return empNo;}
    public LocalDate getDate() {return date;}
    public LocalTime getLogIn() {return logIn;}
    public LocalTime getLogOut() {return logOut;}
    
    // Setter Methods
    public void setDate(LocalDate date) {this.date = date;}
    public void setLogIn(LocalTime logIn) {this.logIn = logIn;}
    public void setLogOut(LocalTime logOut) {this.logOut = logOut;}
}