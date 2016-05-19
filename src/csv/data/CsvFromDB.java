/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.data;

import database.data.CustomQueries;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author the_fegati
 */
public class CsvFromDB {

    CustomQueries cq = new CustomQueries();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExcelReaderPU");
    EntityManager em = emf.createEntityManager();

    private final String COMMA_DELIMITER = ",";
    private final String NEW_LINE_SEPARATOR = "\n";

    public void getFuzzyLabs() throws IOException {
        FileWriter writer = new FileWriter("/home/the_fegati/NetBeansProjects/EBM/data/general_fuzzy.csv");
        List<Object[]> list = cq.getDistinctFuzzyLabs();
        List<String> labs = new ArrayList<>();

        for (Object[] lab : list) {

            List<Object[]> labEncounter = cq.getFuzzyLabs(lab[0].toString(), (Date) lab[1]);
//            System.out.println(labEncounter.size());
            int i = labEncounter.size();
            for (Object[] test : labEncounter) {
                if ((labEncounter.size() == 1) || i == 1) {
                    writer.append(test[1].toString());
                    writer.append(NEW_LINE_SEPARATOR);
                } else {
                    writer.append(test[1].toString());
                    writer.append(COMMA_DELIMITER);
                    i--;
                }
            }
        }
        writer.flush();
        writer.close();
    }

    public void getHivFuzzyLabsOnGender(String gender) throws IOException {
        FileWriter writer = new FileWriter("/home/the_fegati/NetBeansProjects/EBM/data/" + gender + "_fuzzy.csv");
        List<Object[]> list = cq.getDistinctHivLabs();
        List<String> labs = new ArrayList<>();

        for (Object[] lab : list) {

            List<Object[]> labEncounter = cq.getFuzzyLabs(lab[0].toString(), (Date) lab[1]);
            String sex = cq.getGender(lab[0].toString());
            int i = labEncounter.size();
            if (gender.equals(sex.trim())) {
                for (Object[] test : labEncounter) {
                    if ((labEncounter.size() == 1) || i == 1) {
                        writer.append(test[1].toString());
                        writer.append(NEW_LINE_SEPARATOR);
                    } else {
                        writer.append(test[1].toString());
                        writer.append(COMMA_DELIMITER);
                        i--;
                    }
                }
            }
        }
        writer.flush();
        writer.close();
    }

    public void getHivFuzzyLabsOnRegion(String region) throws IOException {
        FileWriter writer = new FileWriter("/home/the_fegati/NetBeansProjects/EBM/data/" + region + "_fuzzy.csv");
        List<Object[]> list = cq.getDistinctHivLabs();
        List<String> labs = new ArrayList<>();

        for (Object[] lab : list) {

            List<Object[]> labEncounter = cq.getFuzzyLabs(lab[0].toString(), (Date) lab[1]);
            String place = cq.getRegion(lab[0].toString());
            int i = labEncounter.size();
            try {
                if (region.equals(place.trim())) {
                    for (Object[] test : labEncounter) {
                        if ((labEncounter.size() == 1) || i == 1) {
                            writer.append(test[1].toString());
                            writer.append(NEW_LINE_SEPARATOR);
                        } else {
                            writer.append(test[1].toString());
                            writer.append(COMMA_DELIMITER);
                            i--;
                        }
                    }
                }
            } catch (Exception e) {
                continue;
            }

        }
        writer.flush();
        writer.close();
    }
    
    public void getHivFuzzyLabsOnMaritalStatus(String status) throws IOException {
        FileWriter writer = new FileWriter("/home/the_fegati/NetBeansProjects/EBM/data/" + status + "_fuzzy.csv");
        List<Object[]> list = cq.getDistinctHivLabs();
        List<String> labs = new ArrayList<>();

        for (Object[] lab : list) {

            List<Object[]> labEncounter = cq.getFuzzyLabs(lab[0].toString(), (Date) lab[1]);
            String marital = cq.getMaritalStatus(lab[0].toString());
            int i = labEncounter.size();
            try {
                if (status.equals(marital.trim())) {
                    for (Object[] test : labEncounter) {
                        if ((labEncounter.size() == 1) || i == 1) {
                            writer.append(test[1].toString());
                            writer.append(NEW_LINE_SEPARATOR);
                        } else {
                            writer.append(test[1].toString());
                            writer.append(COMMA_DELIMITER);
                            i--;
                        }
                    }
                }
            } catch (Exception e) {
                continue;
            }

        }
        writer.flush();
        writer.close();
    }

}
