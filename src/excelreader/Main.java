/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelreader;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author the_fegati
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
      File excelFile = new File("/home/the_fegati/NetBeansProjects/ExcelReader/src/excelreader/PatientCorePopulatedTable.xlsx");
        ExcelReader excelReader = new ExcelReader(excelFile);
        ArrayList<ArrayList<Object>> list = excelReader.getRowAsListFromExcel();
        
        for(ArrayList<Object> singleRow : list){
            int index = 0;
            
            while (index < singleRow.size()) {                
                System.out.print(singleRow.get(index) + "   ");
                index++;
            }
            System.out.println();
        }
        
    }
}
