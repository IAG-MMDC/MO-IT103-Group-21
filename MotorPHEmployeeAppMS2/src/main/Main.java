/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.SwingUtilities;
import view.MainGUIFrame;

/**
 *
 * @author Home Group 21  - ComProg2 - H1101
 */
public class Main {
    
    public static void main(String[] args) {
        
         SwingUtilities.invokeLater(() -> {
            //Launch GUI here
            new MainGUIFrame();
        });
    }
    
}
