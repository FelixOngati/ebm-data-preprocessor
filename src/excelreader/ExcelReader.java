package excelreader;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;

/**
 *
 * @author the_fegati
 */

public class ExcelReader {
    
    private final File file;
    DataFormatter formatter = new DataFormatter();
    public ExcelReader(File file){
        this.file = file;
    }


    public ArrayList<ArrayList<Object>> getRowAsListFromExcel() {
        ArrayList<ArrayList<Object>> rowaslist = new ArrayList();        
        FileInputStream fis; 
        Workbook workbook = null;
        int maxDataCount = 0;
        try {
            String fileExtension = file.toString().substring(file.toString().indexOf("."));
            OPCPackage oPCPackage = OPCPackage.open(file);
            //use xssf for xlsx format else hssf for xls format
            if(fileExtension.equals(".xlsx")){
                workbook = new XSSFWorkbook(oPCPackage);
            }else if(fileExtension.equals(".xls")){
//                workbook = new HSSFWorkbook(new POIFSFileSystem(fis));
                System.err.println("Wrong file type selected!");
            }else{
                System.err.println("Wrong file type selected!");
            }
            
            //get number of worksheets in the workbook
            int numberOfSheets = workbook.getNumberOfSheets();
            
            //iterating over each workbook sheet
            for(int i=0; i<numberOfSheets; i++){
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();
                
                //iterating over each row
                int c = 1;
                while(rowIterator.hasNext()){
                   Row row = (Row) rowIterator.next();
                   ArrayList<Object> singleRows = new  ArrayList<>();
                   //skip the first row because it will be header
                   if(row.getRowNum() == 0){
                       maxDataCount = row.getLastCellNum();
                       continue;
                   }                  
                  
                  
                  /*for each row, iterate through all the columns*/
                  for(int cn = 0; cn < maxDataCount; cn++){
                      Cell cell = row.getCell(cn, Row.CREATE_NULL_AS_BLANK);
                      switch(cell.getCellType()){
                          case Cell.CELL_TYPE_NUMERIC:
                              if(DateUtil.isCellDateFormatted(cell)){
                                   singleRows.add(cell.getDateCellValue());
                              }else{
                                  String data = formatter.formatCellValue(cell);
                                  singleRows.add(data);
                              }
                          break;
                          case Cell.CELL_TYPE_STRING:
                              singleRows.add(cell.getStringCellValue());
                              break;
                          case Cell.CELL_TYPE_BLANK:
                              singleRows.add(null);
                              break;
                          default:
                              singleRows.add(cell.getStringCellValue());
                      }
                  }
                    System.out.println(c++ +"   "+singleRows);
                  rowaslist.add(singleRows);
//                  singleRows.clear();
                }
            }
          workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowaslist;
    }
    
    
}
