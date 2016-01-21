/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelreader;

import apriori.mining.Apriori;
import database.data.Fuzzification;
import miner.data.DataConnection;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        File excelFile = new File("/home/the_fegati/Dropbox/project/data/100-Patients/LabsCorePopulatedTable.xlsx");
        ExcelReader excelReader = new ExcelReader(excelFile);
        //ArrayList<ArrayList<Object>> list = excelReader.getRowAsListFromExcel();

        /*instantiate class DataExport and pass the arraylist data to be exported
         to database*/
        DataExport dataExport = new DataExport();
        //dataExport.tblPatientDetailsExport(list);
        //dataExport.tblICD10Export(list);
        //dataExport.tblAdmissionsExport(list);
        //dataExport.tblAdmissionDiagnosesExport(list);
        //dataExport.tblLabsExport(list);

        Fuzzification f = new Fuzzification();
       // f.getLabsData();

        DataConnection dataConnection = new DataConnection();
        PrintWriter out = new PrintWriter(System.out, true);
//        dataConnection.dataConnect(out, minSupport, minConfidence);

        String filename = "INTEGRATED-DATASET-1.csv";
        Double minSupport = 0.1;
        Double minConfidence = 0.3;
        DataHelper.init(minSupport, minConfidence);
        Apriori aprioriHelper = new Apriori();

        try {
            aprioriHelper.doApriori(minSupport, minConfidence, filename);
        } catch (IOException e) {
            System.err.println("I/O failed " + e.toString());
        }

    }
}
