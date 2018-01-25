# Java template method pattern example
`Template method` pattern is commonly used in this scenario which main logic stable but sub steps not. Let's say you want
to implement `export` function. For different data source there are different way to export data. But the main steps is the
same: "getData", "processData" and "export". Let's try to use `template method` in this example.

**package structure**

`Client` and exporters are **NOT** in same package. 
```
├─template
│  │  Client.java
│  │
│  └─exporter
│          AbstractExporter.java
│          ExporterFromDB.java
```

**AbstractExporter**
```java
package template.exporter;

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
```

**ExporterFromDB**
```java
package template.exporter;

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
```

**Client**
```java
package template;

import template.exporter.AbstractExporter;
import template.exporter.DBExporter;

public class Client {
    public static void main(String[] args) {
        AbstractExporter exporter = new DBExporter();
        exporter.exportData();
    }
}
```

The output is like following.
```
select data from database:[data1, data2, data3]
process data:split all data by ';' 
print:data1;data2;data3
```

EOF