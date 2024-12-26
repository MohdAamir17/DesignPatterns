package com.design.patterns.BehavioralDesignPatterns.StrategyDesignPattern.fileservice;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;

public class PDFExportStrategy implements FileExportStrategy{
    @Override
    public byte[] exportReport(Object data) {
        try {
            Document document = new Document();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document,outputStream);
            document.open();

            document.add(new Paragraph("Header1 : Data1"));
            document.add(new Paragraph("Header2 : Data2"));
            document.add(new Paragraph("Header3 : Data3"));

            document.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error exporting PDF file",e);
        }
    }
}
