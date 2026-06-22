/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Attendance;

/**
 *
 * @author Home
 */
public class AttendanceDataHandler {

    private static final String ATT_CSV = "resources/MotorPH_Employee Data - Attendance Record.csv";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("H:mm"); 

    public static List<Attendance> readAttendance() {

        List<Attendance> attendanceList = new ArrayList<>();

        // Read Attendance Record CSV
        try (BufferedReader br = new BufferedReader(new FileReader(ATT_CSV))) {

            br.readLine(); // Skip header
            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                List<String> data = CSVParser.parseCSVLine(line);

                if (data.size() < 6) {
                    throw new IllegalArgumentException("Invalid attendance record"); 
                }

                int empNo = Integer.parseInt(data.get(0));
                LocalDate date = LocalDate.parse(data.get(3), DATE_FORMAT);
                LocalTime login = LocalTime.parse(data.get(4), TIME_FORMAT);
                LocalTime logout = LocalTime.parse(data.get(5), TIME_FORMAT);

                Attendance attendance
                        = new Attendance(empNo,
                                date,
                                login,
                                logout);
                // Stores Attendance Record CSV
                attendanceList.add(attendance);
            }

        } catch (IOException e) {
            System.out.println("Error reading attendance file.");
            e.printStackTrace();
        }

        return attendanceList;
    }
}
