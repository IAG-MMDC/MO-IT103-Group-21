/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

/**
 *
 * @author Home
 */
public class EmployeeDataHandler {
    
    private static final String EMP_CSV = "resources/MotorPH_Employee Data - Employee Details.csv";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // moved it here 

    private static int parseIntValue(String value) {
        return Integer.parseInt(
                value.replace(",", "").trim());
    }

    private static double parseDoubleValue(String value) {
        return Double.parseDouble(
                value.replace(",", "").trim());
    }

    private static String csv(String value) {

        if (value == null) {
            return "";
        }

        value = value.replace("\"", "\"\"");

        return "\"" + value + "\"";
    }

    // Read Employees
    public static List<Employee> readEmployees() {

        List<Employee> employees = new ArrayList<>();

        // Read Employee Details CSV
        try (BufferedReader br = new BufferedReader(new FileReader(EMP_CSV))) {

            br.readLine();
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.trim().isEmpty()) {
                    continue;
                }

                List<String> data = CSVParser.parseCSVLine(currentLine);
                

                if (data.size() != 19) {
                    throw new IllegalArgumentException("Invalid employee record: expected 19 columns but got " + data.size()); 
                }

                int empNo = parseIntValue(data.get(0));
                String lastName = data.get(1);
                String firstName = data.get(2);
                //LocalDate birthday = LocalDate.parse(data.get(3));
                LocalDate birthday = LocalDate.parse(data.get(3), DATE_FORMAT);
                
                String address = data.get(4);
                String phoneNumber = data.get(5);
                String sssNumber = data.get(6);
                String philhealthNumber = data.get(7);
                String tinNumber = data.get(8);
                String pagibigNumber = data.get(9);
                String status = data.get(10);
                String position = data.get(11);
                String immediateSupervisor = data.get(12);
                int basicSalary = parseIntValue(data.get(13));
                int riceSubsidy = parseIntValue(data.get(14));
                int phoneAllowance = parseIntValue(data.get(15));
                int clothingAllowance = parseIntValue(data.get(16));
                int grossSemiMonthlyRate = parseIntValue(data.get(17));
                double hourlyRate = parseDoubleValue(data.get(18));

                Employee employee
                        = new Employee(empNo,
                                lastName,
                                firstName,
                                birthday,
                                address,
                                phoneNumber,
                                sssNumber,
                                philhealthNumber,
                                tinNumber,
                                pagibigNumber,
                                status,
                                position,
                                immediateSupervisor,
                                basicSalary,
                                riceSubsidy,
                                phoneAllowance,
                                clothingAllowance,
                                grossSemiMonthlyRate,
                                hourlyRate);

                // Stores Employee Details CSV
                employees.add(employee);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error reading date.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to read employee file.",
                    e);
        }

        return employees;
    }

    // Overwrite Employees
    public static void writeEmployees(List<Employee> employees) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(EMP_CSV))) {

            bw.write("Employee #,"
                    + "Last Name,"
                    + "First Name,"
                    + "Birthday, "
                    + "Address,"
                    + "Phone Number,"
                    + "SSS #,"
                    + "PhilHealth #,"
                    + "TIN #,"
                    + "PagIBIG #,"
                    + "Status,"
                    + "Position,"
                    + "Immediate Supervisor,"
                    + "Basic Salary,"
                    + "Rice Subsidy,"
                    + "Phone Allowance,"
                    + "Clothing Allowance,"
                    + "Gross Semi-Monthly Rate,"
                    + "Hourly Rate");

            bw.newLine();
            
            for (Employee e : employees) {

                bw.write(e.getEmpNo() + ","
                        + csv(e.getLastName()) + ","
                        + csv(e.getFirstName()) + ","
                        + e.getBirthday().format(DATE_FORMAT) + ","                       
                        + csv(e.getAddress()) + ","
                        + csv(e.getPhoneNumber()) + ","
                        + csv(e.getSSSNumber()) + ","
                        + csv(e.getPhilHealthNumber()) + ","
                        + csv(e.getTINNumber()) + ","
                        + csv(e.getPagIBIGNumber()) + ","
                        + csv(e.getStatus()) + ","
                        + csv(e.getPosition()) + ","
                        + csv(e.getImmediateSupervisor()) + ","
                        + e.getBasicSalary() + ","
                        + e.getRiceSubsidy() + ","
                        + e.getPhoneAllowance() + ","
                        + e.getClothingAllowance() + ","
                        + e.getGrossSemiMonthlyRate() + ","
                        + e.getHourlyRate()
                );
                bw.newLine();
            }
        } catch (IOException e) {
            //System.out.println("Error writing employee details.");
            //e.printStackTrace();
            throw new RuntimeException(
                    "Unable to write employee file.", 
                    e);
        }
    }

    // Add Employee
    public static void addEmployee(Employee newEmployee) {

        List<Employee> employees = readEmployees();
        
        //added
        for(Employee e : employees) {
            if(e.getEmpNo() == newEmployee.getEmpNo()) {
                throw new IllegalArgumentException(
                        "Employee Number " +
                         newEmployee.getEmpNo() +
                        " already exists.");
            }
            if(newEmployee.getEmpNo() <= 0) {
                throw new IllegalArgumentException(
                        "Employee Number must be greater than zero");
            }
        }
                
        employees.add(newEmployee);
        writeEmployees(employees);
    }

    // Update Employee
    public static void updateEmployee(
            int empNo,
            String newLastName,
            String newFirstName,
            LocalDate newBirthday, //
            String newAddress, //
            String newPhoneNumber, //
            String newSSSNumber,
            String newPhilHealthNumber,
            String newTINNumber,
            String newPagIBIGNumber,
            String newStatus, //
            String newPosition, //
            String newImmediateSupervisor, //
            int newBasicSalary,
            int newRiceSubsidy, //
            int newPhoneAllowance, // 
            int newClothingAllowance, //
            int newGrossSemiMonthlyRate,//
            double newHourlyRate
    ) {

        List<Employee> employees = readEmployees();
        //added
        boolean found = false;

        for (Employee e : employees) {
            //added
            

            if (e.getEmpNo() == empNo) {
                
                found = true;
                
                e.setLastName(newLastName);
                e.setFirstName(newFirstName);
                e.setBirthday(newBirthday);//
                e.setAddress(newAddress);
                e.setPhoneNumber(newPhoneNumber);
                e.setSSSNumber(newSSSNumber);
                e.setPhilHealthNumber(newPhilHealthNumber);
                e.setTINNumber(newTINNumber);
                e.setPagIBIGNumber(newPagIBIGNumber);
                e.setStatus(newStatus);
                e.setPosition(newPosition);
                e.setImmediateSupervisor(newImmediateSupervisor);
                e.setBasicSalary(newBasicSalary);
                e.setRiceSubsidy(newRiceSubsidy);
                e.setPhoneAllowance(newPhoneAllowance);
                e.setClothingAllowance(newClothingAllowance);
                e.setGrossSemiMonthlyRate(newGrossSemiMonthlyRate);
                e.setHourlyRate(newHourlyRate);
                
                break;
            }
        }
        //added
        if(!found) {
            throw new IllegalArgumentException("Employee number " + empNo + " does not exist.");
        }
        
        writeEmployees(employees);
        
        System.out.println("Employee" + empNo);
    }

    // Delete Employee
    public static void deleteEmployee(int empNo) {

        List<Employee> employees = readEmployees();
        //added
        boolean removed = employees.removeIf(e -> e.getEmpNo() == empNo);
        //added
        if(!removed) {
            throw new IllegalArgumentException("Employee Number " + empNo + " does not exist." );
        }

        writeEmployees(employees);
    }
    
    // Find Employee 
    public static Employee findEmpNo(int empNo) {
        
        List<Employee> employees = readEmployees();
        
        for (Employee e : employees) {
            if(e.getEmpNo() == empNo) {
                return e;
            }
        }
        
        return null;
    }
}
