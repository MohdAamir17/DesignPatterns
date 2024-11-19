package com.design.patterns.StrategyDesignPattern.fileservice;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

public class CSVExportStrategy implements FileExportStrategy{
    @Override
    public byte[] exportReport(Object data) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);

        // Example : Assuming 'data' is a list of maps for demonstration
        //Convert 'data' into CSV format

        writer.println("Header1,Header2,Header3");
        writer.println("Row1Col1,Row2Col2,Row3Col3");
        writer.println("Row2Col1,Row2Col2,Row2Col3");

        writer.flush();
        return outputStream.toByteArray();
    }
}
