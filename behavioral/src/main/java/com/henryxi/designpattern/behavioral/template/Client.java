package com.henryxi.designpattern.behavioral.template;

import com.henryxi.designpattern.behavioral.template.exporter.AbstractExporter;
import com.henryxi.designpattern.behavioral.template.exporter.ExporterFromDB;

public class Client {
    public static void main(String[] args) {
        AbstractExporter exporter = new ExporterFromDB();
        exporter.exportData();
    }
}
