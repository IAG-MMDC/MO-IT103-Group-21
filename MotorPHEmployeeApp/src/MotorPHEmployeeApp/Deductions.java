/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPHEmployeeApp;

/**
 *
 * @author Home
 */
public class Deductions {
    
    // Compute SSS Contribution Constants
    private static final int SSS_MIN_CONTRIBUTION = 135;
    public static final int SSS_MAX_CONTRIBUTION = 1125;
    public static final int SSS_LOWEST_SALARY_BRACKET = 3250;
    public static final int SSS_HIGHEST_SALARY_BRACKET = 24750;
    public static final int SSS_SALARY_INCREMENT = 500;
    public static final double SSS_CONTRIBUTION_INCREMENT = 22.50;

    // Compute PagIBIG Contribution Constants
    static final int PAGIBIG_MAX_CONTRIBUTION = 100;
    static final double PAGIBIG_EMP_MIN_CONTRIBUTION_RATE = .01;
    static final double PAGIBIG_EMP_MAX_CONTRIBUTION_RATE = .02;
    static final int PAGIBIG_MIN_SALARY_THRESH = 1000;
    static final int PAGIBIG_MAX_SALARY_THRESH = 1500;

    // Compute PhilHealth Contribution Constants 
    static final double PHILHEALTH_PREM_RATE = 0.03;
    static final int PHILHEALTH_MIN_MO_BASIC_SALARY = 10_000;
    static final int PHILHEALTH_MAX_MO_BASIC_SALARY = 60_000;
    static final double PHILHEALTH_MIN_EMP_SHARE = 150.00;
    static final double PHILHEALTH_MAX_EMP_SHARE = 900.00;
    
    // Withholding Tax - Monthly Rate Constants 
    static final int TAX_BRACKET_1_MAX = 20_832;
    static final int TAX_BRACKET_2_MAX = 33_332;
    static final int TAX_BRACKET_3_MAX = 66_666;
    static final int TAX_BRACKET_4_MAX = 166_666;
    static final int TAX_BRACKET_5_MAX = 666_666;
    
    // Withholding Tax - Marginal Tax Rate Constants
    static final double TAX_RATE_1 = 0.20;
    static final double TAX_RATE_2 = 0.25;
    static final double TAX_RATE_3 = 0.30;
    static final double TAX_RATE_4 = 0.32;
    static final double TAX_RATE_5 = 0.35;
    
    // Withholding Tax - Base Tax Constants
    static final int BASE_TAX_1 = 2500;
    static final int BASE_TAX_2 = 10833;
    static final double BASE_TAX_3 = 40833.33;
    static final double BASE_TAX_4 = 200833.33;

    public static double computeSSSContribution(double grossMonthlySalary) {

        if (grossMonthlySalary < 
                SSS_LOWEST_SALARY_BRACKET) {
            
            return SSS_MIN_CONTRIBUTION; 
        }
        if (grossMonthlySalary >= 
                SSS_HIGHEST_SALARY_BRACKET) {
            
            return SSS_MAX_CONTRIBUTION;
        }

        //Start at minimum contribution and add PHP 22.50 for each PHP 500 increment. 
        double contribution = SSS_MIN_CONTRIBUTION;
        
        for (double salary = SSS_LOWEST_SALARY_BRACKET; salary <= grossMonthlySalary; salary += SSS_SALARY_INCREMENT) {
            contribution += SSS_CONTRIBUTION_INCREMENT;
        }
        return contribution;
    }

    /*
    
    */
    public static double computePagIBIGContribution(double grossMonthlySalary) {
        
        if (grossMonthlySalary >= PAGIBIG_MIN_SALARY_THRESH && grossMonthlySalary <= PAGIBIG_MAX_SALARY_THRESH) {
            
            return Math.min(grossMonthlySalary * PAGIBIG_EMP_MIN_CONTRIBUTION_RATE, PAGIBIG_MAX_CONTRIBUTION);
            
        } else if (grossMonthlySalary > PAGIBIG_MAX_SALARY_THRESH) {
            
            return Math.min(grossMonthlySalary * PAGIBIG_EMP_MAX_CONTRIBUTION_RATE, PAGIBIG_MAX_CONTRIBUTION);
            
        } else {
            return 0;
        }
    }
    
    /*
    
    */
    public static double computePhilHealthContribution(double grossMonthlySalary) {
        
        if (grossMonthlySalary <= PHILHEALTH_MIN_MO_BASIC_SALARY) {
            return (PHILHEALTH_MIN_EMP_SHARE);
        } 
        
        if (grossMonthlySalary >= PHILHEALTH_MAX_MO_BASIC_SALARY) {
            return (PHILHEALTH_MAX_EMP_SHARE);
        } 
        
        return (grossMonthlySalary * PHILHEALTH_PREM_RATE) / 2;  
    }

    
    public static double computeTotalDeductions(
            double sss, 
            double philhealth, 
            double pagibig
    ) {
        return sss + philhealth + pagibig;
    }

    
    public static double computeTaxableIncome(
            double grossMonthlySalary, 
            double totalDeductions
    ) {
        return grossMonthlySalary - totalDeductions;
    }
    
    
    public static double computeWithholdingTax(double taxableIncome) { 
        
        if (taxableIncome <= TAX_BRACKET_1_MAX) return 0;
        
        else if (taxableIncome <= TAX_BRACKET_2_MAX) return (taxableIncome - 20_833) * TAX_RATE_1;
        
        else if (taxableIncome <= TAX_BRACKET_3_MAX) return (taxableIncome - 33_333) * TAX_RATE_2 + BASE_TAX_1;
        
        else if (taxableIncome <= TAX_BRACKET_4_MAX) return (taxableIncome - 66_667) * TAX_RATE_3 + BASE_TAX_2;
        
        else if (taxableIncome <= TAX_BRACKET_5_MAX) return (taxableIncome - 166_667) * TAX_RATE_4 + BASE_TAX_3;
        
        else return (taxableIncome - 666_667) * TAX_RATE_5 + BASE_TAX_4;
    }
}
