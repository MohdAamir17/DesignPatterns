package com.design.patterns.StrategyDesignPattern.fileservice;

import java.util.Objects;

public class FileExportContext {

    private final FileExportStrategy exportStrategy;

    public FileExportContext(FileExportStrategy exportStrategy) {
        this.exportStrategy = exportStrategy;
    }

    public byte[] export(Object data) {
        return exportStrategy.exportReport(data);
    }
}
