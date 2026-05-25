/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPHEmployeeApp;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Group 21 - ComProg2 - H1101
 */
public class MotorPHUI {

    private JFrame frame;
    private JPanel rootPanel;
    private CardLayout cardLayout;
    private ImageIcon image;

    private List<Employee> employeeList;
    private List<Attendance> attendanceList;
    private String currentUsername;

    public MotorPHUI() {

        employeeList = CSVHandler.readEmployeeFile();
        attendanceList = CSVHandler.readAttendanceFile();
        image = new ImageIcon("logo.png");

        frame = new JFrame("MotorPH Payroll App");
        frame.setMinimumSize(new Dimension(620, 430));
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        rootPanel = new JPanel(cardLayout);

        rootPanel.add(createUsernameScreen(), "username");
        rootPanel.add(createPasswordScreen(), "password");
        rootPanel.add(createEmployeeNumberScreen(), "employee-number");
        rootPanel.add(createPayrollChoiceScreen(), "payroll-choice");
        rootPanel.add(createPayrollEmployeeScreen(), "payroll-employee");
        rootPanel.add(createPayrollAllScreen(), "payroll-all");

        frame.add(rootPanel);
        frame.setVisible(true);

        if (employeeList.isEmpty()) {
            showError("An error occurred while reading employee file.", "username");
        }
    }

    private JPanel createUsernameScreen() {

        JPanel panel = appBox();
        GridBagConstraints gbc = baseGbc();

        addAppTitle(panel, gbc);
        addCenteredText(panel, gbc, "Please enter your username.");

        JTextField usernameTxt = new JTextField(22);
        JButton submitBtn = new JButton("Submit");

        addWideField(panel, gbc, usernameTxt);
        addSubmitButton(panel, gbc, submitBtn);

        submitBtn.addActionListener(e -> {
            String username = usernameTxt.getText().trim();

            if (!username.equals("employee") && !username.equals("payroll_staff")) {
                showError("Incorrect Username/Password.", "username");
                return;
            }

            currentUsername = username;
            cardLayout.show(rootPanel, "password");
        });

        return centerScreen(panel);
    }

    private JPanel createPasswordScreen() {

        JPanel panel = appBox();
        GridBagConstraints gbc = baseGbc();

        addAppTitle(panel, gbc);
        addCenteredText(panel, gbc, "Please enter your password.");

        JPasswordField passwordFld = new JPasswordField(22);
        JButton submitBtn = new JButton("Submit");
        JButton backBtn = new JButton("Back");

        addWideField(panel, gbc, passwordFld);
        addSubmitButton(panel, gbc, submitBtn);
        addSubmitButton(panel, gbc, backBtn);

        submitBtn.addActionListener(e -> {
            String password = new String(passwordFld.getPassword());

            if (!password.equals("12345")) {
                showError("Incorrect Username/Password.", "password");
                return;
            }

            passwordFld.setText("");
            if (currentUsername.equals("employee")) {
                cardLayout.show(rootPanel, "employee-number");
            } else {
                cardLayout.show(rootPanel, "payroll-choice");
            }
        });

        backBtn.addActionListener(e -> cardLayout.show(rootPanel, "username"));

        return centerScreen(panel);
    }

    private JPanel createEmployeeNumberScreen() {

        JPanel panel = appBox();
        GridBagConstraints gbc = baseGbc();

        addAppTitle(panel, gbc);
        addCenteredText(panel, gbc, "Please enter your employee number.");

        JTextField employeeNumberTxt = new JTextField(22);
        JButton submitBtn = new JButton("Submit");
        JButton backBtn = new JButton("Back");

        addWideField(panel, gbc, employeeNumberTxt);
        addSubmitButton(panel, gbc, submitBtn);
        addSubmitButton(panel, gbc, backBtn);

        submitBtn.addActionListener(e -> {
            Employee employee = getEmployeeFromInput(employeeNumberTxt);

            if (employee == null) {
                return;
            }

            showEmployeeDetails(employee);
        });

        backBtn.addActionListener(e -> cardLayout.show(rootPanel, "username"));

        return centerScreen(panel);
    }

    private void showEmployeeDetails(Employee employee) {

        JPanel panel = appBox();
        panel.setPreferredSize(new Dimension(390, 250));
        GridBagConstraints gbc = baseGbc();

        addAppTitle(panel, gbc);
        addCenteredText(panel, gbc, "Employee #: " + employee.getEmpNo());
        addCenteredText(panel, gbc, "First Name: " + employee.getFirstName());
        addCenteredText(panel, gbc, "Last Name: " + employee.getLastName());
        addCenteredText(panel, gbc, "Birthday: " + employee.getBirthday());
        addCenteredText(panel, gbc, String.format("Hourly Rate: %.2f", employee.getHourlyRate()));

        JButton backBtn = new JButton("Back");
        addSubmitButton(panel, gbc, backBtn);
        backBtn.addActionListener(e -> cardLayout.show(rootPanel, "employee-number"));

        showTemporaryCard(centerScreen(panel), "employee-details");
    }

    private JPanel createPayrollChoiceScreen() {

        JPanel panel = appBox();
        GridBagConstraints gbc = baseGbc();

        addAppTitle(panel, gbc);
        addCenteredText(panel, gbc, "Choose an employee option.");

        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setOpaque(false);

        JButton oneEmployeeBtn = new JButton("One Employee");
        JButton allEmployeesBtn = new JButton("All Employees");

        GridBagConstraints buttonGbc = new GridBagConstraints();
        buttonGbc.insets = new Insets(8, 8, 8, 8);
        buttons.add(oneEmployeeBtn, buttonGbc);

        buttonGbc.gridx = 1;
        buttons.add(allEmployeesBtn, buttonGbc);

        gbc.gridy++;
        panel.add(buttons, gbc);

        JButton backBtn = new JButton("Back");
        addSubmitButton(panel, gbc, backBtn);

        oneEmployeeBtn.addActionListener(e -> cardLayout.show(rootPanel, "payroll-employee"));
        allEmployeesBtn.addActionListener(e -> cardLayout.show(rootPanel, "payroll-all"));
        backBtn.addActionListener(e -> cardLayout.show(rootPanel, "username"));

        return centerScreen(panel);
    }

    private JPanel createPayrollEmployeeScreen() {

        JPanel panel = appBox();
        panel.setPreferredSize(new Dimension(390, 330));
        GridBagConstraints gbc = baseGbc();

        addAppTitle(panel, gbc);
        addCenteredText(panel, gbc, "Please enter an employee number.");

        JTextField employeeNumberTxt = new JTextField(22);
        JComboBox<String> monthBox = createMonthBox();
        JComboBox<String> coverageBox = createCoverageBox();

        JButton generateBtn = new JButton("Generate Payslip");
        JButton backBtn = new JButton("Back");
        JButton backToLoginBtn = new JButton("Back to Login");

        addWideField(panel, gbc, employeeNumberTxt);
        addLabeledField(panel, gbc, "Month:", monthBox);
        addLabeledField(panel, gbc, "Pay Coverage:", coverageBox);
        addSubmitButton(panel, gbc, generateBtn);
        addSubmitButton(panel, gbc, backBtn);
        addSubmitButton(panel, gbc, backToLoginBtn);

        generateBtn.addActionListener(e -> {
            Employee employee = getEmployeeFromInput(employeeNumberTxt);

            if (employee == null) {
                return;
            }

            String payslip = generatePayslip(employee, monthBox, coverageBox);
            showPayrollResult(payslip, "payroll-employee");
        });

        backBtn.addActionListener(e -> cardLayout.show(rootPanel, "payroll-choice"));
        backToLoginBtn.addActionListener(e -> cardLayout.show(rootPanel, "username"));

        return centerScreen(panel);
    }

    private JPanel createPayrollAllScreen() {

        JPanel panel = appBox();
        panel.setPreferredSize(new Dimension(390, 280));
        GridBagConstraints gbc = baseGbc();

        addAppTitle(panel, gbc);
        addCenteredText(panel, gbc, "Generate payroll for all employees.");

        JComboBox<String> monthBox = createMonthBox();
        JComboBox<String> coverageBox = createCoverageBox();

        JButton generateBtn = new JButton("Generate Payslips");
        JButton backBtn = new JButton("Back");
        JButton backToLoginBtn = new JButton("Back to Login");

        addLabeledField(panel, gbc, "Month:", monthBox);
        addLabeledField(panel, gbc, "Pay Coverage:", coverageBox);
        addSubmitButton(panel, gbc, generateBtn);
        addSubmitButton(panel, gbc, backBtn);
        addSubmitButton(panel, gbc, backToLoginBtn);

        generateBtn.addActionListener(e -> {
            if (employeeList.isEmpty()) {
                showError("No employee data found.", "payroll-all");
                return;
            }

            List<String> payslips = new ArrayList<>();

            for (Employee employee : employeeList) {
                payslips.add(generatePayslip(employee, monthBox, coverageBox));
            }

            showPayrollResult(String.join("\n=======================================\n\n", payslips), "payroll-all");
        });

        backBtn.addActionListener(e -> cardLayout.show(rootPanel, "payroll-choice"));
        backToLoginBtn.addActionListener(e -> cardLayout.show(rootPanel, "username"));

        return centerScreen(panel);
    }

    private String generatePayslip(
            Employee employee,
            JComboBox<String> monthBox,
            JComboBox<String> coverageBox) {

        String selectedMonth = monthBox.getSelectedItem().toString();
        int month = Month.valueOf(selectedMonth.toUpperCase()).getValue();
        String selectedCoverage = coverageBox.getSelectedItem().toString();

        Payroll payroll = new Payroll();
        return payroll.generatePayslip(employee, attendanceList, month, selectedCoverage);
    }

    private void showPayrollResult(String payslip, String backCard) {

        JPanel panel = appBox();
        panel.setPreferredSize(new Dimension(500, 330));
        GridBagConstraints gbc = baseGbc();

        addAppTitle(panel, gbc);

        JTextArea outputArea = new JTextArea(11, 34);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setText(payslip);
        outputArea.setCaretPosition(0);

        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(new JScrollPane(outputArea), gbc);

        JButton backBtn = new JButton("Back");
        addSubmitButton(panel, gbc, backBtn);
        backBtn.addActionListener(e -> cardLayout.show(rootPanel, backCard));

        showTemporaryCard(centerScreen(panel), "payroll-result");
    }

    private Employee getEmployeeFromInput(JTextField employeeNumberTxt) {

        String employeeNumber = employeeNumberTxt.getText().trim();

        if (employeeNumber.isEmpty()) {
            showError("Please enter employee number.", "employee".equals(currentUsername) ? "employee-number" : "payroll-employee");
            return null;
        }

        try {
            Employee employee = CSVHandler.findEmployee(employeeList, Integer.parseInt(employeeNumber));

            if (employee == null) {
                showError("Incorrect Employee Number.", "employee".equals(currentUsername) ? "employee-number" : "payroll-employee");
                return null;
            }

            return employee;
        } catch (NumberFormatException ex) {
            showError("Employee number must be numeric.", "employee".equals(currentUsername) ? "employee-number" : "payroll-employee");
            return null;
        }
    }

    private void showError(String message, String backCard) {

        JPanel panel = appBox();
        GridBagConstraints gbc = baseGbc();

        addAppTitle(panel, gbc);
        addCenteredText(panel, gbc, message);

        JButton backBtn = new JButton("Back");
        addSubmitButton(panel, gbc, backBtn);
        backBtn.addActionListener(e -> cardLayout.show(rootPanel, backCard));

        showTemporaryCard(centerScreen(panel), "error");
    }

    private void showTemporaryCard(JPanel panel, String namePrefix) {

        String cardName = namePrefix + "-" + System.nanoTime();
        rootPanel.add(panel, cardName);
        cardLayout.show(rootPanel, cardName);
    }

    private JComboBox<String> createMonthBox() {

        String[] months = {
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        };

        return new JComboBox<>(months);
    }

    private JComboBox<String> createCoverageBox() {

        String[] coverageOptions = {
            "1 - 15",
            "16 - 30/31",
            "1 - 30/31"
        };

        return new JComboBox<>(coverageOptions);
    }

    private JPanel centerScreen(JPanel content) {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(248, 250, 252));
        panel.add(content);
        return panel;
    }

    private JPanel appBox() {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(360, 230));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(41, 47, 54)),
                BorderFactory.createEmptyBorder(16, 18, 16, 18)));
        return panel;
    }

    private GridBagConstraints baseGbc() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 0, 6, 0);
        return gbc;
    }

    private void addAppTitle(JPanel panel, GridBagConstraints gbc) {

        JLabel title = new JLabel("MotorPH Payroll App");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panel.add(title, gbc);
    }

    private void addCenteredText(JPanel panel, GridBagConstraints gbc, String text) {

        gbc.gridy++;
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel.add(label, gbc);
    }

    private void addWideField(JPanel panel, GridBagConstraints gbc, java.awt.Component field) {

        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 4, 0);
        panel.add(field, gbc);
        gbc.insets = new Insets(6, 0, 6, 0);
    }

    private void addLabeledField(JPanel panel, GridBagConstraints gbc, String label, java.awt.Component field) {

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(field, gbc);

        gbc.gridx = 0;
        gbc.gridwidth = 2;
    }

    private void addSubmitButton(JPanel panel, GridBagConstraints gbc, JButton button) {

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        button.setPreferredSize(new Dimension(132, 24));
        panel.add(button, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }
}
