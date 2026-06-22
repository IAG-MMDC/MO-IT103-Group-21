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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import service.AuthService;

/**
 *
 * @author
 */
public class LoginScreen extends JPanel {

    private JTextField txtUser;
    private JPasswordField txtPass;
    private AuthService authService;
    private MainGUIFrame mainGUIFrame;

    public LoginScreen(MainGUIFrame mainGUIFrame) {
        
        this.mainGUIFrame = mainGUIFrame;
        this.authService = new AuthService();

        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);

        // Login Card Panel 
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setPreferredSize(new Dimension(350, 320));
        loginPanel.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 10, 6, 10);

        // Title 
        JLabel lblTitle = new JLabel("MotorPH Employee App");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 10, 25, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        loginPanel.add(lblTitle, gbc);
        
        // Reset Constraints 
        gbc.insets = new Insets(6, 10, 6, 10);
        gbc.gridwidth = 1;

        // Username
        JLabel lblUser = new JLabel("Username:");
        lblUser.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(lblUser, gbc);

        txtUser = new JTextField();
        txtUser.setPreferredSize(new Dimension(160, 25));

        gbc.gridx = 1;
        loginPanel.add(txtUser, gbc);

        // Password
        JLabel lblPass = new JLabel("Password:");
        lblPass.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(lblPass, gbc);

        txtPass = new JPasswordField();
        txtPass.setPreferredSize(new Dimension(160, 25));

        gbc.gridx = 1;
        loginPanel.add(txtPass, gbc);

        // Login Button
        JButton btnLogin = new JButton("Login");

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        loginPanel.add(btnLogin, gbc);

        btnLogin.addActionListener(e -> login());

        // Add Card 
        add(loginPanel);
    }

    private void login() {

        if (txtUser.getText().isEmpty() || txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in required fields.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String username = txtUser.getText();
        String password = new String(txtPass.getPassword());

        boolean isAuthenticated = authService.authenticate(username, password);

        if (isAuthenticated) {
            JOptionPane.showMessageDialog(
                    this,
                    "Login Sucessful!",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );

            if (username.equals("employee")) {
                mainGUIFrame.showCard("searchEmployee-Card");
            } else if (username.equals("payroll_staff")) {
                mainGUIFrame.showCard("staffMenu-Card");
            }

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid credentials.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        clearFields();
    }

    private void clearFields() {
        txtUser.setText("");
        txtPass.setText("");
    }
}
