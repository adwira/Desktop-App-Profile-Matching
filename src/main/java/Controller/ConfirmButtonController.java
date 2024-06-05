/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DataSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ConfirmButtonController implements ActionListener{
    
    private JFileChooser FileName = new JFileChooser();
    private Kalkulasi NT;
    private JButton ButtonController = new JButton();
    private JFileChooser DirFile = new JFileChooser();
    private JTextField SearchColumn = new JTextField();
    private JLayeredPane LayerPane = new JLayeredPane();
    private JFileChooser Layer1 = new JFileChooser();
    private JTable Layer2 = new JTable();
    DataSource Table = new DataSource();
    private DefaultTableModel model;
    CsvReader CsvFile = new CsvReader();
    
//    private DefaultTableModel model;
    public ConfirmButtonController( DefaultTableModel model,
        JFileChooser FileName, JButton ButtonController, JFileChooser DirFile, 
        JLayeredPane LayerPane, JFileChooser Layer1, JTable Layer2){
        this.DirFile = DirFile;
        this.LayerPane = LayerPane;
        this.Layer1 = Layer1;
        this.model = model;
        this.FileName = FileName;
        this.ButtonController = ButtonController;
        this.Layer2 = Layer2;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String FileNameString = this.FileName.getName();
        String ButtonCondition = ButtonController.getText();
        String DirFileString = this.DirFile.getSelectedFile().getAbsolutePath();
        CsvFile.Reader(DirFileString);
        Table.setDataSource(CsvFile.getTableValue(), CsvFile.getTableHeader());
        model.setDataVector(Table.getDataSourceGapVal(), Table.getDataSourceTH());
//        Table.set(Table.TABLE_HEADER);
        
        SearchColumn.setText(FileNameString);
        
        if(ButtonCondition == "Konfirmasi"){
            
            LayerPane.removeAll();
            LayerPane.add(Layer2);
            LayerPane.repaint();
            LayerPane.revalidate();
            ButtonController.setText("File Lain");
        }
        else{
            LayerPane.removeAll();
            LayerPane.add(Layer1);
            LayerPane.repaint();
            LayerPane.revalidate();
            ButtonController.setText("Konfirmasi");
             
        }
    }
    
}
