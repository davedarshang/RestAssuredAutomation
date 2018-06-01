package API.RestAPIAutomation.tests;
//import API.RestAPIAutomation.common;
public class ReadExcel {

	public static void main(String[] args) throws Exception {
		 
    	//Declaring the path of the Excel file with the name of the Excel file
    	//String sPath = "D://Tools QA Projects//trunk//Hybrid Keyword Driven//src//dataEngine//DataEngine.xlsx";
    	//String sPath = "C://Users//Administrator//workspace//RestAPIAutomation//DataEngine";
		String sPath = "F://Software//TestData.xlsx";
    	int totalRow;
    	int totalCol;
    	//Here we are passing the Excel path and SheetName to connect with the Excel file
        //This method was created in the last chapter of 'Set up Data Engine' 		
    	
    	/*API.RestAPIAutomation.common.ExcelUtils.setExcelFile(sPath, "Sheet1");
 
    	//Hard coded values are used for Excel row & columns for now
    	//In later chapters we will use these hard coded value much efficiently
    	//This is the loop for reading the values of the column 3 (Action Keyword) row by row
		//It means this loop will execute all the steps mentioned for the test case in Test Steps sheet
    	
    	totalRow=ExcelUtils.getRowCount();
    	
    	for (int iRow = 0;iRow <= totalRow;iRow++){
		    //This to get the value of column Action Keyword from the excel
    		totalCol=ExcelUtils.getColCount(iRow);
    		for (int iCol=0;iCol <= totalCol;iCol++){
    			System.out.println(ExcelUtils.getCellData(iRow, iCol));
    		}    		
    		//sActionKeyword = ExcelUtils.getCellData(iRow, 3);
            //A new separate method is created with the name 'execute_Actions'
			//You will find this method below of the this test
			//So this statement is doing nothing but calling that piece of code to execute
    		}
    	*/}
	
}
