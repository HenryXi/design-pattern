package com.henryxi.designpattern.behavioral.template.exporter;

import java.util.List;

public abstract class AbstractExporter {
    public void exportData() {
        List<String> data = getData();
        String processedData = processData(data);
        export(processedData);
    }

    protected abstract List<String> getData();

    protected abstract String processData(List<String> data);

    protected abstract void export(String sumData);
}
