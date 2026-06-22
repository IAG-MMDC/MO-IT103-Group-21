/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Home 
 */
public class MainGUIFrame extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel rootPanel;
    private EmployeeMenu employeeMenu;
    private ImageIcon image;

    public MainGUIFrame() {

        setTitle("MotorPH Employee App");
        image = new ImageIcon("logo.png");
        setIconImage(image.getImage());
        setSize(665, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        LoginScreen login = new LoginScreen(this);
        SearchEmployee searchEmployee = new SearchEmployee(this);
        employeeMenu = new EmployeeMenu(this);
        StaffMenu staffMenu = new StaffMenu(this);
        EmployeeRecords employeeRecords = new EmployeeRecords(this);
        PayrollRecords payrollRecords = new PayrollRecords(this);

        cardLayout = new CardLayout();
        rootPanel = new JPanel(cardLayout);
        
        rootPanel.add(login, "loginScreen-Card");
        rootPanel.add(searchEmployee, "searchEmployee-Card");
        rootPanel.add(employeeMenu, "employeeMenu-Card");
        rootPanel.add(staffMenu, "staffMenu-Card");
        rootPanel.add(employeeRecords, "employeeRecords-Card");
        rootPanel.add(payrollRecords, "payrollRecords-Card");  
        
        add(rootPanel);
       
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // Show Card
    public void showCard(String cardName) {
        cardLayout.show(rootPanel, cardName);
    }
    
    // Get Employee Menu
    public EmployeeMenu getEmployeeMenu() {
        return employeeMenu;
    }
}
