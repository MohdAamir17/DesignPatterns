package com.design.patterns.StrategyDesignPattern.fileservice;

public interface FileExportStrategy {
    byte[] exportReport(Object data);

}
