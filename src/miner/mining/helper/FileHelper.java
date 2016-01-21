package miner.mining.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * FileHelper to do file operations
 * @author nitin kanna
 * 
 *
 */
public class FileHelper {
	/**
	 * Parses the CSV file and fills up the fileMap
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Map<Integer, Set<String>> parseFile(String filename) throws IOException {
		Map<Integer, Set<String>> fileMap = new HashMap<Integer, Set<String>>();
		Set<String> lineSet;
		String input ="";
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		Integer lineCount = 0;
		while((input = reader.readLine()) != null) {
			++lineCount;
			if(lineCount % 1000 == 0){
				System.out.println("Loaded " + lineCount + " transcations into memory. ");
			}
			lineSet = new HashSet<String>();
			String temp [] = input.split(",");
			int i = 0;
			
			/**
			 * Adds to the lineSet and also populates
			 * the frequencyMap using the DataHelper 
			 */
			while (i < temp.length) {
				if(temp[i].length() == 0) { 
					i++;
					continue;
				}
				lineSet.add(temp[i]);
				DataHelper.updateFrequency(temp[i]);
				i++;
				
			}
			fileMap.put(lineCount, lineSet);
		}
		
		DataHelper.setNumTransactions(lineCount);
		return fileMap;
	}
}
