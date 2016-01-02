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
      File excelFile = new File("/home/the_fegati/Dropbox/project/data/100-Patients/LabsCorePopulatedTable.xlsx");
        ExcelReader excelReader = new ExcelReader(excelFile);
        ArrayList<ArrayList<Object>> list = excelReader.getRowAsListFromExcel();
        
        /*instantiate class DataExport and pass the arraylist data to be exported
         to database*/  
        DataExport dataExport = new DataExport();
        //dataExport.tblPatientDetailsExport(list);
        //dataExport.tblICD10Export(list);
        //dataExport.tblAdmissionsExport(list);
        //dataExport.tblAdmissionDiagnosesExport(list);
        dataExport.tblLabsExport(list);
        
    }
}
