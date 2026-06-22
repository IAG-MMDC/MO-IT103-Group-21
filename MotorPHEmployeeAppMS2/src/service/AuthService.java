/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Home
 */
public class AuthService {
    
    public boolean authenticate(String username, String password) {

        return ("employee".equals(username) || "payroll_staff".equals(username))
                && "12345".equals(password);
    }
}
