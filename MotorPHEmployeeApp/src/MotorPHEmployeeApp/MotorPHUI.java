/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPHEmployeeApp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Home
 */
public class MotorPHUI {
    
    private JFrame frame;
    private JPanel panel;
    private ImageIcon image;

    private List<Employee> employeeList;
    private List<Attendance> attendanceList;

    public MotorPHUI() {

        // Load CSV Once
        employeeList = CSVHandler.readEmployeeFile();
        attendanceList = CSVHandler.readAttendanceFile();

        // Logo
        image = new ImageIcon("logo.png");

        // Frame
        frame = new JFrame("MotorPH Employee App");
        frame.setSize(500, 400);
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel
        panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setLayout(new FlowLayout());

        // Load Login Screen
        showLoginScreen();

        frame.add(panel);
        frame.setVisible(true);
    }

    // Login Screen
    private void showLoginScreen() {

        panel.removeAll();

        JLabel usernameLbl = new JLabel("Username:");
        JTextField usernameTxt = new JTextField(15);
                
        JLabel passwordLbl = new JLabel("Password:");               
        JPasswordField passwordFld = new JPasswordField(15);
                
        JButton loginBtn = new JButton("Login");                
        JButton clearBtn = new JButton("Clear");          

        panel.add(usernameLbl);
        panel.add(usernameTxt);

        panel.add(passwordLbl);
        panel.add(passwordFld);

        panel.add(loginBtn);
        panel.add(clearBtn);

        // Login Button 
        loginBtn.addActionListener(new ActionListener() {
                
            @Override
            public void actionPerformed(
                    ActionEvent e) {

                String username = usernameTxt.getText().trim();
                
                String password = new String(passwordFld.getPassword());
                                             
                    // Empty Login
                if (username.equals("") || password.equals("")) {
                    
                    JOptionPane.showMessageDialog(frame,
                            "Please fill out all required fields.");
                  // Employee Login
                } else if (username.equals("employee") && password.equals("12345")) {
               
                    showEmployeeMenu();
                } // Payroll Staff Login
                else if (username.equals("payroll_staff") && password.equals("12345")) { 

                    showPayrollMenu();
                } // Invalid Login
                else {

                    JOptionPane.showMessageDialog(frame,
                            "Invalid username or password.");
                }
            }
        });

        clearBtn.addActionListener(new ActionListener() {
                
            @Override
            public void actionPerformed( ActionEvent e) {
                   
                usernameTxt.setText("");
                passwordFld.setText("");
            }
        });

        panel.revalidate();
        panel.repaint();
    }

    // Employee Menu
    private void showEmployeeMenu() {

        panel.removeAll();

        JButton employeeSearchBtn = new JButton("Search Employee");
        JButton logoutBtn = new JButton("Logout");
                
        panel.add(employeeSearchBtn);
        panel.add(logoutBtn);

        // Search Button
        employeeSearchBtn.addActionListener(new ActionListener() {
                
            @Override
            public void actionPerformed(ActionEvent e) {
                            
                showEmployeeSearch();
            }
        });

        // Logout Button
        logoutBtn.addActionListener(new ActionListener() { 

            @Override
            public void actionPerformed( ActionEvent e) {
                   
                showLoginScreen();
            }
        });

        panel.revalidate();
        panel.repaint();
    }

    // Employee Search
    private void showEmployeeSearch() {

        panel.removeAll();
        JLabel employeeNumberLbl = new JLabel("Employee Number:");    
                        

        JTextField employeeNumberField = new JTextField(15);             

        JButton searchBtn = new JButton("Search");   
        JButton backBtn = new JButton("Back");
                
        panel.add(employeeNumberLbl);
        panel.add(employeeNumberField);
        panel.add(searchBtn);
        panel.add(backBtn);

       // Search Button
        searchBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    
                try {
                    if (employeeNumberField.getText().trim().isEmpty()) {                 
                            
                        JOptionPane.showMessageDialog(frame,
                                "Please enter employee number.");
                        
                        return;
                    }

                    int employeeNumber = Integer.parseInt(employeeNumberField.getText().trim());
                                                                                                          
                    Employee employee = CSVHandler.findEmployee(employeeList, employeeNumber);
                            
                    if (employee == null) {

                        JOptionPane.showMessageDialog(frame,                              
                                "Employee not found.");

                        return;
                    }
                    
                    String info = employee.displayEmployeeInfo();
                            
                    JOptionPane.showMessageDialog(frame,info);
        
                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(frame,
                            "Employee number must be numeric.");
                }
            }
        });

        // Back Button
        backBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                showEmployeeMenu();
            }
        });

        panel.revalidate();
        panel.repaint();
    }

    // Payroll Menu
    private void showPayrollMenu() {

        panel.removeAll();

        JButton processPayrollBtn = new JButton("Process Payroll");
        JButton logoutBtn = new JButton("Logout");

        panel.add(processPayrollBtn);
        panel.add(logoutBtn);

        // Process Payroll
        processPayrollBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                            
                showPayrollEmployeeSearch();
            }
        });

        logoutBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    
                showLoginScreen();
            }
        });

        panel.revalidate();
        panel.repaint();
    }

    // Payroll Screen
    private void showPayrollEmployeeSearch() {

        panel.removeAll();

        // Employee Number 
        JLabel employeeNumberLbl = new JLabel("Employee Number:");
        JTextField employeeNumberTxt = new JTextField(15);

        // Employee Name
        JLabel employeeNameLbl = new JLabel("Employee Name:");
        JTextField employeeNameTxt = new JTextField(15);

        employeeNameTxt.setEditable(false);

        // Month
        JLabel monthLbl = new JLabel("Month:");

        String[] months = {
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        };

        JComboBox<String> monthComBox = new JComboBox<>(months);

        // Pay Coverage
        JLabel coverageLbl = new JLabel("Pay Coverage:");

        String[] coverageOptions = {
            "1 - 15",
            "16 - 30/31",
            "1 - 30/31"
        };

        JComboBox<String> coverageComBox = new JComboBox<>(coverageOptions);

        // Buttons
        JButton generatePayslipBtn = new JButton("Generate Payslip");
        JButton clearBtn = new JButton("Clear");
        JButton backBtn = new JButton("Back");

        // Panel
        panel.add(employeeNumberLbl);
        panel.add(employeeNumberTxt);

        panel.add(employeeNameLbl);
        panel.add(employeeNameTxt);

        panel.add(monthLbl);
        panel.add(monthComBox);

        panel.add(coverageLbl);
        panel.add(coverageComBox);

        panel.add(generatePayslipBtn);

        panel.add(clearBtn);

        panel.add(backBtn);

        // Generate Button
        generatePayslipBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    
                try {
                    // Empty validation
                    if (employeeNumberTxt.getText().trim().isEmpty()) {
                                                                                   
                        JOptionPane.showMessageDialog(frame,
                                "Please enter employee number.");

                        return;
                    }

                    // Numeric Validation
                    int employeeNumber = Integer.parseInt(employeeNumberTxt.getText().trim());

                    // Find Employee
                    Employee employee = CSVHandler.findEmployee(employeeList, employeeNumber);
                            
                    if (employee == null) {

                        JOptionPane.showMessageDialog(frame,
                                "Employee not found.");

                        return;
                    }

                    // Auto-fill Name
                    employeeNameTxt.setText(
                            employee.getFirstName() + " " + employee.getLastName());

                    // Month
                    String selectedMonth = monthComBox.getSelectedItem().toString();

                    int month = Month.valueOf( selectedMonth.toUpperCase()).getValue();
                            
                    // Coverage
                    String selectedCoverage = coverageComBox.getSelectedItem().toString();
                                              
                    // Payroll 
                    Payroll payroll = new Payroll();
                            
                    String payslip = payroll.generatePayslip(employee, attendanceList, month, selectedCoverage);
                            
                    // Display Payslip
                    JOptionPane.showMessageDialog(frame, payslip);                
                    
                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(frame,
                            "Please enter a valid numeric Employee Number.");
                    
                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(frame,
                            "Unexpected Error: " + ex.getMessage());
                            
                }
            }
        });

        // Clear Button
        clearBtn.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                employeeNumberTxt.setText("");
                employeeNameTxt.setText("");

                monthComBox.setSelectedIndex(0);
                coverageComBox.setSelectedIndex(0);
            }
        });

        // Back Button
        backBtn.addActionListener(new ActionListener() {                

            @Override
            public void actionPerformed(ActionEvent e) {
                    
                showPayrollMenu();
            }
        });

        panel.revalidate();
        panel.repaint();
    }
}
