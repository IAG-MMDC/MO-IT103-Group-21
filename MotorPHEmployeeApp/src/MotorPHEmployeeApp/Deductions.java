/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPHEmployeeApp;

/**
 *
 * @author Group 21 - ComProg2 - H1101
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
    
    // Withholding Tax - Maximum Income Limit Per Tier Constants 
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

    // SSS Monthly Contribution Computation
    public static double computeSSSContribution(double grossSalary) {

        if (grossSalary < 
                SSS_LOWEST_SALARY_BRACKET) {
            
            return SSS_MIN_CONTRIBUTION; 
        }
        if (grossSalary >= 
                SSS_HIGHEST_SALARY_BRACKET) {
            
            return SSS_MAX_CONTRIBUTION;
        }

        //Start at minimum contribution and add PHP 22.50 for each PHP 500 increment. 
        double contribution = SSS_MIN_CONTRIBUTION;
        
        for (double salary = SSS_LOWEST_SALARY_BRACKET; salary <= grossSalary; salary += SSS_SALARY_INCREMENT) {
            contribution += SSS_CONTRIBUTION_INCREMENT;
        }
        return contribution;
    }

    /* PagIBIG Monthly Contribution Computation 
     * Salary Below PHP 1000            -> PHP 0 
     * Salary At Least PHP 1000 to 1500 -> 1%, Capped at PHP 100
     * Salary Over PHP 1500             -> 2%, Capped at PHP 100
     */
    public static double computePagIBIGContribution(double grossSalary) {
        
        if (grossSalary >= PAGIBIG_MIN_SALARY_THRESH && grossSalary <= PAGIBIG_MAX_SALARY_THRESH) {
            
            return Math.min(grossSalary * PAGIBIG_EMP_MIN_CONTRIBUTION_RATE, PAGIBIG_MAX_CONTRIBUTION);
            
        } else if (grossSalary > PAGIBIG_MAX_SALARY_THRESH) {
            
            return Math.min(grossSalary * PAGIBIG_EMP_MAX_CONTRIBUTION_RATE, PAGIBIG_MAX_CONTRIBUTION);
            
        } else {
            return 0;
        }
    }
    
    /* PhilHealth Monthly Contribution Computation (Employee Share)
     * Premium rate is divided by two to get employee share.
     * Salary At Or Below PHP 10000           -> PHP 150 
     * Salary Between PHP 10000 And PHP 60000 -> (Gross Salary * .03) / 2
     * Salary At Or Above PHP 60000           -> PHP 900 
     */
    public static double computePhilHealthContribution(double grossSalary) {
        
        if (grossSalary <= PHILHEALTH_MIN_MO_BASIC_SALARY) {
            return (PHILHEALTH_MIN_EMP_SHARE);
        } 
        
        if (grossSalary >= PHILHEALTH_MAX_MO_BASIC_SALARY) {
            return (PHILHEALTH_MAX_EMP_SHARE);
        } 
        
        return (grossSalary * PHILHEALTH_PREM_RATE) / 2;  
    }

    // Total Deductions Computation
    public static double computeTotalDeductions(
            double sss, 
            double philhealth, 
            double pagibig
    ) {
        return sss + philhealth + pagibig;
    }

    // Taxable Income Computation
    public static double computeTaxableIncome(
            double grossSalary, 
            double totalDeductions
    ) {
        return grossSalary - totalDeductions;
    }
    
    // Withholding tax computation based on the government-mandated deductions/contributions matrix.
    public static double computeWithholdingTax(double taxableIncome) { 

        // No withholding tax
        if (taxableIncome <= TAX_BRACKET_1_MAX) return 0;

        // 20% in excess of PHP 20,833
        else if (taxableIncome <= TAX_BRACKET_2_MAX) return (taxableIncome - 20_833) * TAX_RATE_1;

        // PHP 2,500 + 25% in excess of PHP 33,333
        else if (taxableIncome <= TAX_BRACKET_3_MAX) return (taxableIncome - 33_333) * TAX_RATE_2 + BASE_TAX_1;

        // PHP 10,833 + 30% in excess of PHP 66,667
        else if (taxableIncome <= TAX_BRACKET_4_MAX) return (taxableIncome - 66_667) * TAX_RATE_3 + BASE_TAX_2;

        // PHP 40,833.33 + 32% in excess over PHP 166,667
        else if (taxableIncome <= TAX_BRACKET_5_MAX) return (taxableIncome - 166_667) * TAX_RATE_4 + BASE_TAX_3;

        // PHP 200,833.33 + 35% in excess of 666,667
        else return (taxableIncome - 666_667) * TAX_RATE_5 + BASE_TAX_4;
    }
}
