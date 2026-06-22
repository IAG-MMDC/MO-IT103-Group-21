/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class CSVParser {

    public static List<String> parseCSVLine(String line) {

        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            if (currentChar == '"') {
                inQuotes = !inQuotes;
            } else if (currentChar == ',' && !inQuotes) {
                tokens.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(currentChar);
            }
        }
        tokens.add(sb.toString().trim());
        return tokens;
    }
}
