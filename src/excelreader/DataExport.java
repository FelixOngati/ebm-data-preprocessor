package excelreader;

/**
 *
 * @author the_fegati
 */
import database.persistence.TblAdmissionDiagnoses;
import database.persistence.TblAdmissions;
import database.persistence.TblICD10;
import database.persistence.TblLabs;
import database.persistence.TblPatientDetails;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataExport {
    /*create entity manager instance*/

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExcelReaderPU");
    EntityManager em = emf.createEntityManager();

    /*create date formatter to pass String to date*/
    DateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");

    /*inserts patients details into TblPatientDetails entity*/
    public void tblPatientDetailsExport(ArrayList<ArrayList<Object>> list) {

        em.getTransaction().begin();
        /*counter to control batch inserts*/
        int batchsize = 0;
        for (ArrayList<Object> singleRow : list) {
            TblPatientDetails patient = new TblPatientDetails();
            ++batchsize;
            patient.setPatientId(singleRow.get(0).toString());
            patient.setPatientGender(singleRow.get(1).toString());

            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(singleRow.get(2).toString());
                patient.setPatientDOB(date);
            } catch (ParseException ex) {
                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, ex);
            }
            patient.setPatientRace(singleRow.get(3).toString());
            patient.setPatientMaritalStatus(singleRow.get(4).toString());
            patient.setPatientLanguage(singleRow.get(5).toString());
            patient.setPatientPopulationPercentageBelowPoverty(singleRow.get(6).toString());

            em.persist(patient);
            /*insert in batches of size 100*/
            if ((batchsize % 10) == 0) {
                em.getTransaction().commit();
                em.clear();
                batchsize = 0;
                em.getTransaction().begin();
            }

            int index = 0;
            while (index < singleRow.size()) {
                System.out.print(singleRow.get(index) + "   ");
                index++;
            }
            System.out.println();
        }
        em.getTransaction().commit();
        //em.close();
        //emf.close();
    }

    /*inserts ICD 10 codes into TblICD10 entity*/
    public void tblICD10Export(ArrayList<ArrayList<Object>> list) {

        em.getTransaction().begin();
        /*counter to control batch inserts*/
        int batchsize = 0;
        for (ArrayList<Object> singleRow : list) {
            TblICD10 icd10 = new TblICD10();
            ++batchsize;
            icd10.setDcode(singleRow.get(0).toString());
            icd10.setShortDescription(singleRow.get(1).toString());
            icd10.setLongDescription(singleRow.get(2).toString());

            em.persist(icd10);
            /*insert in batches of size 100*/
            if ((batchsize % 1000) == 0) {
                em.getTransaction().commit();
                em.clear();
                batchsize = 0;
                em.getTransaction().begin();
            }

            int index = 0;
            while (index < singleRow.size()) {
                System.out.print(singleRow.get(index) + "   ");
                index++;
            }
            System.out.println();
        }
        em.getTransaction().commit();
        //em.close();
        //emf.close();
    }

    /*inserts ICD 10 codes into TblICD10 entity*/
    public void tblAdmissionsExport(ArrayList<ArrayList<Object>> list) {

        em.getTransaction().begin();
        /*counter to control batch inserts*/
        int batchsize = 0;
        for (ArrayList<Object> singleRow : list) {
            TblAdmissions admission = new TblAdmissions();
            ++batchsize;
            TblPatientDetails patient = em.getReference(TblPatientDetails.class, singleRow.get(0).toString());
            admission.setPatientId(patient);
            int x = Math.round(Float.valueOf(singleRow.get(1).toString()));
            //System.out.println(String.valueOf(x));
            admission.setAdmissionId(String.valueOf(x));
            try {
                Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(singleRow.get(2).toString());
                Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(singleRow.get(3).toString());
                admission.setAdmissionStartDate(date1);
                admission.setAdmissionEndDate(date2);
            } catch (ParseException ex) {
                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, ex);
            }

            em.persist(admission);
            /*insert in batches of size 100*/
            if ((batchsize % 1000) == 0) {
                em.getTransaction().commit();
                em.clear();
                batchsize = 0;
                em.getTransaction().begin();
            }

            int index = 0;
            while (index < singleRow.size()) {
                System.out.print(singleRow.get(index) + "   ");
                index++;
            }
            System.out.println();
        }
        em.getTransaction().commit();
        //em.close();
        //emf.close();
    }

    public void tblAdmissionDiagnosesExport(ArrayList<ArrayList<Object>> list) {

        em.getTransaction().begin();
        /*counter to control batch inserts*/
        int batchsize = 0;
        for (ArrayList<Object> singleRow : list) {
            ++batchsize;

            TblAdmissionDiagnoses diagnosis = new TblAdmissionDiagnoses();
            /*get reference to patientId fron patientDetails in order to set the foreign key*/
            TblPatientDetails patient = em.getReference(TblPatientDetails.class, singleRow.get(0).toString());
           // TblAdmissions admission = em.getReference(TblAdmissions.class, (Math.round(Float.valueOf(singleRow.get(1).toString()))));

            String x = (singleRow.get(2).toString());
            if (x.contains(".")) {
                String[] y = x.split("\\.");
                diagnosis.setDcode(y[0] + y[1]);
                //System.out.println(y[0] + y[1]);
                //System.exit(0);
            } else {
                diagnosis.setDcode(x);
            }

            //TblICD10 icdcode = em.getReference(TblICD10.class, singleRow.get(2).toString());
            diagnosis.setPatientId(patient);
            diagnosis.setAdmissionId(String.valueOf(Math.round(Float.valueOf(singleRow.get(1).toString()))));
            diagnosis.setPrimaryDiagnosisDescription(singleRow.get(3).toString());

            em.persist(diagnosis);
            /*insert in batches of size 100*/
            if ((batchsize % 100) == 0) {
                em.getTransaction().commit();
                em.clear();
                batchsize = 0;
                em.getTransaction().begin();
            }

            int index = 0;
            while (index < singleRow.size()) {
                System.out.print(singleRow.get(index) + "   ");
                index++;
            }
            System.out.println();
        }
        em.getTransaction().commit();
        //em.close();
        //emf.close();
    }

    public void tblLabsExport(ArrayList<ArrayList<Object>> list) {

        em.getTransaction().begin();
        /*counter to control batch inserts*/
        int batchsize = 0;
        for (ArrayList<Object> singleRow : list) {
            ++batchsize;

            TblLabs lab = new TblLabs();
            /*get reference to patientId fron patientDetails in order to set the foreign key*/
            TblPatientDetails patient = em.getReference(TblPatientDetails.class, singleRow.get(0).toString());
            //TblAdmissions admission = em.getReference(TblAdmissions.class, (Math.round(Float.valueOf(singleRow.get(1).toString()))));

            lab.setPatientId(singleRow.get(0).toString());
            lab.setAdmissionId(String.valueOf(Math.round(Float.valueOf(singleRow.get(1).toString()))));
            lab.setLabName(singleRow.get(2).toString());
            lab.setLabValue((double) singleRow.get(3));
            lab.setLabUnits(singleRow.get(4).toString());
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(singleRow.get(5).toString());
                lab.setLabDateTime(date);

            } catch (ParseException ex) {
                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, ex);
            }

            em.persist(lab);
            /*insert in batches of size 100*/
            if ((batchsize % 1000) == 0) {
                em.getTransaction().commit();
                em.clear();
                batchsize = 0;
                em.getTransaction().begin();
            }

            int index = 0;
            while (index < singleRow.size()) {
                System.out.print(singleRow.get(index) + "   ");
                index++;
            }
            System.out.println();
        }
        em.getTransaction().commit();
        //em.close();
        //emf.close();
    }
}
