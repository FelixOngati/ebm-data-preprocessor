/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.data;

import database.persistence.Hivfuzzylabs;
import database.persistence.TblFuzzyLabs;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLLexer;

/**
 *
 * @author the_fegati
 */
public class HivLabsFuzzification {
    int startRow = 0;
    CustomQueries cq = new CustomQueries();    

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExcelReaderPU");
    EntityManager em = emf.createEntityManager();
    
     //get labs data from tblLabs
    public void getLabsData() {
        List<Object[]> list = cq.getDistinctHivLabs();
        em.getTransaction().begin();
        int batch = 0;
        for (Object[] lab : list) {
            //get labs data for this encounter
            List<Object[]> labEncounter = cq.getHivLabs(lab[0].toString(), (Date) lab[1]);
            
            //call fuzzify on the returned llab data
            for (Object[] detail : labEncounter) {
                ++batch;
                Hivfuzzylabs fuzzyLabs = new Hivfuzzylabs();
                fuzzyLabs.setPatientid(detail[0].toString());
                fuzzyLabs.setSitecode(Integer.valueOf(detail[1].toString()));
                fuzzyLabs.setLabdate((Date) detail[2]);
                fuzzyLabs.setTestname(detail[3].toString());
                fuzzyLabs.setFuzzyclass(fuzzify(detail[3].toString(), Float.valueOf(detail[4].toString())));
                
                em.persist(fuzzyLabs);
                
                if ((batch % 1000) == 0) {
                em.getTransaction().commit();
                em.clear();
                batch = 0;
                em.getTransaction().begin();
                }
            }

        }
        em.getTransaction().commit();
    }

    private String fuzzify(String lab, Float value) {
        switch(lab.trim()){
            case "Pcvhct":
                if(value < 38){
                    return "low PCVHCT";
                }else if(value > 49.5){
                    return "high PCVHCT";
                }else{
                    return "normal PCHVHCT";
                }
            case "Wbc":
                if(value < 3.8){
                    return "low WBC";
                }else if(value > 10.8){
                    return "high WBC";
                }else{
                    return "normal WBC";
                }
            case "NE":
                if(value < 1.8){
                    return "low NE";
                }else if(value > 8.3){
                    return "high NE";
                }else{
                    return "normal NE";
                }
            case "creatinine":
                if(value < 0.5){
                    return "low Creatinine";
                }else if(value > 1.2){
                    return "high Creatinine";
                }else{
                    return "normal Creatinine";
                }
            case "Cd3":
                if(value < 614){
                    return "low CD3";
                }else if(value > 2685){
                    return "high CD3";
                }else{
                    return "normal CD3";
                }
            case "Mchc":
                if(value < 32){
                    return "low MCHC";
                }else if(value > 36){
                    return "high MCHC";
                }else{
                    return "normal MCHC";
                }
            case "Lymphocyte":
                if(value < 1.3){
                    return "low Lymphocyte";
                }else if(value > 3.5){
                    return "high Lymphocyte";
                }else{
                    return "normal Lymphocyte";
                }
            case "Rbc":
                if(value < 3.8){
                    return "low RBC";
                }else if(value > 6.5){
                    return "high RBC";
                }else{
                    return "normal RBC";
                }
            case "Mch":
                if(value < 28){
                    return "low MCH";
                }else if(value > 33){
                    return "high MCH";
                }else{
                    return "normal MCH";
                }
            case "Cd4Percent":
                if(value < 25){
                    return "low CD4Percent";
                }else if(value > 65){
                    return "high CD4Percent";
                }else{
                    return "normal CD4Percent";
                }
            case "Platelet":
                if(value < 150){
                    return "low platelet count";
                }else if(value > 400){
                    return "high platelet count";
                }else{
                    return "normal platelet count";
                }
            case "Haemoglobin":
                if(value < 12){
                    return "low haemoglobin level";
                }else if(value > 18){
                    return "high haemoglobin level";
                }else{
                    return "normal haemoglobin level";
                }
            case "CD4_CD3":
                return "";
                
            case "PCT":
                if(value < 0.16){
                    return "normal PCT level";
                }else if(value > 0.15){
                    return "high PCT level";
                }else{
                    return "";
                }
            case "Alt":
                if(value < 7){
                    return "low ALT level";
                }else if(value > 56){
                    return "high ALT level";
                }else{
                    return "normal ALT level";
                }
            case "Mcv":
                if(value < 77){
                    return "low MCV level";
                }else if(value > 95){
                    return "high MCV level";
                }else{
                    return "normal MCV level";
                }
            case "MPV":
                if(value < 7.5){
                    return "low MPV level";
                }else if(value > 10.4){
                    return "high MPV level";
                }else{
                    return "normal MPV level";
                }
            case "PcntLymphocytes":
                if(value < 28){
                    return "low PcntLymphocytes level";
                }else if(value > 55){
                    return "high PcntLymphocytes level";
                }else{
                    return "normal PcntLymphocytes level";
                }
            case "PDW":
                if(value < 8.3){
                    return "low PDW level";
                }else if(value > 25){
                    return "high PDW level";
                }else{
                    return "normal PDW level";
                }
            case "RDW":
                if(value < 11.5){
                    return "low RDW level";
                }else if(value > 14.6){
                    return "high RDW level";
                }else{
                    return "normal RDW level";
                }
            case "Cd4":
                if(value < 343){
                    return "low CD4 count";
                }else if(value > 1493){
                    return "high CD4 count";
                }else{
                    return "normal CD4 count";
                }
            case "EO":
                if(value < 0){
                    return "LOW EO level";
                }else if(value > 0.8){
                    return "high EO level";
                }else{
                    return "normal EO level";
                }
            case "Cholesterol":
                if(value < 40){
                    return "low cholesterol level";
                }else if(value > 190){
                    return "high cholesterol level";
                }else{
                    return "normal cholesterol level";
                }
            case "RBS":
                if(value < 4.4){
                    return "low RBS level";
                }else if(value > 6.6){
                    return "high RBS level";
                }else{
                    return "normal RBS level";
                }
            case "MO":
                if(value < 0.4){
                    return "low MO level";
                }else if(value > 1){
                    return "high MO level";
                }else{
                    return "normal MO level";
                }
            case "Hepatitis":
                if(value == 0){
                    return "Hepatitis test negative";
                }else if(value == 1){
                    return "Hepatitis test positive";
                }else{
                    return "";
                }
            case "BA":
                if(value < 1){
                    return "low BA level";
                }else if(value > 2){
                    return "high BA level";
                }else{
                    return "normal BA level";
                }
            case "Glucose":
                if(value < 64){
                    return "low glucose level";
                }else if(value > 100){
                    return "high glucose level";
                }else{
                    return "normal glucose level";
                }
            case "ViralLoadCount":
                if(value < 40){
                    return "low ViralLoadCount";
                }else if(value > 75){
                    return "high ViralLoadCount";
                }else{
                    return "normal ViralLoadCount";
                }
            case "HbsAg":
                if(value == 0){
                    return "HbsAg test negative";
                }else if(value == 1){
                    return "HbsAg test positive";
                }else{
                    return "";
                }
            case "Ketones":
                if(value < 60){
                    return "normal ketones level";
                }else if(value > 150){
                    return "high ketones level";
                }else{
                    return "moderate ketones level";
                }
            default:
                return "";
        }
    }

}
