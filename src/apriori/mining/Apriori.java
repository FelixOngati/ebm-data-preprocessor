package apriori.mining;

import excelreader.DataExport;
import miner.mining.helper.DataHelper;
import miner.mining.helper.FileHelper;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import miner.valueObjects.AssociationValueObject;
import miner.valueObjects.LargeItemSetVO;

/**
 * 
 * 
 *
 */
public class Apriori {
	/*Hold the resultant large itemset */
	Set<Set<String>> largeItemSet;
	Set<Set<String>> currentItemSet;
	/*Maps the file into memory */
	Map<Integer, Set<String>> fileMap;
	
	/**
	 * The public constructor
	 */
	public Apriori() {
		largeItemSet = new HashSet<Set<String>>();
		fileMap = new HashMap<Integer, Set<String>>();
		currentItemSet = new HashSet<Set<String>>();
	}
	
	/**
	 * Does the Apriori Algo
	 * @param minSupport
	 * @param minConfidence
	 * @throws IOException 
	 */
	public void doApriori(Double minSupport, Double minConfidence, String filename) throws IOException {
		fileMap = FileHelper.parseFile(filename);
		System.out.println("All transcastions loded into memory. \n");
		currentItemSet = DataHelper.getLOneSet();
		System.out.println("Computed L0 ItemSet");
		largeItemSet.addAll(currentItemSet);
		int count = 0;
		while(currentItemSet.size() > 0) {
			System.out.println("Computed L"+ ++count +" ItemSet");
			currentItemSet = getNextLevelItemSet(currentItemSet);
		}
		System.out.println();
//		System.out.println("==Large itemsets ( min_support="+ minSupport*100 + "% )");
//		printLargeItemSet();
		System.out.println();
		System.out.println("==High-confidence association rules"+ "( min_conf="+minConfidence*100 + "% )");
		generateAssociationRules(minConfidence);
	}
	
	/**
	 * private method to generate association rules
	 */
	private void generateAssociationRules(Double minConfidence) {
		ArrayList<AssociationValueObject> associations = new ArrayList<AssociationValueObject>();
		ArrayList<LargeItemSetVO> set = new ArrayList<LargeItemSetVO>(DataHelper.getLargeItemSetWithSupport());
		for(LargeItemSetVO vo: set) {
			/* Get one item on the rhs */
			if (vo.getItems().size() == 1) {
				String item = vo.getItems().iterator().next();
				for (LargeItemSetVO other : set) {
					if (other.getItems().contains(item) && other.getItems().size() > 1) {
						/*Propose an association if > than confidence*/
						Set<String> toOutput = new HashSet<String>(other.getItems());
						toOutput.remove(item);
						if ((other.getSupport().doubleValue() / DataHelper.getSupport(toOutput).doubleValue()) >= minConfidence) {
							associations.add(new AssociationValueObject(toOutput, vo.getItems(), (other.getSupport().doubleValue() / DataHelper.getSupport(toOutput).doubleValue()), other.getSupport()));
						}
					}
				}
			}
		}
		Collections.sort(associations);
		printAssociations(associations);
	}
	
	/**
	 * Print the associations
	 * @param associations
	 */
	private void printAssociations(ArrayList<AssociationValueObject> associations) {
            DecimalFormat df = new DecimalFormat("#.##");
            double support;
            double confidence;
            DataExport dataExport = new DataExport();
		for (AssociationValueObject obj: associations) {
                    confidence = Double.valueOf(df.format(obj.getConfidence()*100));
                    support = Double.valueOf(df.format(obj.getSupport()*100));
                        dataExport.savetRule(stringify(obj.getLhs()) + " => "+ stringify(obj.getRhs()),(float)confidence,(float)support );
			System.out.println(stringify(obj.getLhs()) + " => "+ stringify(obj.getRhs()) + " conf:"+obj.getConfidence()*100+ "% supp:" + obj.getSupport()*100+ "% ");
		}
	}

	/**
	 * Print the Large item sets
	 */
	public void printLargeItemSet() {
		ArrayList<LargeItemSetVO> set = new ArrayList<LargeItemSetVO>(DataHelper.getLargeItemSetWithSupport());
		Collections.sort(set);
		for(LargeItemSetVO vo: set) {
			System.out.println(vo.getItems().toString() + ", " + vo.getSupport()*100+"%" );
		}
	}
	
	/**
	 * Get the next level items
	 * @param curItemSet
	 * @return
	 */
	public Set<Set<String>> getNextLevelItemSet(Set<Set<String>> curItemSet){
		Set<Set<String>> cloneSet = new HashSet<Set<String>>(curItemSet);
		Set<Set<String>> nextLevel = new HashSet<Set<String>>();
		
		for(Set<String> set : curItemSet) {
			for(Set<String> set1 : cloneSet){
				if (!set.equals(set1)) {
					Set<String> toAdd = new HashSet<String>(set);
					toAdd.addAll(set1);
					nextLevel.add(toAdd);
				}
			}
		}
		nextLevel = DataHelper.getFrequentItems(nextLevel, fileMap);
		largeItemSet.addAll(nextLevel);
		return nextLevel;
	}
        
        /**
         * Convert a set to string literal
         * @param set
         */
        public String stringify(Iterable<? extends CharSequence> set){
            Iterator<? extends CharSequence> iterator = set.iterator();
            if(!iterator.hasNext())
                return "";
            StringBuilder builder = new StringBuilder(iterator.next());
            while(iterator.hasNext())
                builder.append(", ").append(iterator.next());
            return builder.toString().replace("\"", "");
        }
	
}
