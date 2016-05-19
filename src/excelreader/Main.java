/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelreader;

import apriori.mining.Apriori;
import csv.data.CsvFromDB;
import miner.data.DataConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import miner.mining.helper.DataHelper;

/**
 *
 * @author the_fegati
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        File excelFile = new File("/media/the_fegati/Warehouse/FelixData/Batch3/pharmacy5.xlsx");
//        HivExcelReader hivExcelReader = new HivExcelReader(excelFile);
//        ExcelReader excelReader = new ExcelReader(excelFile);
//        ArrayList<ArrayList<Object>> list = excelReader.getRowAsListFromExcel();

        /*instantiate class DataExport and pass the arraylist data to be exported
         to database*/
        DataExport dataExport = new DataExport();
        //dataExport.tblPatientDetailsExport(list);
        //dataExport.tblICD10Export(list);
        //dataExport.tblAdmissionsExport(list);
        //dataExport.tblAdmissionDiagnosesExport(list);
        //dataExport.tblLabsExport(list);
//        dataExport.hivLabsExport(list);
//        dataExport.hivArtPatientsExport(list);
//        dataExport.hivPatientsExport(list);
//        dataExport.hivPatientsStatusExport(list);
//        dataExport.hivPharmacyExport(list);

//        HivLabsFuzzification f = new HivLabsFuzzification();
//        f.getLabsData();
        
        CsvFromDB cfdb = new CsvFromDB();
        try {
//            cfdb.getHivFuzzyLabsOnGender("Female");
//            cfdb.getHivFuzzyLabsOnRegion("North Eastern");
            cfdb.getHivFuzzyLabsOnMaritalStatus("Divorced");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        DataConnection dataConnection = new DataConnection();
        PrintWriter out = new PrintWriter(System.out, true);
//        dataConnection.dataConnect(out, minSupport, minConfidence);

        String filename = "data/general_fuzzy.csv";
        Double minSupport = 0.35;
        Double minConfidence = 0.7;
        DataHelper.init(minSupport, minConfidence);
        Apriori aprioriHelper = new Apriori();

//        try {
//            aprioriHelper.doApriori(minSupport, minConfidence, filename);
//        } catch (IOException e) {
//            System.err.println("I/O failed " + e.toString());
//        }

    }
}
