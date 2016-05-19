package excelreader;

/**
 *
 * @author the_fegati
 */
import database.persistence.Hivartpatients;
import database.persistence.Hivgeneralrules;
import database.persistence.Hivlabs;
import database.persistence.Hivpatients;
import database.persistence.Hivpatientsstatus;
import database.persistence.Hivpharmacy;
import database.persistence.TblAdmissionDiagnoses;
import database.persistence.TblAdmissions;
import database.persistence.TblAssociationRules;
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
    
        public void hivLabsExport(ArrayList<ArrayList<Object>> list) {

        em.getTransaction().begin();
        /*counter to control batch inserts*/
        int batchsize = 0;
        for (ArrayList<Object> singleRow : list) {
            ++batchsize;

            Hivlabs lab = new Hivlabs();            

            lab.setPatientid(singleRow.get(0).toString());
            lab.setPatientpk(singleRow.get(1).toString());
            lab.setSitecode(Integer.valueOf((singleRow.get(2)).toString()));
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(3).toString());
                lab.setOrderedbydate(date);
            } catch (Exception e) {
                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, e);
            }
            lab.setTestname(singleRow.get(4).toString());
            try {
                lab.setTestresult((Float.valueOf(singleRow.get(5).toString())));
            } catch (Exception e) {
                lab.setTestresult(0f);
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
    
    /**
     * inserts a rule, its confidence
     * and support into db
     * @param newrule
     * @param confidence
     * @param support
     */
    public void savetRule(String newrule, float confidence, float support){
        em.getTransaction().begin();
        TblAssociationRules rule  = new TblAssociationRules();
        rule.setRule(newrule);
        rule.setConfidence(confidence);
        rule.setSupport(support);
        rule.setRating(0f);
        em.persist(rule);
        em.getTransaction().commit();
        
    }
    
    public void saveGeneralHivRule(String newrule, double confidence, double support){
        em.getTransaction().begin();
         Hivgeneralrules rule  = new Hivgeneralrules();
        rule.setRule(newrule);
        rule.setConfidence(confidence);
        rule.setSupport(support);
        rule.setRating(0f);
        em.persist(rule);
        em.getTransaction().commit();
        
    }

    void hivArtPatientsExport(ArrayList<ArrayList<Object>> list) {
        
        em.getTransaction().begin();
        /*counter to control batch inserts*/
        int batchsize = 0;
        for (ArrayList<Object> singleRow : list) {
            ++batchsize;

            Hivartpatients artpatient = new Hivartpatients();
            artpatient.setPatientpk(singleRow.get(0).toString());
            artpatient.setPatientid(singleRow.get(1).toString());
            artpatient.setAgeenrollment(Float.valueOf(singleRow.get(2).toString()));
            artpatient.setAgeartstart(Float.valueOf(singleRow.get(3).toString()));
            artpatient.setAgelastvisit(Float.valueOf(singleRow.get(4).toString()));
            artpatient.setSitecode(Integer.valueOf(singleRow.get(5).toString()));
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(6).toString());
                artpatient.setStartartdate(date);
            } catch (Exception e) {
                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, e);
            }
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(7).toString());
                artpatient.setStartartatthisfacility(date);
            } catch (Exception e) {
                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, e);
            }
            artpatient.setStartregimen(singleRow.get(8).toString());
            artpatient.setStartregimenline(singleRow.get(9).toString());
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(10).toString());
                artpatient.setLastartdate(date);
            } catch (Exception e) {
                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, e);
            }
            artpatient.setLastregimen(singleRow.get(11).toString());
            artpatient.setLastregimenline(singleRow.get(12).toString());
            artpatient.setDuration(Integer.valueOf(singleRow.get(13).toString()));
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(14).toString());
                artpatient.setExpectedreturn(date);
            } catch (Exception e) {
                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, e);
            }
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(15).toString());
                artpatient.setLastvisit(date);
            } catch (Exception e) {
                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, e);
            }
            try {
               artpatient.setExitreason(singleRow.get(16).toString()); 
            } catch (Exception e) {
                artpatient.setExitreason(null);
            }
            
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(17).toString());
                artpatient.setExitdate(date);
            } catch (Exception e) {
                artpatient.setExitdate(null);
//                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, e);
            }            
            
            em.persist(artpatient);
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
    }

    void hivPatientsExport(ArrayList<ArrayList<Object>> list) {
        em.getTransaction().begin();
        /*counter to control batch inserts*/
        int batchsize = 0;
        for (ArrayList<Object> singleRow : list) {
            ++batchsize;

            Hivpatients patient = new Hivpatients();
            patient.setPatientid(singleRow.get(0).toString());
            patient.setPatientpk(singleRow.get(1).toString());
            patient.setSitecode(Integer.valueOf(singleRow.get(2).toString()));
            patient.setGender(singleRow.get(3).toString());
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(4).toString());
                patient.setDob(date);

            } catch (Exception ex) {
                patient.setDob(null);
//                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(5).toString());
                patient.setRegistrationdate(date);

            } catch (Exception ex) {
                patient.setRegistrationdate(null);
//                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(6).toString());
                patient.setRegistrationatccc(date);

            } catch (Exception ex) {
                patient.setRegistrationatccc(null);
//                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(7).toString());
                patient.setRegistrationatpmtct(date);

            } catch (Exception ex) {
                patient.setRegistrationatpmtct(null);
//                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(8).toString());
                patient.setRegistrationattbclinic(date);

            } catch (Exception ex) {
                patient.setRegistrationattbclinic(null);
//                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, ex);
            }
            patient.setPatientsource(singleRow.get(9).toString());
            try {
               patient.setRegion(singleRow.get(10).toString()); 
            } catch (Exception e) {
                patient.setRegion(null);
            }
            try {
                patient.setDistrict(singleRow.get(11).toString());
            } catch (Exception e) {
                patient.setDistrict(null);
            }            
            
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(12).toString());
                patient.setLastvisit(date);

            } catch (Exception ex) {
                patient.setLastvisit(null);
//                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                patient.setMaritalstatus(singleRow.get(13).toString());
            } catch (Exception e) {
                patient.setMaritalstatus(null);
            }
            try {
                patient.setEducationlevel(singleRow.get(14).toString()); 
            } catch (Exception e) {
                 patient.setEducationlevel(null);
            }
           
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(15).toString());
                patient.setDateconfirmedhivpositive(date);

            } catch (Exception ex) {
                patient.setDateconfirmedhivpositive(null);
//                Logger.getLogger(DataExport.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            em.persist(patient);
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
    }

    void hivPatientsStatusExport(ArrayList<ArrayList<Object>> list) {
        em.getTransaction().begin();
        /*counter to control batch inserts*/
        int batchsize = 0;
        for (ArrayList<Object> singleRow : list) {
            ++batchsize;

            Hivpatientsstatus status = new Hivpatientsstatus();

            status.setPatientid(singleRow.get(0).toString());
            status.setSitecode(Integer.valueOf(singleRow.get(1).toString()));
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(2).toString());
                status.setExitdate(date);
            } catch (Exception e) {
                status.setExitdate(null);
            }
            status.setExitreason(singleRow.get(3).toString());
            
            
            em.persist(status);
            /*insert in batches of size 100*/
            if ((batchsize % 1000) == 0) {
                em.getTransaction().commit();
                em.clear();
                batchsize = 0;
                em.getTransaction().begin();
            }
            
        }
        em.getTransaction().commit();
    }

    void hivPharmacyExport(ArrayList<ArrayList<Object>> list) {
       em.getTransaction().begin();
        /*counter to control batch inserts*/
        int batchsize = 0;
        for (ArrayList<Object> singleRow : list) {
            ++batchsize;

            Hivpharmacy pharmacy = new Hivpharmacy();
            
            pharmacy.setPatientid(singleRow.get(0).toString());
            pharmacy.setSitecode(Integer.valueOf(singleRow.get(1).toString()));
            try {
                pharmacy.setDrug(singleRow.get(2).toString());
            } catch (Exception e) {
                pharmacy.setDrug(null);
            }
            
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(singleRow.get(3).toString());
                pharmacy.setDispensedate(date);
            } catch (Exception e) {
                pharmacy.setDispensedate(null);
            }
            pharmacy.setTreatmenttype(singleRow.get(3).toString());
            
            
            em.persist(pharmacy);
            /*insert in batches of size 100*/
            if ((batchsize % 1000) == 0) {
                em.getTransaction().commit();
                em.clear();
                batchsize = 0;
                em.getTransaction().begin();
            }
            
        }
        em.getTransaction().commit();
    }
}
