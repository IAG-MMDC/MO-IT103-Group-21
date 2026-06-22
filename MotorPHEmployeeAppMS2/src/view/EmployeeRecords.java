/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import service.EmployeeDataHandler;

/**
 *
 * @author Home
 */
public class EmployeeRecords extends JPanel {

    private JTextField txtEmpNo, txtFirstN, txtLastN;
    private JTextField txtBirthday, txtAddress, txtPhoneN, txtSSS, txtPhilHealth, txtTIN, txtPagIBIG,
            txtStatus, txtPosition, txtImmediate, txtBasic, txtRice, txtPhoneAl, txtClothing,
            txtGross, txtHourly;

    private DefaultTableModel tableModel;
    private JTable employeeTable;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public EmployeeRecords(MainGUIFrame mainGUIFrame) {

        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);

        // Labels and Text Fields
        JLabel lblEmpNo = new JLabel("Employee #:");
        lblEmpNo.setBounds(20, 20, 100, 25);
        add(lblEmpNo);

        txtEmpNo = new JTextField();
        txtEmpNo.setBounds(120, 20, 150, 25);
        add(txtEmpNo);

        JLabel lblLastN = new JLabel("Last Name:");
        lblLastN.setBounds(20, 50, 100, 25);
        add(lblLastN);

        txtLastN = new JTextField();
        txtLastN.setBounds(120, 50, 150, 25);
        add(txtLastN);

        JLabel lblFirstN = new JLabel("First Name:");
        lblFirstN.setBounds(20, 80, 100, 25);
        add(lblFirstN);

        txtFirstN = new JTextField();
        txtFirstN.setBounds(120, 80, 150, 25);
        add(txtFirstN);

        JLabel lblBirthday = new JLabel("Birthday:");
        lblBirthday.setBounds(20, 110, 100, 25);
        add(lblBirthday);

        txtBirthday = new JTextField();
        txtBirthday.setBounds(120, 110, 150, 25);
        add(txtBirthday);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(20, 140, 100, 25);
        add(lblAddress);

        txtAddress = new JTextField();
        txtAddress.setBounds(120, 140, 150, 25);
        add(txtAddress);

        JLabel lblPhoneN = new JLabel("Phone #:");
        lblPhoneN.setBounds(20, 170, 100, 25);
        add(lblPhoneN);

        txtPhoneN = new JTextField();
        txtPhoneN.setBounds(120, 170, 150, 25);
        add(txtPhoneN);

        JLabel lblSSS = new JLabel("SSS #:");
        lblSSS.setBounds(20, 200, 100, 25);
        add(lblSSS);

        txtSSS = new JTextField();
        txtSSS.setBounds(120, 200, 150, 25);
        add(txtSSS);

        JLabel lblPhilHealth = new JLabel("PhiHealth #:");
        lblPhilHealth.setBounds(20, 230, 100, 25);
        add(lblPhilHealth);

        txtPhilHealth = new JTextField();
        txtPhilHealth.setBounds(120, 230, 150, 25);
        add(txtPhilHealth);

        JLabel lblTIN = new JLabel("TIN #:");
        lblTIN.setBounds(20, 260, 100, 25);
        add(lblTIN);

        txtTIN = new JTextField();
        txtTIN.setBounds(120, 260, 150, 25);
        add(txtTIN);

        JLabel lblPagIBIG = new JLabel("PagIBIG #:");
        lblPagIBIG.setBounds(20, 290, 100, 25);
        add(lblPagIBIG);

        txtPagIBIG = new JTextField();
        txtPagIBIG.setBounds(120, 290, 150, 25);
        add(txtPagIBIG);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(300, 20, 150, 25);
        add(lblStatus);

        txtStatus = new JTextField();
        txtStatus.setBounds(480, 20, 150, 25);
        add(txtStatus);

        JLabel lblPosition = new JLabel("Position:");
        lblPosition.setBounds(300, 50, 150, 25);
        add(lblPosition);

        txtPosition = new JTextField();
        txtPosition.setBounds(480, 50, 150, 25);
        add(txtPosition);

        JLabel lblImmediate = new JLabel("Immediate Supervisor:");
        lblImmediate.setBounds(300, 80, 150, 25);
        add(lblImmediate);

        txtImmediate = new JTextField();
        txtImmediate.setBounds(480, 80, 150, 25);
        add(txtImmediate);

        JLabel lblBasic = new JLabel("Basic Salary:");
        lblBasic.setBounds(300, 110, 150, 25);
        add(lblBasic);

        txtBasic = new JTextField();
        txtBasic.setBounds(480, 110, 150, 25);
        add(txtBasic);

        JLabel lblRice = new JLabel("Rice Subsidy:");
        lblRice.setBounds(300, 140, 150, 25);
        add(lblRice);

        txtRice = new JTextField();
        txtRice.setBounds(480, 140, 150, 25);
        add(txtRice);

        JLabel lblPhoneAl = new JLabel("Phone Allowance:");
        lblPhoneAl.setBounds(300, 170, 150, 25);
        add(lblPhoneAl);

        txtPhoneAl = new JTextField();
        txtPhoneAl.setBounds(480, 170, 150, 25);
        add(txtPhoneAl);

        JLabel lblClothing = new JLabel("Clothing Allowance:");
        lblClothing.setBounds(300, 200, 150, 25);
        add(lblClothing);

        txtClothing = new JTextField();
        txtClothing.setBounds(480, 200, 150, 25);
        add(txtClothing);

        JLabel lblGross = new JLabel("Gross Semi-Monthly Rate: ");
        lblGross.setBounds(300, 230, 150, 25);
        add(lblGross);

        txtGross = new JTextField();
        txtGross.setBounds(480, 230, 150, 25);
        add(txtGross);

        JLabel lblHourly = new JLabel("Hourly Rate: ");
        lblHourly.setBounds(300, 260, 150, 25);
        add(lblHourly);

        txtHourly = new JTextField();
        txtHourly.setBounds(480, 260, 150, 25);
        add(txtHourly);

        // Buttons
        JButton btnView = new JButton("View All");
        btnView.setBounds(490, 335, 130, 25);
        add(btnView);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(490, 365, 130, 25);
        add(btnAdd);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(490, 395, 130, 25);
        add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(490, 425, 130, 25);
        add(btnDelete);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(500, 475, 110, 25);
        add(btnBack);

        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(500, 505, 110, 25);
        add(btnLogOut);

        // Table 
        tableModel = new DefaultTableModel();

        tableModel.addColumn("Employee #");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Birthday");
        tableModel.addColumn("Address");
        tableModel.addColumn("Phone #");
        tableModel.addColumn("SSS #");
        tableModel.addColumn("PhiHealth #");
        tableModel.addColumn("TIN #");
        tableModel.addColumn("Pag-IBIG #");
        tableModel.addColumn("Status");
        tableModel.addColumn("Position");
        tableModel.addColumn("Immediate Supervisor");
        tableModel.addColumn("Basic Salary");
        tableModel.addColumn("Rice Subsidy");
        tableModel.addColumn("Phone Allowance");
        tableModel.addColumn("Clothing Allowance");
        tableModel.addColumn("Gross Semi-Monthly Rate");
        tableModel.addColumn("Hourly Rate");

        employeeTable = new JTable(tableModel);

        employeeTable.getSelectionModel().addListSelectionListener(e -> {

            if (e.getValueIsAdjusting()) {
                return;
            }

            int row = employeeTable.getSelectedRow();

            if (row >= 0) {

                txtEmpNo.setText(tableModel.getValueAt(row, 0).toString());
                txtLastN.setText(tableModel.getValueAt(row, 1).toString());
                txtFirstN.setText(tableModel.getValueAt(row, 2).toString());
                txtBirthday.setText(tableModel.getValueAt(row, 3).toString());
                txtAddress.setText(tableModel.getValueAt(row, 4).toString());
                txtPhoneN.setText(tableModel.getValueAt(row, 5).toString());
                txtSSS.setText(tableModel.getValueAt(row, 6).toString());
                txtPhilHealth.setText(tableModel.getValueAt(row, 7).toString());
                txtTIN.setText(tableModel.getValueAt(row, 8).toString());
                txtPagIBIG.setText(tableModel.getValueAt(row, 9).toString());
                txtStatus.setText(tableModel.getValueAt(row, 10).toString());
                txtPosition.setText(tableModel.getValueAt(row, 11).toString());
                txtImmediate.setText(tableModel.getValueAt(row, 12).toString());
                txtBasic.setText(tableModel.getValueAt(row, 13).toString());
                txtRice.setText(tableModel.getValueAt(row, 14).toString());
                txtPhoneAl.setText(tableModel.getValueAt(row, 15).toString());
                txtClothing.setText(tableModel.getValueAt(row, 16).toString());
                txtGross.setText(tableModel.getValueAt(row, 17).toString());
                txtHourly.setText(tableModel.getValueAt(row, 18).toString());
            }
        });

        employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        employeeTable.getColumnModel().getColumn(0).setPreferredWidth(80);

        // JScroll Pane
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBounds(20, 335, 430, 200);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        // Button Actions
        btnView.addActionListener(e -> viewEmployees());
        btnAdd.addActionListener(e -> addEmployee());
        btnUpdate.addActionListener(e -> updateEmployee());
        btnDelete.addActionListener(e -> deleteEmployee());
        btnBack.addActionListener(e -> mainGUIFrame.showCard("staffMenu-Card"));
        btnLogOut.addActionListener(e -> mainGUIFrame.showCard("loginScreen-Card"));
    }

    // View Employees
    private void viewEmployees() {
        List<Employee> list = EmployeeDataHandler.readEmployees();

        tableModel.setRowCount(0);

        for (Employee e : list) {
            tableModel.addRow(new Object[]{
                e.getEmpNo(),
                e.getLastName(),
                e.getFirstName(),
                e.getBirthday().format(DATE_FORMAT),
                e.getAddress(),
                e.getPhoneNumber(),
                e.getSSSNumber(),
                e.getPhilHealthNumber(),
                e.getTINNumber(),
                e.getPagIBIGNumber(),
                e.getStatus(),
                e.getPosition(),
                e.getImmediateSupervisor(),
                e.getBasicSalary(),
                e.getRiceSubsidy(),
                e.getPhoneAllowance(),
                e.getClothingAllowance(),
                e.getGrossSemiMonthlyRate(),
                e.getHourlyRate()
            });
        }
    }

    // Add Employee
    private void addEmployee() {

        if (txtEmpNo.getText().isBlank()
                || txtLastN.getText().isBlank()
                || txtFirstN.getText().isBlank()
                || txtAddress.getText().isBlank()
                || txtPhoneN.getText().isBlank()
                || txtSSS.getText().isBlank()
                || txtPhilHealth.getText().isBlank()
                || txtTIN.getText().isBlank()
                || txtPagIBIG.getText().isBlank()
                || txtStatus.getText().isBlank()
                || txtPosition.getText().isBlank()
                || txtImmediate.getText().isBlank()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all required fields.",
                    "MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int empNo = Integer.parseInt(txtEmpNo.getText());
            String lastName = txtLastN.getText();
            String firstName = txtFirstN.getText();
            LocalDate birthday = LocalDate.parse(txtBirthday.getText(), DATE_FORMAT);
            String address = txtAddress.getText();
            String phoneNumber = txtPhoneN.getText();
            String sssNumber = txtSSS.getText();
            String philHealthNumber = txtPhilHealth.getText();
            String tinNumber = txtTIN.getText();
            String pagIBIGNumber = txtPagIBIG.getText();
            String status = txtStatus.getText();
            String position = txtPosition.getText();
            String immediateSupervisor = txtImmediate.getText();
            int basicSalary = Integer.parseInt(txtBasic.getText());
            int riceSubsidy = Integer.parseInt(txtRice.getText());
            int phoneAllowance = Integer.parseInt(txtPhoneAl.getText());
            int clothingAllowance = Integer.parseInt(txtClothing.getText());
            int grossSemiMonthlyRate = Integer.parseInt(txtGross.getText());
            double hourlyRate = Double.parseDouble(txtHourly.getText());

            Employee employee = new Employee(
                    empNo,
                    lastName,
                    firstName,
                    birthday,
                    address,
                    phoneNumber,
                    sssNumber,
                    philHealthNumber,
                    tinNumber,
                    pagIBIGNumber,
                    status,
                    position,
                    immediateSupervisor,
                    basicSalary,
                    riceSubsidy,
                    phoneAllowance,
                    clothingAllowance,
                    grossSemiMonthlyRate,
                    hourlyRate
            );

            EmployeeDataHandler.addEmployee(employee);

            viewEmployees();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Birthday must be in MM//dd/yyyy format." + e.getMessage(),
                    "Date Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Unexpected Error: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Update Employee
    private void updateEmployee() {

        if (employeeTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select an employee first.",
                    "Message",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {

            int empNo = Integer.parseInt(txtEmpNo.getText());

            String lastName = txtLastN.getText();
            String firstName = txtFirstN.getText();
            LocalDate birthday = LocalDate.parse(txtBirthday.getText(), DATE_FORMAT);
            String address = txtAddress.getText();
            String phoneNumber = txtPhoneN.getText();
            String sssNumber = txtSSS.getText();
            String philHealthNumber = txtPhilHealth.getText();
            String tinNumber = txtTIN.getText();
            String pagIBIGNumber = txtPagIBIG.getText();
            String status = txtStatus.getText();
            String position = txtPosition.getText();
            String immediateSupervisor = txtImmediate.getText();
            int basicSalary = Integer.parseInt(txtBasic.getText());
            int riceSubsidy = Integer.parseInt(txtRice.getText());
            int phoneAllowance = Integer.parseInt(txtPhoneAl.getText());
            int clothingAllowance = Integer.parseInt(txtClothing.getText());
            int grossSemiMonthlyRate = Integer.parseInt(txtGross.getText());
            double hourlyRate = Double.parseDouble(txtHourly.getText());
            System.out.println("Updating employee # " + empNo);
            System.out.println("New last name  = " + lastName);

            EmployeeDataHandler.updateEmployee(
                    empNo,
                    lastName,
                    firstName,
                    birthday,
                    address,
                    phoneNumber,
                    sssNumber,
                    philHealthNumber,
                    tinNumber,
                    pagIBIGNumber,
                    status,
                    position,
                    immediateSupervisor,
                    basicSalary,
                    riceSubsidy,
                    phoneAllowance,
                    clothingAllowance,
                    grossSemiMonthlyRate,
                    hourlyRate
            );

            viewEmployees();
            clearFields();

            JOptionPane.showMessageDialog(
                    this,
                    "Employee updated successfully!",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Birthday must be MM/dd/yyyy.",
                    "Date Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Update Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Delete Employee
    private void deleteEmployee() {

        int selectedRow = employeeTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select an employee first.",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Delete selected employee?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int empNo = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());

        EmployeeDataHandler.deleteEmployee(empNo);

        viewEmployees();

        clearFields();
    }

    // Clear Fields 
    private void clearFields() {
        txtEmpNo.setText("");
        txtLastN.setText("");
        txtFirstN.setText("");
        txtBirthday.setText("");
        txtAddress.setText("");
        txtPhoneN.setText("");
        txtSSS.setText("");
        txtPhilHealth.setText("");
        txtTIN.setText("");
        txtPagIBIG.setText("");
        txtStatus.setText("");
        txtPosition.setText("");
        txtImmediate.setText("");
        txtBasic.setText("");
        txtRice.setText("");
        txtPhoneAl.setText("");
        txtClothing.setText("");
        txtGross.setText("");
        txtHourly.setText("");
    }
}
