package org.pstag.output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.pstag.model.Car;

import java.util.List;

class XmlOutputPrinter implements CarOutputPrinter {
    private final XmlMapper mapper;

    public XmlOutputPrinter() {
        mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.findAndRegisterModules();
    }

    @Override
    public void print(List<Car> cars) {
        try {
            System.out.println(mapper.writeValueAsString(cars));
        } catch (JsonProcessingException e) {
            System.err.println("Error printing XML: " + e.getMessage());
        }
    }
}