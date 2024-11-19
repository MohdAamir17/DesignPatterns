package com.design.patterns.SingletonDesignPatterns.controller;

import com.design.patterns.SingletonDesignPatterns.service.ConnectionPool;
import com.design.patterns.SingletonDesignPatterns.service.LoggerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @GetMapping("/log")
    public ResponseEntity<String> logMessage() {
        // Accessing the Singleton instance of LoggerService
        LoggerService logger = LoggerService.getInstance();
        logger.log("This is a log message!");
        return ResponseEntity.ok("Message logged successfully");
    }

    @GetMapping("/connectionlog")
    public ResponseEntity<String> connectionLog(){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        return ResponseEntity.ok("Find Connection : ");
    }


}
