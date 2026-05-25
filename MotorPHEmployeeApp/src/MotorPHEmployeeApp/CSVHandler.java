/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPHEmployeeApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class CSVHandler {
    
    private static final String EMP_CSV = "resources/MotorPH_Employee Data - Employee Details.csv";
    private static final String ATT_CSV = "resources/MotorPH_Employee Data - Attendance Record.csv";

    public static List<Employee> readEmployeeFile() {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        List<Employee> employeeList = new ArrayList<>();

        // Read Employee Details CSV
        try (BufferedReader br = new BufferedReader(new FileReader(EMP_CSV))) {

            br.readLine();
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.trim().isEmpty()) {
                    continue;
                }

                String[] data = currentLine.split(",");

                int empNo = Integer.parseInt(data[0]);
                String lastName = (data[1].trim());
                String firstName = (data[2].trim());
                LocalDate birthday = LocalDate.parse(data[3].trim(), dateFormat);
                double hourlyRate = (Double.parseDouble(data[data.length - 1]));

                Employee employeeRecord = new Employee(empNo,
                        lastName,
                        firstName,
                        birthday,
                        hourlyRate);
                // Stores Employee Details CSV
                employeeList.add(employeeRecord);
            }
        } catch (Exception e) {
            System.out.println("Error reading employee file.");
            e.printStackTrace();
        }

        return employeeList;
    }

    public static List<Attendance> readAttendanceFile() {

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        List<Attendance> attendanceList = new ArrayList<>();

        // Read Attendance Record CSV
        try (BufferedReader br = new BufferedReader(new FileReader(ATT_CSV))) {

            br.readLine(); // Skip header
            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length < 6) {
                    continue;
                }

                int empNo = Integer.parseInt(data[0].trim());
                LocalDate date = LocalDate.parse(data[3].trim(), dateFormat);
                LocalTime login = LocalTime.parse(data[4].trim(), timeFormat);
                LocalTime logout = LocalTime.parse(data[5].trim(), timeFormat);

                Attendance attendanceRecord = new Attendance(empNo,
                        date,
                        login,
                        logout);
                // Stores Attendance Record CSV
                attendanceList.add(attendanceRecord);
            }

        } catch (Exception e) {
            System.out.println("Error reading attendance file.");
            e.printStackTrace();
        }

        return attendanceList;
    }
    
    // Find Employee
    public static Employee findEmployee(List<Employee> employeeList, int empID) {

        for (Employee employee : employeeList) {
            if (employee.getEmpNo() == empID) {
                return employee;
            }
        }
        return null;
    }
}
