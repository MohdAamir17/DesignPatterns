package com.design.patterns.BehavioralDesignPatterns.StrategyDesignPattern.fileservice;

import org.springframework.stereotype.Service;

@Service
public class ReportService {
    public byte[] exportReport(String format, Object data) {
        FileExportStrategy strategy;

        switch (format.toLowerCase()) {
            case "csv":
                strategy = new CSVExportStrategy();
                break;
            case "excel":
                strategy = new ExcelExportStrategy();
                break;
            case "pdf":
                strategy = new PDFExportStrategy();
                break;
            default:
                throw new IllegalArgumentException("Invalid format : " + format);
        }

        FileExportContext context = new FileExportContext(strategy);
        return context.export(data);
    }
}
