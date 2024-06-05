/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class Kalkulasi {
    
    Object[][] value;
    Object [][] NT;
    Double [] SfVal;
    Double [] CfVal;
    int [] CFCol;
    int [] SFCol;
    double cf, sf;
    HashMap<Integer,Double> Bobot = new HashMap<Integer,Double>();
    
    Kalkulasi(Object[][] value, double cf, double sf,int [] CFCol,  int [] SFCol){
        this.value = value;
        this.cf = cf;
        this.sf = sf;
        this.CFCol = CFCol;
        this.SFCol = SFCol;
        
    }
    public int[] extractNumbers(String input) {
        // Pisahkan string berdasarkan koma
        String[] numbersAsString = input.split(",");
        
        // Buat array untuk menyimpan angka-angka
        int[] numbers = new int[numbersAsString.length];
        
        // Konversi string ke angka dan simpan ke dalam array
        for (int i = 0; i < numbersAsString.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }
        
        return numbers;
    }
    public void bobotRun(){
        Bobot.put(0, 5.0);
        Bobot.put(1, 4.5);
        Bobot.put(-1, 4.0);
        Bobot.put(2, 3.5);
        Bobot.put(-2, 3.0);
        Bobot.put(3, 2.5);
        Bobot.put(-3, 2.0);
        Bobot.put(4, 1.5);
        Bobot.put(-4, 1.0);
        
        for(int i = 0; i < value.length; i++){
            for(int j = 1; j < value[i].length; j++){        
                Double s = Bobot.get(value[i][j]);
                value[i][j] = s;
            }
        }
        
    }
    
    public Object[][] NTGet(){
        
        for(int j = 0; j < value.length; j++){
            double nf = 0;
            for(int i = 0; i < CFCol.length; i++){
                double temp = 0;
                temp = (double) value[j][CFCol[i]];
                nf += temp;
            }
            CfVal[j] = nf;
        }
        
        for(int j = 0; j < value.length; j++){
            double nf = 0;
            for(int i = 0; i < SFCol.length; i++){
                double temp = 0;
                temp = (double) value[j][SFCol[i]];
                nf += temp;
            }
            SfVal[j] = nf;
        }
        
        for(int i = 0; i < value.length; i++){
            NT[i][0] = value[i][0];
            NT[i][1] = ((CfVal[i]*cf)/100 + (SfVal[i]*sf)/100);
        }
        return NT;
    }
    
//    bobot.put(0,5);
//    double [] bobot;
    
}
