/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.data;

import database.persistence.TblPatientDetails;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author the_fegati
 */
public class CustomQueries {

    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ExcelReaderPU");
    EntityManager em = emfactory.createEntityManager();

    //fetch distinct lab tests from TblLabs
    public List<Object[]> getDistinctLabs() {

        TypedQuery<Object[]> query = em.createQuery(
                "select distinct e.patientId, e.admissionId from TblLabs e", Object[].class);
        List<Object[]> list = query.getResultList();
        return list;
    }

    public List<Object[]> getLabs(String patientId, String admissionId) {
        TypedQuery<Object[]> query = em.createQuery(
                "select p.patientId, l.admissionId, l.labName, l.labValue, l.labDateTime"
                + " from TblPatientDetails p INNER JOIN TblLabs l on "
                + "p.patientId = l.patientId where p.patientId = :patientId "
                + "and l.admissionId = :admissionId", Object[].class);
        query.setParameter("patientId", patientId);
        query.setParameter("admissionId", admissionId);
        List<Object[]> list = query.getResultList();
        return list;
    }
    
    public List<Object[]> getPatientDetails(String patientId){
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT p.patientId, p.patientGender, p.patientDOB, p.patientRace, "
                        + "p.patientMaritalStatus, p.patientLanguage, "
                        + "p.patientPopulationPercentageBelowPoverty "
                        + "FROM TblPatientDetails p WHERE p.patientId =:patientId", Object[].class
        );
        query.setParameter("patientId", patientId);
        List<Object[]> list = query.getResultList();
        
        return list;
    }
    
    public String getDiagnosis(String patientId, int admissionId){
        String diagnosis=null;
        System.out.println(patientId);
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT d.dcode, d.primaryDiagnosisDescription FROM TblAdmissionDiagnoses d "
                        + "WHERE d.patientId=:patientId AND d.admissionId=:admissionId",
                Object[].class);
        query.setParameter("patientId", em.getReference(TblPatientDetails.class, patientId));
        query.setParameter("admissionId", Integer.toString(admissionId));
        List<Object[]> list = query.getResultList();
        
        for(Object[] obj:list){
            diagnosis = obj[1].toString();
        }
     return diagnosis;
    }
    
    //fetches all data from TblFuzzyLabs
    public List<Object[]> getFuzzyLabs(){
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT f.gender, f.age, f.race, f.maritalStatus, f.urinalysisRbc,"
                        + "f.metabolicGlucose, f.metabolicCalcium, f.cbcRbcCount, "
                        + "f.urinalysisPh, f.metabolicTotalProtein, f.metabolicChloride, "
                        + "f.cbcLymphocytes, f.metabolicSodium, f.urinalysisSpecificGravity, "
                        + "f.metabolicBiliTotal, f.urinalysisWbc, f.cbcEosinophils,"
                        + " f.metabolicAlkPhos, f.cbcRdw, f.metabolicAstSgot, "
                        + "f.cbcNeutrophils, f.cbcBasophils, f.cbcMonocytes, f.cbcMch, "
                        + "f.metabolicBun, f.cbcWbcCount, f.cbcPlateletCount, "
                        + "f.metabolicPotassium, f.metabolicAnionGap, f.cbcHematocrit, "
                        + "f.metabolicCreatinine, f.cbcHemoglobin, f.cbcAbsoluteLymphocytes, "
                        + "f.metabolicCarbonDioxide, f.cbcAbsoluteNeutrophils, "
                        + "f.metabolicAlbumin, f.cbcMchc, f.diagnosis FROM TblFuzzyLabs f", 
                Object[].class        
        );
        List<Object[]> fuzzyLabsList = query.getResultList();
        
        return fuzzyLabsList;
    }
    
    /**
     * Truncates table
     * @param tableName
     */
    public void truncateTable(String tableName){
        Query query = em.createQuery(
                "truncate "+tableName
        );
        query.executeUpdate();
    }

}
