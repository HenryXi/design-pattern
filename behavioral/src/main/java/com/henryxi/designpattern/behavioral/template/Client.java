package com.henryxi.designpattern.behavioral.template;

import com.henryxi.designpattern.behavioral.template.exporter.AbstractExporter;
import com.henryxi.designpattern.behavioral.template.exporter.DBExporter;

public class Client {
    public static void main(String[] args) {
        AbstractExporter exporter = new DBExporter();
        exporter.exportData();
    }
}
