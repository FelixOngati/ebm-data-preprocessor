/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.data;

import database.persistence.TblLabs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author the_fegati
 */
public class Fuzzification {

    int startRow = 0;
    CustomQueries cq = new CustomQueries();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExcelReaderPU");
    EntityManager em = emf.createEntityManager();

    //constructor starts the whole process by calling getLabsData
//    public Fuzzification() {
//        getLabsData();
//    }
//  
    //get labs data from tblLabs
    public void getLabsData() {
        List<Object[]> list = cq.getDistinctLabs();
        for (Object[] lab : list) {
            //get labs data for this encounter
            List<Object[]> labEncounter = cq.getLabs(lab[0].toString(), lab[1].toString());
            //call fuzzify on the returned llab data
            fuzzify(labEncounter);
        }
    }

    //assign the real values to fuzzy sets
    private void fuzzify(List<Object[]> labEncounter) {
        for (Object[] lab : labEncounter) {
//            System.out.println(lab[0]+"   "+lab[1]+"    "+lab[2]+"    "+lab[3]);
            switch (lab[2].toString().trim()) {
                case "URINALYSIS: RED BLOOD CELLS":
                    if (Double.valueOf(lab[3].toString()) < 2) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 3) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "METABOLIC: GLUCOSE":
                    if (Double.valueOf(lab[3].toString()) < 64) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 100) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "METABOLIC: CALCIUM":
                    if (Double.valueOf(lab[3].toString()) < 8.5) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 10.2) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "CBC: RED BLOOD CELL COUNT":
                    if (Double.valueOf(lab[3].toString()) < 4.1) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 5.9) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "URINALYSIS: PH":
                    if (Double.valueOf(lab[3].toString()) < 4.6) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 8) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "METABOLIC: TOTAL PROTEIN":
                    if (Double.valueOf(lab[3].toString()) < 6) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 8.3) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "METABOLIC: CHLORIDE":
                    if (Double.valueOf(lab[3].toString()) < 101) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 111) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "CBC: LYMPHOCYTES":
                    if (Double.valueOf(lab[3].toString()) < 0.8) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 5) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "METABOLIC: SODIUM":
                    if (Double.valueOf(lab[3].toString()) < 136) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 144) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "URINALYSIS: SPECIFIC GRAVITY":
                    if (Double.valueOf(lab[3].toString()) < 1.005) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 1.035) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "METABOLIC: BILI TOTAL":
                    if (Double.valueOf(lab[3].toString()) < 0.3) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 1.9) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "URINALYSIS: WHITE BLOOD CELLS":
                    if (Double.valueOf(lab[3].toString()) < 2) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 5) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "CBC: EOSINOPHILS":
                    if (Double.valueOf(lab[3].toString()) < 0) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 0.8) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "METABOLIC: ALK PHOS":
                    if (Double.valueOf(lab[3].toString()) < 44) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 147) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "CBC: RDW":
                    if (Double.valueOf(lab[3].toString()) < 11.5) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 14.5) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;
                case "METABOLIC: AST/SGOT":
                    if (Double.valueOf(lab[3].toString()) < 10) {
                        System.out.println(lab[2] + "     Low");
                    } else if (Double.valueOf(lab[3].toString()) > 34) {
                        System.out.println(lab[2] + "     High");
                    } else {
                        System.out.println(lab[2] + "     Normal");
                    }
                    break;

            }
        }
        System.exit(0);
    }

    //persists fuzzified data to tblFuzzyLabs
    public void persist() {

    }

}
