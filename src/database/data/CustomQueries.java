/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.data;

import database.persistence.TblLabs;
import java.util.ArrayList;
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
    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "ExcelReaderPU" );
    EntityManager em = emfactory.createEntityManager();
    
    //fetches a row from tblLabs by a given offset
    public List<Object[]> getLabsRow(int rowOffset){
               
        TypedQuery<Object[]> query = em.createQuery(
                "select distinct e.patientId, e.admissionId from TblLabs e", Object[].class)
                ;
        List<Object[]> list = query.getResultList();
        return list;
    }
    
}
