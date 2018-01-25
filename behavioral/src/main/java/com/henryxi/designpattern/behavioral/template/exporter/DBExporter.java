package com.henryxi.designpattern.behavioral.template.exporter;

import java.util.Arrays;
import java.util.List;

public class DBExporter extends AbstractExporter {

    @Override
    protected List<String> getData() {
        List<String> data = Arrays.asList("data1", "data2", "data3");
        System.out.println("select data from database:" + data);
        return data;
    }

    @Override
    protected String processData(List<String> data) {
        System.out.println("process data:split all data by ';' ");
        return String.join(";", data);
    }

    @Override
    protected void export(String sumData) {
        System.out.println("print:" + sumData);
    }
}
