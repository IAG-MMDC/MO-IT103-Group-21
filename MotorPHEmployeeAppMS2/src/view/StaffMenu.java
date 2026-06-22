/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Home
 */
public class StaffMenu extends JPanel {

    public StaffMenu(MainGUIFrame mainGUIFrame) {
        /*
        -Employee Records 
        -Payroll
            -One Employee
            -All Employee
         */
        
        setLayout(new BorderLayout());

        // Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.DARK_GRAY);
        leftPanel.setPreferredSize(new Dimension(190, 0));
        leftPanel.setLayout(null);    
       
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.LIGHT_GRAY);
        
        JButton btnRecords = new JButton("Employee Records");
        btnRecords.setBounds(20, 200, 150, 30);
        
        JButton btnPayroll = new JButton("Payroll Records");
        btnPayroll.setBounds(20, 235, 150, 30);
        
        // Button
        JButton btnLogOut = new JButton("LogOut");
        btnLogOut.setBounds(40, 505, 110, 25);

        leftPanel.add(btnRecords);
        leftPanel.add(btnPayroll);
        leftPanel.add(btnLogOut);
        
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        // Button Actions 
        btnRecords.addActionListener(e -> mainGUIFrame.showCard("employeeRecords-Card"));
        btnPayroll.addActionListener(e -> mainGUIFrame.showCard("payrollRecords-Card"));
        btnLogOut.addActionListener(e -> mainGUIFrame.showCard("loginScreen-Card"));
    }
}
