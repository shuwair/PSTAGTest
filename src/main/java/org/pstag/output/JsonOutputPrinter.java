package org.pstag.output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.pstag.model.Car;

import java.util.List;

class JsonOutputPrinter implements CarOutputPrinter {
    private final ObjectMapper mapper;

    public JsonOutputPrinter() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.findAndRegisterModules();
    }

    @Override
    public void print(List<Car> cars) {
        try {
            System.out.println(mapper.writeValueAsString(cars));
        } catch (JsonProcessingException e) {
            System.err.println("Error printing JSON: " + e.getMessage());
        }
    }
}