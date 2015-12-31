package excelreader;

/**
 *
 * @author the_fegati
 */

import database.TblPatientDetails;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataExport {
    /*create entity manager instance*/
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExcelReaderPU");
    EntityManager em = emf.createEntityManager();
    
    /*inserts patients details into TblPatientDetails entity*/
    public void tblPatientDetailsExport(ArrayList<ArrayList<Object>> list){
        em.getTransaction().begin();
        
        TblPatientDetails patient = new TblPatientDetails();
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
