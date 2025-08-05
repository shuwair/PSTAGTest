package org.pstag.util;

import org.pstag.sort.SortField;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class CLIArgsReader {
    private File xmlFile;
    private File csvFile;

    public void readFilesFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("📄 Enter path to XML file: ");
            String xmlPath = scanner.nextLine().trim();
            File file = new File(xmlPath);
            if (file.exists() && file.isFile()) {
                this.xmlFile = file;
                break;
            }
            System.out.println("❌ File not found. Please enter a valid XML file path.\n");
        }

        while (true) {
            System.out.print("📄 Enter path to CSV file: ");
            String csvPath = scanner.nextLine().trim();
            File file = new File(csvPath);
            if (file.exists() && file.isFile()) {
                this.csvFile = file;
                break;
            }
            System.out.println("❌ File not found. Please enter a valid CSV file path.\n");
        }
    }

    public UserOptions readUserOptions() {
        Scanner scanner = new Scanner(System.in);
        UserOptions options = new UserOptions();

        System.out.print("🔎 Brand (or Enter to skip): ");
        String brand = scanner.nextLine().trim();
        if (!brand.isEmpty()) options.setBrand(brand);

        while (true) {
            System.out.print("💲 Max Price (or Enter to skip): ");
            String priceInput = scanner.nextLine().trim();
            if (priceInput.isEmpty()) break;

            try {
                options.setMaxPrice(Double.parseDouble(priceInput));
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid price. Please enter a valid number.");
            }
        }

        while (true) {
            System.out.print("📆 Release After (yyyy-MM-dd) (or Enter to skip): ");
            String dateInput = scanner.nextLine().trim();
            if (dateInput.isEmpty()) break;

            try {
                options.setReleaseAfter(LocalDate.parse(dateInput));
                break;
            } catch (Exception e) {
                System.out.println("❌ Invalid date format. Use yyyy-MM-dd.");
            }
        }

        System.out.print("🗂 Sort By (releaseDate / price / type-currency / custom): ");
        String sortInput = scanner.nextLine().trim().toLowerCase();
        switch (sortInput) {
            case "releasedate" -> options.setSortField(SortField.RELEASE_DATE);
            case "price" -> options.setSortField(SortField.PRICE);
            case "type-currency" -> options.setSortField(SortField.TYPE_AND_CURRENCY);
            case "custom" -> {
                options.setSortField(SortField.CUSTOM);
                System.out.print("🚗 Enter car type to sort (SUV/Sedan/Truck): ");
                options.setCustomType(scanner.nextLine().trim());
                System.out.print("💱 Enter currency (USD/EUR/JPY): ");
                options.setCustomCurrency(scanner.nextLine().trim());
            }
        }

        System.out.print("📤 Output Format (table/json/xml): ");
        String output = scanner.nextLine().trim().toLowerCase();
        options.setOutputFormat(output.isEmpty() ? "table" : output);

        return options;
    }

    public File getXmlFile() {
        return xmlFile;
    }

    public File getCsvFile() {
        return csvFile;
    }
}
