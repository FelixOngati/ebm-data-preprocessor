package apriori.mining;

import miner.mining.helper.DataHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import miner.valueObjects.AssociationObject;
import miner.valueObjects.LargeItemSetVO;

public class Mining {
    /*Hold the resultant large itemset */

    Set<Set<String>> largeItemSet;
    Set<Set<String>> currentItemSet;

    /*Maps the file into memory */
    Map<Integer, Set<String>> fileMap;

    PrintWriter out;

    public Mining() {
        largeItemSet = new HashSet<>();
        fileMap = new HashMap<>();
        currentItemSet = new HashSet<>();
    }

    public void doMining(Double minSupport, Double minConfidence, ArrayList<ArrayList<String>> columns, PrintWriter out) throws IOException {
        this.out = out;
        Set<String> lineSet;
        Integer lineCount = 0;
        for (int i = 0; i < columns.get(0).size(); i++) {
            lineSet = new HashSet<>();
            ++lineCount;
            int j = 0;
            while (j < columns.size()) {

                if (!columns.get(j).get(i).equals("")) {
                    lineSet.add(columns.get(j).get(i));
                    DataHelper.updateFrequency(columns.get(j).get(i));
                }
                j++;
            }
            fileMap.put(lineCount, lineSet);
        }
//        System.exit(0);

        DataHelper.setNumTransactions(lineCount);
        currentItemSet = DataHelper.getLOneSet();
        largeItemSet.addAll(currentItemSet);
        while (currentItemSet.size() > 0) {
            currentItemSet = getNextLevelItemSet(currentItemSet);
        }
        out.println("min_support=" + minSupport * 100 + "% </br>");
//        printLargeItemSet();
        System.out.println();
        out.println("High-confidence association rules" + "( min_conf=" + minConfidence * 100 + "% )</br>");
        generateAssociationRules(minConfidence);
    }

    /**
     * private method to generate association rules
     */
    private void generateAssociationRules(Double minConfidence) {
        ArrayList<AssociationObject> associations = new ArrayList<>();
        ArrayList<LargeItemSetVO> set = new ArrayList<>(DataHelper.getLargeItemSetWithSupport());
        for (LargeItemSetVO vo : set) {
            /* Get one item on the rhs */
            if (vo.getItems().size() == 1) {
                String item = vo.getItems().iterator().next();
                System.out.println(item);
                for (LargeItemSetVO other : set) {
                    System.out.println(other.getItems());
                    if (other.getItems().contains(item) && other.getItems().size() >0) {
                        /*Propose an association if we have required  confidence*/
                        System.out.println(other.getItems()+"here");
                        Set<String> toOutput = new HashSet<>(other.getItems());
                        toOutput.remove(item);
                        if ((other.getSupport() / DataHelper.getSupport(toOutput)) >= minConfidence) {
                            associations.add(new AssociationObject(toOutput, vo.getItems(), (other.getSupport() / DataHelper.getSupport(toOutput)), other.getSupport()));
                        }
                    }
                }
            }
        }
        Collections.sort(associations);
        printAssociations(associations);
    }

    private void printAssociations(ArrayList<AssociationObject> associations) {
        for (AssociationObject obj : associations) {
            System.out.println(obj + "hehehehe");
            out.println(obj.getLhs() + " => " + obj.getRhs() + " (conf:" + obj.getConfidence() * 100 + "% supp:" + obj.getSupport() * 100 + "% )</br>");
        }
    }

    public void printLargeItemSet() {
        ArrayList<LargeItemSetVO> set = new ArrayList<>(DataHelper.getLargeItemSetWithSupport());
        Collections.sort(set);
        for (LargeItemSetVO vo : set) {
            out.println(vo.getItems().toString() + ", " + vo.getSupport() * 100 + "%</br>");
        }
    }

    public Set<Set<String>> getNextLevelItemSet(Set<Set<String>> curItemSet) {
        Set<Set<String>> cloneSet = new HashSet<>(curItemSet);
        Set<Set<String>> nextLevel = new HashSet<>();

        for (Set<String> set : curItemSet) {
            for (Set<String> set1 : cloneSet) {
                if (!set.equals(set1)) {
                    Set<String> toAdd = new HashSet<>(set);
                    toAdd.addAll(set1);
                    nextLevel.add(toAdd);
                }
            }
        }
        nextLevel = DataHelper.getFrequentItems(nextLevel, fileMap);
        largeItemSet.addAll(nextLevel);
        return nextLevel;
    }

}
