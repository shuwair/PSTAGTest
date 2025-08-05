package org.pstag.parser;

import org.pstag.model.Car;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CarDataParser  {

    public List<Car> parse(File xmlFile, File csvFile) throws Exception {
        List<String[]> csvData = parseCSV(csvFile);
        List<Car> cars = new ArrayList<>();

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
        NodeList carNodes = doc.getElementsByTagName("car");

        for (int i = 0; i < carNodes.getLength(); i++) {
            Element carElem = (Element) carNodes.item(i);
            String model = getText(carElem, "model");
            String type = getText(carElem, "type");
            double basePrice = Double.parseDouble(carElem.getElementsByTagName("price").item(0).getTextContent());

            // Multi-currency prices
            Map<String, Double> currencyPrices = new HashMap<>();
            NodeList priceNodes = carElem.getElementsByTagName("prices").item(0).getChildNodes();
            for (int j = 0; j < priceNodes.getLength(); j++) {
                if (priceNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element priceElem = (Element) priceNodes.item(j);
                    String currency = priceElem.getAttribute("currency");
                    double value = Double.parseDouble(priceElem.getTextContent());
                    currencyPrices.put(currency, value);
                }
            }

            // Corresponding CSV data
            String brand = csvData.get(i)[0];
            LocalDate releaseDate = LocalDate.parse(csvData.get(i)[1], DateTimeFormatter.ofPattern("MM/dd/yyyy"));

            Car car = new Car(brand, model, type, releaseDate, basePrice, currencyPrices);
            cars.add(car);
        }

        return cars;
    }

    private String getText(Element parent, String tag) {
        return parent.getElementsByTagName(tag).item(0).getTextContent();
    }

    private List<String[]> parseCSV(File csvFile) throws Exception {
        List<String[]> rows = new ArrayList<>();
        try (Scanner scanner = new Scanner(csvFile)) {
            scanner.nextLine(); // skip header
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().replace("\"", "").split(",", -1);
                rows.add(parts);
            }
        }
        return rows;
    }
}

