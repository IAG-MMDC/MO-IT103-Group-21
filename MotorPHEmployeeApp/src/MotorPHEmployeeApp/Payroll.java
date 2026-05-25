/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPHEmployeeApp;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

/**
 *
 * @author Group21 - H1101
 */
public class Payroll {
      
    private static final int MAX_WORKING_MINS = 540;
    private static final int LUNCH_BREAK_MINS = 60;
    private static final int MINS_PER_HOUR = 60;

    // Compute Hours Worked
    public double computeHoursWorked(
            LocalTime login, 
            LocalTime logout) {
                
        LocalTime graceLimit = LocalTime.of(8, 10);                   
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(17, 0);
                    
        // No overtime
        if (logout.isAfter(endTime)) {logout = endTime;}

        // Grace period
        if (!login.isAfter(graceLimit)) {login = startTime;}
                
        long lateMinutes = Math.max(0, Duration.between(startTime, login).toMinutes());
                    
        long minutesWorked = Math.min(Duration.between(login, logout).toMinutes(), MAX_WORKING_MINS - lateMinutes);

        // Lunch deduction
        if (minutesWorked > 60) {
            
            minutesWorked -= LUNCH_BREAK_MINS;

        } else {
            
            minutesWorked = 0;
            
        }

        return (double) minutesWorked / MINS_PER_HOUR;
                    
        }

    // Generate Payslip
    public String generatePayslip(
                Employee employee,
                List<Attendance> attendanceList,
                int month,
                String payCoverageOption) {

        double totalHoursWorked = 0;

            // Filter Attendance
        for (Attendance attendance : attendanceList) {
  
            // Match employee
            if (attendance.getEmpNo() != employee.getEmpNo()) continue;
    
            // Match year
            if (attendance.getDate().getYear() != 2024) continue;

            // Match month
            if (attendance.getDate().getMonthValue()!= month) continue;

                int day = attendance.getDate().getDayOfMonth();
                        
                // First cutoff
                if (payCoverageOption.equals("1 - 15")) {
                        
                    if (day > 15) continue;
                    
                } // Second cutoff
                else if (payCoverageOption.equals("16 - 30/31")) {

                    if (day <= 15) continue;
                        
                }

                totalHoursWorked
                        += computeHoursWorked(
                                attendance.getLogIn(),
                                attendance.getLogOut());
            }

            //
            if (totalHoursWorked == 0) {

                return "No attendance records found " + "for selected pay coverage.";
            }

            // Gross Salary
            double grossSalary = totalHoursWorked * employee.getHourlyRate();

            double sss = 0;
            double philHealth = 0;
            double pagIbig = 0;
            double withholdingTax = 0;
            double totalDeductions = 0;
            double netSalary = grossSalary;

            // Whole Month Deductions
            if (payCoverageOption.equals("1 - 30/31")) {

                sss = Deductions.computeSSSContribution(grossSalary);
                philHealth = Deductions.computePhilHealthContribution(grossSalary);
                pagIbig = Deductions.computePagIBIGContribution(grossSalary);
                       
                totalDeductions = Deductions.computeTotalDeductions(                      
                            sss,
                            pagIbig,
                            philHealth);

                double taxableIncome = Deductions.computeTaxableIncome(
                            grossSalary,
                            totalDeductions);

                withholdingTax = Deductions.computeWithholdingTax(
                            taxableIncome);

                netSalary = taxableIncome - withholdingTax;
                        
                        
            }

            // Pay Coverage Text
            Month monthName = Month.of(month);
         
            String payCoverage;

            if (payCoverageOption.equals("1 - 15")) {
               
                payCoverage  = monthName + " 1 - 15";
                    
            } else if (payCoverageOption.equals("16 - 30/31")) {
                    
                int endDay = YearMonth.of(2024, month).lengthOfMonth();
                        
                payCoverage = monthName + " 16 - " + endDay;
                        
            } else {
                
                int endDay = YearMonth.of(2024, month).lengthOfMonth();

                payCoverage = monthName + " 1 - " + endDay;
                        
                        
            }

            // Return Payslip
            return  """
                    ======== MOTORPH PAYSLIP ========
                    
                    Employee Number : %d
                    Employee Name   : %s %s
                    Pay Coverage    : %s
                    Hours Worked    : %.2f
                    Hourly Rate     : %.2f
                    Gross Salary    : %.2f
                    
                    ========== DEDUCTIONS ==========
                    
                    SSS             : %.2f
                    PhilHealth      : %.2f
                    Pag-IBIG        : %.2f
                    Tax             : %.2f
                    Total Deductions: %.2f
                    
                    NET SALARY      : %.2f
                    """
                        .formatted(
                            employee.getEmpNo(),
                            employee.getFirstName(),
                            employee.getLastName(),
                            payCoverage,
                            totalHoursWorked,
                            employee.getHourlyRate(),
                            grossSalary,
                            sss,
                            philHealth,
                            pagIbig,
                            withholdingTax,
                            totalDeductions,
                            netSalary
                        );
        }
}
