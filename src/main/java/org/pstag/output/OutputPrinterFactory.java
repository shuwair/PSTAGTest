package org.pstag.output;

import java.util.HashMap;
import java.util.Map;

public class OutputPrinterFactory {
    private static final Map<String, CarOutputPrinter> PRINTERS = new HashMap<>();

    static {
        PRINTERS.put("table", new TableOutputPrinter());
        PRINTERS.put("json", new JsonOutputPrinter());
        PRINTERS.put("xml", new XmlOutputPrinter());
    }

    public static CarOutputPrinter getPrinter(String format) {
        return PRINTERS.getOrDefault(format.toLowerCase(), new TableOutputPrinter());
    }
}
