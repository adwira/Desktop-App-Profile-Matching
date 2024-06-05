/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DataSource extends DefaultTableModel {

    
    public static Object [][] gapValue;
//    public static Object [] ColumnName = {"a","b","c","d","e"};
    public static String [] TABLE_HEADER;
    public void setDataSource(Object [][] gapValue, String [] TABLE_HEADER ){
        this.gapValue = gapValue;
        this.TABLE_HEADER = TABLE_HEADER;
    }
    
    public Object[][]  getDataSourceGapVal(){
        return this.gapValue;
    }
    
    public String[] getDataSourceTH(){
        return TABLE_HEADER;
    }

    
}
