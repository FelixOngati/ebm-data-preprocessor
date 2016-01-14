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

/**
 *
 * @author the_fegati
 */
public class Fuzzification {
  int startRow = 0;
  CustomQueries cq = new CustomQueries();
  
  //constructor starts the whole process by calling getLabsData
//    public Fuzzification() {
//        getLabsData();
//    }
//  
  
  //get labs data from tblLabs
  public void getLabsData(){
      List<Object[]> list = cq.getLabsRow(0);
      for (Object[] lab : list) {
          System.out.println(lab[0] + "   "+lab[1]);
      }
  }
  
  //assign the real values to fuzzy sets
  public void fuzzify(){
      
  }
  
  //persists fuzzified data to tblFuzzyLabs
  public void persist(){
      
  }
  
}
