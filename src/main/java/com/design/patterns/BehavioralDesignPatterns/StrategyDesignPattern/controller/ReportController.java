package com.design.patterns.BehavioralDesignPatterns.StrategyDesignPattern.controller;

import com.design.patterns.BehavioralDesignPatterns.StrategyDesignPattern.fileservice.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportReport(@RequestParam String format,
                                               @RequestParam(required = false) String filter) {
        //Mock data for demonstration
        Object data = "Some data based on filter : " + filter;

        byte[] report = reportService.exportReport(format,data);

        String fileName = "report." + format.toLowerCase();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" + fileName);
        return new ResponseEntity<>(report,httpHeaders,HttpStatus.OK);
    }
}
