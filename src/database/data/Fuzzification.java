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
            fuzzyLabs.setDiagnosis(cq.getDiagnosis(lab[0].toString(), Integer.valueOf(lab[1].toString())));
            switch (lab[2].toString().trim()) {
                case "URINALYSIS: RED BLOOD CELLS":
                    if (Double.valueOf(lab[3].toString()) < 2) {
                        fuzzyLabs.setUrinalysisRbc("low urinalysis_rbc");
                    } else if (Double.valueOf(lab[3].toString()) > 3) {
                        fuzzyLabs.setUrinalysisRbc("high urinalysis_rbc");
                    } else {
                        fuzzyLabs.setUrinalysisRbc("normal urinalysis_rbc");
                    }
                    break;
                case "METABOLIC: GLUCOSE":
                    if (Double.valueOf(lab[3].toString()) < 64) {
                        fuzzyLabs.setMetabolicGlucose("low metabolic_glucose");
                    } else if (Double.valueOf(lab[3].toString()) > 100) {
                        fuzzyLabs.setMetabolicGlucose("high metabolic_glucose");
                    } else {
                        fuzzyLabs.setMetabolicGlucose("normal metabolic_glucose");
                    }
                    break;
                case "METABOLIC: CALCIUM":
                    if (Double.valueOf(lab[3].toString()) < 8.5) {
                        fuzzyLabs.setMetabolicCalcium("low metabolic_calcium");
                    } else if (Double.valueOf(lab[3].toString()) > 10.2) {
                        fuzzyLabs.setMetabolicCalcium("high metabolic_calcium");
                    } else {
                        fuzzyLabs.setMetabolicCalcium("normal metabolic_calcium");
                    }
                    break;
                case "CBC: RED BLOOD CELL COUNT":
                    if (Double.valueOf(lab[3].toString()) < 4.1) {
                        fuzzyLabs.setCbcRbcCount("low cbc_rbc_count");
                    } else if (Double.valueOf(lab[3].toString()) > 5.9) {
                        fuzzyLabs.setCbcRbcCount("high cbc_rbc_count");
                    } else {
                        fuzzyLabs.setCbcRbcCount("normal cbc_rbc_count");
                    }
                    break;
                case "URINALYSIS: PH":
                    if (Double.valueOf(lab[3].toString()) < 4.6) {
                        fuzzyLabs.setUrinalysisPh("low urinalysis_ph");
                    } else if (Double.valueOf(lab[3].toString()) > 8) {
                        fuzzyLabs.setUrinalysisPh("high urinalysis_ph");
                    } else {
                        fuzzyLabs.setUrinalysisPh("normal urinalysis_ph");
                    }
                    break;
                case "METABOLIC: TOTAL PROTEIN":
                    if (Double.valueOf(lab[3].toString()) < 6) {
                        fuzzyLabs.setMetabolicTotalProtein("low metabolic_total_protein");
                    } else if (Double.valueOf(lab[3].toString()) > 8.3) {
                        fuzzyLabs.setMetabolicTotalProtein("high metabolic_total_protein");
                    } else {
                        fuzzyLabs.setMetabolicTotalProtein("normal metabolic_total_protein");
                    }
                    break;
                case "METABOLIC: CHLORIDE":
                    if (Double.valueOf(lab[3].toString()) < 101) {
                        fuzzyLabs.setMetabolicChloride("low metabolic_chloride");
                    } else if (Double.valueOf(lab[3].toString()) > 111) {
                        fuzzyLabs.setMetabolicChloride("high metabolic_chloride");
                    } else {
                        fuzzyLabs.setMetabolicChloride("normal metabolic_chloride");
                    }
                    break;
                case "CBC: LYMPHOCYTES":
                    if (Double.valueOf(lab[3].toString()) < 0.8) {
                        fuzzyLabs.setCbcLymphocytes("low cbc_lymphocytes");
                    } else if (Double.valueOf(lab[3].toString()) > 5) {
                        fuzzyLabs.setCbcLymphocytes("high cbc_lymphocytes");
                    } else {
                        fuzzyLabs.setCbcLymphocytes("normal cbc_lymphocytes");
                    }
                    break;
                case "METABOLIC: SODIUM":
                    if (Double.valueOf(lab[3].toString()) < 136) {
                        fuzzyLabs.setMetabolicSodium("low metabolic_sodium");
                    } else if (Double.valueOf(lab[3].toString()) > 144) {
                        fuzzyLabs.setMetabolicSodium("high metabolic_sodium");
                    } else {
                        fuzzyLabs.setMetabolicSodium("normal metabolic_sodium");
                    }
                    break;
                case "URINALYSIS: SPECIFIC GRAVITY":
                    if (Double.valueOf(lab[3].toString()) < 1.005) {
                        fuzzyLabs.setUrinalysisSpecificGravity("low urinalysis_specific_gravity");
                    } else if (Double.valueOf(lab[3].toString()) > 1.035) {
                        fuzzyLabs.setUrinalysisSpecificGravity("high urinalysis_specific_gravity");
                    } else {
                        fuzzyLabs.setUrinalysisSpecificGravity("normal urinalysis_specific_gravity");
                    }
                    break;
                case "METABOLIC: BILI TOTAL":
                    if (Double.valueOf(lab[3].toString()) < 0.3) {
                        fuzzyLabs.setMetabolicBiliTotal("low metabolic_bili_total");
                    } else if (Double.valueOf(lab[3].toString()) > 1.9) {
                        fuzzyLabs.setMetabolicBiliTotal("high metabolic_bili_total");
                    } else {
                        fuzzyLabs.setMetabolicBiliTotal("normal metabolic_bili_total");
                    }
                    break;
                case "URINALYSIS: WHITE BLOOD CELLS":
                    if (Double.valueOf(lab[3].toString()) < 2) {
                        fuzzyLabs.setUrinalysisWbc("low urinalysis_wbc");
                    } else if (Double.valueOf(lab[3].toString()) > 5) {
                        fuzzyLabs.setUrinalysisWbc("high urinalysis_wbc");
                    } else {
                        fuzzyLabs.setUrinalysisWbc("normal urinalysis_wbc");
                    }
                    break;
                case "CBC: EOSINOPHILS":
                    if (Double.valueOf(lab[3].toString()) < 0) {
                        fuzzyLabs.setCbcEosinophils("low cbc_eosinophils");
                    } else if (Double.valueOf(lab[3].toString()) > 0.8) {
                        fuzzyLabs.setCbcEosinophils("high cbc_eosinophils");
                    } else {
                        fuzzyLabs.setCbcEosinophils("normal cbc_eosinophils");
                    }
                    break;
                case "METABOLIC: ALK PHOS":
                    if (Double.valueOf(lab[3].toString()) < 44) {
                        fuzzyLabs.setMetabolicAlkPhos("low metabolic_alk_phos");
                    } else if (Double.valueOf(lab[3].toString()) > 147) {
                        fuzzyLabs.setMetabolicAlkPhos("high metabolic_alk_phos");
                    } else {
                        fuzzyLabs.setMetabolicAlkPhos("normal metabolic_alk_phos");
                    }
                    break;
                case "CBC: RDW":
                    if (Double.valueOf(lab[3].toString()) < 11.5) {
                        fuzzyLabs.setCbcRdw("low cbc_rdw");
                    } else if (Double.valueOf(lab[3].toString()) > 14.5) {
                        fuzzyLabs.setCbcRdw("high cbc_rdw");
                    } else {
                        fuzzyLabs.setCbcRdw("normal cbc_rdw");
                    }
                    break;
                case "METABOLIC: AST/SGOT":
                    if (Double.valueOf(lab[3].toString()) < 10) {
                        fuzzyLabs.setMetabolicAstSgot("low metabolic_ast_sgot");
                    } else if (Double.valueOf(lab[3].toString()) > 34) {
                        fuzzyLabs.setMetabolicAstSgot("high metabolic_ast_sgot");
                    } else {
                        fuzzyLabs.setMetabolicAstSgot("normal metabolic_ast_sgot");
                    }
                    break;
                case "CBC: NEUTROPHILS":
                    if (Double.valueOf(lab[3].toString()) < 1.8) {
                        fuzzyLabs.setCbcNeutrophils("low cbc_neutrophils");
                    } else if (Double.valueOf(lab[3].toString()) > 8.3) {
                        fuzzyLabs.setCbcNeutrophils("high cbc_neutrophils");
                    } else {
                        fuzzyLabs.setCbcNeutrophils("normal cbc_neutrophils");
                    }
                    break;
                case "CBC: BASOPHILS":
                    if (Double.valueOf(lab[3].toString()) < 0) {
                        fuzzyLabs.setCbcBasophils("low cbc_basophils");
                    } else if (Double.valueOf(lab[3].toString()) > 0.1) {
                        fuzzyLabs.setCbcBasophils("high cbc_basophils");
                    } else {
                        fuzzyLabs.setCbcBasophils("normal cbc_basophils");
                    }
                    break;
                case "CBC: MONOCYTES":
                    if (Double.valueOf(lab[3].toString()) < 0.4) {
                        fuzzyLabs.setCbcMonocytes("low cbc_monocytes");
                    } else if (Double.valueOf(lab[3].toString()) > 1) {
                        fuzzyLabs.setCbcMonocytes("high cbc_monocytes");
                    } else {
                        fuzzyLabs.setCbcMonocytes("normal cbc_monocytes");
                    }
                    break;
                case "CBC: MCH":
                    if (Double.valueOf(lab[3].toString()) < 28) {
                        fuzzyLabs.setCbcMch("low cbc_mch");
                    } else if (Double.valueOf(lab[3].toString()) > 33) {
                        fuzzyLabs.setCbcMch("high cbc_mch");
                    } else {
                        fuzzyLabs.setCbcMch("normal cbc_mch");
                    }
                    break;
                case "METABOLIC: BUN":
                    if (Double.valueOf(lab[3].toString()) < 7) {
                        fuzzyLabs.setMetabolicBun("low metabolic_bun");
                    } else if (Double.valueOf(lab[3].toString()) > 20) {
                        fuzzyLabs.setMetabolicBun("high metabolic_bun");
                    } else {
                        fuzzyLabs.setMetabolicBun("normal metabolic_bun");
                    }
                    break;
                case "CBC: WHITE BLOOD CELL COUNT":
                    if (Double.valueOf(lab[3].toString()) < 4.3) {
                        fuzzyLabs.setCbcWbcCount("low cbc_wbc_count");
                    } else if (Double.valueOf(lab[3].toString()) > 10.8) {
                        fuzzyLabs.setCbcWbcCount("high cbc_wbc_count");
                    } else {
                        fuzzyLabs.setCbcWbcCount("normal cbc_wbc_count");
                    }
                    break;
                case "CBC: PLATELET COUNT":
                    if (Double.valueOf(lab[3].toString()) < 150) {
                        fuzzyLabs.setCbcPlateletCount("low cbc_platelet_count");
                    } else if (Double.valueOf(lab[3].toString()) > 350) {
                        fuzzyLabs.setCbcPlateletCount("high cbc_platelet_count");
                    } else {
                        fuzzyLabs.setCbcPlateletCount("normal cbc_platelet_count");
                    }
                    break;
                case "METABOLIC: POTASSIUM":
                    if (Double.valueOf(lab[3].toString()) < 3.7) {
                        fuzzyLabs.setMetabolicPotassium("low metabolic_potassium");
                    } else if (Double.valueOf(lab[3].toString()) > 5.2) {
                        fuzzyLabs.setMetabolicPotassium("high metabolic_potassium");
                    } else {
                        fuzzyLabs.setMetabolicPotassium("normal metabolic_potassium");
                    }
                    break;
                case "METABOLIC: ANION GAP":
                    if (Double.valueOf(lab[3].toString()) < 8) {
                        fuzzyLabs.setMetabolicAnionGap("low metabolic_anion_gap");
                    } else if (Double.valueOf(lab[3].toString()) > 16) {
                        fuzzyLabs.setMetabolicAnionGap("high metabolic_anion_gap");
                    } else {
                        fuzzyLabs.setMetabolicAnionGap("normal metabolic_anion_gap");
                    }
                    break;
                case "CBC: HEMOGLOBIN":
                    if (Double.valueOf(lab[3].toString()) < 12) {
                        fuzzyLabs.setCbcHemoglobin("low cbc_hemoglobin");
                    } else if (Double.valueOf(lab[3].toString()) > 18) {
                        fuzzyLabs.setCbcHemoglobin("high cbc_hemoglobin");
                    } else {
                        fuzzyLabs.setCbcHemoglobin("normal cbc_hemoglobin");
                    }
                    break;
                case "CBC: HEMATOCTRIT":
                    if (Double.valueOf(lab[3].toString()) < 37) {
                        fuzzyLabs.setCbcHematocrit("low cbc_hematocrit");
                    } else if (Double.valueOf(lab[3].toString()) > 52) {
                        fuzzyLabs.setCbcHematocrit("high cbc_hematocrit");
                    } else {
                        fuzzyLabs.setCbcHematocrit("normal cbc_hematocrit");
                    }
                    break;
                case "CBC: ABSOLUTE LYMPHOCYTES":
                    if (Double.valueOf(lab[3].toString()) < 18) {
                        fuzzyLabs.setCbcAbsoluteLymphocytes("low cbc_absolute_lymphocytes");
                    } else if (Double.valueOf(lab[3].toString()) > 45) {
                        fuzzyLabs.setCbcAbsoluteLymphocytes("high cbc_absolute_lymphocytes");
                    } else {
                        fuzzyLabs.setCbcAbsoluteLymphocytes("normal cbc_absolute_lymphocytes");
                    }
                    break;
                case "METABOLIC: CARBON DIOXIDE":
                    if (Double.valueOf(lab[3].toString()) < 20) {
                        fuzzyLabs.setMetabolicCarbonDioxide("low metabolic_metabolic_carbon_dioxide");
                    } else if (Double.valueOf(lab[3].toString()) > 29) {
                        fuzzyLabs.setMetabolicCarbonDioxide("high metabolic_metabolic_carbon_dioxide");
                    } else {
                        fuzzyLabs.setMetabolicCarbonDioxide("normal metabolic_metabolic_carbon_dioxide");
                    }
                    break;
                case "CBC: ABSOLUTE NEUTROPHILS":
                    if (Double.valueOf(lab[3].toString()) < 45) {
                        fuzzyLabs.setCbcAbsoluteNeutrophils("low cbc_absolute_neutrophils");
                    } else if (Double.valueOf(lab[3].toString()) > 74) {
                        fuzzyLabs.setCbcAbsoluteNeutrophils("high cbc_absolute_neutrophils");
                    } else {
                        fuzzyLabs.setCbcAbsoluteNeutrophils("normal cbc_absolute_neutrophils");
                    }
                    break;
                case "METABOLIC: ALBUMIN":
                    if (Double.valueOf(lab[3].toString()) < 3.4) {
                        fuzzyLabs.setMetabolicAlbumin("low metabolic_albumin");
                    } else if (Double.valueOf(lab[3].toString()) > 5.4) {
                        fuzzyLabs.setMetabolicAlbumin("high metabolic_albumin");
                    } else {
                        fuzzyLabs.setMetabolicAlbumin("normal metabolic_albumin");
                    }
                    break;
                case "CBC: MCHC":
                    if (Double.valueOf(lab[3].toString()) < 32) {
                        fuzzyLabs.setCbcMchc("low cbc_mchc");
                    } else if (Double.valueOf(lab[3].toString()) > 36) {
                        fuzzyLabs.setCbcMchc("high cbc_mchc");
                    } else {
                        fuzzyLabs.setCbcMchc("normal cbc_mchc");
                    }
                    break;
                case "METABOLIC: CREATININE":
                    if (Double.valueOf(lab[3].toString()) < 0.6) {
                        fuzzyLabs.setCbcMchc("low metabolic_creatinine");
                    } else if (Double.valueOf(lab[3].toString()) > 1.3) {
                        fuzzyLabs.setCbcMchc("high metabolic_creatinine");
                    } else {
                        fuzzyLabs.setCbcMchc("normal metabolic_creatinine");
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
