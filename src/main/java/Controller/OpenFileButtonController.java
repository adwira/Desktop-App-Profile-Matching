/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.DataSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class OpenFileButtonController implements ActionListener{
     private JFileChooser FileName = new JFileChooser();
     private JFileChooser DirFile = new JFileChooser();
     private JTextField SearchColumn = new JTextField();
     private JLayeredPane LayerPane = new JLayeredPane();
     private JTable Layer2 = new JTable();
     DataSource Table = new DataSource();
     private DefaultTableModel model;
     CsvReader CsvFile = new CsvReader();
     

    public OpenFileButtonController(JFileChooser FileName, JFileChooser DirFile, 
            JLayeredPane LayerPane, JTable Layer2, DefaultTableModel model, JTextField SearchColumn) {
        this.FileName = FileName; 
        this.SearchColumn = SearchColumn;
        this.DirFile = DirFile;
        this.LayerPane = LayerPane;
        this.Layer2 = Layer2;
        this.model = model;
//        this.SearchColumn = SearchColumn;
    }
     
     

    @Override
    public void actionPerformed(ActionEvent e) {
        String FileNameString = this.FileName.getName();
        String DirFileString = this.DirFile.getSelectedFile().getAbsolutePath();
        CsvFile.Reader(DirFileString);
        Table.setDataSource(CsvFile.getTableValue(), CsvFile.getTableHeader());
        model.setDataVector(CsvFile.tableValue, CsvFile.tableHeader);
//        String[] t = Table.TABLE_HEADER;
        
        
//        Layer2.setTableHeader();
        SearchColumn.setText(DirFileString);
        LayerPane.removeAll();
        LayerPane.add(Layer2);
        LayerPane.repaint();
        LayerPane.revalidate();
    }

//    private void CsvFile(String DirFileString) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
     
}
