package com.design.patterns.StrategyDesignPattern.fileservice;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;

public class ExcelExportStrategy implements FileExportStrategy{

    @Override
    public byte[] exportReport(Object data) {
        try (Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Report");
            Row headerRow = sheet.createRow(0);

            //Create Headers
            headerRow.createCell(0).setCellValue("Header1");
            headerRow.createCell(0).setCellValue("Header2");
            headerRow.createCell(0).setCellValue("Header3");

            //Create Data Rows
            Row row = sheet.createRow(1);
            row.createCell(0).setCellValue("Data1");
            row.createCell(1).setCellValue("Data2");
            row.createCell(2).setCellValue("Data3");

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error exporting Excel file",e);
        }
    }
}
