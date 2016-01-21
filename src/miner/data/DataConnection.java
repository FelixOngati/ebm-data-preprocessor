/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miner.data;

import apriori.mining.Apriori;
import database.data.CustomQueries;
import miner.mining.helper.DataHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataConnection {
    
    CustomQueries cq = new CustomQueries();
    List<Object[]> array = new ArrayList<>();

    public void dataConnect( PrintWriter out,double minSupport,double minConfidence) {
        array = cq.getFuzzyLabs();
        ArrayList<ArrayList<String>> columnData = new ArrayList<>();
        for (Object[] obj : array) {
            int count = 4;
            ArrayList<String> data = new ArrayList<>();
            while(obj.length > count+1){
                if(obj[count] != null)
                    data.add(obj[count].toString());
                count++;
            }
            
//                System.out.println("Break "+data.size());
//               System.out.println(data);
            columnData.add(data);
            
        }
        int x = 0;
        for(List list:columnData){
            System.out.println(list);
            x++;
        }
        System.out.println(x);
        DataHelper.init(minSupport, minConfidence);
        Apriori aprioriHelper = new Apriori();
    }

}
