package com.boda.utils.dateReader;

import com.boda.utils.logs.LogsManager;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private static final String TEST_DATA_PATH = PropertyReader.getProperty("testDataPath");

    public static String getExcelData(String fileName, String sheetName, int rowNum, int colNum) {
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        String cellData;

        try {
            workbook = new XSSFWorkbook(TEST_DATA_PATH + fileName);
            sheet = workbook.getSheet(sheetName);
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            workbook.close();
            return cellData;
        } catch (Exception e) {
            LogsManager.error("Error reading Excel file: " + fileName, e.getMessage());
            return "";
        }
    }

}
