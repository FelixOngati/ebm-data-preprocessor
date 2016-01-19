/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.data;

import database.persistence.TblFuzzyLabs;
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
    TblFuzzyLabs fuzzyLabs = new TblFuzzyLabs();

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
            List<Object[]> patientDetails = cq.getPatientDetails(lab[0].toString());
            for (Object[] detail : patientDetails) {
                fuzzyLabs.setGender(detail[1].toString());
                fuzzyLabs.setRace(detail[3].toString());
                fuzzyLabs.setMaritalStatus(detail[4].toString());
                fuzzyLabs.setPovertyindex(Double.valueOf(detail[6].toString()));
            }
            fuzzify(labEncounter);

        }
    }

    //assign the real values to fuzzy sets
    private void fuzzify(List<Object[]> labEncounter) {
        for (Object[] lab : labEncounter) {
            fuzzyLabs.setPatientId(lab[0].toString());
            fuzzyLabs.setAdmissionId(Integer.valueOf(lab[1].toString()));
            switch (lab[2].toString().trim()) {
                case "URINALYSIS: RED BLOOD CELLS":
                    if (Double.valueOf(lab[3].toString()) < 2) {
                        fuzzyLabs.setUrinalysisRbc("low");
                    } else if (Double.valueOf(lab[3].toString()) > 3) {
                        fuzzyLabs.setUrinalysisRbc("high");
                    } else {
                        fuzzyLabs.setUrinalysisRbc("normal");
                    }
                    break;
                case "METABOLIC: GLUCOSE":
                    if (Double.valueOf(lab[3].toString()) < 64) {
                        fuzzyLabs.setMetabolicGlucose("low");
                    } else if (Double.valueOf(lab[3].toString()) > 100) {
                        fuzzyLabs.setMetabolicGlucose("high");
                    } else {
                        fuzzyLabs.setMetabolicGlucose("normal");
                    }
                    break;
                case "METABOLIC: CALCIUM":
                    if (Double.valueOf(lab[3].toString()) < 8.5) {
                        fuzzyLabs.setMetabolicCalcium("low");
                    } else if (Double.valueOf(lab[3].toString()) > 10.2) {
                        fuzzyLabs.setMetabolicCalcium("high");
                    } else {
                        fuzzyLabs.setMetabolicCalcium("normal");
                    }
                    break;
                case "CBC: RED BLOOD CELL COUNT":
                    if (Double.valueOf(lab[3].toString()) < 4.1) {
                        fuzzyLabs.setCbcRbcCount("low");
                    } else if (Double.valueOf(lab[3].toString()) > 5.9) {
                        fuzzyLabs.setCbcRbcCount("high");
                    } else {
                        fuzzyLabs.setCbcRbcCount("normal");
                    }
                    break;
                case "URINALYSIS: PH":
                    if (Double.valueOf(lab[3].toString()) < 4.6) {
                        fuzzyLabs.setUrinalysisPh("low");
                    } else if (Double.valueOf(lab[3].toString()) > 8) {
                        fuzzyLabs.setUrinalysisPh("high");
                    } else {
                        fuzzyLabs.setUrinalysisPh("normal");
                    }
                    break;
                case "METABOLIC: TOTAL PROTEIN":
                    if (Double.valueOf(lab[3].toString()) < 6) {
                        fuzzyLabs.setMetabolicTotalProtein("low");
                    } else if (Double.valueOf(lab[3].toString()) > 8.3) {
                        fuzzyLabs.setMetabolicTotalProtein("high");
                    } else {
                        fuzzyLabs.setMetabolicTotalProtein("normal");
                    }
                    break;
                case "METABOLIC: CHLORIDE":
                    if (Double.valueOf(lab[3].toString()) < 101) {
                        fuzzyLabs.setMetabolicChloride("low");
                    } else if (Double.valueOf(lab[3].toString()) > 111) {
                        fuzzyLabs.setMetabolicChloride("high");
                    } else {
                        fuzzyLabs.setMetabolicChloride("normal");
                    }
                    break;
                case "CBC: LYMPHOCYTES":
                    if (Double.valueOf(lab[3].toString()) < 0.8) {
                        fuzzyLabs.setCbcLymphocytes("low");
                    } else if (Double.valueOf(lab[3].toString()) > 5) {
                        fuzzyLabs.setCbcLymphocytes("high");
                    } else {
                        fuzzyLabs.setCbcLymphocytes("normal");
                    }
                    break;
                case "METABOLIC: SODIUM":
                    if (Double.valueOf(lab[3].toString()) < 136) {
                        fuzzyLabs.setMetabolicSodium("low");
                    } else if (Double.valueOf(lab[3].toString()) > 144) {
                        fuzzyLabs.setMetabolicSodium("high");
                    } else {
                        fuzzyLabs.setMetabolicSodium("normal");
                    }
                    break;
                case "URINALYSIS: SPECIFIC GRAVITY":
                    if (Double.valueOf(lab[3].toString()) < 1.005) {
                        fuzzyLabs.setUrinalysisSpecificGravity("low");
                    } else if (Double.valueOf(lab[3].toString()) > 1.035) {
                        fuzzyLabs.setUrinalysisSpecificGravity("high");
                    } else {
                        fuzzyLabs.setUrinalysisSpecificGravity("normal");
                    }
                    break;
                case "METABOLIC: BILI TOTAL":
                    if (Double.valueOf(lab[3].toString()) < 0.3) {
                        fuzzyLabs.setMetabolicBiliTotal("low");
                    } else if (Double.valueOf(lab[3].toString()) > 1.9) {
                        fuzzyLabs.setMetabolicBiliTotal("high");
                    } else {
                        fuzzyLabs.setMetabolicBiliTotal("normal");
                    }
                    break;
                case "URINALYSIS: WHITE BLOOD CELLS":
                    if (Double.valueOf(lab[3].toString()) < 2) {
                        fuzzyLabs.setUrinalysisWbc("low");
                    } else if (Double.valueOf(lab[3].toString()) > 5) {
                        fuzzyLabs.setUrinalysisWbc("high");
                    } else {
                        fuzzyLabs.setUrinalysisWbc("normal");
                    }
                    break;
                case "CBC: EOSINOPHILS":
                    if (Double.valueOf(lab[3].toString()) < 0) {
                        fuzzyLabs.setCbcEosinophils("low");
                    } else if (Double.valueOf(lab[3].toString()) > 0.8) {
                        fuzzyLabs.setCbcEosinophils("high");
                    } else {
                        fuzzyLabs.setCbcEosinophils("normal");
                    }
                    break;
                case "METABOLIC: ALK PHOS":
                    if (Double.valueOf(lab[3].toString()) < 44) {
                        fuzzyLabs.setMetabolicAlkPhos("low");
                    } else if (Double.valueOf(lab[3].toString()) > 147) {
                        fuzzyLabs.setMetabolicAlkPhos("high");
                    } else {
                        fuzzyLabs.setMetabolicAlkPhos("normal");
                    }
                    break;
                case "CBC: RDW":
                    if (Double.valueOf(lab[3].toString()) < 11.5) {
                        fuzzyLabs.setCbcRdw("low");
                    } else if (Double.valueOf(lab[3].toString()) > 14.5) {
                        fuzzyLabs.setCbcRdw("high");
                    } else {
                        fuzzyLabs.setCbcRdw("normal");
                    }
                    break;
                case "METABOLIC: AST/SGOT":
                    if (Double.valueOf(lab[3].toString()) < 10) {
                        fuzzyLabs.setMetabolicAstSgot("low");
                    } else if (Double.valueOf(lab[3].toString()) > 34) {
                        fuzzyLabs.setMetabolicAstSgot("high");
                    } else {
                        fuzzyLabs.setMetabolicAstSgot("normal");
                    }
                    break;
                case "CBC: NEUTROPHILS":
                    if (Double.valueOf(lab[3].toString()) < 1.8) {
                        fuzzyLabs.setCbcNeutrophils("low");
                    } else if (Double.valueOf(lab[3].toString()) > 8.3) {
                        fuzzyLabs.setCbcNeutrophils("high");
                    } else {
                        fuzzyLabs.setCbcNeutrophils("normal");
                    }
                    break;
                case "CBC: BASOPHILS":
                    if (Double.valueOf(lab[3].toString()) < 0) {
                        fuzzyLabs.setCbcBasophils("low");
                    } else if (Double.valueOf(lab[3].toString()) > 0.1) {
                        fuzzyLabs.setCbcBasophils("high");
                    } else {
                        fuzzyLabs.setCbcBasophils("normal");
                    }
                    break;
                case "CBC: MONOCYTES":
                    if (Double.valueOf(lab[3].toString()) < 0.4) {
                        fuzzyLabs.setCbcMonocytes("low");
                    } else if (Double.valueOf(lab[3].toString()) > 1) {
                        fuzzyLabs.setCbcMonocytes("high");
                    } else {
                        fuzzyLabs.setCbcMonocytes("normal");
                    }
                    break;
                case "CBC: MCH":
                    if (Double.valueOf(lab[3].toString()) < 28) {
                        fuzzyLabs.setCbcMch("low");
                    } else if (Double.valueOf(lab[3].toString()) > 33) {
                        fuzzyLabs.setCbcMch("high");
                    } else {
                        fuzzyLabs.setCbcMch("normal");
                    }
                    break;
                case "METABOLIC: BUN":
                    if (Double.valueOf(lab[3].toString()) < 7) {
                        fuzzyLabs.setMetabolicBun("low");
                    } else if (Double.valueOf(lab[3].toString()) > 20) {
                        fuzzyLabs.setMetabolicBun("high");
                    } else {
                        fuzzyLabs.setMetabolicBun("normal");
                    }
                    break;
                case "CBC: WHITE BLOOD CELL COUNT":
                    if (Double.valueOf(lab[3].toString()) < 4.3) {
                        fuzzyLabs.setCbcWbcCount("low");
                    } else if (Double.valueOf(lab[3].toString()) > 10.8) {
                        fuzzyLabs.setCbcWbcCount("high");
                    } else {
                        fuzzyLabs.setCbcWbcCount("normal");
                    }
                    break;
                case "CBC: PLATELET COUNT":
                    if (Double.valueOf(lab[3].toString()) < 150) {
                        fuzzyLabs.setCbcPlateletCount("low");
                    } else if (Double.valueOf(lab[3].toString()) > 350) {
                        fuzzyLabs.setCbcPlateletCount("high");
                    } else {
                        fuzzyLabs.setCbcPlateletCount("normal");
                    }
                    break;
                case "METABOLIC: POTASSIUM":
                    if (Double.valueOf(lab[3].toString()) < 3.7) {
                        fuzzyLabs.setMetabolicPotassium("low");
                    } else if (Double.valueOf(lab[3].toString()) > 5.2) {
                        fuzzyLabs.setMetabolicPotassium("high");
                    } else {
                        fuzzyLabs.setMetabolicPotassium("normal");
                    }
                    break;
                case "METABOLIC: ANION GAP":
                    if (Double.valueOf(lab[3].toString()) < 8) {
                        fuzzyLabs.setMetabolicAnionGap("low");
                    } else if (Double.valueOf(lab[3].toString()) > 16) {
                        fuzzyLabs.setMetabolicAnionGap("high");
                    } else {
                        fuzzyLabs.setMetabolicAnionGap("normal");
                    }
                    break;
                case "CBC: HEMOGLOBIN":
                    if (Double.valueOf(lab[3].toString()) < 12) {
                        fuzzyLabs.setCbcHemoglobin("low");
                    } else if (Double.valueOf(lab[3].toString()) > 18) {
                        fuzzyLabs.setCbcHemoglobin("high");
                    } else {
                        fuzzyLabs.setCbcHemoglobin("normal");
                    }
                    break;
                case "CBC: HEMATOCTRIT":
                    if (Double.valueOf(lab[3].toString()) < 37) {
                        fuzzyLabs.setCbcHematocrit("low");
                    } else if (Double.valueOf(lab[3].toString()) > 52) {
                        fuzzyLabs.setCbcHematocrit("high");
                    } else {
                        fuzzyLabs.setCbcHematocrit("normal");
                    }
                    break;
                case "CBC: ABSOLUTE LYMPHOCYTES":
                    if (Double.valueOf(lab[3].toString()) < 18) {
                        fuzzyLabs.setCbcAbsoluteLymphocytes("low");
                    } else if (Double.valueOf(lab[3].toString()) > 45) {
                        fuzzyLabs.setCbcAbsoluteLymphocytes("high");
                    } else {
                        fuzzyLabs.setCbcAbsoluteLymphocytes("normal");
                    }
                    break;
                case "METABOLIC: CARBON DIOXIDE":
                    if (Double.valueOf(lab[3].toString()) < 20) {
                        fuzzyLabs.setMetabolicCarbonDioxide("low");
                    } else if (Double.valueOf(lab[3].toString()) > 29) {
                        fuzzyLabs.setMetabolicCarbonDioxide("high");
                    } else {
                        fuzzyLabs.setMetabolicCarbonDioxide("normal");
                    }
                    break;
                case "CBC: ABSOLUTE NEUTROPHILS":
                    if (Double.valueOf(lab[3].toString()) < 45) {
                        fuzzyLabs.setCbcAbsoluteNeutrophils("low");
                    } else if (Double.valueOf(lab[3].toString()) > 74) {
                        fuzzyLabs.setCbcAbsoluteNeutrophils("high");
                    } else {
                        fuzzyLabs.setCbcAbsoluteNeutrophils("normal");
                    }
                    break;
                case "METABOLIC: ALBUMIN":
                    if (Double.valueOf(lab[3].toString()) < 3.4) {
                        fuzzyLabs.setMetabolicAlbumin("low");
                    } else if (Double.valueOf(lab[3].toString()) > 5.4) {
                        fuzzyLabs.setMetabolicAlbumin("high");
                    } else {
                        fuzzyLabs.setMetabolicAlbumin("normal");
                    }
                    break;
                case "CBC: MCHC":
                    if (Double.valueOf(lab[3].toString()) < 32) {
                        fuzzyLabs.setCbcMchc("low");
                    } else if (Double.valueOf(lab[3].toString()) > 36) {
                        fuzzyLabs.setCbcMchc("high");
                    } else {
                        fuzzyLabs.setCbcMchc("normal");
                    }
                    break;
                case "METABOLIC: CREATININE":
                    if (Double.valueOf(lab[3].toString()) < 0.6) {
                        fuzzyLabs.setCbcMchc("low");
                    } else if (Double.valueOf(lab[3].toString()) > 1.3) {
                        fuzzyLabs.setCbcMchc("high");
                    } else {
                        fuzzyLabs.setCbcMchc("normal");
                    }
                    break;

            }
        }
        persist(fuzzyLabs);
    }

    //persists fuzzified data to tblFuzzyLabs
    public void persist(TblFuzzyLabs fuzzyLabs) {
        em.getTransaction().begin();
        em.persist(fuzzyLabs);
        em.getTransaction().commit();
        em.clear();
    }

}
