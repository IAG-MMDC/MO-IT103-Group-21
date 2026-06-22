/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Attendance;
import model.Employee;
import service.AttendanceDataHandler;
import service.PayrollCalculator;

/**
 *
 * @author Home
 */
public class EmployeeMenu extends JPanel {

    private JTextArea displayArea;
    private Employee employee;

    JComboBox coverageBox;
    JComboBox monthBox;
    JComboBox yearBox;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public EmployeeMenu(MainGUIFrame mainGUIFrame) {

        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);
        
        // Label
        JLabel lblTitle = new JLabel("MotorPH Employee App");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setBounds(20, 20, 240, 30);
        add(lblTitle);
        
        JLabel lblMonth = new JLabel("Month:");
        lblMonth.setBounds(20, 110, 100, 25);
        add(lblMonth);

        JLabel lblYear = new JLabel("Year:");
        lblYear.setBounds(20, 140, 100, 25);
        add(lblYear);
        
        JLabel lblPayCov = new JLabel("Pay Coverage:");
        lblPayCov.setBounds(20, 170, 100, 25);
        add(lblPayCov);

        // Buttons
        JButton btnViewED = new JButton("View Details");
        btnViewED.setBounds(490, 110, 130, 25);
        add(btnViewED);

        JButton btnViewPS = new JButton("View Payslip");
        btnViewPS.setBounds(490, 140, 130, 25);
        add(btnViewPS);

        JButton btnLogOut = new JButton("Logout");
        btnLogOut.setBounds(500, 505, 110, 25);
        add(btnLogOut);

        // Arrays
        Integer[] months = {6, 7, 8, 9, 10, 11, 12};
        Integer[] years = {2024, 2025, 2026};
        String[] coverageOptions = {"1 - 15", "16 - 30/31", "1 - 30/31"};

        // Combo Box
        monthBox = new JComboBox(months);
        monthBox.setBounds(300, 110, 150, 25);
        add(monthBox);

        yearBox = new JComboBox(years);
        yearBox.setBounds(300, 140, 150, 25);
        add(yearBox);

        coverageBox = new JComboBox(coverageOptions);
        coverageBox.setBounds(300, 170, 150, 25);
        add(coverageBox);

        //Button Actions
        btnViewED.addActionListener(e -> showDetails());
        btnViewPS.addActionListener(e -> showPayslip());
        btnLogOut.addActionListener(e -> mainGUIFrame.showCard("loginScreen-Card"));

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(20, 200, 430, 320);
        add(scrollPane);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    // Set Employee
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // Show Employee Details
    private void showDetails() {
        if (employee == null) {
            return;
        }

        displayArea.setText(String.format(
                """
        ========== Employee Details ==========
        
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %s
        %-25s %,d
        %-25s %,d
        %-25s %,d
        %-25s %,d
        %-25s %,d
        %-25s %,.2f
        
        =========================================
        """,
                "Employee No:", employee.getEmpNo(),
                "Last Name:", employee.getLastName(),
                "First Name:", employee.getFirstName(),
                "Birthday:", employee.getBirthday().format(DATE_FORMAT),
                "Address:", employee.getAddress(),
                "Phone #:", employee.getPhoneNumber(),
                "SSS #:", employee.getSSSNumber(),
                "PhilHealth #:", employee.getPhilHealthNumber(),
                "TIN #:", employee.getTINNumber(),
                "PagIBIG #:", employee.getPagIBIGNumber(),
                "Status:", employee.getStatus(),
                "Position:", employee.getPosition(),
                "Immediate Supervisor:", employee.getImmediateSupervisor(),
                "Basic Salary:", employee.getBasicSalary(),
                "Rice Subsidy:", employee.getRiceSubsidy(),
                "Phone Allowance:", employee.getPhoneAllowance(),
                "Clothing Allowance:", employee.getClothingAllowance(),
                "Gross Semi-Monthly Rate:", employee.getGrossSemiMonthlyRate(),
                "Hourly Rate:", employee.getHourlyRate()
        ));
    }

    private void showPayslip() {
        if (employee == null) {
            return;
        }

        List<Attendance> attendanceList
                = AttendanceDataHandler.readAttendance();

        int month = (Integer) monthBox.getSelectedItem();
        int year = (Integer) yearBox.getSelectedItem();
        String coverage = (String) coverageBox.getSelectedItem();

        PayrollCalculator calculator = new PayrollCalculator();

        String payslip = calculator.generatePayslip(
                employee,
                attendanceList,
                year,
                month,
                coverage
        );

        displayArea.setText(payslip);
    }
}
