/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Employee;
import service.EmployeeDataHandler;

/**
 *
 * @author Home
 */
public class SearchEmployee extends JPanel {

    private MainGUIFrame mainGUIFrame;
    private EmployeeDataHandler employeeDataHandler;

    private JTextField txtEmpNo;

    public SearchEmployee(MainGUIFrame mainGUIFrame) {
        this.mainGUIFrame = mainGUIFrame;
        this.employeeDataHandler = new EmployeeDataHandler();

        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);

        GridBagConstraints outer = new GridBagConstraints();
        outer.gridx = 0;
        outer.gridy = 0;

        // Card Panel
        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setPreferredSize(new Dimension(350, 320));
        searchPanel.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);

        // Title 
        JLabel lblTitle = new JLabel("MotorPH Employee App");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 10, 25, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        searchPanel.add(lblTitle, gbc);

        // Reset Constraints 
        gbc.insets = new Insets(6, 10, 6, 10);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Label
        JLabel lblSearchNo = new JLabel("Search Employee #:");
        lblSearchNo.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 1;
        searchPanel.add(lblSearchNo, gbc);

        // Text Field
        txtEmpNo = new JTextField();
        txtEmpNo.setPreferredSize(new Dimension(160, 25));

        gbc.gridx = 1;
        searchPanel.add(txtEmpNo, gbc);

        // Buttons
        JButton btnSearch = new JButton("Search");
        JButton btnClear = new JButton("Clear");

        Dimension btnSize = new Dimension(80, 30);
        btnSearch.setPreferredSize(btnSize);
        btnClear.setPreferredSize(btnSize);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnClear);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        searchPanel.add(buttonPanel, gbc);

        // Button Actions
        btnSearch.addActionListener(e -> searchEmployee());
        btnClear.addActionListener(e -> clearFields());

        // Add Panel
        add(searchPanel, outer);
    }

    // Search Employee
    private void searchEmployee() {

        try {
            int empNo = Integer.parseInt(txtEmpNo.getText());

            Employee employee = EmployeeDataHandler.findEmpNo(empNo);

            if (employee != null) {

                mainGUIFrame.getEmployeeMenu().setEmployee(employee);

                mainGUIFrame.showCard("employeeMenu-Card");
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Employee not found.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please input a numeric value.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            
            clearFields();
        }
    }

    // Clear Fields
    private void clearFields() {
        txtEmpNo.setText("");
    }
}
