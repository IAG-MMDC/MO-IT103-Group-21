/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Attendance;
import model.Employee;
import service.AttendanceDataHandler;
import service.EmployeeDataHandler;
import service.PayrollCalculator;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Home
 */
public class PayrollRecords extends JPanel {

    private JTextField txtSearchNo, txtSearchName;
    private JTextArea displayArea;
    private Employee selectedEmployee = null;
    private JComboBox monthBox, coverageBox, yearBox;

    public PayrollRecords(MainGUIFrame mainGUIFrame) {

        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);

        //Labels and Text Fields
        JLabel lblSearchNo = new JLabel("Search Employee #:");
        lblSearchNo.setBounds(20, 20, 150, 25);
        add(lblSearchNo);

        txtSearchNo = new JTextField();
        txtSearchNo.setBounds(180, 20, 150, 25);
        add(txtSearchNo);

        JLabel lblSearchName = new JLabel("Search Employee Name:");
        lblSearchName.setBounds(20, 50, 150, 25);
        add(lblSearchName);

        txtSearchName = new JTextField();
        txtSearchName.setBounds(180, 50, 150, 25);
        add(txtSearchName);
        
        JLabel lblMonth = new JLabel("Month:");
        lblMonth.setBounds(20, 110, 100, 25);
        add(lblMonth);

        JLabel lblYear = new JLabel("Year:");
        lblYear.setBounds(20, 140, 100, 25);
        add(lblYear);
        
        JLabel lblPayCov = new JLabel("Pay Coverage:");
        lblPayCov.setBounds(20, 170, 100, 25);
        add(lblPayCov);

        //Buttons
        JButton btnSubmitNo = new JButton("Submit");
        btnSubmitNo.setBounds(350, 20, 80, 25);
        add(btnSubmitNo);

        JButton btnSubmitName = new JButton("Submit");
        btnSubmitName.setBounds(350, 50, 80, 25);
        add(btnSubmitName); 
        
        JButton btnCalculateOne = new JButton("Calculate One");
        btnCalculateOne.setBounds(490, 110, 130, 25);
        add(btnCalculateOne);

        JButton btnCalculateAll = new JButton("Calculate All");
        btnCalculateAll.setBounds(490, 140, 130, 25);
        add(btnCalculateAll);
        
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(490, 170, 130, 25);
        add(btnSave);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(500, 475, 110, 25);
        add(btnBack);

        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(500, 505, 110, 25);
        add(btnLogOut);

        //Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);

        // Arrays
        Integer[] months = {6, 7, 8, 9, 10, 11, 12};
        Integer[] years = {2024, 2025, 2026};
        String[] coverageOptions = {"1 - 15", "16 - 30/31", "1 - 30/31"};

        // JCombo Box
        monthBox = new JComboBox(months);
        monthBox.setBounds(300, 110, 150, 25);
        add(monthBox);

        yearBox = new JComboBox(years);
        yearBox.setBounds(300, 140, 150, 25);
        add(yearBox);

        coverageBox = new JComboBox(coverageOptions);
        coverageBox.setBounds(300, 170, 150, 25);
        add(coverageBox);

        // JScroll Pane
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(20, 200, 430, 320);
        add(scrollPane);

        // Horizontal And Vertical Scroll
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Button Actions 
        btnSubmitNo.addActionListener(e -> submitNo());
        btnSubmitName.addActionListener(e -> submitName());

        btnCalculateOne.addActionListener(e -> calculateOneEmployee());
        btnCalculateAll.addActionListener(e -> calculateAllEmployees());
        btnSave.addActionListener(e -> savePayroll());

        btnBack.addActionListener(e -> mainGUIFrame.showCard("staffMenu-Card"));
        btnLogOut.addActionListener(e -> mainGUIFrame.showCard("loginScreen-Card"));
    }

    // Submit Number 
    private void submitNo() {

        String input = txtSearchNo.getText().trim();

        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter employee number.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            int empNo = Integer.parseInt(input);

            selectedEmployee = EmployeeDataHandler.findEmpNo(empNo);

            if (selectedEmployee == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee not found.",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid employee number format.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        clearFields();
    }

    // Submit Name
    private void submitName() {

        String input = txtSearchName.getText().trim();

        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter employee name.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        List<Employee> employees = EmployeeDataHandler.readEmployees();

        selectedEmployee = null;

        for (Employee e : employees) {

            String fullName = e.getFirstName() + " " + e.getLastName();

            if (fullName.equalsIgnoreCase(input)) {
                selectedEmployee = e;
                break;
            }
        }

        if (selectedEmployee == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Employee not found.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        clearFields();
    }
    
    // Calculate One Employee
    private void calculateOneEmployee() {

        if (selectedEmployee == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter employee # or name first.",
                    "MESSAGE",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        List<Attendance> attendanceList
                = AttendanceDataHandler.readAttendance();

        int month = (Integer) monthBox.getSelectedItem();
        int year = (Integer) yearBox.getSelectedItem();
        String coverage = (String) coverageBox.getSelectedItem();

        PayrollCalculator calculator = new PayrollCalculator();

        String payslip = calculator.generatePayslip(
                selectedEmployee,
                attendanceList,
                year,
                month,
                coverage
        );

        displayArea.setText(payslip);
    }

    // Calculate All Employees
    private void calculateAllEmployees() {

        List<Employee> employees = EmployeeDataHandler.readEmployees();
        List<Attendance> attendanceList = AttendanceDataHandler.readAttendance();

        if (employees.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No employees found.",
                    "MESSAGE",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        int month = (Integer) monthBox.getSelectedItem();
        int year = (Integer) yearBox.getSelectedItem();
        String coverage = (String) coverageBox.getSelectedItem();

        PayrollCalculator calculator = new PayrollCalculator();

        StringBuilder sb = new StringBuilder();
        sb.append("ALL PAYSLIPS\n\n");

        for (Employee emp : employees) {

            String payslip = calculator.generatePayslip(
                    emp,
                    attendanceList,
                    year,
                    month,
                    coverage
            );

            sb.append("========================================\n");
            sb.append(payslip).append("\n\n");
        }

        displayArea.setText(sb.toString());
    }
    
    // Save Payroll
    private void savePayroll() {
        String content = displayArea.getText();

        if (content.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No payroll information to save.",
                    "MESSAGE",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        try {
            Files.writeString(Path.of("payroll_output.txt"), content);
            JOptionPane.showMessageDialog(
                    this,
                    "Payroll information saved succesfully.",
                    "MESSAGE",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Unable to save payroll information.",
                    "MESSAGE",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void clearFields() {
        txtSearchNo.setText("");
        txtSearchName.setText("");
    }
}
