package API.RestAPIAutomation.common;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    
public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

	//This method is to set the File path and to open the Excel file
	//Pass Excel Path and SheetName as Arguments to this method
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		System.out.println(Path);
		FileInputStream ExcelFile = new FileInputStream(Path);
		System.out.println(ExcelFile);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}
	
	//This method is to read the test data from the Excel cell
	//In this we are passing parameters/arguments as Row Num and Col Num
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();
		return CellData;
	}
	
	public static int getRowCount(){
		
		return ExcelWSheet.getLastRowNum();
	}
	
	public static int getColCount(int rowNum){
		
		return ExcelWSheet.getRow(rowNum).getLastCellNum();
	}
	
	/*private int getColumnsCount() {
	    int result = 0;
	    Iterator<Row> rowIterator = ExcelWSheet.iterator();
	    while (rowIterator.hasNext()) {
	        Row row = rowIterator.next();
	        List<Cell> cells = new ArrayList<>();
	        Iterator<Cell> cellIterator = row.cellIterator();
	        while (cellIterator.hasNext()) {
	            cells.add(cellIterator.next());
	        }
	        for (int i = cells.size(); i >= 0; i--) {
	            Cell cell = cells.get(i-1);
	            if (cell.toString().trim().isEmpty()) {
	                cells.remove(i-1);
	            } else {
	                result = cells.size() > result ? cells.size() : result;
	                break;
	            }
	        }
	    }
	    return result;
	}*/
}
