/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Home
 */
public class Employee {
        
    private int empNo;
    private String lastName;
    private String firstName;
    private LocalDate birthday;
    private String address; // 
    private String phoneNumber; // 
    private String sssNumber;
    private String philHealthNumber; // -> changed the name
    private String tinNumber; 
    private String pagIBIGNumber; //-> chnaged the name
    private String status; // 
    private String position; // 
    private String immediateSupervisor; // 
    private int basicSalary; // 
    private int riceSubsidy; // 
    private int phoneAllowance; // 
    private int clothingAllowance; //
    private int grossSemiMonthlyRate; // 
    private double hourlyRate;
    
    
    // Constructors
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
        
     public Employee(int empNo, String lastName, String firstName, String sssNumber, String philHealthNumber, String tinNumber, String pagIBIGNumber) {
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.sssNumber = sssNumber;
        this.philHealthNumber = philHealthNumber;
        this.tinNumber = tinNumber;
        this.pagIBIGNumber = pagIBIGNumber;
    }
     
    public Employee(int empNo, String lastName, String firstName, String sssNumber, String philHealthNumber, String tinNumber, String pagIBIGNumber, double hourlyRate) {
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.sssNumber = sssNumber;
        this.philHealthNumber = philHealthNumber;
        this.tinNumber = tinNumber;
        this.pagIBIGNumber = pagIBIGNumber;
        this.hourlyRate = hourlyRate;
    }
    
    public Employee(int empNo, 
            String lastName, 
            String firstName, 
            LocalDate birthday, 
            String address, 
            String phoneNumber, 
            String sssNumber, 
            String philhealthNumber, 
            String tinNumber, 
            String pagibigNumber, 
            String status, 
            String position, 
            String immediateSupervisor,
            int basicSalary, 
            int riceSubsidy, 
            int phoneAllowance, 
            int clothingAllowance, 
            int grossSemiMonthlyRate, 
            double hourlyRate
    ) {
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philHealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagIBIGNumber = pagibigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }

    // Getter Methods
    public int getEmpNo() {return empNo;}
    public String getLastName() {return lastName;}
    public String getFirstName() {return firstName;}
    public LocalDate getBirthday() {return birthday;}
    public double getHourlyRate() {return hourlyRate;}
    public String getAddress() {return address;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getSSSNumber() {return sssNumber;}
    public String getPhilHealthNumber() {return philHealthNumber;}
    public String getTINNumber() {return tinNumber;}
    public String getPagIBIGNumber() {return pagIBIGNumber;}
    public String getStatus() {return status;}
    public String getPosition() {return position;}
    public String getImmediateSupervisor() {return immediateSupervisor;}
    public int getBasicSalary() {return basicSalary;}
    public int getRiceSubsidy() {return riceSubsidy;}
    public int getPhoneAllowance() {return phoneAllowance;}
    public int getClothingAllowance() {return clothingAllowance;}
    public int getGrossSemiMonthlyRate() {return grossSemiMonthlyRate;}
     
    //Setter Methods
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setBirthday(LocalDate birthday) {this.birthday = birthday;}
    public void setHourlyRate(double hourlyRate) {this.hourlyRate = hourlyRate;}
    public void setEmpNo(int empNo) {this.empNo = empNo;}
    public void setAddress(String address) {this.address = address;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setSSSNumber(String sssNumber) {this.sssNumber = sssNumber;}
    public void setPhilHealthNumber(String philhealthNumber) {this.philHealthNumber = philhealthNumber;}
    public void setTINNumber(String tinNumber) {this.tinNumber = tinNumber;}
    public void setPagIBIGNumber(String pagibigNumber) {this.pagIBIGNumber = pagibigNumber;}
    public void setStatus(String status) {this.status = status;}
    public void setPosition(String position) {this.position = position;}
    public void setImmediateSupervisor(String immediateSupervisor) {this.immediateSupervisor = immediateSupervisor;}
    public void setBasicSalary(int basicSalary) {this.basicSalary = basicSalary;}
    public void setRiceSubsidy(int riceSubsidy) {this.riceSubsidy = riceSubsidy;}
    public void setPhoneAllowance(int phoneAllowance) {this.phoneAllowance = phoneAllowance;}
    public void setClothingAllowance(int clothingAllowance) {this.clothingAllowance = clothingAllowance;}
    public void setGrossSemiMonthlyRate(int grossSemiMonthlyRate) {this.grossSemiMonthlyRate = grossSemiMonthlyRate;}
}