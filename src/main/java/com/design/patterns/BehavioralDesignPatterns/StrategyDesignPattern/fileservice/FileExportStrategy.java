package com.design.patterns.BehavioralDesignPatterns.StrategyDesignPattern.fileservice;

public interface FileExportStrategy {
    byte[] exportReport(Object data);

}
