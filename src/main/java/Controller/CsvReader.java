/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DataSource;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class CsvReader {
    private String file;
    public Object [][] tableValue;
    public String[]tableHeader;
    

//    public CsvReader() {
//        
//    }
    
    public void Reader(String file){
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//        String line = br.readLine();
//        while(line != null){
//        }
        this.file = file;
        this.tableHeader = tableHeader;
        this.tableValue = tableValue;
        List<Object[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean headerRead = false;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (!headerRead) {
                    tableHeader = values;
                       
//                    rows.add(values);
                    headerRead = true;
                } else {
                    rows.add(values);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tableValue = new Object[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            tableValue[i] = rows.get(i);
        }
    }
     public Object[][] getTableValue() {
        return tableValue;
    }

    public String[] getTableHeader() {
        return tableHeader;
    }
//    DataSource table = new DataSource(tableValue,tableHeader);
//    table(tableValue,tableHeader);
    
}
